package com.gusmelford.gusmelfordbooks_spring.controllers.shop;

import com.gusmelford.gusmelfordbooks_spring.mappers.shop.UserBookMapper;
import com.gusmelford.gusmelfordbooks_spring.payload.dto.BookForBuyDto;
import com.gusmelford.gusmelfordbooks_spring.payload.dto.UserBookDto;
import com.gusmelford.gusmelfordbooks_spring.services.interfaces.shop.ShopService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/shop")
@AllArgsConstructor
public class ShopController {
    private final ShopService shopService;
    private final UserBookMapper userBookMapper;

    @GetMapping("/user-books")
    public List<UserBookDto> getUserBooks(){
        return shopService.getUserBooks(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString())
                .stream().map(userBookMapper::toDto).toList();
    }

    @PostMapping("/buy-books")
    public ResponseEntity<UUID> buyBooks(@RequestBody BookForBuyDto bookForBuyDto) {
        String s = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return ResponseEntity.ok(shopService.createOrder(s, bookForBuyDto.getBookIds()));
    }
}
