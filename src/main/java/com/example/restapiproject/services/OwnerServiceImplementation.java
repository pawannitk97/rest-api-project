package com.example.restapiproject.services;

import com.example.restapiproject.exceptions.RecordNotFoundException;
import com.example.restapiproject.models.Owner;
import com.example.restapiproject.repositories.OwnerRepository;
import com.example.restapiproject.viewmodels.OwnerCreateViewModel;
import com.example.restapiproject.viewmodels.OwnerUpdateViewModel;
import com.example.restapiproject.viewmodels.OwnerViewModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class OwnerServiceImplementation implements OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerServiceImplementation(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<OwnerViewModel> getAll() {
        return ownerRepository.findAll()
                .stream()
                .map(this::toViewModel)
                .collect(Collectors.toList());
    }

    @Override
    public OwnerViewModel getById(int owner_id) {
        return toViewModel(getEntityById( owner_id));
    }

    @Override
    public OwnerViewModel create(OwnerCreateViewModel viewModel) {
        return toViewModel(ownerRepository.saveAndFlush(toEntity(viewModel)));
    }

    @Override
    public OwnerViewModel update(int owner_id, OwnerUpdateViewModel viewModel) {
        return toViewModel(ownerRepository.saveAndFlush(toUpdatedEntity(viewModel,getEntityById(owner_id))));
    }

    @Override
    public void deleteById(int owner_id) {
        ownerRepository.delete(getEntityById((owner_id)));

    }


    private Owner getEntityById(int owner_id) {
        return ownerRepository.findById(owner_id)
                .orElseThrow(
                        () ->
                                new RecordNotFoundException(
                                        String.format(
                                                "Could not find the publisher with id: %d",
                                                owner_id
                                        )
                                )
                );
    }

    private OwnerViewModel toViewModel(Owner entity) {
        OwnerViewModel viewModel = new OwnerViewModel();
        BeanUtils.copyProperties(entity, viewModel);
        return viewModel;
    }

    private Owner toEntity(OwnerCreateViewModel viewModel) {
        Owner entity = new Owner();
        BeanUtils.copyProperties(viewModel, entity);
        return entity;
    }

    private Owner toUpdatedEntity(OwnerUpdateViewModel viewModel, Owner entity) {
        BeanUtils.copyProperties(viewModel, entity);
        return entity;
    }
}
