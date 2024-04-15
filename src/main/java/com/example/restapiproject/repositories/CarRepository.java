package com.example.restapiproject.repositories;

import com.example.restapiproject.models.Car;
import com.example.restapiproject.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
}
