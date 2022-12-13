package com.velialiyev.microservicesbrewery.services;

import com.velialiyev.microservicesbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface BeerService {

    BeerDto getBeerById(UUID beerId);

    BeerDto createNewBeer(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteById(UUID beerId);

}
