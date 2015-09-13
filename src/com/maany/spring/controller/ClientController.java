package com.maany.spring.controller;

import com.maany.spring.dao.ClientDAO;
import com.maany.spring.model.Address;
import com.maany.spring.model.Client;
import com.maany.spring.propertyeditor.CollectionPropertyEditor;
import com.maany.spring.service.ClientRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.Collection;

/**
 * Created by Mayank on 9/12/2015.
 */
@Controller
@RequestMapping(value="/client/register.form")
public class ClientController {
    @Autowired
    private ClientRegistrationService clientRegistrationService;
    public static final String REGISTRATION_FORM_VIEW = "registration";
    @RequestMapping( method= RequestMethod.POST)
    public ModelAndView onSubmit(ModelMap map,@Valid @ModelAttribute("client") Client client, BindingResult result){
        if(result.hasErrors())
            return new ModelAndView(REGISTRATION_FORM_VIEW);
        if(client ==null)
            throw new RuntimeException("Client was null");

        clientRegistrationService.registerNewClient(client);
        map.put("message","Client successfully registered : " + client.getName() + " id: " + client.getId());
        ModelAndView modelAndView = new ModelAndView(REGISTRATION_FORM_VIEW,"model",map);
        return modelAndView;
    }

    @RequestMapping( method= RequestMethod.GET)
    public String onInit(ModelMap map){
        return REGISTRATION_FORM_VIEW;
    }

    @ModelAttribute("client")
    public Client getNewClient(){
        return new Client();
    }

    @InitBinder
    public void setBinders(WebDataBinder binder){
        CollectionPropertyEditor collectionPropertyEditor = new CollectionPropertyEditor<Address>(Address.class);
        binder.registerCustomEditor(Collection.class,collectionPropertyEditor);

    }
}
