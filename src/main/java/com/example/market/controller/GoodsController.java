package com.example.market.controller;

import com.example.market.domain.Goods;
import com.example.market.repository.GoodsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodsController {
    private final GoodsRepository goodsRepository;

    public GoodsController(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/goods")
    List<Goods> all(){
        System.out.println("==========get all goods============");
        return goodsRepository.findAll();
    }

    @PostMapping("/goods")
    Goods newGoods(@RequestBody Goods newGoods){
        return goodsRepository.save(newGoods);
    }

    @PostMapping("/goods/{id}")
    Goods replaceGoods(@RequestBody Goods newGoods, @PathVariable Long id){
        return goodsRepository.findById(id)
                .map(goods -> {
                    goods.setTitle(newGoods.getTitle());
                    goods.setContent(newGoods.getContent());
                    return goodsRepository.save(goods);
                })
                .orElseGet(() -> goodsRepository.save(newGoods));
    }

    @DeleteMapping("/goods/{id}")
    void deleteGoods(@PathVariable Long id) {
        goodsRepository.deleteById(id);
    }
}
