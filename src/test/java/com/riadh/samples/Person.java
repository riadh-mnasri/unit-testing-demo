package com.riadh.samples;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Person {

    private String firstname;

    public Person() {
        // TODO Auto-generated constructor stub
    }

    public Person(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public int hashCode() {
        // final int prime = 31;
        // int result = 1;
        // return result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        // return true;
        return EqualsBuilder.reflectionEquals(this, obj);
    }

}
