package com.artwood.Dao;

import com.artwood.model.Client;

// Interface
public interface ClientDao {
    void addClient(Client client);

    Client getClient(long id);

    void updateClient(Client client);

    void deleteClient(long id);
}

