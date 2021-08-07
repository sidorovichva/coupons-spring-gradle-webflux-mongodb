package com.vs.couponsspringgradlewebfluxmongodb.service;

import com.vs.couponsspringgradlewebfluxmongodb.model.Purchase;
import reactor.core.publisher.Mono;

public interface PurchaseServiceInterface {
    Mono<Purchase> getPurchase(String id);
    Mono<Purchase> addPurchase(Mono<Purchase> purchaseMono);
    Mono<Purchase> updatePurchase(String id, Mono<Purchase> purchaseMono);
}
