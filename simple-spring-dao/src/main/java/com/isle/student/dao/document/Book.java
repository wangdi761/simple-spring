package com.isle.student.dao.document;

import java.io.Serializable;

/**
 * Created by 61066 on 2017/12/28.
 */
public class Book implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
