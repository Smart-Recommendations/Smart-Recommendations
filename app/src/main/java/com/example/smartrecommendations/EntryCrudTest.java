package com.example.smartrecommendations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import android.os.Build;

import androidx.annotation.RequiresApi;
public class EntryCrudTest {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Test
    void testAddOperations() throws IOException {
        // Create a temporary CSV file for testing
        Path tempFile = Files.createTempFile("test", ".csv");

        // Create an com.example.smartrecommendations.EntryCrud object with the temporary CSV file path
        EntryCrud entryCrud = new EntryCrud(tempFile.toString());

        // Create some sample entries
        Entry entry1 = new Entry("Movie 1", true, true);
        Entry entry2 = new Entry("Movie 2", false, false);

        // Add entries
        entryCrud.addEntry(entry1);
        entryCrud.addEntry(entry2);

        // Gets the entries and verifies that they were correctly added
        List<Entry> entries = entryCrud.getAllEntries();
        assertEquals(2, entries.size());
        Assertions.assertEquals(entry1, entries.get(0));
        Assertions.assertEquals(entry2, entries.get(1));

        // Cleanup: Delete the temporary CSV file
        Files.deleteIfExists(tempFile);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Test
    void testUpdateOperation() throws IOException {
        // Create a temporary CSV file for testing
        Path tempFile = Files.createTempFile("test", ".csv");

        // Create an com.example.smartrecommendations.EntryCrud object with the temporary CSV file path
        EntryCrud entryCrud = new EntryCrud(tempFile.toString());

        // Create some sample entries
        Entry entry1 = new Entry("Movie 1", true, true);
        Entry entry2 = new Entry("Movie 2", false, false);

        // Add entries
        entryCrud.addEntry(entry1);
        entryCrud.addEntry(entry2);

        // Update an entry
        Entry updatedEntry = new Entry("Updated Movie 1", false, true);
        Assertions.assertTrue(entryCrud.updateEntry("Movie 1", updatedEntry));

        // Get all entries and verify they are added correctly
        List<Entry> entries = entryCrud.getAllEntries();

        // Verify the entry is updated correctly
        entries = entryCrud.getAllEntries();
        assertEquals(2, entries.size());
        Assertions.assertEquals(updatedEntry, entries.get(0));

        // Cleanup: Delete the temporary CSV file
        Files.deleteIfExists(tempFile);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Test
    void testDeleteOperations() throws IOException{
        // Create a temporary CSV file for testing
        Path tempFile = Files.createTempFile("test", ".csv");

        // Create an com.example.smartrecommendations.EntryCrud object with the temporary CSV file path
        EntryCrud entryCrud = new EntryCrud(tempFile.toString());

        // Create some sample entries
        Entry entry1 = new Entry("Movie 1", true, true);
        Entry entry2 = new Entry("Movie 2", false, false);

        // Add entries
        entryCrud.addEntry(entry1);
        entryCrud.addEntry(entry2);

        // Update an entry
        Entry updatedEntry = new Entry("Updated Movie 1", false, true);
        Assertions.assertTrue(entryCrud.updateEntry("Movie 1", updatedEntry));

        // Get all entries and verify they are added correctly
        List<Entry> entries = entryCrud.getAllEntries();

        // Delete an entry
        Assertions.assertTrue(entryCrud.deleteEntry("Updated Movie 1"));

        // Verify the entry is deleted correctly
        entries = entryCrud.getAllEntries();
        assertEquals(1, entries.size());
        Assertions.assertEquals(entry2, entries.get(0));

        // Cleanup: Delete the temporary CSV file
        Files.deleteIfExists(tempFile);
    }

}


