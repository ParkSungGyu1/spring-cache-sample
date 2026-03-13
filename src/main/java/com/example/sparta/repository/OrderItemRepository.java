package com.example.sparta.repository;

import com.example.sparta.dto.ProductStatsDto;
import com.example.sparta.entity.OrderItem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    @Query("""
           select new com.example.sparta.dto.ProductStatsDto(
               p.id, p.name, sum(oi.quantity), sum(oi.quantity * p.price)
           )
           from OrderItem oi
           join oi.product p
           group by p.id, p.name
           order by sum(oi.quantity * p.price) desc
           """)
    List<ProductStatsDto> findTopProductsGlobal(Pageable pageable);
}