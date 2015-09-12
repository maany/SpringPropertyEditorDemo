package com.maany.spring.controller;

import com.maany.spring.dao.ClientDAO;
import com.maany.spring.model.Client;
import com.maany.spring.service.ClientRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Mayank on 9/12/2015.
 */
@Controller
@RequestMapping(value="/client")
public class ClientController {
    @Autowired
    private ClientRegistrationService clientRegistrationService;
    private static final String REGISTRATION_FORM_VIEW = "registration"; //todo add address

    @RequestMapping(value = "/register", method= RequestMethod.POST)
    public ModelAndView registerClient(@Valid @ModelAttribute("client") Client client, BindingResult result){
        if(result.hasErrors())
            return new ModelAndView(REGISTRATION_FORM_VIEW);
        if(client ==null)
            throw new RuntimeException("Client was null");

        clientRegistrationService.registerNewClient(client);
        return new ModelAndView(REGISTRATION_FORM_VIEW);
    }

    @ModelAttribute("client")
    public Client getNewClient(){
        return new Client();
    }
}
