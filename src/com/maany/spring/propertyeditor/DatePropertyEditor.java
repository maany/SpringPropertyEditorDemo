package com.maany.spring.propertyeditor;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mayank on 9/20/2015.
 */
public class DatePropertyEditor extends PropertyEditorSupport {
    @Override
    public String getAsText() {
        if(getValue()!=null)
            return getValue().toString();
        else
            return null;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        Date date = new Date();
        try {
            date = format.parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        setValue(date);
    }
}
