package concept;

public interface HasDescription {
    /**
     * Get human-readable description of object.
     * @return String containing human-readable description.
     */
    String getDescription();

    /**
     * Get minimal human-readable description of object.
     * @return String containing terse description.
     */
    String getShortDescription();
}
