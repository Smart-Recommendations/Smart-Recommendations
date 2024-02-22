import java.util.Objects;

/**
 * Represents an entry into a list with a title, watched status, and rating.
 */
public class Entry {
    // Variables for an entry into the list
    private String title;
    private boolean watched;
    private boolean rating;

    /**
     * Constructor to initialize an Entry object with provided title, watched status, and rating.
     * @param title The title of the entry.
     * @param watched The watched status of the entry (true if watched, false otherwise).
     * @param rating The rating of the entry (true if rated, false otherwise).
     */
    public Entry(String title, boolean watched, boolean rating) {
        this.title = title;
        this.watched = watched;
        this.rating = rating;
    }

    /**
     * Returns the title of the entry.
     * @return The title of the entry.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the watched status of the entry.
     * @return True if the entry is watched, false otherwise.
     */
    public boolean getWatched() {
        return watched;
    }

    /**
     * Returns the rating status of the entry.
     * @return True if the entry is rated, false otherwise.
     */
    public boolean getRating() {
        return rating;
    }

    /**
     * Sets the title of the entry.
     * @param title The new title for the entry.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the watched status of the entry.
     * @param watched The new watched status for the entry.
     */
    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    /**
     * Sets the rating status of the entry.
     * @param rating The new rating status for the entry.
     */
    public void setRating(boolean rating) {
        this.rating = rating;
    }

    /**
     * Returns a CSV representation of the Entry object.
     * @return A CSV string representing the Entry object.
     */
    @Override
    public String toString() {
        return "\"" + title + "\", " + watched + ", " + rating;
    }

    // Override equals method to compare entry content
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Entry entry = (Entry) obj;
        return watched == entry.watched &&
                rating == entry.rating &&
                Objects.equals(title, entry.title);
    }
}

