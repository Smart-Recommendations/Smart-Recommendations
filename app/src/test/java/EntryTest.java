import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EntryTest {

    @Test
    void testEntryCreationAndGetters() {
        // Create a new Entry object
        Entry entry = new Entry("Movie Title", true, false);

        // Check if the getters return the correct values
        assertEquals("Movie Title", entry.getTitle());
        assertTrue(entry.getWatched());
        assertFalse(entry.getRating());
    }

    @Test
    void testEntrySetters() {
        // Create a new Entry object
        Entry entry = new Entry("Movie Title", true, false);

        // Use setters to update the values
        entry.setTitle("New Title");
        entry.setWatched(false);
        entry.setRating(true);

        // Check if the getters return the updated values
        assertEquals("New Title", entry.getTitle());
        assertFalse(entry.getWatched());
        assertTrue(entry.getRating());
    }

    @Test
    void testToString() {
        // Create a new Entry object
        Entry entry = new Entry("Movie Title", true, false);

        // Check if the toString method returns the expected CSV representation
        assertEquals("\"Movie Title\", true, false", entry.toString());
    }

    @Test
    void testEquals() {
        // Create two Entry objects with the same values
        Entry entry1 = new Entry("Movie Title", true, false);
        Entry entry2 = new Entry("Movie Title", true, false);
        Entry entry3 = new Entry("Another Title", true, false);

        // Test equality
        assertTrue(entry1.equals(entry2));
        assertFalse(entry1.equals(entry3));
    }
}