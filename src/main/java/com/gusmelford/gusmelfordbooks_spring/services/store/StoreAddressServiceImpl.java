package com.gusmelford.gusmelfordbooks_spring.services.store;

import com.gusmelford.gusmelfordbooks_spring.entities.Address;
import com.gusmelford.gusmelfordbooks_spring.repositories.AddressRepository;
import com.gusmelford.gusmelfordbooks_spring.services.interfaces.store.StoreAddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StoreAddressServiceImpl implements StoreAddressService {
    private final AddressRepository addressRepository;

    @Override
    public UUID addAddress(Address address) {
        addressRepository.save(address);
        return address.getId();
    }

    @Override
    public Address getAddress(UUID addressId) {
        return addressRepository.findById(addressId).orElseThrow();
    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll().stream().toList();
    }

    @Override
    public void deleteAddress(UUID addressId) {
        addressRepository.deleteById(addressId);
    }

    @Override
    public UUID updateAddress(Address address) {
        Address fromDbAddress = addressRepository.findById(address.id).orElseThrow();
        fromDbAddress.setCity(address.getCity());
        fromDbAddress.setStreet(address.getStreet());
        fromDbAddress.setCountry(address.getCountry());
        addressRepository.save(fromDbAddress);
        return fromDbAddress.getId();
    }
}
