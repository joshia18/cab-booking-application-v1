package com.aj.cabbookingapp.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Journey {
    @Id
    private String userName;
    private String driverName;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name="x",
                    column = @Column(name = "start_location_coordinate_x")
            ),
            @AttributeOverride(
                    name="y",
                    column = @Column(name = "start_location_coordinate_y")
            )
    })
    private Location start;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name="x",
                    column = @Column(name = "end_location_coordinate_x")
            ),
            @AttributeOverride(
                    name="y",
                    column = @Column(name = "end_location_coordinate_y")
            )
    })
    private Location end;
    private Double bill;
}
