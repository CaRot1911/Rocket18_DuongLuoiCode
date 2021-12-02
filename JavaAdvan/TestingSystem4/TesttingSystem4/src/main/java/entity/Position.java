package entity;


import enumConfig.PosNameEnum;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Position", catalog = "TestingSystem")
public class Position implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PositionID",nullable = false)
    private short PositionID;

    @Column(name = "PositionName",nullable = false,unique = true)
    @Enumerated(EnumType.STRING)
    private PosNameEnum PositionName;


    public short getPositionID() {
        return PositionID;
    }

    public void setPositionID(short positionID) {
        PositionID = positionID;
    }

    public PosNameEnum getPositionName() {
        return PositionName;
    }

    public void setPositionName(PosNameEnum positionName) {
        PositionName = positionName;
    }
}
