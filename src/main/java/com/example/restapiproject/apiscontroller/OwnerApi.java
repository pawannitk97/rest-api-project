package com.example.restapiproject.apiscontroller;

import com.example.restapiproject.services.OwnerService;
import com.example.restapiproject.viewmodels.OwnerCreateViewModel;
import com.example.restapiproject.viewmodels.OwnerUpdateViewModel;
import com.example.restapiproject.viewmodels.OwnerViewModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/owners")
@Tag(name = "Owner", description = "Owner REST API endpoints")
public class OwnerApi {
    private final OwnerService ownerService;

    public OwnerApi(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public ResponseEntity<List<OwnerViewModel>> getAll(){
        return ResponseEntity.ok(ownerService.getAll());
    }

    @GetMapping("{ownerId}")
    public ResponseEntity<OwnerViewModel> getById(@PathVariable int ownerId){
        return ResponseEntity.ok(ownerService.getById(ownerId));
    }

    @PostMapping
    public ResponseEntity<OwnerViewModel> create (@RequestBody OwnerCreateViewModel owner){
        return ResponseEntity.ok(ownerService.create(owner));
    }

    @PutMapping("{ownerId}")
    public ResponseEntity<OwnerViewModel> update (@PathVariable int ownerId, @RequestBody OwnerUpdateViewModel owner){
        return ResponseEntity.ok(ownerService.update(ownerId,owner));
    }
    @DeleteMapping("{ownerId}")
    public ResponseEntity<?> deleteById(@PathVariable int ownerId){
        ownerService.deleteById(ownerId);
        return ResponseEntity.noContent().build();
    }
}
