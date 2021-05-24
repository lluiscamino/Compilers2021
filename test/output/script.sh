#! /bin/bash
as asm/globalvariables.asm -o asm/globalvariables.asm.o
ld asm/globalvariables.asm.o -o asm/globalvariables.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./asm/globalvariables.asm-exec > outputs/globalvariables.asm.txt
diff -y -q -w outputs/globalvariables.asm.txt expectedoutputs/globalvariables.asm.txt
as asm/forloop.asm -o asm/forloop.asm.o
ld asm/forloop.asm.o -o asm/forloop.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./asm/forloop.asm-exec > outputs/forloop.asm.txt
diff -y -q -w outputs/forloop.asm.txt expectedoutputs/forloop.asm.txt
as asm/printmax.asm -o asm/printmax.asm.o
ld asm/printmax.asm.o -o asm/printmax.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./asm/printmax.asm-exec > outputs/printmax.asm.txt
diff -y -q -w outputs/printmax.asm.txt expectedoutputs/printmax.asm.txt
as asm/differentscopesmain.asm -o asm/differentscopesmain.asm.o
ld asm/differentscopesmain.asm.o -o asm/differentscopesmain.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./asm/differentscopesmain.asm-exec > outputs/differentscopesmain.asm.txt
diff -y -q -w outputs/differentscopesmain.asm.txt expectedoutputs/differentscopesmain.asm.txt
as asm/printstrings.asm -o asm/printstrings.asm.o
ld asm/printstrings.asm.o -o asm/printstrings.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./asm/printstrings.asm-exec > outputs/printstrings.asm.txt
diff -y -q -w outputs/printstrings.asm.txt expectedoutputs/printstrings.asm.txt
as asm/while.asm -o asm/while.asm.o
ld asm/while.asm.o -o asm/while.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./asm/while.asm-exec > outputs/while.asm.txt
diff -y -q -w outputs/while.asm.txt expectedoutputs/while.asm.txt
as asm/comparestrings.asm -o asm/comparestrings.asm.o
ld asm/comparestrings.asm.o -o asm/comparestrings.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./asm/comparestrings.asm-exec > outputs/comparestrings.asm.txt
diff -y -q -w outputs/comparestrings.asm.txt expectedoutputs/comparestrings.asm.txt
as asm/printstringslength.asm -o asm/printstringslength.asm.o
ld asm/printstringslength.asm.o -o asm/printstringslength.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./asm/printstringslength.asm-exec > outputs/printstringslength.asm.txt
diff -y -q -w outputs/printstringslength.asm.txt expectedoutputs/printstringslength.asm.txt
as asm/fibonacci.asm -o asm/fibonacci.asm.o
ld asm/fibonacci.asm.o -o asm/fibonacci.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./asm/fibonacci.asm-exec > outputs/fibonacci.asm.txt
diff -y -q -w outputs/fibonacci.asm.txt expectedoutputs/fibonacci.asm.txt
as asm/lucassequence.asm -o asm/lucassequence.asm.o
ld asm/lucassequence.asm.o -o asm/lucassequence.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./asm/lucassequence.asm-exec > outputs/lucassequence.asm.txt
diff -y -q -w outputs/lucassequence.asm.txt expectedoutputs/lucassequence.asm.txt
as asm/identity.asm -o asm/identity.asm.o
ld asm/identity.asm.o -o asm/identity.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./asm/identity.asm-exec > outputs/identity.asm.txt
diff -y -q -w outputs/identity.asm.txt expectedoutputs/identity.asm.txt
as asm/printbooleans.asm -o asm/printbooleans.asm.o
ld asm/printbooleans.asm.o -o asm/printbooleans.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./asm/printbooleans.asm-exec > outputs/printbooleans.asm.txt
diff -y -q -w outputs/printbooleans.asm.txt expectedoutputs/printbooleans.asm.txt
