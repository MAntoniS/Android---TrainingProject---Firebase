package com.example.firepets.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PetFirebaseDB {

    public final static int DB_VERSION = 1;

    private FirebaseDatabase database;

    public PetFirebaseDB() {
        this.database = FirebaseDatabase.getInstance();
    }

    public FirebaseDatabase getDatabase() {
        return database;
    }

    public DatabaseReference getDatabaseReference(){
        return database.getReference();
    }
}
