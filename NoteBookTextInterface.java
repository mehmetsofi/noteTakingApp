public class NoteBookTextInterface
{
    // The address book to be viewed and manipulated.
    private NoteBook book;
    // A parser for handling user commands.
    private Parser parser;
    
    /**
     * Constructor for objects of class NoteBookTextInterface
     * @param book The notebook to be manipulated.
     */
    public NoteBookTextInterface(NoteBook book)
    {
        this.book = book;
        parser = new Parser();
    }
    
    /**
     * Read a series of commands from the user to interact
     * with the notebook. Stop when the user types 'quit'.
     */
    public void run()
    {
        System.out.println("Notebook- note taking made simple.");
        System.out.println("Type 'help' for a list of commands.");
        
        String command;
        do{
            command = parser.getCommand();
            if(command.equals("add")){ 
                add();
            }
            else if(command.equals("list")){
                list();
            }
            else if(command.equals("remove")){
                remove();
            }
            else if(command.equals("help")){
                help();
            }
            else{
                // Do nothing.
            }
        } while(!(command.equals("quit")));

        System.out.println("Goodbye.");
    }
    
    /**
     * Add a new entry.
     */
    private void add()
    {
        System.out.print("Name: ");
        String name = parser.readLine();
        System.out.print("details: ");
        String details = parser.readLine();
        
        book.addDetails(new NoteDetails(name, details));
    }
    
    
    
    /**
     * Remove an entry matching a key.
     */
    private void remove()
    {
        System.out.println("Type the key of the entry.");
        String key = parser.readLine();
        book.removeDetails(key);
    }
    
    
    
    /**
     * List the available commands.
     */
    private void help()
    {
        parser.showCommands();
    }
    
    /**
     * List the book's contents.
     */
    private void list()
    {
        System.out.println(book.listDetails());
    }
}