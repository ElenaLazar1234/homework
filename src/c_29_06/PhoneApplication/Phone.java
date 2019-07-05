package c_29_06.PhoneApplication;

import sun.plugin2.message.Message;

import java.util.List;
public class Phone implements PhoneInterface{

    public List<Contact> contacts;
    public void addContact(String contactNumber, String phoneNumber, String firstName , String lastName){
        Contact contact = new Contact();
        contact.number = contactNumber;
        contact.phoneNumber = phoneNumber;
        contact.firstName = firstName;
        contact.lastName = lastName;
        contacts.add(contact);
    }
    public void makeCalls(){

    }
    public void listContacts(){
        if(!contacts.isEmpty()){
            for(Contact contact : contacts) {
                System.out.println(contact.firstName + "" + contact.lastName + "" + contact.phoneNumber);
            }
        }
    }
    public void sendMessage(String phoneNumber, String messageContent){
        TextMessage message = new TextMessage();
        message.text = messageContent;
        message.contact.phoneNumber = phoneNumber;
    }
    public void seeMessagesForAcontact(){

    }
    public  void callsHistory(){

    }
}
