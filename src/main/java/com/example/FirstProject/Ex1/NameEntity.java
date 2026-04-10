package com.example.FirstProject.Ex1;

public class NameEntity {

    String name ;
    int id  ;
    String usn ;

    public String getName() {
        return name;
    }


    public NameEntity(String name, int id, String usn) {
        this.name = name;
        this.id = id;
        this.usn = usn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }
}
