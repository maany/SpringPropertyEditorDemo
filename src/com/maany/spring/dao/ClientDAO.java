package com.maany.spring.dao;

import com.maany.spring.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Mayank on 9/12/2015.
 */
@Repository
public class ClientDAO {
    private Collection<Client> clients = new ArrayList<Client>();
    private static int counter = 0;
    /**
     * add new clients
     * @param client
     */
    public void addClient(Client client){
        client.setId(counter);
        counter++;
        clients.add(client);
    }

    /**
     * Perform Read and Update operation of CRUD
     * Get references of stored clients.
     * Update Client : Any changes made to the reference will reflect in the client
     * @param id
     * @return
     */
    public Client getClient(int id){
        Client client = null;
        for(Client clientFromList:clients){
            if(clientFromList.getId()==id) {
                client = clientFromList;
                break;
            }
        }
        return client;
    }

    /**
     * remove the client
     * @param client
     */
    public void removeClient(Client client){
        if(clients.contains(client))
            clients.remove(client);
    }

}
