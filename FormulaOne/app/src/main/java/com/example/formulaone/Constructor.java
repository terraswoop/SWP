package com.example.formulaone;

public class Constructor {
    String constructor_id;
    String name;
    String nationality;
    String wiki_site; //url
    public Constructor(String ci, String name, String nat, String wik){
        constructor_id=ci;
        this.name=name;
        nationality=nat;
        wiki_site=wik;
    }

    @Override
    public String toString() {
        return
                //"constructor_id:'" + constructor_id + '\'' +
                (String)("Constructor: "+name+", "+nationality+"\n");
                //", wiki_site:'" + wiki_site + '\'';
    }
}
