package com.example.razon30.jsonviajackson;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by razon30 on 29-07-15.
 */
public class JacksonHelper {

    int id;
    String name;
    boolean permanent;
    HashMap<String,String> address = new HashMap<String,String>();
    ArrayList<String> phone = new ArrayList<String>();
    String role;
    ArrayList<String> cities = new ArrayList<String>();
    HashMap<String,String> properties = new HashMap<String,String>();

    public JacksonHelper(int id, String name, boolean permanent, HashMap<String, String> address, ArrayList<String> phone, String role, ArrayList<String> cities, HashMap<String, String> properties) {
        this.id = id;
        this.name = name;
        this.permanent = permanent;
        this.address = address;
        this.phone = phone;
        this.role = role;
        this.cities = cities;
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "JacksonHelper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", permanent=" + permanent +
                ", address=" + address +
                ", phone=" + phone +
                ", role='" + role + '\'' +
                ", cities=" + cities +
                ", properties=" + properties +
                '}';
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

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public HashMap<String, String> getAddress() {
        return address;
    }

    public void setAddress(HashMap<String, String> address) {
        this.address = address;
    }

    public ArrayList<String> getPhone() {
        return phone;
    }

    public void setPhone(ArrayList<String> phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<String> getCities() {
        return cities;
    }

    public void setCities(ArrayList<String> cities) {
        this.cities = cities;
    }

    public HashMap<String, String> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, String> properties) {
        this.properties = properties;
    }
}
