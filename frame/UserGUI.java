package frame;

import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class UserGUI extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    ArrayList<String> names = new ArrayList<String>(); // the text for the
                                                       // labels
    ArrayList<String> values = new ArrayList<String>(); // the initial contents
                                                        // of the text fields
    int col; // the number of columns used to set the width of each textfield

    public UserGUI() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 2));

        names = new ArrayList<String>();
        values = new ArrayList<String>();

        JLabel lab1 = new JLabel("User Name", JLabel.LEFT);
        p.add(lab1);
        JTextField txt1 = new JTextField("User Name", JTextField.RIGHT);
        p.add(txt1);

        names.add(lab1.getText());
        values.add(txt1.getText());

        JLabel lab2 = new JLabel("Password ", JLabel.LEFT);
        p.add(lab2);
        JPasswordField txt2 = new JPasswordField("*****", JPasswordField.RIGHT);
        p.add(txt2);
        names.add(lab2.getText());
        // values.add(txt2.getText());

        // names.add(lab1,lab2);// Not right but I want to put the label text to
        // this arrayList
        // values.add(txt1,txt2);//
        txt1.addFocusListener(new ArrayListFocusListener(txt1, values, 0));
        txt2.addFocusListener(new ArrayListFocusListener(txt2, values, 1));

        add(p);

        // Start a thread to print the content of the list for 10 seconds
        new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    System.out.println(values);
                }
            }
        }.start();

    };

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.getContentPane().add(new UserGUI());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);

    };

    class ArrayListFocusListener implements FocusListener {
        JTextField textField;
        ArrayList<String> backingList;
        int myIndex;

        public ArrayListFocusListener(JTextField textField,
                ArrayList<String> backingList, int myIndex) {
            this.textField = textField;
            this.backingList = backingList;
            this.myIndex = myIndex;
        }

        public void focusGained(FocusEvent e) {
        }

        @Override
        public void focusLost(FocusEvent e) {
            backingList.set(myIndex, textField.getText());
        }

    }
}
