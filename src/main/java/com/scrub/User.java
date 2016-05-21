package com.scrub;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ishan on 6/8/14.
 */
@XmlRootElement
public class User {
    Integer id;
    String email;
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
