package com.maany.spring.propertyeditor;

import com.maany.spring.model.Address;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Mayank on 9/13/2015.
 */
public class CollectionPropertyEditor<T extends Address>  extends PropertyEditorSupport {
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
        try {
            Collection<T> collection = (Collection<T>)getValue();
            for(T element : collection){
                returnValue+= element.toString() + ", ";
            }
        }catch (Exception ex){
            System.out.println("FAILED to getAsText() object of type " + classType.getName());
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
        String[] values = text.split(", ");
        Collection<Address> collection = new ArrayList<Address>();
        for(String value:values){
            if(value.length()<=1)
                continue;
            value.trim();
            String[] addressLine= value.split("--");
            Address address = new Address();
            address.setFirstLine(addressLine[0]);
            address.setSecondLine(addressLine[1]);
            address.setThirdLine(addressLine[2]);
            collection.add(address);
        }
        setValue(collection);
    }


}
