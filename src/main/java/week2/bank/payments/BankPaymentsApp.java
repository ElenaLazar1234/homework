package week2.bank.payments;

import java.util.Calendar;
import java.util.GregorianCalendar;
public class BankPaymentsApp {
    public static void main (String[] args){

        Calendar myCalendar = new GregorianCalendar(2023, 2, 11);

        User user = new User();
        Card card1 = new Card(myCalendar.getTime(),10,"Elena Lazar");
        user.addCard(card1);
        BankAccount bankAccount = new BankAccount("IRO232323232323232");
        bankAccount.AttachedCardNumber(10);
        user.addBankAccount(bankAccount);
        user.bankAccounts.get(0).addMoney(100);
        Pos pos1 = new Pos();
        pos1.addKnownBankAccount(bankAccount);

        for(Card card : user.cards){
            System.out.println(pos1.pay(20,card));
        }
    }
}
