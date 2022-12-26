package com.example.market.dto;

import com.example.market.domain.Goods;

import java.time.LocalDateTime;

/**
 * A DTO for the {@link Goods} entity
 */
public record GoodsDto(LocalDateTime createdAt,
                       String createdBy,
                       LocalDateTime modifiedAt,
                       String modifiedBy,
                       Long id,
                       String title,
                       String content)
{
public static GoodsDto of(LocalDateTime createdAt,
                          String createdBy,
                          LocalDateTime modifiedAt,
                          String modifiedBy,
                          Long id,
                          String title,
                          String content){
    return new GoodsDto(createdAt, createdBy, modifiedAt, modifiedBy, id, title, content);
}

}