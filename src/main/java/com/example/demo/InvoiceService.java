package com.example.demo;

import com.example.demo.model.Invoice;
import com.example.demo.model.Play;

import java.util.Objects;

public class InvoiceService {
    public String statement(Invoice invoice, Play plays) {
        int totalAmount = 0;
        int volumeCredits = 0;
        StringBuilder result = new StringBuilder(String.format("Statement for %s \n", invoice.getCustomer()));
        for (Invoice.Performance performance : invoice.getPerformances()) {
            Play.SpecificPlay play = plays.getPlayMap().get(performance.getPlayID());
            int thisAmount = 0;
            switch (play.getType()) {
                case "tragedy":
                    thisAmount = 40000;
                    if (performance.getAudience() > 30) {
                        thisAmount += 1000 * (performance.getAudience() - 30);
                    }
                    break;
                case "comedy":
                    thisAmount = 30000;
                    if (performance.getAudience() > 20) {
                        thisAmount += 10000 + 500 * (performance.getAudience() - 20);
                    }
                    thisAmount += 300 * performance.getAudience();
                    break;
                default:
                    throw new RuntimeException("error");
            }
            //add volume credits
            volumeCredits += Math.max(performance.getAudience() - 30, 0);
            if (Objects.equals("comedy", play.getType())) {
                volumeCredits += Math.floor(performance.getAudience() / 5);
            }
            //print line for this order
            result.append(play.getName()).append(": $").append(thisAmount / 100)
                    .append("($").append(performance.getAudience()).append(" seats) \n");
            totalAmount += thisAmount;
        }
        result.append("Amount own is $").append(totalAmount / 100).append("\n");
        result.append("you earn ").append(volumeCredits).append(" credits");
        return String.valueOf(result);
    }
}
