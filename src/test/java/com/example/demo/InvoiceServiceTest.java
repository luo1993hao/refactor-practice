package com.example.demo;

import com.example.demo.model.Invoice;
import com.example.demo.model.Play;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
    private InvoiceService invoiceService = new InvoiceService();

    @Test
    public void should_return_true_result() {
        //given
        Invoice invoice = Invoice.createTestInvoice();
        Play play = Play.createTestPlay();
        String exceptResult = "Statement for BigCo \n" +
                "Hamlet: $650($55 seats) \n" +
                "As you Like It: $580($35 seats) \n" +
                "Othello: $500($40 seats) \n" +
                "Amount own is $1730\n" +
                "you earn 47 credits";
        //when
        String result = invoiceService.statement(invoice, play);
        //then
        Assertions.assertEquals(result, exceptResult);
    }
}
