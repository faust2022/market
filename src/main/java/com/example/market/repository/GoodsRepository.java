package com.example.market.repository;

import com.example.market.domain.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GoodsRepository extends JpaRepository<Goods,Long> {

}
