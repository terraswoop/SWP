package com.example.formulaone;

public class Driver {
    String lastname; //familyName
    String firstname; //givenName
    String nationality;
    int wins;
    public Driver(String l, String f, String n, int w){
        lastname=l;
        firstname=f;
        nationality=n;
        wins=w;
    }

    @Override
    public String toString() {
        return
                "Lastname:'" + lastname + '\'' +
                ", firstname:'" + firstname + '\'' +
                ", nationality:'" + nationality + '\'' +
                ", wins:" + wins;
    }
}
