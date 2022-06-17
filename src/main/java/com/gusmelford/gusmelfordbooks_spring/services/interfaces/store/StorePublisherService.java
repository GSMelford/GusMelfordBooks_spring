package com.gusmelford.gusmelfordbooks_spring.services.interfaces.store;

import com.gusmelford.gusmelfordbooks_spring.entities.Publisher;
import com.gusmelford.gusmelfordbooks_spring.payload.domain.PublisherData;
import com.gusmelford.gusmelfordbooks_spring.payload.domain.PublisherInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface StorePublisherService {
    UUID addPublisher(PublisherData publisherData);
    PublisherInfo getPublisher(UUID publisherId);
    List<PublisherInfo> getAllPublisher();
    void deletePublisher(UUID publisherId);
    UUID updatePublisher(PublisherData publisherData);
}
