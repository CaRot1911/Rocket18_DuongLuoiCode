package entity;


import enumConfig.TypeQuesEnum;
import enumConfig.TypeQuestionConverter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TypeQuestion",catalog = "TestingSystem")
public class TypeQuestion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TypeID")
    private short typeID;

    @Column(name = "TypeName",nullable = false)
    @Convert(converter = TypeQuestionConverter.class)
    private TypeQuesEnum typeName;

    public TypeQuestion() {
    }

    public short getTypeID() {
        return typeID;
    }

    public void setTypeID(short typeID) {
        typeID = typeID;
    }

    public TypeQuesEnum getTypeName() {
        return typeName;
    }

    public void setTypeName(TypeQuesEnum typeName) {
        typeName = typeName;
    }



}
