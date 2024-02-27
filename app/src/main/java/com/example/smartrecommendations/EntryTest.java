package com.example.smartrecommendations;

import com.example.smartrecommendations.Entry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntryTest {

    @Test
    void testEntryCreationAndGetters() {
        // Create a new com.example.smartrecommendations.Entry object
        Entry entry = new Entry("Movie Title", true, false);

        // Check if the getters return the correct values
        Assertions.assertEquals("Movie Title", entry.getTitle());
        Assertions.assertTrue(entry.getWatched());
        Assertions.assertFalse(entry.getRating());
    }

    @Test
    void testEntrySetters() {
        // Create a new com.example.smartrecommendations.Entry object
        Entry entry = new Entry("Movie Title", true, false);

        // Use setters to update the values
        entry.setTitle("New Title");
        entry.setWatched(false);
        entry.setRating(true);

        // Check if the getters return the updated values
        Assertions.assertEquals("New Title", entry.getTitle());
        Assertions.assertFalse(entry.getWatched());
        Assertions.assertTrue(entry.getRating());
    }

    @Test
    void testToString() {
        // Create a new com.example.smartrecommendations.Entry object
        Entry entry = new Entry("Movie Title", true, false);

        // Check if the toString method returns the expected CSV representation
        Assertions.assertEquals("\"Movie Title\", true, false", entry.toString());
    }

    @Test
    void testEquals() {
        // Create two com.example.smartrecommendations.Entry objects with the same values
        Entry entry1 = new Entry("Movie Title", true, false);
        Entry entry2 = new Entry("Movie Title", true, false);
        Entry entry3 = new Entry("Another Title", true, false);

        // Test equality
        Assertions.assertTrue(entry1.equals(entry2));
        Assertions.assertFalse(entry1.equals(entry3));
    }
}