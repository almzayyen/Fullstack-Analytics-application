package com.abdalsalam.spring.towerdata.demo.model;

import java.util.List;

public class TowerDataList {
    private List<TowerData> towers;

    public TowerDataList(List<TowerData> towers) {
        this.towers = towers;
    }
    public List<TowerData> getTowers() {
        return towers;
    }

    public void setTowers(List<TowerData> towers) {
        this.towers = towers;
    }
}
