package com.maany.spring.controller;

import com.maany.spring.model.Client;
import com.maany.spring.service.ClientRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
