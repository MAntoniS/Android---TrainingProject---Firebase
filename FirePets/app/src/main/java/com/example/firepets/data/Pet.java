package com.example.firepets.data;

public class Pet {

    private static int mPetID = 0;
    private String mPetName;
    private String mPetBreed;
    private String mPetGender;
    private String mPetWeight;

    public Pet(String mPetName, String mPetBreed, String mPetGender, String mPetWeight) {
        this.mPetName = mPetName;
        this.mPetBreed = mPetBreed;
        this.mPetGender = mPetGender;
        this.mPetWeight = mPetWeight;
        mPetID ++;
    }

    public static int getmPetID() {
        return mPetID;
    }

    public String getmPetName() {
        return mPetName;
    }

    public String getmPetBreed() {
        return mPetBreed;
    }

    public String getmPetGender() {
        return mPetGender;
    }

    public String getmPetWeight() {
        return mPetWeight;
    }
}
