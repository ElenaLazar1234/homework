package b_01_06.BankPayments;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<Card> cards = new ArrayList<>();
    List<BankAccount> bankAccounts = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
}
    public void addBankAccount(BankAccount bankAccount){
        bankAccounts.add(bankAccount);
    }

}

