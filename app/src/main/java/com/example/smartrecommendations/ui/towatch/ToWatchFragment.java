package com.example.smartrecommendations.ui.towatch;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartrecommendations.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ToWatchFragment extends Fragment {

    private EditText editTextMovie;
    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;
    private static final String SHARED_PREFS_NAME = "ToWatchPrefs";
    private static final String KEY_ITEMS = "items";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_to_watch, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editTextMovie = view.findViewById(R.id.editTextMovie);
        Button buttonAdd = view.findViewById(R.id.buttonAdd);
        ListView listView = view.findViewById(R.id.listView);

        loadItemsFromSharedPreferences();

        adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        buttonAdd.setOnClickListener(this::addToList);

        // Add item click listener to delete item when clicked
        listView.setOnItemClickListener((parent, view1, position, id) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(R.string.todo);
            builder.setPositiveButton(R.string.movetowatched, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            builder.setNegativeButton(R.string.delete, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String selectedItem = items.get(position);
                    items.remove(selectedItem);
                    adapter.notifyDataSetChanged();
                    saveItemsToSharedPreferences();
                    Toast.makeText(requireContext(), "Item deleted", Toast.LENGTH_SHORT).show();
                }
            });
            builder.show();
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        saveItemsToSharedPreferences();
    }

    private void addToList(View view) {
            String newItem = editTextMovie.getText().toString().trim();
            if (!newItem.isEmpty()) {
                items.add(newItem);
                adapter.notifyDataSetChanged();
                editTextMovie.getText().clear();
                saveItemsToSharedPreferences();
            }
    }

    private void loadItemsFromSharedPreferences() {
        SharedPreferences sharedPreferences = requireContext().getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        Set<String> itemSet = sharedPreferences.getStringSet(KEY_ITEMS, new HashSet<>());
        items = new ArrayList<>(itemSet);
    }

    private void saveItemsToSharedPreferences() {
        SharedPreferences sharedPreferences = requireContext().getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> itemSet = new HashSet<>(items);
        editor.putStringSet(KEY_ITEMS, itemSet);
        editor.apply();
    }
}
