package com.abdalsalam.spring.towerdata.demo.service;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.abdalsalam.spring.towerdata.demo.model.TowerData;

public interface MyService {

    List<TowerData> getExternalApiResponse();
    Page<TowerData> getTowerPages(Pageable pageable);

}
