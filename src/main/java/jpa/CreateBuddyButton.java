package jpa; /**
 * Created by craigshorrocks on 1/26/2017.
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateBuddyButton extends JButton{

    private ActionListener listener;

    public void setListener(ActionListener listener){
        this.listener = listener;
    }

    public CreateBuddyButton(){
        this.setText("Create Buddy");
    }

    public void init(){
        this.addActionListener(listener);
    }
}
