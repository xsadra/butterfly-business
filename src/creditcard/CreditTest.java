package creditcard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreditTest {

    private Credit credit = new Credit();

    @Test
    void testAmericanExpress() {
        String number = "378282246310005";
        String creditCard = credit.getCardNumber(number);
        Assertions.assertEquals("American Express", creditCard);
    }

    @Test
    void testMasterCard() {
        String number = "5555555555554444";
        String creditCard = credit.getCardNumber(number);
        Assertions.assertEquals("MasterCard", creditCard);
    }

    @Test
    void testVisaElectron(){
        String number = "4026189610576657";
        String creditCard = credit.getCardNumber(number);
        Assertions.assertEquals("VisaElectron", creditCard);
    }
    @Test
    void testVisa() {
        String number = "4222222222222";
        String creditCard = credit.getCardNumber(number);
        Assertions.assertEquals("Visa", creditCard);
    }
    @Test
    void testMaestro() {
        String number = "6761972156212629";
        String creditCard = credit.getCardNumber(number);
        Assertions.assertEquals("Maestro", creditCard);
    }
    @Test
    void testInstaPayment(){
        String number = "6399487547910120";
        String creditCard = credit.getCardNumber(number);
        Assertions.assertEquals("InstaPayment", creditCard);
    }
    @Test
    void testDiscover(){
        String number = "6011490659073693";
        String creditCard = credit.getCardNumber(number);
        Assertions.assertEquals("Discover", creditCard);
    }
    @Test
    void testInvalid() {
        String number = "130042200878292";
        String creditCard = credit.getCardNumber(number);
        Assertions.assertEquals("invalid", creditCard);
    }
    @Test
    void testUnknown() {
        String number = "30042200878292";
        String creditCard = credit.getCardNumber(number);
        Assertions.assertEquals("unknown", creditCard);
    }
}