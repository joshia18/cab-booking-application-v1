package com.aj.cabbookingapp.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cab {
    @Id
    private String driverName;
    private Character gender;
    private Integer age;
    private String vehicleNameAndReg;
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
    private Location currentLocation;
    //private Journey currentJourney;
    private Boolean isAvailable;
    private Double earning;

    public Cab(){
        this.isAvailable = true;
        this.earning = 0.0;
    }

    public Cab(String driverName, Character gender, Integer age, String vehicleNameAndReg, Location currentLocation) {
        this.driverName = driverName;
        this.gender = gender;
        this.age = age;
        this.vehicleNameAndReg = vehicleNameAndReg;
        this.currentLocation = currentLocation;
    }
}
