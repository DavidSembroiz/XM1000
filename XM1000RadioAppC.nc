#include "XM1000Radio.h"

configuration XM1000RadioAppC {
	
	
}

implementation {
	
	components XM1000RadioC as App;
	components MainC, LedsC;
	components new TimerMilliC() as Timer;
	
	components ActiveMessageC;
	components new AMSenderC(AM_XM1000MSG);
	
	
	//components SerialPrintfC;
	components new SensirionSht11C() as TempHumSensor;
	components new HamamatsuS10871TsrC() as LightSensor;
	components new VoltageC() as Battery;
	
	App.Boot -> MainC;
	App.Leds -> LedsC;
	App.Timer -> Timer;
	
	App.Packet -> AMSenderC;
	App.AMPacket -> AMSenderC;
	App.AMSend -> AMSenderC;
	App.AMControl -> ActiveMessageC;
	
	App.Temp -> TempHumSensor.Temperature;
	App.Hum -> TempHumSensor.Humidity;
	App.Light -> LightSensor;
	App.Batt -> Battery;
}
