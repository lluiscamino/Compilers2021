#! /bin/bash

as unoptimizedasm/basicforloop.asm -o unoptimizedasm/basicforloop.asm.o
ld unoptimizedasm/basicforloop.asm.o -o unoptimizedasm/basicforloop.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/basicforloop.asm-exec > outputs/basicforloop.asm.txt
diff -y -q -w outputs/basicforloop.asm.txt expectedoutputs/basicforloop.asm.txt
rm unoptimizedasm/basicforloop.asm.o
rm unoptimizedasm/basicforloop.asm-exec

as unoptimizedasm/max5.asm -o unoptimizedasm/max5.asm.o
ld unoptimizedasm/max5.asm.o -o unoptimizedasm/max5.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/max5.asm-exec > outputs/max5.asm.txt
diff -y -q -w outputs/max5.asm.txt expectedoutputs/max5.asm.txt
rm unoptimizedasm/max5.asm.o
rm unoptimizedasm/max5.asm-exec

as unoptimizedasm/globalvariables.asm -o unoptimizedasm/globalvariables.asm.o
ld unoptimizedasm/globalvariables.asm.o -o unoptimizedasm/globalvariables.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/globalvariables.asm-exec > outputs/globalvariables.asm.txt
diff -y -q -w outputs/globalvariables.asm.txt expectedoutputs/globalvariables.asm.txt
rm unoptimizedasm/globalvariables.asm.o
rm unoptimizedasm/globalvariables.asm-exec

as unoptimizedasm/forloop.asm -o unoptimizedasm/forloop.asm.o
ld unoptimizedasm/forloop.asm.o -o unoptimizedasm/forloop.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/forloop.asm-exec > outputs/forloop.asm.txt
diff -y -q -w outputs/forloop.asm.txt expectedoutputs/forloop.asm.txt
rm unoptimizedasm/forloop.asm.o
rm unoptimizedasm/forloop.asm-exec

as unoptimizedasm/printmax.asm -o unoptimizedasm/printmax.asm.o
ld unoptimizedasm/printmax.asm.o -o unoptimizedasm/printmax.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/printmax.asm-exec > outputs/printmax.asm.txt
diff -y -q -w outputs/printmax.asm.txt expectedoutputs/printmax.asm.txt
rm unoptimizedasm/printmax.asm.o
rm unoptimizedasm/printmax.asm-exec

as unoptimizedasm/differentscopesmain.asm -o unoptimizedasm/differentscopesmain.asm.o
ld unoptimizedasm/differentscopesmain.asm.o -o unoptimizedasm/differentscopesmain.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/differentscopesmain.asm-exec > outputs/differentscopesmain.asm.txt
diff -y -q -w outputs/differentscopesmain.asm.txt expectedoutputs/differentscopesmain.asm.txt
rm unoptimizedasm/differentscopesmain.asm.o
rm unoptimizedasm/differentscopesmain.asm-exec

as unoptimizedasm/arrayliterallength.asm -o unoptimizedasm/arrayliterallength.asm.o
ld unoptimizedasm/arrayliterallength.asm.o -o unoptimizedasm/arrayliterallength.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/arrayliterallength.asm-exec > outputs/arrayliterallength.asm.txt
diff -y -q -w outputs/arrayliterallength.asm.txt expectedoutputs/arrayliterallength.asm.txt
rm unoptimizedasm/arrayliterallength.asm.o
rm unoptimizedasm/arrayliterallength.asm-exec

as unoptimizedasm/bubblesort.asm -o unoptimizedasm/bubblesort.asm.o
ld unoptimizedasm/bubblesort.asm.o -o unoptimizedasm/bubblesort.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/bubblesort.asm-exec > outputs/bubblesort.asm.txt
diff -y -q -w outputs/bubblesort.asm.txt expectedoutputs/bubblesort.asm.txt
rm unoptimizedasm/bubblesort.asm.o
rm unoptimizedasm/bubblesort.asm-exec

as unoptimizedasm/printstrings.asm -o unoptimizedasm/printstrings.asm.o
ld unoptimizedasm/printstrings.asm.o -o unoptimizedasm/printstrings.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/printstrings.asm-exec > outputs/printstrings.asm.txt
diff -y -q -w outputs/printstrings.asm.txt expectedoutputs/printstrings.asm.txt
rm unoptimizedasm/printstrings.asm.o
rm unoptimizedasm/printstrings.asm-exec

as unoptimizedasm/average.asm -o unoptimizedasm/average.asm.o
ld unoptimizedasm/average.asm.o -o unoptimizedasm/average.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/average.asm-exec > outputs/average.asm.txt
diff -y -q -w outputs/average.asm.txt expectedoutputs/average.asm.txt
rm unoptimizedasm/average.asm.o
rm unoptimizedasm/average.asm-exec

as unoptimizedasm/twosum.asm -o unoptimizedasm/twosum.asm.o
ld unoptimizedasm/twosum.asm.o -o unoptimizedasm/twosum.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/twosum.asm-exec > outputs/twosum.asm.txt
diff -y -q -w outputs/twosum.asm.txt expectedoutputs/twosum.asm.txt
rm unoptimizedasm/twosum.asm.o
rm unoptimizedasm/twosum.asm-exec

as unoptimizedasm/binarysearch.asm -o unoptimizedasm/binarysearch.asm.o
ld unoptimizedasm/binarysearch.asm.o -o unoptimizedasm/binarysearch.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/binarysearch.asm-exec > outputs/binarysearch.asm.txt
diff -y -q -w outputs/binarysearch.asm.txt expectedoutputs/binarysearch.asm.txt
rm unoptimizedasm/binarysearch.asm.o
rm unoptimizedasm/binarysearch.asm-exec

as unoptimizedasm/unusedprocedure.asm -o unoptimizedasm/unusedprocedure.asm.o
ld unoptimizedasm/unusedprocedure.asm.o -o unoptimizedasm/unusedprocedure.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/unusedprocedure.asm-exec > outputs/unusedprocedure.asm.txt
diff -y -q -w outputs/unusedprocedure.asm.txt expectedoutputs/unusedprocedure.asm.txt
rm unoptimizedasm/unusedprocedure.asm.o
rm unoptimizedasm/unusedprocedure.asm-exec

as unoptimizedasm/while.asm -o unoptimizedasm/while.asm.o
ld unoptimizedasm/while.asm.o -o unoptimizedasm/while.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/while.asm-exec > outputs/while.asm.txt
diff -y -q -w outputs/while.asm.txt expectedoutputs/while.asm.txt
rm unoptimizedasm/while.asm.o
rm unoptimizedasm/while.asm-exec

as unoptimizedasm/comparestrings.asm -o unoptimizedasm/comparestrings.asm.o
ld unoptimizedasm/comparestrings.asm.o -o unoptimizedasm/comparestrings.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/comparestrings.asm-exec > outputs/comparestrings.asm.txt
diff -y -q -w outputs/comparestrings.asm.txt expectedoutputs/comparestrings.asm.txt
rm unoptimizedasm/comparestrings.asm.o
rm unoptimizedasm/comparestrings.asm-exec

as unoptimizedasm/printstringslength.asm -o unoptimizedasm/printstringslength.asm.o
ld unoptimizedasm/printstringslength.asm.o -o unoptimizedasm/printstringslength.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/printstringslength.asm-exec > outputs/printstringslength.asm.txt
diff -y -q -w outputs/printstringslength.asm.txt expectedoutputs/printstringslength.asm.txt
rm unoptimizedasm/printstringslength.asm.o
rm unoptimizedasm/printstringslength.asm-exec

as unoptimizedasm/fibonacci.asm -o unoptimizedasm/fibonacci.asm.o
ld unoptimizedasm/fibonacci.asm.o -o unoptimizedasm/fibonacci.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/fibonacci.asm-exec > outputs/fibonacci.asm.txt
diff -y -q -w outputs/fibonacci.asm.txt expectedoutputs/fibonacci.asm.txt
rm unoptimizedasm/fibonacci.asm.o
rm unoptimizedasm/fibonacci.asm-exec

as unoptimizedasm/onedimensionarrayinstance.asm -o unoptimizedasm/onedimensionarrayinstance.asm.o
ld unoptimizedasm/onedimensionarrayinstance.asm.o -o unoptimizedasm/onedimensionarrayinstance.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/onedimensionarrayinstance.asm-exec > outputs/onedimensionarrayinstance.asm.txt
diff -y -q -w outputs/onedimensionarrayinstance.asm.txt expectedoutputs/onedimensionarrayinstance.asm.txt
rm unoptimizedasm/onedimensionarrayinstance.asm.o
rm unoptimizedasm/onedimensionarrayinstance.asm-exec

as unoptimizedasm/onedimensionarrayliteral.asm -o unoptimizedasm/onedimensionarrayliteral.asm.o
ld unoptimizedasm/onedimensionarrayliteral.asm.o -o unoptimizedasm/onedimensionarrayliteral.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/onedimensionarrayliteral.asm-exec > outputs/onedimensionarrayliteral.asm.txt
diff -y -q -w outputs/onedimensionarrayliteral.asm.txt expectedoutputs/onedimensionarrayliteral.asm.txt
rm unoptimizedasm/onedimensionarrayliteral.asm.o
rm unoptimizedasm/onedimensionarrayliteral.asm-exec

as unoptimizedasm/lucassequence.asm -o unoptimizedasm/lucassequence.asm.o
ld unoptimizedasm/lucassequence.asm.o -o unoptimizedasm/lucassequence.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/lucassequence.asm-exec > outputs/lucassequence.asm.txt
diff -y -q -w outputs/lucassequence.asm.txt expectedoutputs/lucassequence.asm.txt
rm unoptimizedasm/lucassequence.asm.o
rm unoptimizedasm/lucassequence.asm-exec

as unoptimizedasm/identity.asm -o unoptimizedasm/identity.asm.o
ld unoptimizedasm/identity.asm.o -o unoptimizedasm/identity.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/identity.asm-exec > outputs/identity.asm.txt
diff -y -q -w outputs/identity.asm.txt expectedoutputs/identity.asm.txt
rm unoptimizedasm/identity.asm.o
rm unoptimizedasm/identity.asm-exec

as unoptimizedasm/simplevariablepass.asm -o unoptimizedasm/simplevariablepass.asm.o
ld unoptimizedasm/simplevariablepass.asm.o -o unoptimizedasm/simplevariablepass.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/simplevariablepass.asm-exec > outputs/simplevariablepass.asm.txt
diff -y -q -w outputs/simplevariablepass.asm.txt expectedoutputs/simplevariablepass.asm.txt
rm unoptimizedasm/simplevariablepass.asm.o
rm unoptimizedasm/simplevariablepass.asm-exec

as unoptimizedasm/multidimensionalarrayinstance.asm -o unoptimizedasm/multidimensionalarrayinstance.asm.o
ld unoptimizedasm/multidimensionalarrayinstance.asm.o -o unoptimizedasm/multidimensionalarrayinstance.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/multidimensionalarrayinstance.asm-exec > outputs/multidimensionalarrayinstance.asm.txt
diff -y -q -w outputs/multidimensionalarrayinstance.asm.txt expectedoutputs/multidimensionalarrayinstance.asm.txt
rm unoptimizedasm/multidimensionalarrayinstance.asm.o
rm unoptimizedasm/multidimensionalarrayinstance.asm-exec

as unoptimizedasm/printbooleans.asm -o unoptimizedasm/printbooleans.asm.o
ld unoptimizedasm/printbooleans.asm.o -o unoptimizedasm/printbooleans.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/printbooleans.asm-exec > outputs/printbooleans.asm.txt
diff -y -q -w outputs/printbooleans.asm.txt expectedoutputs/printbooleans.asm.txt
rm unoptimizedasm/printbooleans.asm.o
rm unoptimizedasm/printbooleans.asm-exec

as unoptimizedasm/foreach.asm -o unoptimizedasm/foreach.asm.o
ld unoptimizedasm/foreach.asm.o -o unoptimizedasm/foreach.asm-exec -macosx_version_min 11.0  -L /Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/lib -lSystem
./unoptimizedasm/foreach.asm-exec > outputs/foreach.asm.txt
diff -y -q -w outputs/foreach.asm.txt expectedoutputs/foreach.asm.txt
rm unoptimizedasm/foreach.asm.o
rm unoptimizedasm/foreach.asm-exec

