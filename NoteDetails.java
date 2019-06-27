
public class NoteDetails implements Comparable<NoteDetails>
{
    private String name;
    private String details;

    /**
     * Set up the note details. All details are trimmed to remove
     * trailing white space.
     * @param name the title of the note.
     * @param details details of the note
     * @throws IllegalStateException If both name and details are blank.
     */
    public NoteDetails(String name, String details)
    {
        // Use blank strings if any of the arguments is null.
        if(name == null) {
            name = "";
        }
        if(details == null) {
            details = "";
        }
        

        this.name = name.trim();
        this.details = details.trim();
        

        if(this.name.isEmpty()) {
            throw new IllegalStateException(
                      "name must not be blank");
        }
    }
    
    /**
     * @return The name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return The teledetails number.
     */
    public String getDetails()
    {
        return details;
    }
    
    /**
     * Test for content equality between two objects.
     * @param other The object to compare to this one.
     * @return true if the argument object is a set
     *              of contact details with matching attributes.
     */
    public boolean equals(Object other)
    {
        if(other instanceof NoteDetails) {
            NoteDetails otherDetails = (NoteDetails) other;
            return name.equals(otherDetails.getName()) &&
                    details.equals(otherDetails.getDetails()) ;
        }
        else {
            return false;
        }
    }

    /**
     * Compare these details against another set, for the purpose
     * of sorting. The fields are sorted by name, details, and address.
     * @param otherDetails The details to be compared against.
     * @return a negative integer if this comes before the parameter,
     *         zero if they are equal and a positive integer if this
     *         comes after the second.
     */
    public int compareTo(NoteDetails otherDetails)
    {
        int comparison = name.compareTo(otherDetails.getName());
        if(comparison != 0){
            return comparison;
        }
        
        return details.compareTo(otherDetails.getDetails());
    }

    /**
     * @return A multi-line string containing the name of the note and it's details
     */
    public String toString()
    {
        return name + "\n" + details ;
    }

    /**
     * Compute a hashcode using the rules to be found in
     * "Effective Java", by Joshua Bloch.
     * @return A hashcode for NoteDetails.
     */
    public int hashCode()
    {
        int code = 17;
        code = 37 * code + name.hashCode();
        code = 37 * code + details.hashCode();
        return code;
    }
}
