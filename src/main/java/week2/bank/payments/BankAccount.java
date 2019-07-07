package week2.bank.payments;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    String iban;
    int balance;
    List<Integer> attachedCardNumbers = new ArrayList<>();

    public  BankAccount(String iban) {
        this.iban = iban;
    }

    public void addMoney(int amount) {
        balance = +amount;
    }

    public void withdrawMoney(int amount) {
        if(balance > amount){
        balance = -amount;
        }
    }

    public void AttachedCardNumber(int cardNumber) {
        attachedCardNumbers.add(cardNumber);
    }
}
