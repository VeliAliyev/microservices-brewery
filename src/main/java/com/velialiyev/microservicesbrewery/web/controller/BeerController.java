package com.velialiyev.microservicesbrewery.web.controller;

import com.velialiyev.microservicesbrewery.services.BeerService;
import com.velialiyev.microservicesbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID uuid){
        return new ResponseEntity<>(beerService.getBeerById(uuid), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> createNewBeer(@RequestBody BeerDto beerDto){

        BeerDto savedDto =  beerService.createNewBeer(beerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/beer/" + savedDto.getId().toString());

        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity updateBeer(@PathVariable UUID uuid, @RequestBody BeerDto beerDto){

        beerService.updateBeer(uuid,beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity deleteBeerById(@PathVariable UUID uuid){
        beerService.deleteById(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
