# TinyOS XM1000 Radio Sensing Software

This software is specific for XM1000 motes (http://www.advanticsys.com/shop/asxm1000-p-24.html).

# Installation
##Unix

For **UNIX** systems, once the mote is connected via USB, the software can be installed as follows:

```
cd XM1000Radio/src/
./install.sh <#USB port>
```
For instance, if the mote is connected to **/dev/ttyUSB1**, the installation is done as follows:

```
cd XM1000Radio/src/
./install.sh 1
```

The mote will start to send data messages every *t* seconds via ActiveMessage (TinyOS 802.15.4 Radio Messages).

### Change sampling rate

In order to change the rate in which data messages are sent, edit the file **XM1000RadioC.nc** and you will see the following variable:

```
int SAMPLE_SECONDS = n;
```

Change the value to an appropriate one and reinstall the software.
