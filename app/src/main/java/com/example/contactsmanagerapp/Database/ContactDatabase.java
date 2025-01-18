package com.example.contactsmanagerapp.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.contactsmanagerapp.DAO.ContactDAO;
import com.example.contactsmanagerapp.Entity.Contacts;

@Database(entities = {Contacts.class}, version = 1)
public abstract class ContactDatabase extends RoomDatabase {

    public abstract ContactDAO getContactDAO();

    // Singleton Pattern
    private static ContactDatabase dbInstance;

    // method to check if any instance of database exist
    public static synchronized ContactDatabase getInstance(Context context){

        // create database if is no instance
        if (dbInstance == null){
            dbInstance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ContactDatabase.class,
                    "contacts_db"
            ).fallbackToDestructiveMigration().build(); // delete the database what ever is contain for each build
        }
        return dbInstance;
    }
}
