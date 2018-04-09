package magstash;

import java.util.HashSet;

/**
 * A class that holds all literature in a HashSet. Work in progress.
 * 
 * @author Fredrik
 */
public class LiteratureRegister {
    private HashSet<Literature> litRegister;
    
    public LiteratureRegister() {
        litRegister = new HashSet<>();
    }
    
    public void addLiterature(Literature l) {
        
    }
    
    public Literature getByTitle(String title) {
        return null;
    }
    
    public Literature getByPublisher(String publisher) {
        return null;
    }
}