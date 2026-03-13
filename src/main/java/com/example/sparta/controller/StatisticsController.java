package com.example.sparta.controller;

import com.example.sparta.dto.ProductStatsDto;
import com.example.sparta.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/statistics")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;

    // 대시보드용 누적 매출 Top 10 상품 조회
    @GetMapping("/top-products")
    public List<ProductStatsDto> getTopProducts() {
        return statisticsService.getTop10ProductsByRevenue();
    }
}