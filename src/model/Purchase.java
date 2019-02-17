package model;

import java.time.LocalDate;

public class Purchase {
    private LocalDate date;
    private String cardNumber;
    private String creditCardIssuer;
    private Double amountPaid;

    private Purchase(LocalDate date, String cardNumber, String creditCardIssuer, Double amountPaid) {
        this.date = date;
        this.cardNumber = cardNumber;
        this.creditCardIssuer = creditCardIssuer;
        this.amountPaid = amountPaid;
    }

    public void setCreditCardIssuer(String creditCardIssuer) {
        this.creditCardIssuer = creditCardIssuer;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "date=" + date +
                ", cardNumber='" + cardNumber + '\'' +
                ", creditCardIssuer='" + creditCardIssuer + '\'' +
                ", amountPaid=" + amountPaid +
                '}';
    }

    public static PurchaseBuilder builder() {
        return new PurchaseBuilder();
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCreditCardIssuer() {
        return creditCardIssuer;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public static class PurchaseBuilder {
        private LocalDate date;
        private String cardNumber;
        private String creditCardIssuer;

        private Double amountPaid;

        public PurchaseBuilder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public PurchaseBuilder cardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public PurchaseBuilder creditCardIssuer(String creditCardIssuer) {
            this.creditCardIssuer = creditCardIssuer;
            return this;
        }

        public PurchaseBuilder amountPaid(Double amountPaid) {
            this.amountPaid = amountPaid;
            return this;
        }

        public Purchase build() {
            if (date == null) {
                throw new IllegalArgumentException("Use the date method");
            }
            if (cardNumber == null) {
                throw new IllegalArgumentException("Use the cardNumber method");
            }

            if (creditCardIssuer == null) {
                creditCardIssuer = "";
            }

            if (amountPaid == 0) {
                throw new IllegalArgumentException("Use the amountPaid method");
            }
            return new Purchase(date, cardNumber,creditCardIssuer, amountPaid);
        }
    }

}
