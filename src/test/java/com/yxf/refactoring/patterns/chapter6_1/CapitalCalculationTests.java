package com.yxf.refactoring.patterns.chapter6_1;

import org.junit.Test;

import java.util.Date;

public class CapitalCalculationTests {
    @Test
    public void testTermLoanNoPayments() {
        double commitment = 1.2f;
        int riskRating = 9;
        Date maturity = new Date();
        Loan termLoan = new Loan(commitment, riskRating, maturity);

    }
}
