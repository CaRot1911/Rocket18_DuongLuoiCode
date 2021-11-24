package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DetailDepartment",catalog = "TestingSystem")

public class DetailDepartment implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "DepartmentID",referencedColumnName = "DepartmentID")
    private Department departmentID;

    @ManyToOne
    @JoinColumn(name = "AddressID",referencedColumnName = "AddressID",unique = true)
    private Address addressID;

    @Column(name = "EmulationPoint")
    private short emulationPoint;

    public DetailDepartment() {
    }

    public Department getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Department departmentID) {
        departmentID = departmentID;
    }

    public Address getAddressID() {
        return addressID;
    }

    public void setAddressID(Address addressID) {
        addressID = addressID;
    }

    public short getEmulationPoint() {
        return emulationPoint;
    }

    public void setEmulationPoint(short emulationPoint) {
        emulationPoint = emulationPoint;
    }
}
