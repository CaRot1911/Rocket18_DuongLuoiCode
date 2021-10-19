package Emty;

import java.io.Serializable;

public class Students implements Serializable {
    private int id;
    private String Name;

    public Students(int id, String name) {
        this.id = id;
        Name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + "-" + "Name: "+getName();
    }
}
