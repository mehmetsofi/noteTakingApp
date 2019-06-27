import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * A class to maintain an arbitrary number of notes.
 * Details are indexed by title of the note.
 * 
 */
public class NoteBook
{
    // Storage for an arbitrary number of details.
    private TreeMap<String, NoteDetails> book;
    private int numberOfEntries;

    /**
     * Perform any initialization for the notebook.
     */
    public NoteBook()
    {
        book = new TreeMap<>();
        numberOfEntries = 0;
    }
    
    /**
     * Look up a note ad return it's details
     * @param key The title looked up.
     * @return The details corresponding to the key.
     */
    public NoteDetails getDetails(String key)
    {
        return book.get(key);
    }

    /**
     * Return whether or not the current key is in use.
     * @param key The title to be looked up
     * @return true if the key is in use, false otherwise.
     */
    public boolean keyInUse(String key)
    {
        return book.containsKey(key);
    }

    /**
     * Add a new set of details to the notebook
     * @param details The details to associate with the new note
     */
    public void addDetails(NoteDetails details)
    {
        if(details == null) {
            throw new IllegalArgumentException("Null details passed to addDetails.");
        }
        book.put(details.getName(), details);
        
        numberOfEntries++;
    }

    /**
     * Return the number of entries currently in the
     * notebook
     * @return The number of entries.
     */
    public int getNumberOfEntries()
    {
        return numberOfEntries;
    }

    /**
     * Remove the entry with the given key from the notebook.
     * The key should be one that is currently in use.
     * @param key One of the keys of the entry to be removed.
     * @throws IllegalArgumentException If the key is null.
     */
    public void removeDetails(String key)
    {
        if(key == null){
            throw new IllegalArgumentException("Null key passed to removeDetails.");
        }
        if(keyInUse(key)) {
            NoteDetails details = book.get(key);
            book.remove(details.getName());
            
            numberOfEntries--;
        }
    }

    /**
     * Return all the note details, sorted according
     * to the sort order of the NoteDetails class.
     * @return A sorted list of the details.
     */
    public String listDetails()
    {
        // Because each entry is stored under two keys, it is
        // necessary to build a set of the NoteDetails. This
        // eliminates duplicates.
        StringBuilder allEntries = new StringBuilder();
       
        Set<NoteDetails> sortedDetails = new TreeSet<>(book.values());
        for(NoteDetails details : sortedDetails) {
            allEntries.append(details).append("\n\n");
        }
        return allEntries.toString();
    }
}