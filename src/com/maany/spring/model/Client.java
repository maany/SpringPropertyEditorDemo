package com.maany.spring.model;

import java.util.Collection;

/**
 * Created by Mayank on 9/12/2015.
 */
public class Client {
    private int id;
    private String name;
    private Collection<Address> addressCollection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Address> getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection) {
        this.addressCollection = addressCollection;
    }
}
