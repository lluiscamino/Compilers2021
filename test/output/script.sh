#! /bin/bash
as asm/forloop.asm -o asm/forloop.asm.o
ld asm/forloop.asm.o -o asm/forloop.asm -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./asm/forloop.asm > outputs/forloop.asm.txt
diff -y -q -w outputs/forloop.asm.txt expectedoutputs/forloop.asm.txt
as asm/while.asm -o asm/while.asm.o
ld asm/while.asm.o -o asm/while.asm -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./asm/while.asm > outputs/while.asm.txt
diff -y -q -w outputs/while.asm.txt expectedoutputs/while.asm.txt
