COMPONENT=XM1000RadioAppC
PFLAGS += -I$(TOSDIR)/lib/printf
BUILD_EXTRA_DEPS=XM1000Msg.class

XM1000Msg.class: XM1000Msg.java
	javac XM1000Msg.java
	
XM1000Msg.java:
	mig java -target=null -java-classname=XM1000Msg XM1000Radio.h XM1000Msg -o $@

include $(MAKERULES)
