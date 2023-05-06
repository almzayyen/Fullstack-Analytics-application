package com.abdalsalam.spring.towerdata.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "towers")
public class TowerData {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @JsonProperty("tower_id")
    @Column(name = "tower_id")
    private Long towerId;

    @Column(name = "operator")
    private String operator;

    @Column(name = "address")
    private String address;

    @Column(name = "height")
    private Double height;

    @JsonProperty("tower_type")
    @Column(name = "tower_type")
    private String towerType;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "technology")
    private String technology;

    public TowerData() {

    }

    public TowerData(Long towerId, String operator, String address, Double height,
            String towerType, Double latitude, Double longitude, String technology) {
        this.towerId = towerId;
        this.operator = operator;
        this.address = address;
        this.height = height;
        this.towerType = towerType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.technology = technology;
    }
    // getters and setters

    public Long getId() {
        return id;
    }
    public Long getTowerId() {
        return towerId;
    }

    public void setTowerId(Long towerId) {
        this.towerId = towerId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getTowerType() {
        return towerType;
    }

    public void setTowerType(String towerType) {
        this.towerType = towerType;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }


    @Override
    public String toString() {
        return "Response [towerId=" + towerId + ", operator=" + operator + ", address=" + address +
               ", height=" + height + ", towerType=" + towerType + ", latitude=" + latitude +
               ", longitude=" + longitude + ", technology=" + technology + "]";
    }
    
}
