package com.gusmelford.gusmelfordbooks_spring.controllers.store;

import com.gusmelford.gusmelfordbooks_spring.mappers.store.AddressMapper;
import com.gusmelford.gusmelfordbooks_spring.payload.dto.AddressDto;
import com.gusmelford.gusmelfordbooks_spring.services.interfaces.store.StoreAddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/store/address")
@AllArgsConstructor
public class StoreAddressController {
    private final StoreAddressService storeAddressService;
    private final AddressMapper addressMapper;

    @PostMapping
    public ResponseEntity<UUID> addAddress(@RequestBody AddressDto addressDto){
        return ResponseEntity.ok(storeAddressService.addAddress(addressMapper.fromDto(addressDto)));
    }

    @GetMapping
    public ResponseEntity<AddressDto> getAddress(@RequestParam UUID addressId){
        return ResponseEntity.ok(addressMapper.toDto(storeAddressService.getAddress(addressId)));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AddressDto>> getAllAddress(){
        return ResponseEntity.ok(storeAddressService.getAllAddress().stream().map(addressMapper::toDto).toList());
    }

    @DeleteMapping()
    public void deleteAddress(@RequestParam UUID addressId){
        storeAddressService.deleteAddress(addressId);
    }

    @PatchMapping()
    public ResponseEntity<UUID> updateAddress(@RequestBody AddressDto addressDto){
        return ResponseEntity.ok(storeAddressService.updateAddress(addressMapper.fromDtoWithId(addressDto)));
    }
}
