package jpa;

import javax.swing.*;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by craigshorrocks on 1/26/2017.
 */
public class DisplayBuddiesTextArea extends JTextArea implements Observer{


    public DisplayBuddiesTextArea(){
        this.setEditable(false);
    }

    public void updateDisplay(AddressBook book){
        List<BuddyInfo> buddies = book.getBuddies();
        String str = "Name   Phone Number";
        for(BuddyInfo buddy : buddies){
            str += "\n" + buddy.getName() + "    " + buddy.getPhoneNumber();
        }
        this.setText(str);
    }

    public void update(Observable o, Object arg) {
        AddressBook b = (AddressBook) o;
        updateDisplay(b);
    }
}
