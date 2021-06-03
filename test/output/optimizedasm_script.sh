#! /bin/bash

as optimizedasm/arrayliterallength.asm -o optimizedasm/arrayliterallength.asm.o
ld optimizedasm/arrayliterallength.asm.o -o optimizedasm/arrayliterallength.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/arrayliterallength.asm-exec > outputs/arrayliterallength.asm.txt
diff -y -q -w outputs/arrayliterallength.asm.txt expectedoutputs/arrayliterallength.asm.txt
rm optimizedasm/arrayliterallength.asm.o
rm optimizedasm/arrayliterallength.asm-exec

as optimizedasm/average.asm -o optimizedasm/average.asm.o
ld optimizedasm/average.asm.o -o optimizedasm/average.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/average.asm-exec > outputs/average.asm.txt
diff -y -q -w outputs/average.asm.txt expectedoutputs/average.asm.txt
rm optimizedasm/average.asm.o
rm optimizedasm/average.asm-exec

as optimizedasm/basicforloop.asm -o optimizedasm/basicforloop.asm.o
ld optimizedasm/basicforloop.asm.o -o optimizedasm/basicforloop.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/basicforloop.asm-exec > outputs/basicforloop.asm.txt
diff -y -q -w outputs/basicforloop.asm.txt expectedoutputs/basicforloop.asm.txt
rm optimizedasm/basicforloop.asm.o
rm optimizedasm/basicforloop.asm-exec

as optimizedasm/binarysearch.asm -o optimizedasm/binarysearch.asm.o
ld optimizedasm/binarysearch.asm.o -o optimizedasm/binarysearch.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/binarysearch.asm-exec > outputs/binarysearch.asm.txt
diff -y -q -w outputs/binarysearch.asm.txt expectedoutputs/binarysearch.asm.txt
rm optimizedasm/binarysearch.asm.o
rm optimizedasm/binarysearch.asm-exec

as optimizedasm/bubblesort.asm -o optimizedasm/bubblesort.asm.o
ld optimizedasm/bubblesort.asm.o -o optimizedasm/bubblesort.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/bubblesort.asm-exec > outputs/bubblesort.asm.txt
diff -y -q -w outputs/bubblesort.asm.txt expectedoutputs/bubblesort.asm.txt
rm optimizedasm/bubblesort.asm.o
rm optimizedasm/bubblesort.asm-exec

as optimizedasm/comparestrings.asm -o optimizedasm/comparestrings.asm.o
ld optimizedasm/comparestrings.asm.o -o optimizedasm/comparestrings.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/comparestrings.asm-exec > outputs/comparestrings.asm.txt
diff -y -q -w outputs/comparestrings.asm.txt expectedoutputs/comparestrings.asm.txt
rm optimizedasm/comparestrings.asm.o
rm optimizedasm/comparestrings.asm-exec

as optimizedasm/differentscopesmain.asm -o optimizedasm/differentscopesmain.asm.o
ld optimizedasm/differentscopesmain.asm.o -o optimizedasm/differentscopesmain.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/differentscopesmain.asm-exec > outputs/differentscopesmain.asm.txt
diff -y -q -w outputs/differentscopesmain.asm.txt expectedoutputs/differentscopesmain.asm.txt
rm optimizedasm/differentscopesmain.asm.o
rm optimizedasm/differentscopesmain.asm-exec

as optimizedasm/fibonacci.asm -o optimizedasm/fibonacci.asm.o
ld optimizedasm/fibonacci.asm.o -o optimizedasm/fibonacci.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/fibonacci.asm-exec > outputs/fibonacci.asm.txt
diff -y -q -w outputs/fibonacci.asm.txt expectedoutputs/fibonacci.asm.txt
rm optimizedasm/fibonacci.asm.o
rm optimizedasm/fibonacci.asm-exec

as optimizedasm/foreach.asm -o optimizedasm/foreach.asm.o
ld optimizedasm/foreach.asm.o -o optimizedasm/foreach.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/foreach.asm-exec > outputs/foreach.asm.txt
diff -y -q -w outputs/foreach.asm.txt expectedoutputs/foreach.asm.txt
rm optimizedasm/foreach.asm.o
rm optimizedasm/foreach.asm-exec

as optimizedasm/forloop.asm -o optimizedasm/forloop.asm.o
ld optimizedasm/forloop.asm.o -o optimizedasm/forloop.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/forloop.asm-exec > outputs/forloop.asm.txt
diff -y -q -w outputs/forloop.asm.txt expectedoutputs/forloop.asm.txt
rm optimizedasm/forloop.asm.o
rm optimizedasm/forloop.asm-exec

as optimizedasm/globalvariables.asm -o optimizedasm/globalvariables.asm.o
ld optimizedasm/globalvariables.asm.o -o optimizedasm/globalvariables.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/globalvariables.asm-exec > outputs/globalvariables.asm.txt
diff -y -q -w outputs/globalvariables.asm.txt expectedoutputs/globalvariables.asm.txt
rm optimizedasm/globalvariables.asm.o
rm optimizedasm/globalvariables.asm-exec

as optimizedasm/identity.asm -o optimizedasm/identity.asm.o
ld optimizedasm/identity.asm.o -o optimizedasm/identity.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/identity.asm-exec > outputs/identity.asm.txt
diff -y -q -w outputs/identity.asm.txt expectedoutputs/identity.asm.txt
rm optimizedasm/identity.asm.o
rm optimizedasm/identity.asm-exec

as optimizedasm/lucassequence.asm -o optimizedasm/lucassequence.asm.o
ld optimizedasm/lucassequence.asm.o -o optimizedasm/lucassequence.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/lucassequence.asm-exec > outputs/lucassequence.asm.txt
diff -y -q -w outputs/lucassequence.asm.txt expectedoutputs/lucassequence.asm.txt
rm optimizedasm/lucassequence.asm.o
rm optimizedasm/lucassequence.asm-exec

as optimizedasm/max5.asm -o optimizedasm/max5.asm.o
ld optimizedasm/max5.asm.o -o optimizedasm/max5.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/max5.asm-exec > outputs/max5.asm.txt
diff -y -q -w outputs/max5.asm.txt expectedoutputs/max5.asm.txt
rm optimizedasm/max5.asm.o
rm optimizedasm/max5.asm-exec

as optimizedasm/onedimensionarrayinstance.asm -o optimizedasm/onedimensionarrayinstance.asm.o
ld optimizedasm/onedimensionarrayinstance.asm.o -o optimizedasm/onedimensionarrayinstance.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/onedimensionarrayinstance.asm-exec > outputs/onedimensionarrayinstance.asm.txt
diff -y -q -w outputs/onedimensionarrayinstance.asm.txt expectedoutputs/onedimensionarrayinstance.asm.txt
rm optimizedasm/onedimensionarrayinstance.asm.o
rm optimizedasm/onedimensionarrayinstance.asm-exec

as optimizedasm/onedimensionarrayliteral.asm -o optimizedasm/onedimensionarrayliteral.asm.o
ld optimizedasm/onedimensionarrayliteral.asm.o -o optimizedasm/onedimensionarrayliteral.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/onedimensionarrayliteral.asm-exec > outputs/onedimensionarrayliteral.asm.txt
diff -y -q -w outputs/onedimensionarrayliteral.asm.txt expectedoutputs/onedimensionarrayliteral.asm.txt
rm optimizedasm/onedimensionarrayliteral.asm.o
rm optimizedasm/onedimensionarrayliteral.asm-exec

as optimizedasm/printbooleans.asm -o optimizedasm/printbooleans.asm.o
ld optimizedasm/printbooleans.asm.o -o optimizedasm/printbooleans.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/printbooleans.asm-exec > outputs/printbooleans.asm.txt
diff -y -q -w outputs/printbooleans.asm.txt expectedoutputs/printbooleans.asm.txt
rm optimizedasm/printbooleans.asm.o
rm optimizedasm/printbooleans.asm-exec

as optimizedasm/printmax.asm -o optimizedasm/printmax.asm.o
ld optimizedasm/printmax.asm.o -o optimizedasm/printmax.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/printmax.asm-exec > outputs/printmax.asm.txt
diff -y -q -w outputs/printmax.asm.txt expectedoutputs/printmax.asm.txt
rm optimizedasm/printmax.asm.o
rm optimizedasm/printmax.asm-exec

as optimizedasm/printstrings.asm -o optimizedasm/printstrings.asm.o
ld optimizedasm/printstrings.asm.o -o optimizedasm/printstrings.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/printstrings.asm-exec > outputs/printstrings.asm.txt
diff -y -q -w outputs/printstrings.asm.txt expectedoutputs/printstrings.asm.txt
rm optimizedasm/printstrings.asm.o
rm optimizedasm/printstrings.asm-exec

as optimizedasm/printstringslength.asm -o optimizedasm/printstringslength.asm.o
ld optimizedasm/printstringslength.asm.o -o optimizedasm/printstringslength.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/printstringslength.asm-exec > outputs/printstringslength.asm.txt
diff -y -q -w outputs/printstringslength.asm.txt expectedoutputs/printstringslength.asm.txt
rm optimizedasm/printstringslength.asm.o
rm optimizedasm/printstringslength.asm-exec

as optimizedasm/simplevariablepass.asm -o optimizedasm/simplevariablepass.asm.o
ld optimizedasm/simplevariablepass.asm.o -o optimizedasm/simplevariablepass.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/simplevariablepass.asm-exec > outputs/simplevariablepass.asm.txt
diff -y -q -w outputs/simplevariablepass.asm.txt expectedoutputs/simplevariablepass.asm.txt
rm optimizedasm/simplevariablepass.asm.o
rm optimizedasm/simplevariablepass.asm-exec

as optimizedasm/twosum.asm -o optimizedasm/twosum.asm.o
ld optimizedasm/twosum.asm.o -o optimizedasm/twosum.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/twosum.asm-exec > outputs/twosum.asm.txt
diff -y -q -w outputs/twosum.asm.txt expectedoutputs/twosum.asm.txt
rm optimizedasm/twosum.asm.o
rm optimizedasm/twosum.asm-exec

as optimizedasm/unusedprocedure.asm -o optimizedasm/unusedprocedure.asm.o
ld optimizedasm/unusedprocedure.asm.o -o optimizedasm/unusedprocedure.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/unusedprocedure.asm-exec > outputs/unusedprocedure.asm.txt
diff -y -q -w outputs/unusedprocedure.asm.txt expectedoutputs/unusedprocedure.asm.txt
rm optimizedasm/unusedprocedure.asm.o
rm optimizedasm/unusedprocedure.asm-exec

as optimizedasm/while.asm -o optimizedasm/while.asm.o
ld optimizedasm/while.asm.o -o optimizedasm/while.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/while.asm-exec > outputs/while.asm.txt
diff -y -q -w outputs/while.asm.txt expectedoutputs/while.asm.txt
rm optimizedasm/while.asm.o
rm optimizedasm/while.asm-exec

