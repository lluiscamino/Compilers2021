#! /bin/bash

as optimizedasm/basicforloop.asm -o optimizedasm/basicforloop.asm.o
ld optimizedasm/basicforloop.asm.o -o optimizedasm/basicforloop.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/basicforloop.asm-exec > outputs/basicforloop.asm.txt
diff -y -q -w outputs/basicforloop.asm.txt expectedoutputs/basicforloop.asm.txt
rm optimizedasm/basicforloop.asm.o
rm optimizedasm/basicforloop.asm-exec

as unoptimizedasm/basicforloop.asm -o unoptimizedasm/basicforloop.asm.o
ld unoptimizedasm/basicforloop.asm.o -o unoptimizedasm/basicforloop.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/basicforloop.asm-exec > outputs/basicforloop.asm.txt
diff -y -q -w outputs/basicforloop.asm.txt expectedoutputs/basicforloop.asm.txt
rm unoptimizedasm/basicforloop.asm.o
rm unoptimizedasm/basicforloop.asm-exec

as optimizedasm/max5.asm -o optimizedasm/max5.asm.o
ld optimizedasm/max5.asm.o -o optimizedasm/max5.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/max5.asm-exec > outputs/max5.asm.txt
diff -y -q -w outputs/max5.asm.txt expectedoutputs/max5.asm.txt
rm optimizedasm/max5.asm.o
rm optimizedasm/max5.asm-exec

as unoptimizedasm/max5.asm -o unoptimizedasm/max5.asm.o
ld unoptimizedasm/max5.asm.o -o unoptimizedasm/max5.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/max5.asm-exec > outputs/max5.asm.txt
diff -y -q -w outputs/max5.asm.txt expectedoutputs/max5.asm.txt
rm unoptimizedasm/max5.asm.o
rm unoptimizedasm/max5.asm-exec

as optimizedasm/globalvariables.asm -o optimizedasm/globalvariables.asm.o
ld optimizedasm/globalvariables.asm.o -o optimizedasm/globalvariables.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/globalvariables.asm-exec > outputs/globalvariables.asm.txt
diff -y -q -w outputs/globalvariables.asm.txt expectedoutputs/globalvariables.asm.txt
rm optimizedasm/globalvariables.asm.o
rm optimizedasm/globalvariables.asm-exec

as unoptimizedasm/globalvariables.asm -o unoptimizedasm/globalvariables.asm.o
ld unoptimizedasm/globalvariables.asm.o -o unoptimizedasm/globalvariables.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/globalvariables.asm-exec > outputs/globalvariables.asm.txt
diff -y -q -w outputs/globalvariables.asm.txt expectedoutputs/globalvariables.asm.txt
rm unoptimizedasm/globalvariables.asm.o
rm unoptimizedasm/globalvariables.asm-exec

as optimizedasm/forloop.asm -o optimizedasm/forloop.asm.o
ld optimizedasm/forloop.asm.o -o optimizedasm/forloop.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/forloop.asm-exec > outputs/forloop.asm.txt
diff -y -q -w outputs/forloop.asm.txt expectedoutputs/forloop.asm.txt
rm optimizedasm/forloop.asm.o
rm optimizedasm/forloop.asm-exec

as unoptimizedasm/forloop.asm -o unoptimizedasm/forloop.asm.o
ld unoptimizedasm/forloop.asm.o -o unoptimizedasm/forloop.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/forloop.asm-exec > outputs/forloop.asm.txt
diff -y -q -w outputs/forloop.asm.txt expectedoutputs/forloop.asm.txt
rm unoptimizedasm/forloop.asm.o
rm unoptimizedasm/forloop.asm-exec

as optimizedasm/printmax.asm -o optimizedasm/printmax.asm.o
ld optimizedasm/printmax.asm.o -o optimizedasm/printmax.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/printmax.asm-exec > outputs/printmax.asm.txt
diff -y -q -w outputs/printmax.asm.txt expectedoutputs/printmax.asm.txt
rm optimizedasm/printmax.asm.o
rm optimizedasm/printmax.asm-exec

as unoptimizedasm/printmax.asm -o unoptimizedasm/printmax.asm.o
ld unoptimizedasm/printmax.asm.o -o unoptimizedasm/printmax.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/printmax.asm-exec > outputs/printmax.asm.txt
diff -y -q -w outputs/printmax.asm.txt expectedoutputs/printmax.asm.txt
rm unoptimizedasm/printmax.asm.o
rm unoptimizedasm/printmax.asm-exec

as optimizedasm/differentscopesmain.asm -o optimizedasm/differentscopesmain.asm.o
ld optimizedasm/differentscopesmain.asm.o -o optimizedasm/differentscopesmain.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/differentscopesmain.asm-exec > outputs/differentscopesmain.asm.txt
diff -y -q -w outputs/differentscopesmain.asm.txt expectedoutputs/differentscopesmain.asm.txt
rm optimizedasm/differentscopesmain.asm.o
rm optimizedasm/differentscopesmain.asm-exec

as unoptimizedasm/differentscopesmain.asm -o unoptimizedasm/differentscopesmain.asm.o
ld unoptimizedasm/differentscopesmain.asm.o -o unoptimizedasm/differentscopesmain.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/differentscopesmain.asm-exec > outputs/differentscopesmain.asm.txt
diff -y -q -w outputs/differentscopesmain.asm.txt expectedoutputs/differentscopesmain.asm.txt
rm unoptimizedasm/differentscopesmain.asm.o
rm unoptimizedasm/differentscopesmain.asm-exec

as optimizedasm/arrayliterallength.asm -o optimizedasm/arrayliterallength.asm.o
ld optimizedasm/arrayliterallength.asm.o -o optimizedasm/arrayliterallength.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/arrayliterallength.asm-exec > outputs/arrayliterallength.asm.txt
diff -y -q -w outputs/arrayliterallength.asm.txt expectedoutputs/arrayliterallength.asm.txt
rm optimizedasm/arrayliterallength.asm.o
rm optimizedasm/arrayliterallength.asm-exec

as unoptimizedasm/arrayliterallength.asm -o unoptimizedasm/arrayliterallength.asm.o
ld unoptimizedasm/arrayliterallength.asm.o -o unoptimizedasm/arrayliterallength.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/arrayliterallength.asm-exec > outputs/arrayliterallength.asm.txt
diff -y -q -w outputs/arrayliterallength.asm.txt expectedoutputs/arrayliterallength.asm.txt
rm unoptimizedasm/arrayliterallength.asm.o
rm unoptimizedasm/arrayliterallength.asm-exec

as optimizedasm/bubblesort.asm -o optimizedasm/bubblesort.asm.o
ld optimizedasm/bubblesort.asm.o -o optimizedasm/bubblesort.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/bubblesort.asm-exec > outputs/bubblesort.asm.txt
diff -y -q -w outputs/bubblesort.asm.txt expectedoutputs/bubblesort.asm.txt
rm optimizedasm/bubblesort.asm.o
rm optimizedasm/bubblesort.asm-exec

as unoptimizedasm/bubblesort.asm -o unoptimizedasm/bubblesort.asm.o
ld unoptimizedasm/bubblesort.asm.o -o unoptimizedasm/bubblesort.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/bubblesort.asm-exec > outputs/bubblesort.asm.txt
diff -y -q -w outputs/bubblesort.asm.txt expectedoutputs/bubblesort.asm.txt
rm unoptimizedasm/bubblesort.asm.o
rm unoptimizedasm/bubblesort.asm-exec

as optimizedasm/printstrings.asm -o optimizedasm/printstrings.asm.o
ld optimizedasm/printstrings.asm.o -o optimizedasm/printstrings.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/printstrings.asm-exec > outputs/printstrings.asm.txt
diff -y -q -w outputs/printstrings.asm.txt expectedoutputs/printstrings.asm.txt
rm optimizedasm/printstrings.asm.o
rm optimizedasm/printstrings.asm-exec

as unoptimizedasm/printstrings.asm -o unoptimizedasm/printstrings.asm.o
ld unoptimizedasm/printstrings.asm.o -o unoptimizedasm/printstrings.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/printstrings.asm-exec > outputs/printstrings.asm.txt
diff -y -q -w outputs/printstrings.asm.txt expectedoutputs/printstrings.asm.txt
rm unoptimizedasm/printstrings.asm.o
rm unoptimizedasm/printstrings.asm-exec

as optimizedasm/average.asm -o optimizedasm/average.asm.o
ld optimizedasm/average.asm.o -o optimizedasm/average.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/average.asm-exec > outputs/average.asm.txt
diff -y -q -w outputs/average.asm.txt expectedoutputs/average.asm.txt
rm optimizedasm/average.asm.o
rm optimizedasm/average.asm-exec

as unoptimizedasm/average.asm -o unoptimizedasm/average.asm.o
ld unoptimizedasm/average.asm.o -o unoptimizedasm/average.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/average.asm-exec > outputs/average.asm.txt
diff -y -q -w outputs/average.asm.txt expectedoutputs/average.asm.txt
rm unoptimizedasm/average.asm.o
rm unoptimizedasm/average.asm-exec

as optimizedasm/twosum.asm -o optimizedasm/twosum.asm.o
ld optimizedasm/twosum.asm.o -o optimizedasm/twosum.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/twosum.asm-exec > outputs/twosum.asm.txt
diff -y -q -w outputs/twosum.asm.txt expectedoutputs/twosum.asm.txt
rm optimizedasm/twosum.asm.o
rm optimizedasm/twosum.asm-exec

as unoptimizedasm/twosum.asm -o unoptimizedasm/twosum.asm.o
ld unoptimizedasm/twosum.asm.o -o unoptimizedasm/twosum.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/twosum.asm-exec > outputs/twosum.asm.txt
diff -y -q -w outputs/twosum.asm.txt expectedoutputs/twosum.asm.txt
rm unoptimizedasm/twosum.asm.o
rm unoptimizedasm/twosum.asm-exec

as optimizedasm/binarysearch.asm -o optimizedasm/binarysearch.asm.o
ld optimizedasm/binarysearch.asm.o -o optimizedasm/binarysearch.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/binarysearch.asm-exec > outputs/binarysearch.asm.txt
diff -y -q -w outputs/binarysearch.asm.txt expectedoutputs/binarysearch.asm.txt
rm optimizedasm/binarysearch.asm.o
rm optimizedasm/binarysearch.asm-exec

as unoptimizedasm/binarysearch.asm -o unoptimizedasm/binarysearch.asm.o
ld unoptimizedasm/binarysearch.asm.o -o unoptimizedasm/binarysearch.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/binarysearch.asm-exec > outputs/binarysearch.asm.txt
diff -y -q -w outputs/binarysearch.asm.txt expectedoutputs/binarysearch.asm.txt
rm unoptimizedasm/binarysearch.asm.o
rm unoptimizedasm/binarysearch.asm-exec

as optimizedasm/unusedprocedure.asm -o optimizedasm/unusedprocedure.asm.o
ld optimizedasm/unusedprocedure.asm.o -o optimizedasm/unusedprocedure.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/unusedprocedure.asm-exec > outputs/unusedprocedure.asm.txt
diff -y -q -w outputs/unusedprocedure.asm.txt expectedoutputs/unusedprocedure.asm.txt
rm optimizedasm/unusedprocedure.asm.o
rm optimizedasm/unusedprocedure.asm-exec

as unoptimizedasm/unusedprocedure.asm -o unoptimizedasm/unusedprocedure.asm.o
ld unoptimizedasm/unusedprocedure.asm.o -o unoptimizedasm/unusedprocedure.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/unusedprocedure.asm-exec > outputs/unusedprocedure.asm.txt
diff -y -q -w outputs/unusedprocedure.asm.txt expectedoutputs/unusedprocedure.asm.txt
rm unoptimizedasm/unusedprocedure.asm.o
rm unoptimizedasm/unusedprocedure.asm-exec

as optimizedasm/while.asm -o optimizedasm/while.asm.o
ld optimizedasm/while.asm.o -o optimizedasm/while.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/while.asm-exec > outputs/while.asm.txt
diff -y -q -w outputs/while.asm.txt expectedoutputs/while.asm.txt
rm optimizedasm/while.asm.o
rm optimizedasm/while.asm-exec

as unoptimizedasm/while.asm -o unoptimizedasm/while.asm.o
ld unoptimizedasm/while.asm.o -o unoptimizedasm/while.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/while.asm-exec > outputs/while.asm.txt
diff -y -q -w outputs/while.asm.txt expectedoutputs/while.asm.txt
rm unoptimizedasm/while.asm.o
rm unoptimizedasm/while.asm-exec

as optimizedasm/comparestrings.asm -o optimizedasm/comparestrings.asm.o
ld optimizedasm/comparestrings.asm.o -o optimizedasm/comparestrings.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/comparestrings.asm-exec > outputs/comparestrings.asm.txt
diff -y -q -w outputs/comparestrings.asm.txt expectedoutputs/comparestrings.asm.txt
rm optimizedasm/comparestrings.asm.o
rm optimizedasm/comparestrings.asm-exec

as unoptimizedasm/comparestrings.asm -o unoptimizedasm/comparestrings.asm.o
ld unoptimizedasm/comparestrings.asm.o -o unoptimizedasm/comparestrings.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/comparestrings.asm-exec > outputs/comparestrings.asm.txt
diff -y -q -w outputs/comparestrings.asm.txt expectedoutputs/comparestrings.asm.txt
rm unoptimizedasm/comparestrings.asm.o
rm unoptimizedasm/comparestrings.asm-exec

as optimizedasm/printstringslength.asm -o optimizedasm/printstringslength.asm.o
ld optimizedasm/printstringslength.asm.o -o optimizedasm/printstringslength.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/printstringslength.asm-exec > outputs/printstringslength.asm.txt
diff -y -q -w outputs/printstringslength.asm.txt expectedoutputs/printstringslength.asm.txt
rm optimizedasm/printstringslength.asm.o
rm optimizedasm/printstringslength.asm-exec

as unoptimizedasm/printstringslength.asm -o unoptimizedasm/printstringslength.asm.o
ld unoptimizedasm/printstringslength.asm.o -o unoptimizedasm/printstringslength.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/printstringslength.asm-exec > outputs/printstringslength.asm.txt
diff -y -q -w outputs/printstringslength.asm.txt expectedoutputs/printstringslength.asm.txt
rm unoptimizedasm/printstringslength.asm.o
rm unoptimizedasm/printstringslength.asm-exec

as optimizedasm/fibonacci.asm -o optimizedasm/fibonacci.asm.o
ld optimizedasm/fibonacci.asm.o -o optimizedasm/fibonacci.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/fibonacci.asm-exec > outputs/fibonacci.asm.txt
diff -y -q -w outputs/fibonacci.asm.txt expectedoutputs/fibonacci.asm.txt
rm optimizedasm/fibonacci.asm.o
rm optimizedasm/fibonacci.asm-exec

as unoptimizedasm/fibonacci.asm -o unoptimizedasm/fibonacci.asm.o
ld unoptimizedasm/fibonacci.asm.o -o unoptimizedasm/fibonacci.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/fibonacci.asm-exec > outputs/fibonacci.asm.txt
diff -y -q -w outputs/fibonacci.asm.txt expectedoutputs/fibonacci.asm.txt
rm unoptimizedasm/fibonacci.asm.o
rm unoptimizedasm/fibonacci.asm-exec

as optimizedasm/onedimensionarrayinstance.asm -o optimizedasm/onedimensionarrayinstance.asm.o
ld optimizedasm/onedimensionarrayinstance.asm.o -o optimizedasm/onedimensionarrayinstance.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/onedimensionarrayinstance.asm-exec > outputs/onedimensionarrayinstance.asm.txt
diff -y -q -w outputs/onedimensionarrayinstance.asm.txt expectedoutputs/onedimensionarrayinstance.asm.txt
rm optimizedasm/onedimensionarrayinstance.asm.o
rm optimizedasm/onedimensionarrayinstance.asm-exec

as unoptimizedasm/onedimensionarrayinstance.asm -o unoptimizedasm/onedimensionarrayinstance.asm.o
ld unoptimizedasm/onedimensionarrayinstance.asm.o -o unoptimizedasm/onedimensionarrayinstance.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/onedimensionarrayinstance.asm-exec > outputs/onedimensionarrayinstance.asm.txt
diff -y -q -w outputs/onedimensionarrayinstance.asm.txt expectedoutputs/onedimensionarrayinstance.asm.txt
rm unoptimizedasm/onedimensionarrayinstance.asm.o
rm unoptimizedasm/onedimensionarrayinstance.asm-exec

as optimizedasm/onedimensionarrayliteral.asm -o optimizedasm/onedimensionarrayliteral.asm.o
ld optimizedasm/onedimensionarrayliteral.asm.o -o optimizedasm/onedimensionarrayliteral.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/onedimensionarrayliteral.asm-exec > outputs/onedimensionarrayliteral.asm.txt
diff -y -q -w outputs/onedimensionarrayliteral.asm.txt expectedoutputs/onedimensionarrayliteral.asm.txt
rm optimizedasm/onedimensionarrayliteral.asm.o
rm optimizedasm/onedimensionarrayliteral.asm-exec

as unoptimizedasm/onedimensionarrayliteral.asm -o unoptimizedasm/onedimensionarrayliteral.asm.o
ld unoptimizedasm/onedimensionarrayliteral.asm.o -o unoptimizedasm/onedimensionarrayliteral.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/onedimensionarrayliteral.asm-exec > outputs/onedimensionarrayliteral.asm.txt
diff -y -q -w outputs/onedimensionarrayliteral.asm.txt expectedoutputs/onedimensionarrayliteral.asm.txt
rm unoptimizedasm/onedimensionarrayliteral.asm.o
rm unoptimizedasm/onedimensionarrayliteral.asm-exec

as optimizedasm/lucassequence.asm -o optimizedasm/lucassequence.asm.o
ld optimizedasm/lucassequence.asm.o -o optimizedasm/lucassequence.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/lucassequence.asm-exec > outputs/lucassequence.asm.txt
diff -y -q -w outputs/lucassequence.asm.txt expectedoutputs/lucassequence.asm.txt
rm optimizedasm/lucassequence.asm.o
rm optimizedasm/lucassequence.asm-exec

as unoptimizedasm/lucassequence.asm -o unoptimizedasm/lucassequence.asm.o
ld unoptimizedasm/lucassequence.asm.o -o unoptimizedasm/lucassequence.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/lucassequence.asm-exec > outputs/lucassequence.asm.txt
diff -y -q -w outputs/lucassequence.asm.txt expectedoutputs/lucassequence.asm.txt
rm unoptimizedasm/lucassequence.asm.o
rm unoptimizedasm/lucassequence.asm-exec

as optimizedasm/identity.asm -o optimizedasm/identity.asm.o
ld optimizedasm/identity.asm.o -o optimizedasm/identity.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/identity.asm-exec > outputs/identity.asm.txt
diff -y -q -w outputs/identity.asm.txt expectedoutputs/identity.asm.txt
rm optimizedasm/identity.asm.o
rm optimizedasm/identity.asm-exec

as unoptimizedasm/identity.asm -o unoptimizedasm/identity.asm.o
ld unoptimizedasm/identity.asm.o -o unoptimizedasm/identity.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/identity.asm-exec > outputs/identity.asm.txt
diff -y -q -w outputs/identity.asm.txt expectedoutputs/identity.asm.txt
rm unoptimizedasm/identity.asm.o
rm unoptimizedasm/identity.asm-exec

as optimizedasm/simplevariablepass.asm -o optimizedasm/simplevariablepass.asm.o
ld optimizedasm/simplevariablepass.asm.o -o optimizedasm/simplevariablepass.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/simplevariablepass.asm-exec > outputs/simplevariablepass.asm.txt
diff -y -q -w outputs/simplevariablepass.asm.txt expectedoutputs/simplevariablepass.asm.txt
rm optimizedasm/simplevariablepass.asm.o
rm optimizedasm/simplevariablepass.asm-exec

as unoptimizedasm/simplevariablepass.asm -o unoptimizedasm/simplevariablepass.asm.o
ld unoptimizedasm/simplevariablepass.asm.o -o unoptimizedasm/simplevariablepass.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/simplevariablepass.asm-exec > outputs/simplevariablepass.asm.txt
diff -y -q -w outputs/simplevariablepass.asm.txt expectedoutputs/simplevariablepass.asm.txt
rm unoptimizedasm/simplevariablepass.asm.o
rm unoptimizedasm/simplevariablepass.asm-exec

as optimizedasm/printbooleans.asm -o optimizedasm/printbooleans.asm.o
ld optimizedasm/printbooleans.asm.o -o optimizedasm/printbooleans.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/printbooleans.asm-exec > outputs/printbooleans.asm.txt
diff -y -q -w outputs/printbooleans.asm.txt expectedoutputs/printbooleans.asm.txt
rm optimizedasm/printbooleans.asm.o
rm optimizedasm/printbooleans.asm-exec

as unoptimizedasm/printbooleans.asm -o unoptimizedasm/printbooleans.asm.o
ld unoptimizedasm/printbooleans.asm.o -o unoptimizedasm/printbooleans.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/printbooleans.asm-exec > outputs/printbooleans.asm.txt
diff -y -q -w outputs/printbooleans.asm.txt expectedoutputs/printbooleans.asm.txt
rm unoptimizedasm/printbooleans.asm.o
rm unoptimizedasm/printbooleans.asm-exec

as optimizedasm/foreach.asm -o optimizedasm/foreach.asm.o
ld optimizedasm/foreach.asm.o -o optimizedasm/foreach.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./optimizedasm/foreach.asm-exec > outputs/foreach.asm.txt
diff -y -q -w outputs/foreach.asm.txt expectedoutputs/foreach.asm.txt
rm optimizedasm/foreach.asm.o
rm optimizedasm/foreach.asm-exec

as unoptimizedasm/foreach.asm -o unoptimizedasm/foreach.asm.o
ld unoptimizedasm/foreach.asm.o -o unoptimizedasm/foreach.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/foreach.asm-exec > outputs/foreach.asm.txt
diff -y -q -w outputs/foreach.asm.txt expectedoutputs/foreach.asm.txt
rm unoptimizedasm/foreach.asm.o
rm unoptimizedasm/foreach.asm-exec

