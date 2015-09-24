package com.maany.spring.propertyeditor;

import com.maany.spring.model.Address;
import com.maany.spring.model.AddressCollection;
import com.maany.spring.model.Parametrized;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Mayank on 9/13/2015.
 */
public class  CollectionPropertyEditor extends PropertyEditorSupport {
    private Class classType;

    public CollectionPropertyEditor(Class classType) {
        this.classType = classType;
    }

    /**
     * return a collection directly? or a CSV
     * returning a CSV for now
     * @return
     */
    @Override
    public String getAsText() {
        String returnValue = "";
        if(classType ==Address.class) {
            try {
                AddressCollection collection = (AddressCollection) getValue();
                for (Address element : collection) {
                    returnValue += element.toString() + " , ";
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("FAILED to getAsText() object of type " + classType.getName());
            }
        } else{
            try {
                Collection<? extends Parametrized> collection = (HashSet<? extends Parametrized>) getValue();
                for (Parametrized element : collection)
                    returnValue += element.getParameter() + " , ";
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("FAILED to getAsText() object of type " + classType.getName());
            }
        }
        return returnValue;
    }

    /**
     * receive CSV string and create a collection
     * @param text
     * @throws IllegalArgumentException
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] values = text.split(" , ");
        if(classType == Address.class) {
            AddressCollection collection = new AddressCollection();
            for (String value : values) {
                if (value.length() <= 1)
                    continue;
                value.trim();
                String[] addressLine = value.split("--");
                Address address = new Address();
                address.setFirstLine(addressLine[0]);
                address.setSecondLine(addressLine[1]);
                address.setThirdLine(addressLine[2]);
                collection.add(address);
            }
            setValue(collection);
        } else {
            // create collection of classType and modify frontend
            setValue(createCollection(values));
        }
    }

    public <T extends Parametrized> Collection<T> createCollection(String[] values) {
        Collection<T> collection = new HashSet<>();
        for(String value : values) {
            T instance = null;
            try {
                instance = (T) classType.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            instance.setParameter(value);
            collection.add(instance);
        }
        return collection;
    }



}
