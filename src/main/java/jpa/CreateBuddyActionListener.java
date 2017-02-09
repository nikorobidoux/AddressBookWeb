package jpa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by craigshorrocks on 1/26/2017.
 */
public class CreateBuddyActionListener implements ActionListener{

    private AddressBook book;

    public void setBook(AddressBook b){
        book = b;
    }

    public CreateBuddyActionListener(){
        book = new AddressBook();
    }

    public void actionPerformed(ActionEvent e) {
        // Bring up window to create buddy
        String name = JOptionPane.showInputDialog("Please enter a name: ");
        String number = JOptionPane.showInputDialog("Please enter a number: ");
        BuddyInfo b = new BuddyInfo(name,number);
        book.addBuddy(b);
    }
}
