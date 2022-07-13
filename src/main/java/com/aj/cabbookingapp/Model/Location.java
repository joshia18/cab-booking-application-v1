package com.aj.cabbookingapp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private Integer x;
    private Integer y;

    public Double getDistance(Location location){
        return Math.sqrt((Math.pow(this.x - location.x, 2) + Math.pow(this.y - location.y, 2)));
    }
}
