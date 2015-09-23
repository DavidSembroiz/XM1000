#!/bin/bash

[ $# -ne 1 ] && { echo "Usage: $0 <USB port>"; exit 1; } 

make xm1000 install bsl,/dev/ttyUSB$1

