package b_01_06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Date;

public class Pos {
    List<BankAccount> bankAccounts = new ArrayList<>();

    public void addKnownBankAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
    }

    public String pay(int amount, Card card) {
        Date date = new Date();
        if (card.expirationDate.compareTo(date) < 0) {

            return "The card is expired";
        }
        Iterator it = bankAccounts.iterator();
        while (it.hasNext()) {
            BankAccount b = (BankAccount) it.next();
            if (b.balance < amount) {
                return "There is not enough money in the account";
            }
            boolean isCardInList = false;
            for (int attachedCard : b.attachedCardNumbers) {
                if (card.cardNumber == attachedCard) {
                    isCardInList = true;
                    break;
                }
            }

            if (isCardInList == false) {
                return "The Pos can’t find the bank account";
            } else {
                b.withdrawMoney(amount);
            }
        }

        return "The payment was done";
    }

}
