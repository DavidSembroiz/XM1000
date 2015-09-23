#include<Timer.h>
#include<string.h>
#include<stdio.h>
#include "XM1000Radio.h"

module XM1000RadioC {
	
	uses {
		interface Boot;
		interface Leds;
		interface Timer<TMilli>;
		
		interface Packet;
		interface AMPacket;
		interface AMSend;
		interface SplitControl as AMControl;
		
		interface Read<uint16_t> as Temp;
		interface Read<uint16_t> as Light;
		interface Read<uint16_t> as Hum;
		interface Read<uint16_t> as Batt;
	}
}

implementation{

    int SAMPLE_SECONDS = 5;
    
	
	bool busy = FALSE;
	message_t pkt;
	
	long int TempVal, LightVal, HumVal, BattVal;
	
	//SHT1x v4 humidity conversion coefficients (12 bits) 
	uint16_t C1, C2, C3;
	long int temp, value;
		
	//SHT1x v4 temperature compensation coefficients (12 bits)
	uint16_t T1, T2;
		
	//SHT1x v4 temperature conversion coefficients (12 bits)
	uint16_t D1, D2;
	
	void printfFloat(float toBePrinted) {
		uint32_t fi, f0, f1, f2;
	    char c;
	    float f = toBePrinted;
	
	    if (f<0){
	    	c = '-'; f = -f;
	    } else {
	       c = ' ';
	    }
	
	     // integer portion.
	     fi = (uint32_t) f;
	
	     // decimal portion...get index for up to 3 decimal places.
	     f = f - ((float) fi);
	     f0 = f*10;   f0 %= 10;
	     f1 = f*100;  f1 %= 10;
	     f2 = f*1000; f2 %= 10;
	     printf("%c%ld.%d%d%d", c, fi, (uint8_t) f0, (uint8_t) f1,  
		(uint8_t) f2);
   }
	

	event void Boot.booted(){
		call AMControl.start();
		C1 = 205;						// -2.0468
		C2 = 367;						// 0.0367 (367 * 10^⁻4)
		C3 = 16;						// -1.5955 * 10^-6
		
		T1 = 1000;						// 0.01
		T2 = 8;							// 8 * 10 ^-5
		
		D1 = 4010;						// -40.1
		D2 = 1;							// 0.01
	}

	event void Timer.fired(){
		call Temp.read();
		call Light.read();
		call Hum.read();
		call Batt.read();
		if (!busy) {
			XM1000Msg* senspkt = (XM1000Msg*) (call Packet.getPayload(&pkt, sizeof(XM1000Msg)));
			senspkt->nodeid = TOS_NODE_ID;
			senspkt->temp = TempVal;
			senspkt->hum = HumVal;
			senspkt->light = LightVal;
			senspkt->batt = BattVal;
			if (call AMSend.send(AM_BROADCAST_ADDR, &pkt, sizeof(XM1000Msg)) == SUCCESS) {
				busy = TRUE;
			}
		}
	}

	//TempVal = D1 + D2 * SOt
	event void Temp.readDone(error_t result, uint16_t val){
		if (result == SUCCESS) {
			
			TempVal = (val*D2 - D1);
			
			/*printf("Temperature: ");
			printfFloat(TempVal/100.0);
			printf("\r\n");*/
		}
		else {
			//printf("Error reading temperature sensor \r\n");
		}
	}

	event void Light.readDone(error_t result, uint16_t val){
		if (result == SUCCESS) {
			
			//TODO Needs revision
			LightVal = 1.5*((val / 4096.0) * 6250.0);
			
			/*printf("Light: ");
			printfFloat(LightVal/100.0);
			printf("\r\n");*/
		}
		else {
			//printf("Error reading light sensor \r\n");
		}
	}

	// HumVal = C1 + C2 * Sohr + C3 * SOhr^2
	event void Hum.readDone(error_t result, uint16_t val){
		if (result == SUCCESS) {
			
			// val == 1000 should give 35 as value (is a %)
			
			value = val;
			temp = value*value*C3/100000;
			
			HumVal = value*C2 / 100 - temp - C1;
			
			//Temperature compensation
			//HumValtrue = (T - 25) * (T1 + T2 * SOhr) + RHlin
			temp = (T1 + (T2*value))/1000;
			temp = ((TempVal - 2500)*temp)/100;
			HumVal = temp + HumVal;
			
			//printf("Humidity: ");
			if (HumVal > 9900) HumVal = 10000;
			//printfFloat(HumVal/100.0);
			//printf("\r\n");
		}
		else {
			//printf("Error reading humidity sensor \r\n");
		}
	}
	
	event void Batt.readDone(error_t result, uint16_t val){
		if (result == SUCCESS) {
            long int aux = val;
            BattVal = (aux * 100 * 3) / 4096.0;
        }
		else {
        }
	}
	
	event void AMSend.sendDone(message_t *msg, error_t error){
		if (&pkt == msg) busy = FALSE;
	}

	event void AMControl.startDone(error_t error){
		if (error == SUCCESS) {
			call Timer.startPeriodic(SAMPLE_SECONDS * 1000);
		}
		else {
			call AMControl.start();
		}
	}

	event void AMControl.stopDone(error_t error){
	}
}
