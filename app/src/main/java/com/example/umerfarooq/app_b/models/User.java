package com.example.umerfarooq.app_b.models;


public class User {

    private int id;
    private String contactname;
    private String contactnumber;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Contactname='" + contactname + '\'' +
                ", Contactnumber='" + contactnumber + '\'' +
                '}';
    }

    public User(int id, String contactname, String contactnumber) {
        this.id = id;
        this.contactname = contactname;
        this.contactnumber = contactnumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }


    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

}
