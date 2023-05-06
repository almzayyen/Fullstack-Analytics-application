package com.abdalsalam.spring.towerdata.demo.controller;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abdalsalam.spring.towerdata.demo.model.TowerData;
import com.abdalsalam.spring.towerdata.demo.service.MyService;

// import com.bezkoder.spring.jpa.h2.service.MyService;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TowerDataController {

	private final MyService towerService;

	@Autowired
	public TowerDataController(MyService myService) {
		this.towerService = myService;
	}

	/**
	 * 
	 * This controller fetches paginated tower data from an external API and returns
	 * only the page requested.
	 * The returned page can be sorted by the specified sortBy parameter, default
	 * sorting is by tower_id.
	 * The pagination is based on the size and page parameters, which have default
	 * values of 10 and 0 respectively.
	 * 
	 * @param page   the page number requested, default value is 0
	 * @param size   the number of items per page, default value is 10
	 * @param sortBy the field to sort the page by, default value is tower_id
	 * @return a ResponseEntity containing the requested page of tower data along
	 *         with headers for the total count and number of towers
	 */
	@GetMapping("/paginatedTowerData")
	public ResponseEntity<Page<TowerData>> getTowers(
			@RequestParam(required = false, name = "page", defaultValue = "0") int page,
			@RequestParam(required = false, name = "size", defaultValue = "10") int size,
			@RequestParam(required = false, name = "sortBy", defaultValue = "tower_id") String sortBy) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
		Page<TowerData> towersPage = towerService.getTowerPages(pageable);
		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.add("Content-Type", "application/json");
		responseHeaders.add("X-Total-Count", Long.toString(towersPage.getTotalElements()));

		responseHeaders.set("Total-Towers", String.valueOf(towersPage.getTotalElements()));

		return new ResponseEntity<>(towersPage, responseHeaders, HttpStatus.OK);

	}

	/**
	 * 
	 * This controller fetches cell tower data from an external API and returns it
	 * based on filter parameters.
	 * 
	 * The filters available are towerId, networkoperator, technology, and
	 * towerType.
	 * 
	 * @param towerId         the id of the tower to filter by
	 * 
	 * @param networkoperator the network operator to filter by
	 * 
	 * @param technology      the technology to filter by
	 * 
	 * @param towerType       the type of tower to filter by
	 * 
	 * @return ResponseEntity<List<TowerData>> the list of filtered tower data
	 */
	@GetMapping("/challenge/towers")
	public ResponseEntity<List<TowerData>> getTowers(
			@RequestParam(required = false) Long towerId,
			@RequestParam(required = false) String networkoperator,
			@RequestParam(required = false) String technology,
			@RequestParam(required = false) String towerType) {
		List<TowerData> towerDataList = towerService.getExternalApiResponse();

		// Filter the tower data based on the given query parameters
		if (towerId != null) {
			towerDataList = towerDataList.stream()
					.filter(tower -> tower.getTowerId().equals(towerId))
					.collect(Collectors.toList());
		}
		if (networkoperator != null) {
			towerDataList = towerDataList.stream()
					.filter(tower -> networkoperator.toLowerCase().equals(tower.getOperator().toLowerCase()))
					.collect(Collectors.toList());
		}
		if (technology != null) {
			towerDataList = towerDataList.stream()
					.filter(tower -> technology.toLowerCase().equals(tower.getTechnology().toLowerCase()))
					.collect(Collectors.toList());
		}
		if (towerType != null) {
			towerDataList = towerDataList.stream()
					.filter(tower -> towerType.toLowerCase().equals(tower.getTowerType().toLowerCase()))
					.collect(Collectors.toList());
		}

		return ResponseEntity.ok().body(towerDataList);
	}

}
