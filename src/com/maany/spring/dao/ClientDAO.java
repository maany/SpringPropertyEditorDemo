package com.maany.spring.dao;

import com.maany.spring.model.Client;

import java.util.List;

/**
 * Created by Mayank on 9/12/2015.
 */
public class ClientDAO {
    private List<Client> clients;
    private static ClientDAO instance;

    private ClientDAO() {
    }

    /**
     * Client follows Singleton Pattern. Use this method to get the instance.
     * @return
     */
    public static ClientDAO getInstance(){
        if(instance==null)
            instance = new ClientDAO();
        return instance;
    }

    /**
     * add new clients
     * @param client
     */
    public void addClient(Client client){
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
