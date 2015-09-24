package com.maany.spring.model;

/**
 * Created by Mayank on 9/22/2015.
 */
public class GrantType implements Parametrized {
    String grantType;

    public GrantType() {
    }

    public GrantType(String grantType) {
        this.grantType = grantType;
    }

    @Override
    public String getParameter() {
        return grantType;
    }

    @Override
    public void setParameter(String parameter) {
        grantType = parameter;
    }

    @Override
    public String toString() {
        return grantType;
    }

    @Override
    public boolean equals(Object obj) {
        return grantType.equals(obj.toString());
    }
}
