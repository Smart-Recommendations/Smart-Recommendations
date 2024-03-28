package com.example.smartrecommendations.ui.towatch;




import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;




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




        loadItemsFromSharedPreferences(); // Load items from SharedPreferences




        adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);




        buttonAdd.setOnClickListener(this::addToList);
    }


    @Override
    public void onPause() {
        super.onPause();
        saveItemsToSharedPreferences(); // Save items to SharedPreferences when fragment pauses
    }


    private void addToList(View view) {
        // Check if the list size is less than 10
        if (items.size() < 10) {
            String newItem = editTextMovie.getText().toString().trim();
            if (!newItem.isEmpty()) {
                items.add(newItem);
                adapter.notifyDataSetChanged();
                editTextMovie.getText().clear();
            }
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
