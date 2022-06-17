package com.gusmelford.gusmelfordbooks_spring.services.store;

import com.gusmelford.gusmelfordbooks_spring.entities.Publisher;
import com.gusmelford.gusmelfordbooks_spring.payload.domain.PublisherData;
import com.gusmelford.gusmelfordbooks_spring.payload.domain.PublisherInfo;
import com.gusmelford.gusmelfordbooks_spring.repositories.AddressRepository;
import com.gusmelford.gusmelfordbooks_spring.repositories.PublisherRepository;
import com.gusmelford.gusmelfordbooks_spring.services.interfaces.store.StorePublisherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StorePublisherServiceImpl implements StorePublisherService {
    private final PublisherRepository publisherRepository;
    private final AddressRepository addressRepository;

    @Override
    public UUID addPublisher(PublisherData publisherData) {
        Publisher publisher = new Publisher();
        publisher.setName(publisherData.getName());
        publisher.setPhone(publisherData.getPhone());
        publisher.setAddress(addressRepository.findById(publisherData.getAddressId()).orElseThrow());
        publisherRepository.save(publisher);
        return publisher.getId();
    }

    @Override
    public PublisherInfo getPublisher(UUID publisherId) {
        Publisher publisher = publisherRepository.findById(publisherId).orElseThrow();

        return new PublisherInfo(publisher.id, publisher.getName(), publisher.getPhone(),
                String.join(",", publisher.getAddress().getCountry(), publisher.getAddress().getCity(),
                        publisher.getAddress().getStreet()));
    }

    @Override
    public List<PublisherInfo> getAllPublisher() {
        return publisherRepository.findAll().stream()
                .map(x -> new PublisherInfo(x.id, x.getName(), x.getPhone(),
                        String.join(",", x.getAddress().getCountry(), x.getAddress().getCity(), x.getAddress().getStreet())))
                .toList();
    }

    @Override
    public void deletePublisher(UUID publisherId) {
        publisherRepository.deleteById(publisherId);
    }

    @Override
    public UUID updatePublisher(PublisherData publisherData) {
        Publisher fromDbPublisher = publisherRepository.findById(publisherData.getId()).orElseThrow();
        fromDbPublisher.setName(publisherData.getName());
        fromDbPublisher.setPhone(publisherData.getPhone());
        fromDbPublisher.setAddress(addressRepository.findById(publisherData.getAddressId()).orElseThrow());
        publisherRepository.save(fromDbPublisher);
        return fromDbPublisher.getId();
    }
}
