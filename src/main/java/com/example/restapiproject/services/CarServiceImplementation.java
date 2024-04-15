package com.example.restapiproject.services;

import com.example.restapiproject.exceptions.RecordNotFoundException;
import com.example.restapiproject.models.Car;
import com.example.restapiproject.models.Owner;
import com.example.restapiproject.repositories.CarRepository;
import com.example.restapiproject.repositories.OwnerRepository;
import com.example.restapiproject.viewmodels.CarCreateViewModel;
import com.example.restapiproject.viewmodels.CarUpdateViewModel;
import com.example.restapiproject.viewmodels.CarViewModel;
import com.example.restapiproject.viewmodels.OwnerViewModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class CarServiceImplementation implements CarService {
    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;

    public CarServiceImplementation(CarRepository carRepository, OwnerRepository ownerRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<CarViewModel> getAll() {
        return carRepository.findAll()
                .stream()
                .map(this::toViewModel)
                .collect(Collectors.toList());
    }

    @Override
    public CarViewModel getById(int car_id) {
        return toViewModel(getEntityById(car_id));
    }

    @Override
    public CarViewModel create(CarCreateViewModel viewModel) {
        return toViewModel(carRepository.saveAndFlush(toEntity(viewModel)));
    }

    @Override
    public CarViewModel update(int car_id, CarUpdateViewModel viewModel) {
        return toViewModel(carRepository.saveAndFlush(toUpdatedEntity(viewModel,getEntityById(car_id))));
    }

    @Override
    public void deleteById(int car_id) {
        carRepository.delete(getEntityById(car_id));

    }


    private Car getEntityById(int car_id) {
        return carRepository.findById(car_id)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Could not find the car with id %d", car_id)));
    }

    private Owner getMasterEntityById(int owner_id) {
        return ownerRepository.findById(owner_id)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Could not find the owner with id: %d", owner_id)));
    }

    private CarViewModel toViewModel(Car entity) {
        CarViewModel viewModel = new CarViewModel();
        BeanUtils.copyProperties(entity, viewModel);
        viewModel.setOwner(toViewModel(entity.getOwner()));
        return viewModel;
    }

    private OwnerViewModel toViewModel(Owner entity) {
        OwnerViewModel viewModel = new OwnerViewModel();
        BeanUtils.copyProperties(entity, viewModel);
        return viewModel;
    }

    private Car toEntity(CarCreateViewModel viewModel) {
        Car entity = new Car();
        BeanUtils.copyProperties(viewModel, entity);
        entity.setOwner(getMasterEntityById(viewModel.getOwnerId()));
        return entity;
    }

    private Car toUpdatedEntity(CarUpdateViewModel viewModel, Car entity) {
        BeanUtils.copyProperties(viewModel, entity);
        return entity;
    }
}
