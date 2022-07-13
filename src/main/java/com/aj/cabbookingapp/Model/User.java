package com.aj.cabbookingapp.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    private String userName;
    private Character gender;
    private Integer age;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name="x",
                    column = @Column(name = "location_coordinate_x")
            ),
            @AttributeOverride(
                    name="y",
                    column = @Column(name = "location_coordinate_y")
            )
    })
    private Location location;
    private String contact;

    public User(){
        this.location = new Location(0,0);
    }

    public User(String userName, Character gender, Integer age, String contact) {
        this.userName = userName;
        this.gender = gender;
        this.age = age;
        this.contact = contact;
    }
}
