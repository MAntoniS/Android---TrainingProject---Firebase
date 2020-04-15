package com.example.firepets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.firepets.data.FirePetProvider;
import com.example.firepets.data.Pet;
import com.example.firepets.data.PetFireContract.FirePetEntry;


public class CatalogActivity extends AppCompatActivity {


    private TextView testText;

    private FirePetProvider mFireProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        mFireProvider = new FirePetProvider();
        testText = (TextView)findViewById(R.id.text);

        mFireProvider.read(testText, FirePetEntry.TEST_ID);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_catalog.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Insert dummy data" menu option
            case R.id.action_insert_dummy_data:
                // Do nothing for now
                insertDummyData();
                return true;
            // Respond to a click on the "Delete all entries" menu option
            case R.id.action_delete_all_entries:
                // Do nothing for now
                Intent intent = new Intent(CatalogActivity.this,EditorActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void insertDummyData(){

        mFireProvider.createAPet(new Pet("Boris","York","Male","12"));

    }
}
