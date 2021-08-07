package com.vs.couponsspringgradlewebfluxmongodb.service;

import com.vs.couponsspringgradlewebfluxmongodb.model.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PurchaseService implements PurchaseServiceInterface{
    private final ReactiveMongoOperations reactiveMongoOperations;

    @Override
    public Mono<Purchase> getPurchase(String id) {
        return reactiveMongoOperations.findById(id, Purchase.class);
    }

    @Override
    public Mono<Purchase> addPurchase(Mono<Purchase> purchaseMono) {
        return reactiveMongoOperations.save(purchaseMono);
    }

    @Override
    public Mono<Purchase> updatePurchase(String id, Mono<Purchase> purchaseMono) { //todo id
        return purchaseMono.flatMap(purchase -> reactiveMongoOperations.findAndModify(
                    Query.query(Criteria.where("id").is(id)),
                    Update.update("isRedeemed", purchase.getIsRedeemed()),
                    Purchase.class
            )
        );
    }
}
