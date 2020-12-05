package LocaCarv1.views;

import javax.swing.*;
import frame.SpringUtilities;
 
public class ClienteForm {
    private static void clienteForm() {
        String[] labels = {"Name: ", "CPF: ", "Data De Nascimento: "};
        int numPairs = labels.length;

        //Create and populate the panel.
        JPanel p = new JPanel(new SpringLayout());
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            JButton botaoOK = new JButton("OK");
            p.add(botaoOK);

            p.add(l);
            JTextField textField = new JTextField(15);
            l.setLabelFor(textField);
            p.add(textField);

            p.add(botaoOK);
        }

        //Lay out the panel.
        SpringUtilities.makeCompactGrid(p,
                                        numPairs, 2, //rows, cols
                                        6, 6,        //initX, initY
                                        6, 6);       //xPad, yPad
 
        //Create and set up the window.
        JFrame frame = new JFrame("Cadastro De Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton botaoOK = new JButton("OK");
        frame.add(botaoOK);
 
        //Set up the content pane.
        p.setOpaque(true);  //content panes must be opaque
       
        frame.setContentPane(p);
       
 
        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                clienteForm();
            }
        });
    }

	
}