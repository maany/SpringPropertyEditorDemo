package com.maany.spring.controller;

import com.maany.spring.dao.ClientDAO;
import com.maany.spring.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Mayank on 9/12/2015.
 */
@Controller
public class ClientRegistrationFormController {

    @Autowired
    private ClientDAO clientDAO;

    public void registerNewClient(Client client){
        clientDAO.addClient(client);
    }

    public Client getClient(int id){
        return clientDAO.getClient(id);
    }
}
