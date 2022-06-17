package com.gusmelford.gusmelfordbooks_spring.controllers.store;

import com.gusmelford.gusmelfordbooks_spring.mappers.store.PublisherMapper;
import com.gusmelford.gusmelfordbooks_spring.payload.dto.PublisherDto;
import com.gusmelford.gusmelfordbooks_spring.payload.dto.PublisherInfoDto;
import com.gusmelford.gusmelfordbooks_spring.services.interfaces.store.StorePublisherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/store/publisher")
@AllArgsConstructor
public class StorePublisherController {
    private final StorePublisherService storePublisherService;
    private final PublisherMapper publisherMapper;

    @PostMapping
    public ResponseEntity<UUID> addPublisher(@RequestBody PublisherDto publisherDto){
        return ResponseEntity.ok(storePublisherService.addPublisher(publisherMapper.fromDto(publisherDto)));
    }

    @GetMapping
    public ResponseEntity<PublisherInfoDto> getPublisher(@RequestParam UUID publisherId){
        return ResponseEntity.ok(publisherMapper.toDto(storePublisherService.getPublisher(publisherId)));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PublisherInfoDto>> getAllAddress(){
        return ResponseEntity.ok(storePublisherService.getAllPublisher().stream().map(publisherMapper::toDto).toList());
    }

    @DeleteMapping()
    public void deleteAddress(@RequestParam UUID publisherId){
        storePublisherService.deletePublisher(publisherId);
    }

    @PatchMapping()
    public ResponseEntity<UUID> updateAddress(@RequestBody PublisherDto publisherDto){
        return ResponseEntity.ok(storePublisherService.updatePublisher(publisherMapper.fromDto(publisherDto)));
    }
}
