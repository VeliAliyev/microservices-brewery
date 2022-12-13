package com.velialiyev.microservicesbrewery.services.impl;

import com.velialiyev.microservicesbrewery.services.BeerService;
import com.velialiyev.microservicesbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
@Slf4j
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("EFES")
                .beerStyle("PILSNER")
                .build();
    }

    @Override
    public BeerDto createNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName(beerDto.getBeerName())
                .beerStyle(beerDto.getBeerStyle())
                .upc(beerDto.getUpc())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        log.debug("Updating Beer...");
    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("Deleting Beer...");
    }
}
