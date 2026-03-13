package com.example.sparta.dto;

public record ProductStatsDto(
        Long productId,
        String productName,
        Long totalQuantity,
        Long totalRevenue
) {}