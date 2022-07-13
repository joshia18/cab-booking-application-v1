package com.aj.cabbookingapp.Repository;

import com.aj.cabbookingapp.Model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CabRepository extends JpaRepository<Cab, String> {
    public List<Cab> findByIsAvailableTrue();
}
