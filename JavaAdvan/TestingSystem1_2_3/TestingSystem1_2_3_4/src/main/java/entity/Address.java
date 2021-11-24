package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Address" ,catalog = "TestingSystem")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressID",nullable = false)
    private short AddressID;

    @Column(name = "AddressName", length = 100, nullable = false,unique = true)
    private  String AddressName;



    public Address() {
    }

    public short getAddressID() {
        return AddressID;
    }

    public void setAddressID(short addressID) {
        AddressID = addressID;
    }

    public String getAddressName() {
        return AddressName;
    }

    public void setAddressName(String addressName) {
        AddressName = addressName;
    }

}
