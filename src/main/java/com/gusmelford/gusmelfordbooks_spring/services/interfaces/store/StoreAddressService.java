package com.gusmelford.gusmelfordbooks_spring.services.interfaces.store;

import com.gusmelford.gusmelfordbooks_spring.entities.Address;

import java.util.List;
import java.util.UUID;

public interface StoreAddressService {
    UUID addAddress(Address address);
    Address getAddress(UUID addressId);
    List<Address> getAllAddress();
    void deleteAddress(UUID addressId);
    UUID updateAddress(Address address);
}
