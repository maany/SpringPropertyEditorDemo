package com.maany.spring.model;

/**
 * Created by Mayank on 9/22/2015.
 */
public class GrantType implements Parametrized {
    String grantType;
    @Override
    public String getParameter() {
        return grantType;
    }

    @Override
    public void setParameter(String parameter) {
        grantType = parameter;
    }
}
