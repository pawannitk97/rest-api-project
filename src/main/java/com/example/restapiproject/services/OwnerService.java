package com.example.restapiproject.services;

import com.example.restapiproject.viewmodels.OwnerCreateViewModel;
import com.example.restapiproject.viewmodels.OwnerUpdateViewModel;
import com.example.restapiproject.viewmodels.OwnerViewModel;

import java.util.List;

public interface OwnerService {
    List<OwnerViewModel> getAll();
    OwnerViewModel getById(int owner_id);
    OwnerViewModel create(OwnerCreateViewModel viewModel);
    OwnerViewModel update(int owner_id, OwnerUpdateViewModel viewModel);
    void deleteById(int owner_id);
}
