package com.example.smartrecommendations;

import com.example.smartrecommendations.Entry;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class EntryCrud {
    private String csvFilePath;

    // Constructor
    public EntryCrud(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    // Create operation
    /**
     * Adds a new entry to the CSV file.
     * @param entry The entry to be added.
     */
    public void addEntry(Entry entry) {
        try (FileWriter writer = new FileWriter(csvFilePath, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(entryToCSV(entry));
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read operation
    /**
     * Retrieves all entries from the CSV file.
     * @return A list containing all entries.
     */
    public List<Entry> getAllEntries() {
        List<Entry> entries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                entries.add(parseCSVToEntry(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }

    // Update operation
    /**
     * Updates an existing entry with the specified title.
     * @param title The title of the entry to be updated.
     * @param updatedEntry The updated entry object.
     * @return True if the entry was successfully updated, false otherwise.
     */
    public boolean updateEntry(String title, Entry updatedEntry) {
        List<Entry> entries = getAllEntries();
        for (int i = 0; i < entries.size(); i++) {
            Entry entry = entries.get(i);
            if (entry.getTitle().equals(title)) {
                entries.set(i, updatedEntry);
                if (updateCSVFile(entries)) {
                    return true;
                }
            }
        }
        return false; // com.example.smartrecommendations.Entry with specified title not found
    }

    // Delete operation
    /**
     * Deletes an entry with the specified title.
     * @param title The title of the entry to be deleted.
     * @return True if the entry was successfully deleted, false otherwise.
     */
    public boolean deleteEntry(String title) {
        List<Entry> entries = getAllEntries();
        for (int i = 0; i < entries.size(); i++) {
            Entry entry = entries.get(i);
            if (entry.getTitle().equals(title)) {
                entries.remove(i);
                if (updateCSVFile(entries)) {
                    return true;
                }
            }
        }
        return false; // com.example.smartrecommendations.Entry with specified title not found
    }

    // Helper method to update the CSV file with a list of entries
    private boolean updateCSVFile(List<Entry> entries) {
        try (FileWriter writer = new FileWriter(csvFilePath);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (Entry entry : entries) {
                bufferedWriter.write(entryToCSV(entry));
                bufferedWriter.newLine();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Helper method to convert com.example.smartrecommendations.Entry object to CSV format
    private String entryToCSV(Entry entry) {
        return entry.getTitle() + "," + entry.getWatched() + "," + entry.getRating();
    }

    // Helper method to parse CSV line to com.example.smartrecommendations.Entry object
    private Entry parseCSVToEntry(String line) {
        String[] parts = line.split(",");
        String title = parts[0];
        boolean watched = Boolean.parseBoolean(parts[1]);
        boolean rating = Boolean.parseBoolean(parts[2]);
        return new Entry(title, watched, rating);
    }
}
