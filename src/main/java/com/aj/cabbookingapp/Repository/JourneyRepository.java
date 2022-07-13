package com.aj.cabbookingapp.Repository;

import com.aj.cabbookingapp.Model.Journey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JourneyRepository extends JpaRepository<Journey, String> {
}
