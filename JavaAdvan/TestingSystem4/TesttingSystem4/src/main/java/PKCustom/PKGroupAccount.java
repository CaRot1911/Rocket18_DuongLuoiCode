package PKCustom;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PKGroupAccount implements Serializable {

    @Column(name = "GroupID",nullable = false)
    private short GroupID;

    @Column(name = "AccountID",nullable = false)
    private short AccountID;

}
