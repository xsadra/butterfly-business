package model;

import java.time.LocalDate;

public class Purchase {
    private LocalDate date;
    private String cardNumber;
    private Double amountPaid;

    private Purchase(LocalDate date, String cardNumber, Double amountPaid) {
        this.date = date;
        this.cardNumber = cardNumber;
        this.amountPaid = amountPaid;
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

    public Double getAmountPaid() {
        return amountPaid;
    }

    public static class PurchaseBuilder {
        private LocalDate date;
        private String cardNumber;
        private Double amountPaid;

        public PurchaseBuilder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public PurchaseBuilder cardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
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
            if (amountPaid == 0) {
                throw new IllegalArgumentException("Use the amountPaid method");
            }
            return new Purchase(date, cardNumber, amountPaid);
        }
    }

}
