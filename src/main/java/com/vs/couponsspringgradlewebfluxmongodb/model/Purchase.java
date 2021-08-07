package com.vs.couponsspringgradlewebfluxmongodb.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Document
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Purchase
{
    @Id
    @Setter(AccessLevel.NONE)
    private String id;

    @NonNull
    @Indexed
    private Long customerId;
    @NonNull
    private Long couponId;
    @NonNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate purchaseDate;
    @NonNull
    private Integer validityDurationDays;
    @NonNull
    private Boolean isRedeemed;
}
