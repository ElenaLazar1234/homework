package week3.phone.app;

public interface PhoneInterface {
    void addContact(String contactNumber, String phoneNumber, String firstName , String lastName);
    void makeCalls();
    void listContacts();
    void sendMessage(String phoneNumber , String content);
    void seeMessagesForAcontact();
    void callsHistory();

   static final int BateryLife = 8;
    String color = "black";
    String material = "plastic";
    String imei = "imei123456";
}
