package com.maany.spring.propertyeditor;

import java.beans.PropertyEditorSupport;

/**
 * Created by Mayank on 9/13/2015.
 */
public class CollectionPropertyEditor extends PropertyEditorSupport {
    private Class classType;

    @Override
    public String getAsText() {
        return super.getAsText();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        super.setAsText(text);
    }
}
