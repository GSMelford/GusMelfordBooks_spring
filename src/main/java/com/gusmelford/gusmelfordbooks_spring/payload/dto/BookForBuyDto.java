package com.gusmelford.gusmelfordbooks_spring.payload.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class BookForBuyDto {
    private List<UUID> bookIds;
}
