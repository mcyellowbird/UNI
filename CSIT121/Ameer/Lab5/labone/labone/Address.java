/*------------------------------------------------------ 
Name: Ameer Al-Hariri
Subject code: DPIT121
Student number: 76151917
Email address: aah141@uowmail.edu.au
Task: Week 4 lab
-------------------------------------------------------*/
package labone;

public class Address implements Cloneable, Comparable < Address > {
    private int streetNum;
    private String street;
    private String suburb;
    private String city;
    public Address(int streetNum, String street, String suburb, String city) {
        super();
        this.streetNum = streetNum;
        this.street = street;
        this.suburb = suburb;
        this.city = city;
    }
    public Address(Address address) {
        this.streetNum = address.streetNum;
        this.street = address.street;
        this.suburb = address.suburb;
        this.city = address.city;
    }
    @Override
    public int compareTo(Address address) {
        return address.city.compareTo(city);
    }

    public String toString() {
        return streetNum + " " + street + ", " + suburb + ", " + city;
    }
    public void print() {
        System.out.print(streetNum + " " + street + ", " + suburb + ", " + city);
    }

    public int getStreetNum() {
        return streetNum;
    }
    public void setStreetNum(int streetNum) {
        this.streetNum = streetNum;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getSuburb() {
        return suburb;
    }
    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
}