package com.example.formulaone;

import java.util.ArrayList;

public class DriverStandings {
    Driver d;
    ArrayList<Constructor> c;
    int position;
    int points;
    public DriverStandings(Driver d, ArrayList<Constructor> c, int pos, int points){
        this.d=d;
        this.c=c;
        position=pos;
        this.points=points;
    }

    @Override
    public String toString() {
        return  (String) (position+". "+
                 d.lastname +"\t"+c.toString()+"\n");
                  //     + ", points=" + points+
                //"\tConstructor:" + c.toString() +
                //"\n";
    }
}
