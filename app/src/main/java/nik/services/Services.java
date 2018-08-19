package nik.services;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by nikhil on 18/08/2018.
 */

public class Services implements Serializable{
    public Services(){

    }

    public Services(HashMap<Integer,String> map){
        this.BN=Integer.parseInt(map.get(0));
        this.cost=map.get(1);
        this.address=map.get(2);
        this.date_time=map.get(3);
        this.details=map.get(4);
        this.name=map.get(5);
        this.status=map.get(6);
        this.where=map.get(7);

    }
    public String name;
    public int BN;
    public String cost;
    public String address;
    public String date_time;
    public String details;
    public String where;
    public String status;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBN() {
        return BN;
    }

    public void setBN(int BN) {
        this.BN = BN;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
