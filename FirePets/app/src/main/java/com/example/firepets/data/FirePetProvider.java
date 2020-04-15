package com.example.firepets.data;


import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.example.firepets.data.PetFireContract.FirePetEntry;

public class FirePetProvider {

    public static final String LOG_TAG = FirePetProvider.class.getSimpleName();

    private PetFirebaseDB mFireDB;

    public FirePetProvider(){
        mFireDB = new PetFirebaseDB();
    }

    public void createAPet(Pet pet){

        DatabaseReference myRef = mFireDB.getDatabaseReference();

        String petID = Integer.toString(Pet.getmPetID());
        myRef.child(FirePetEntry.DB_ROOT)
                .child(FirePetEntry.NODE_PETS)
                .child(FirePetEntry.NODE_ID)
                .child(petID)
                .setValue(pet);
    }

    public void read(final TextView textView,final String petID){
        DatabaseReference myRef = mFireDB.getDatabase().getReference();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot
                        .child(FirePetEntry.DB_ROOT)
                        .child(FirePetEntry.NODE_PETS)
                        .child(FirePetEntry.NODE_ID)
                        .child(petID)
                        .getValue(String.class);
                ;
                textView.setText(value);
                Log.d(LOG_TAG, "Value read finished " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(LOG_TAG, "Failed to read value.", error.toException());
            }
        });

    }

    public void update(){}

    public void delete(){}

}
