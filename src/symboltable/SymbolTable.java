package symboltable;

public interface SymbolTable {
    
    interface Scope {
        
        public int getNumber();
        
        public void empty();
        
        public void put(String symbol);
        
        public void putIndex(String identifier, IdentifierDescription description);
        
        public void putParameter(String subprogramIdentifier, String paramIdentifier, IdentifierDescription description);
        
        public IdentifierDescription get(String identifier);
    }
    
    interface IdentifierDescription {
        public String getName();
        
        public Scope getScope();
    }
    
    public void empty();
    
    public void put(String symbol);
    
    public IdentifierDescription get(String identifier);
    
    public void enterBlock();
    
    public void exitBlock();
    
    /* Arrays */
    public void putIndex(String identifier, IdentifierDescription description);
    
    public int first(String identifier);
    
    public int next(int idx);
    
    public int last(int idex);
    
    /* Procedure and function arguments */
    public void putParameter(String subprogramIdentifier, String paramIdentifier, IdentifierDescription description);
    
    @Override
    public String toString();
}
