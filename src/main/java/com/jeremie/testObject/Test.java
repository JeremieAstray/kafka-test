package com.jeremie.testObject;

import java.io.Serializable;

/**
 * @author guanhong 16/6/9 下午1:14.
 */
public class Test implements Serializable {

    private int id;
    private String name;

    public Test(int id, String name) {
        this.id = id;
        this.name = name;
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
}
