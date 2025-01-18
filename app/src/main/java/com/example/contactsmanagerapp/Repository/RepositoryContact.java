package com.example.contactsmanagerapp.Repository;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import com.example.contactsmanagerapp.DAO.ContactDAO;
import com.example.contactsmanagerapp.Database.ContactDatabase;
import com.example.contactsmanagerapp.Entity.Contacts;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class RepositoryContact {
    // The available Data Sources:
    // -Room Database

    private final ContactDAO contactDAO;
    ExecutorService executor;
    Handler handler;

    public RepositoryContact(Application application) {

        ContactDatabase contactDatabase = ContactDatabase.getInstance(application);

        this.contactDAO = contactDatabase.getContactDAO();

        // Used for Background Database Operations
         executor = Executors.newSingleThreadExecutor();

        // Used for updating the UI
        handler = new Handler(Looper.getMainLooper());
    }

    // Methods in DAO is being executed from Repository
    public void addContact(Contacts contact){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                // Execute this code asynchronously
                // on separate thread
                contactDAO.insert(contact);
            }
        });
    }

    public void deleteContact(Contacts contact){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.delete(contact);
            }
        });
    }

    public LiveData<List<Contacts>> getAllContacts(){
        return contactDAO.getAllContacts();
    }
}
