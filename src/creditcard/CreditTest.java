package creditcard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditTest {

    private Credit credit = new Credit();

    @Test
    void testAmericanExpress() {
        Long number = 378282246310005L;
        String creditCard = credit.getType(number);
        Assertions.assertEquals("American Express", creditCard);
    }

    @Test
    void testMasterCard() {
        Long number = 5555555555554444L;
        String creditCard = credit.getType(number);
        Assertions.assertEquals("MasterCard", creditCard);
    }

    @Test
    void testVisaElectron(){
        Long number = 4026189610576657L;
        String creditCard = credit.getType(number);
        Assertions.assertEquals("VisaElectron", creditCard);
    }
    @Test
    void testVisa() {
        Long number = 4222222222222L;
        String creditCard = credit.getType(number);
        Assertions.assertEquals("Visa", creditCard);
    }
    @Test
    void testMaestro() {
        Long number = 6761972156212629L;
        String creditCard = credit.getType(number);
        Assertions.assertEquals("Maestro", creditCard);
    }
    @Test
    void testInstaPayment(){
        Long number = 6399487547910120L;
        String creditCard = credit.getType(number);
        Assertions.assertEquals("InstaPayment", creditCard);
    }
    @Test
    void testDiscover(){
        Long number = 6011490659073693L;
        String creditCard = credit.getType(number);
        Assertions.assertEquals("Discover", creditCard);
    }
    @Test
    void testInvalid() {
        Long number = 2223016768739314L;
        String creditCard = credit.getType(number);
        Assertions.assertEquals("unknown", creditCard);
    }
}