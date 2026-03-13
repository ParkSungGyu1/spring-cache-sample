package com.example.sparta.service;

import com.example.sparta.dto.ProductStatsDto;
import com.example.sparta.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StatisticsService {

    private final OrderItemRepository orderItemRepository;

    public List<ProductStatsDto> getTop10ProductsByRevenue() {
        // DB에 무리를 주는 작업이므로 PageRequest를 이용해 딱 10개만 가져오도록 요청
        return orderItemRepository.findTopProductsGlobal(PageRequest.of(0, 10));
    }
}