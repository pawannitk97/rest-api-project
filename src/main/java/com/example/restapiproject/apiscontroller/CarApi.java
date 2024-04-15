package com.example.restapiproject.apiscontroller;

import com.example.restapiproject.services.CarService;
import com.example.restapiproject.viewmodels.CarCreateViewModel;
import com.example.restapiproject.viewmodels.CarUpdateViewModel;
import com.example.restapiproject.viewmodels.CarViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cars")
public class CarApi {
    private final CarService carService;

    public CarApi(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<CarViewModel>> getAll(){
        return ResponseEntity.ok(carService.getAll());
    }

    @GetMapping("{carId}")
    public  ResponseEntity<CarViewModel> getById(@PathVariable int carId){
        return ResponseEntity.ok(carService.getById(carId));
    }

    @PostMapping
    public  ResponseEntity<CarViewModel> create(@RequestBody CarCreateViewModel car){
        return ResponseEntity.ok(carService.create(car));
    }
    @PutMapping("{carId}")
    public ResponseEntity<CarViewModel> update(@PathVariable int carId , @RequestBody CarUpdateViewModel car){
        return ResponseEntity.ok(carService.update(carId,car));
    }
    @DeleteMapping("{carId}")
    public  ResponseEntity<?> deleteById(@PathVariable int carId){
        carService.deleteById(carId);
        return ResponseEntity.noContent().build();
    }
}
