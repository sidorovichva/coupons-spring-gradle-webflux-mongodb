package com.vs.couponsspringgradlewebfluxmongodb.controller;

import com.vs.couponsspringgradlewebfluxmongodb.model.Purchase;
import reactor.core.publisher.Mono;

public interface PurchaseControllerInterface {
    Mono<Purchase> getPurchaseById(String id);
    Mono<Purchase> addPurchase(Mono<Purchase> purchase);
    Mono<Purchase> updatePurchase(String id, Mono<Purchase> purchase);
}
