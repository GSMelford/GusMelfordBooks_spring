package com.gusmelford.gusmelfordbooks_spring.services.interfaces.shop;

import com.gusmelford.gusmelfordbooks_spring.payload.domain.UserBook;

import java.util.List;
import java.util.UUID;

public interface ShopService {
    List<UserBook> getUserBooks(String email);
    UUID createOrder(String email, List<UUID> bookIds);
}
