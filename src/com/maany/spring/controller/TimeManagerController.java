package com.maany.spring.controller;

import com.maany.spring.model.TimeManager;
import com.maany.spring.propertyeditor.DatePropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by Mayank on 9/20/2015.
 */
@Controller
@RequestMapping(value="/timeManager/register.form")
public class TimeManagerController {
    private String view = "timeManager";
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(ModelMap map, @ModelAttribute("timeManager")TimeManager timeManager){
        System.out.println("Date Recieved from Form  : " + timeManager.getDate().toString());
        return new ModelAndView(view);
    }
    @ModelAttribute("timeManager")
    public TimeManager modelObject(){
        return new TimeManager();
    }
    @RequestMapping(method = RequestMethod.GET)
    public String onLoad(){
        return view;
    }
    @InitBinder
    public void initBinder(WebDataBinder binder){
        DatePropertyEditor datePropertyEditor = new DatePropertyEditor();
        binder.registerCustomEditor(Date.class,datePropertyEditor);

    }
}
