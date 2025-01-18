package com.example.contactsmanagerapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.contactsmanagerapp.Entity.Contacts;
import com.example.contactsmanagerapp.Repository.RepositoryContact;

import java.util.List;

public class MyViewmodel extends AndroidViewModel {

    // If you need to use context inside your Viewmodel
    // You should use AndroidViewModel (AVM)
    // Because it contains the application context.

    private RepositoryContact repositoryContact;

    // LiveData
    private LiveData<List<Contacts>> allContacts;

    public MyViewmodel(@NonNull Application application
    ) {
        super(application);
        this.repositoryContact = new RepositoryContact(application);
    }

    public LiveData<List<Contacts>> getAllContacts() {
        allContacts = repositoryContact.getAllContacts();
        return allContacts;
    }

    public void addNewContact(Contacts contacts){
        repositoryContact.addContact(contacts);
    }

    public void deleteContact(Contacts contacts){
        repositoryContact.deleteContact(contacts);
    }
}
