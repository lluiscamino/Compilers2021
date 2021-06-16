package optimizers.local;

import optimizers.utils.BasicBloc;
import tac.instructions.TACInstruction;
import tac.instructions.arithmetic.CopyInstruction;
import tac.references.TACReference;
import tac.references.TACVariable;

import java.util.*;

public final class CopyPropagationOptimizer extends LocalOptimizer {
    public CopyPropagationOptimizer(List<TACInstruction> unoptimizedInstructions, Collection<BasicBloc> basicBlocs) {
        super(unoptimizedInstructions, basicBlocs);
    }

    @Override
    public List<TACInstruction> optimize() {
        Map<BasicBloc, Collection<TACVariable[]>> generatedElements = new HashMap<>();
        Map<BasicBloc, Collection<TACVariable[]>> removedElements = new HashMap<>();
        for (BasicBloc basicBloc : basicBlocs) {
            Collection<TACVariable[]> basicBlocGeneratedElements = new ArrayList<>(),
                    basicBlocRemovedElements = new ArrayList<>();
            generatedElements.put(basicBloc, basicBlocGeneratedElements);
            removedElements.put(basicBloc, basicBlocRemovedElements);
            for (int line = basicBloc.getStartLineNumber(); line <= basicBloc.getEndLineNumber(); line++) {
                TACInstruction instruction = unoptimizedInstructions.get(line);
                if (!(instruction.getFirstReference() instanceof TACVariable)) {
                    continue;
                }
                propagateCopies(basicBlocGeneratedElements, instruction);
                removeNoLongerAvailableCopies(basicBlocGeneratedElements, basicBlocRemovedElements, instruction);
                addNewAvailableCopy(basicBlocGeneratedElements, instruction);
            }
        }
        return unoptimizedInstructions;
    }

    private void propagateCopies(Collection<TACVariable[]> generatedElements, TACInstruction instruction) {
        TACReference[] references = {instruction.getSecondReference(), instruction.getThirdReference()};
        for (int referencePosition = 0; referencePosition < references.length; referencePosition++) {
            if (references[referencePosition] instanceof TACVariable) {
                TACVariable pair = findPair(generatedElements, (TACVariable) references[referencePosition]);
                if (pair != null) {
                    replaceVariable(instruction, referencePosition, pair);
                }
            }
        }
    }

    private void replaceVariable(TACInstruction instruction, int position, TACVariable variable) {
        switch (position) {
            case 0 -> instruction.setSecondReference(variable);
            case 1 -> instruction.setThirdReference(variable);
        }
    }

    // Find element c such that \exists (a,c) \in G(b) | x = a
    private TACVariable findPair(Collection<TACVariable[]> generatedElements, TACVariable variable) {
        for (TACVariable[] pair : generatedElements) {
            if (pair[0].equals(variable)) {
                return pair[1];
            }
        }
        return null;
    }

    private void removeNoLongerAvailableCopies(
            Collection<TACVariable[]> generatedElements,
            Collection<TACVariable[]> removedElements,
            TACInstruction instruction
    ) {
        TACVariable destinyReference = (TACVariable) instruction.getFirstReference();
        for (TACInstruction iteratingInstruction : unoptimizedInstructions) {
            if (iteratingInstruction instanceof CopyInstruction) {
                TACReference firstReference = iteratingInstruction.getFirstReference(),
                        secondReference = iteratingInstruction.getSecondReference();
                if (!(firstReference instanceof TACVariable) || !(secondReference instanceof TACVariable)) {
                    continue;
                }
                if (firstReference.equals(destinyReference) || secondReference.equals(destinyReference)) {
                    TACVariable[] pair = variablesToPair(firstReference, secondReference);
                    removePair(generatedElements, pair);
                    removedElements.add(pair);
                }
            }
        }
    }

    private void addNewAvailableCopy(Collection<TACVariable[]> generatedElements, TACInstruction instruction) {
        if (instruction instanceof CopyInstruction && instruction.getSecondReference() instanceof TACVariable) {
            generatedElements.add(variablesToPair(instruction.getFirstReference(), instruction.getSecondReference()));
        }
    }

    private TACVariable[] variablesToPair(TACReference reference1, TACReference reference2) {
        if (reference1 instanceof TACVariable && reference2 instanceof TACVariable) {
            return new TACVariable[]{(TACVariable) reference1, (TACVariable) reference2};
        }
        throw new RuntimeException("References need to be TACVariables to convert them to a pair");
    }

    private void removePair(Collection<TACVariable[]> elements, TACVariable[] pair) {
        elements.removeIf(iteratingPair -> pairsAreEqual(iteratingPair, pair));
    }

    private boolean pairsAreEqual(TACVariable[] pair1, TACVariable[] pair2) {
        return pair1[0].equals(pair2[0]) && pair1[1].equals(pair2[1]);
    }
}
