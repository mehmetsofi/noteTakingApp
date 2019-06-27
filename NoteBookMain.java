
/**
 * Write a description of class NoteBookMain here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NoteBookMain
{
    private NoteBook book;
    private NoteBookTextInterface interaction;

    /**
     * Constructor for objects of class NoteBookMain
     */
    public NoteBookMain()
    {
        book = new NoteBook(); 
        interaction = new NoteBookTextInterface(book);
        showInterface(); 
    }

    /**
     * Allow the user to interact with the notebook
     */
    public void showInterface()
    {
        interaction.run();
    }

    
}
