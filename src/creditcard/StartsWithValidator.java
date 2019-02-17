package creditcard;

import java.util.List;

public class StartsWithValidator extends Validator {

    public StartsWithValidator(List<String> possibilities) {
        super(possibilities);
    }

    @Override
    public boolean isValid(String cardNumber){
      return   getPossibilities().stream()
                .anyMatch(cardNumber::startsWith);
    }
}
