package com.maany.spring.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Mayank on 9/12/2015.
 */
public class Client {
    private int id;
    private String name;


    private AddressCollection addressCollection;
    private Collection<GrantType> authorizedGrantTypes;

    public Client() {
        addressCollection = new AddressCollection();
        authorizedGrantTypes = new HashSet<>();
    }

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

    public AddressCollection getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(AddressCollection addressCollection) {
        this.addressCollection = addressCollection;
    }

    public Collection<GrantType> getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(Collection<GrantType> authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }
}
