package jpa;

import javax.swing.*;
import java.awt.*;

/**
 * Created by craigshorrocks on 1/26/2017.
 */
public class BuddyFrame extends JFrame {

    private AddressBook book;
    private CreateBuddyButton createBuddy;
    private DisplayBuddiesTextArea displayBuddies;

    public void setBook(AddressBook book) {
        this.book = book;
    }

    public void setCreateBuddy(CreateBuddyButton createBuddy) {
        this.createBuddy = createBuddy;
    }

    public void setDisplayBuddies(DisplayBuddiesTextArea displayBuddies) {
        this.displayBuddies = displayBuddies;
    }


    public void init(){
        book.addObserver(displayBuddies);
        this.setLayout(new GridLayout(2,1));
        this.getContentPane().add(createBuddy);
        this.getContentPane().add(displayBuddies);
        this.setVisible(true);

    }



    public BuddyFrame(){
        // Set defaults of frame
        this.setTitle("AddressBook");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);

    }




    public static void main(String[] args){
        BuddyFrame frame = new BuddyFrame();
    }
}
