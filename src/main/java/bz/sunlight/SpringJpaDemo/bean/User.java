package bz.sunlight.SpringJpaDemo.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User
 * Created by chen_yong on 2017/6/1.
 */
@Entity
@Table(name="t_user")
public class User implements Serializable {

    @Id @GeneratedValue
    private int id;
    private String name;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
