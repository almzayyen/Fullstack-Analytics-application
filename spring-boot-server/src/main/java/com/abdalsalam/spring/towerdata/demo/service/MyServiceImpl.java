
package com.abdalsalam.spring.towerdata.demo.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abdalsalam.spring.towerdata.demo.model.TowerData;

@Service
public class MyServiceImpl implements MyService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 
     * Retrieves paginated tower data from an external API.
     * 
     * @return A List of TowerData objects retrieved from the external API.
     */
    public List<TowerData> getExternalApiResponse() {
        String apiUrl = "https://byanat.wiremockapi.cloud/api/v3/towers";
        ResponseEntity<TowerData[]> response = restTemplate.getForEntity(apiUrl, TowerData[].class);
        TowerData[] towerDataArray = response.getBody();

        return Arrays.asList(towerDataArray);
    }

    /**
     * 
     * Fetches paginated tower data from an external API and returns the page
     * requested.
     * 
     * @param pageable the Pageable object containing information about the
     *                 requested page
     * @return a Page object containing the requested towers
     * @throws IllegalStateException if the response from the API is null
     */
    public Page<TowerData> getTowerPages(Pageable pageable) {
        String apiUrl = "https://byanat.wiremockapi.cloud/api/v3/towers";
        ResponseEntity<TowerData[]> response = restTemplate.getForEntity(apiUrl, TowerData[].class);
        TowerData[] towers = response.getBody();

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<TowerData> pageTowers;
        if (towers == null) {
            throw new IllegalStateException();
        }
        if (towers.length < startItem) {
            pageTowers = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, towers.length);
            pageTowers = Arrays.asList(Arrays.copyOfRange(towers, startItem, toIndex));
        }

        Page<TowerData> towerPage = new PageImpl<>(pageTowers, pageable, towers.length);
        return towerPage;
    }
}
