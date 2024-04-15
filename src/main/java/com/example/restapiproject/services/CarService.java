package com.example.restapiproject.services;

import com.example.restapiproject.viewmodels.CarCreateViewModel;
import com.example.restapiproject.viewmodels.CarUpdateViewModel;
import com.example.restapiproject.viewmodels.CarViewModel;

import java.util.List;

public interface CarService {
    List<CarViewModel> getAll();
    CarViewModel getById(int car_id);
    CarViewModel create(CarCreateViewModel viewModel);
    CarViewModel update(int car_id, CarUpdateViewModel viewModel);
    void deleteById(int car_id);
}
