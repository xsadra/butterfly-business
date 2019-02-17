package creditcard;

public class Credit {

    private LuhnValidator luhnValidator = new LuhnValidator();

    public String getCardNumber(String cardNumber){
        //String cardNumber = number.toString();
        if(!luhnValidator.isValid(cardNumber)){
            return "invalid";
        }
        return CreditCards.getCreditCard(cardNumber);
    }

}
