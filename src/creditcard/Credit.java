package creditcard;

public class Credit {

    private LuhnValidator luhnValidator = new LuhnValidator();

    public String getType(Long number){
        String cardNumber = number.toString();
        if(!luhnValidator.isValid(cardNumber)){
            return "unknown";
        }
        return CreditCards.getCreditCard(cardNumber);
    }

}
