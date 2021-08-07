package com.vs.couponsspringgradlewebfluxmongodb.controller;

import com.vs.couponsspringgradlewebfluxmongodb.model.Purchase;
import com.vs.couponsspringgradlewebfluxmongodb.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(PurchaseController.URI)
@RequiredArgsConstructor
public class PurchaseController implements PurchaseControllerInterface {
    public static final String URI = "/purchase";

    private final PurchaseService purchaseService;

    @Override
    @GetMapping(
        path = "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Purchase> getPurchaseById(@PathVariable String id) {
        return purchaseService.getPurchase(id);
    }

    @Override
    @PostMapping(
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Purchase> addPurchase(@RequestBody Mono<Purchase> purchase) {
        return purchaseService.addPurchase(purchase);
    }

    @Override
    @PutMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Purchase> updatePurchase(
            @PathVariable String id,
            @RequestBody Mono<Purchase> purchase
    ) {
        return purchaseService.updatePurchase(id, purchase);
    }
}
