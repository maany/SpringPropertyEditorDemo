package com.maany.spring.controller;

import com.maany.spring.model.Address;
import com.maany.spring.model.Client;
import com.maany.spring.model.GrantType;
import com.maany.spring.propertyeditor.CollectionPropertyEditor;
import com.maany.spring.service.ClientRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Mayank on 9/24/2015.
 */
@Controller
@RequestMapping(value="/client/view")
public class ViewEditClientController {
    @Autowired
    ClientRegistrationService clientRegistrationService;
    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public ModelAndView getClient(@PathVariable("id") Integer id,ModelMap map){
        Client client = clientRegistrationService.getClient(id);
        map.put("client",client);
        ModelAndView modelAndView = new ModelAndView("viewEditClient","model",map);
        return modelAndView;
    }
    @RequestMapping(value="{id}", method = RequestMethod.POST)
    public ModelAndView updateClient(@PathVariable("id") Integer id,ModelMap map,@ModelAttribute("client") Client client,BindingResult errors){
        ModelAndView modelAndView = new ModelAndView("viewEditClient","model",map);
        return modelAndView;
    }

    @InitBinder
    public void setBinders(WebDataBinder binder){
        CollectionPropertyEditor collectionPropertyEditor = new CollectionPropertyEditor(Address.class);
        CollectionPropertyEditor grantTypeCollectionPropertyEditor = new CollectionPropertyEditor(GrantType.class);
        binder.registerCustomEditor(getNewClient().getAuthorizedGrantTypes().getClass(),grantTypeCollectionPropertyEditor);
        binder.registerCustomEditor(getNewClient().getAddressCollection().getClass(),collectionPropertyEditor);

    }

    public Client getNewClient(){ return new Client();};

}
