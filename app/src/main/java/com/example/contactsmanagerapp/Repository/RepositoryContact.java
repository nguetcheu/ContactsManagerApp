package com.example.contactsmanagerapp.Repository;

import com.example.contactsmanagerapp.Entity.ContactDAO;
import com.example.contactsmanagerapp.Entity.Contacts;

import java.util.List;

public class RepositoryContact {
    // The available Data Sources:
    // -Room Database

    private final ContactDAO contactDAO;

    public RepositoryContact(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    // Methods in DAO is being executed from Repository
    public void addContact(Contacts contact){
        contactDAO.insert(contact);
    }

    public void deleteContact(Contacts contact){
        contactDAO.delete(contact);
    }

    public List<Contacts> getAllContacts(){
        return contactDAO.getAllContacts();
    }
}
