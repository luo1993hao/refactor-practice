package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
@Builder
public class Invoice {
    private String customer;
    private List<Performance> performances;

    @Data
    @Builder
    public static class Performance {
        private String playID;
        private int audience;
    }

    public static Invoice createTestInvoice() {
        return Invoice.builder()
                .customer("BigCo")
                .performances(Arrays.asList(
                        Performance.builder()
                                .playID("hamlet")
                                .audience(55)
                                .build(),
                        Performance.builder()
                                .audience(35)
                                .playID("as-like")
                                .build(),
                        Performance.builder()
                                .audience(40)
                                .playID("othello")
                                .build()
                )).build();
    }
}
