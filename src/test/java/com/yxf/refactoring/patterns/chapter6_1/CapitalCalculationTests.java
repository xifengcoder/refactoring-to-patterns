package com.yxf.refactoring.patterns.chapter6_1;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;

public class CapitalCalculationTests {
    @Test
    public void testTermLoanNoPayments() {
        double commitment = 1.2f;
        int riskRating = 9;
        Date maturity = new Date();
        Loan loan = Loan.createTermLoan(commitment, riskRating, maturity);
        assert loan.getCommitment() == 1.2f;
        assertTrue(loan.getRiskRating() == 9);

    }
}
