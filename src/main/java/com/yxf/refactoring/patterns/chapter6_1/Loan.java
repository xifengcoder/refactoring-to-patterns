package com.yxf.refactoring.patterns.chapter6_1;

import java.util.Date;

public class Loan {
    private double commitment;
    private double outstanding;
    private int riskRating;
    private Date maturity;
    private Date expiry;
    private CapitalStrategy capitalStrategy;

    public static Loan createTermLoan(double commitment, int riskRating, Date maturity) {
        return new Loan(null, commitment, 0.00, riskRating, maturity, null);
    }

    public static Loan createTermLoan(CapitalStrategy capitalStrategy,
                                      double commitment, double outstanding, int riskRating, Date maturity) {
        return new Loan(capitalStrategy, commitment, outstanding, riskRating, maturity, null);
    }

    public static Loan createResolver(double commitment, double outstanding, int riskRating, Date maturity, Date expiry) {
        return new Loan(null, commitment, outstanding, riskRating, maturity, expiry);
    }

    public static Loan createRCTL(double commitment, double outstanding, int riskRating, Date maturity, Date expiry) {
        return new Loan(null, commitment, outstanding, riskRating, maturity, expiry);
    }

    public static Loan createRCTL(CapitalStrategy capitalStrategy, double commitment, double outstanding, int riskRating, Date maturity, Date expiry) {

        return new Loan(capitalStrategy, commitment, outstanding, riskRating, maturity, expiry);
    }

    public static Loan createResolver(CapitalStrategy capitalStrategy, double commitment,
                                      int riskRating, Date maturity, Date expiry) {
        return new Loan(capitalStrategy, commitment, riskRating, maturity, expiry);
    }

    private Loan(CapitalStrategy capitalStrategy, double commitment,
                 int riskRating, Date maturity, Date expiry) {
        this(capitalStrategy, commitment, 0.00, riskRating, maturity, expiry);
    }

    public Loan(CapitalStrategy capitalStrategy, double commitment,
                double outstanding, int riskRating,
                Date maturity, Date expiry) {
        this.commitment = commitment;
        this.outstanding = outstanding;
        this.riskRating = riskRating;
        this.maturity = maturity;
        this.expiry = expiry;
        this.capitalStrategy = capitalStrategy;

        if (capitalStrategy == null) {
            if (expiry == null)
                this.capitalStrategy = new CapitalStrategyTermLoan();
            else if (maturity == null)
                this.capitalStrategy = new CapitalStrategyRevolver();
            else {
                this.capitalStrategy = new CapitalStrategyRCTL();
            }
        }
    }

    public int getRiskRating() {
        return riskRating;
    }

    public Date getMaturity() {
        return maturity;
    }

    public double getCommitment() {
        return commitment;
    }
}