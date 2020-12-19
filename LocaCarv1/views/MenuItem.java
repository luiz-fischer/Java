package LocaCarv1.views;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.ImageIcon;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
/* MenuLookDemo.java requires images/middle.gif. */
 
public class MenuItem {
    JTextArea output;
    JScrollPane scrollPane;
 
    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
 
        menuBar = new JMenuBar();
 
        menu = new JMenu("Cliente");
       
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);
 
        menuItem = new JMenuItem("Cadastrar Cliente",
                                 KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        ActionListener acaoCadastrarCliente = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleAction(e);
            }
        };

        menuItem.addActionListener(acaoCadastrarCliente);
        menu.add(menuItem);

        menuItem = new JMenuItem("Listar Cliente", KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        ActionListener acaoListarCliente = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleListernerClient(e);
            }
        };

        menu.add(menuItem);
        menuItem.addActionListener(acaoListarCliente);



 
        // ImageIcon icon = createImageIcon("images/middle.gif");
        // menuItem = new JMenuItem("Both text and icon", icon);
        // menuItem.setMnemonic(KeyEvent.VK_B);
        // menu.add(menuItem);
 
        // menuItem = new JMenuItem(icon);
        // menuItem.setMnemonic(KeyEvent.VK_D);
        // menu.add(menuItem);
 
        //a submenu
        menu.addSeparator();
        submenu = new JMenu("A submenu");
        submenu.setMnemonic(KeyEvent.VK_S);
 
        menuItem = new JMenuItem("An item in the submenu");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        submenu.add(menuItem);
 
        //Build second menu in the menu bar.
        menu = new JMenu("Veículo");
        menu.setMnemonic(KeyEvent.VK_N);
        menuItem = new JMenuItem("Cadastrar Veiculo",
                                 KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        ActionListener acaoCadastrarVeiculo = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleActionVehicle(e);
            }
        };
        menuBar.add(menu);
        menu.add(menuItem);
        menuItem.addActionListener(acaoCadastrarVeiculo);

        menuItem = new JMenuItem("Listar Veiculo",
                                 KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        ActionListener acaoListarVeiculo = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleListenerVehicle(e);
            }
        };

        menu.add(menuItem);
        menuItem.addActionListener(acaoListarVeiculo);

        //Build third menu in the menu bar.
        menu = new JMenu("Aluguel");
        menu.setMnemonic(KeyEvent.VK_N);
        menuItem = new JMenuItem("Cadastrar Aluguel",
                                 KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        ActionListener acaoCadastrarAluguel = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleActionVehicle(e);
            }
        };

        menuBar.add(menu);
        menu.add(menuItem);
        menuItem.addActionListener(acaoCadastrarAluguel);
         
        menuItem = new JMenuItem("Listar Aluguel",
                                 KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        ActionListener acaoListarAluguel = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            handleLIstenerRent(e);
        }

        };

        menu.add(menuItem);
        menuItem.addActionListener(acaoListarAluguel);

        menuItem = new JMenuItem("Listar Locações",
        KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));

        menuBar.add(menu);
        menu.add(menuItem);
        menuItem.addActionListener(acaoListarAluguel);
 
        return menuBar;
    }
 
    public Container createContentPane() {
        //Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
 
        //Create a scrolled text area.
        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);
 
        //Add the text area to the content pane.
        contentPane.add(scrollPane, BorderLayout.CENTER);
 
        return contentPane;
    }
 
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = MenuItem.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("MenuLookDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        MenuItem demo = new MenuItem();
        frame.setJMenuBar(demo.createMenuBar());
        frame.setContentPane(demo.createContentPane());
 
        //Display the window.
        frame.setSize(450, 260);
        frame.setVisible(true);
    }

    public void handleAction(ActionEvent e) {
        try {
            LocaCarv1.models.Cliente.cadastrarCliente();
        } catch (SQLException e1) {
            System.out.println("ERRO: " + e1.getMessage());
            e1.printStackTrace();
        }
        
    }

    public void handleListernerClient(ActionEvent e) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JtableCliente table;
                try {
                    table = new JtableCliente();
                    table.setLocationRelativeTo(null);
                    table.setVisible(true);
                } catch (SQLException e) {
                    System.out.println("ERRO:" + e);
                    e.printStackTrace();
                }
                
            }
        });
    }

    public void handleActionVehicle(ActionEvent e) {
        new CadastrarVeiculo();
    }
    public void handleListenerVehicle(ActionEvent e) {
        new ListarVeiculo();
    }
    public void handleLIstenerRent(ActionEvent e) {
        new ListarLocacao();
    } 
    public void handleLIstenerRentAll(ActionEvent e) {
    }

    public void ajustaFundo(String arquivo) {
		JLabel fundo = new JLabel(new ImageIcon(arquivo));
		fundo.setLayout(new FlowLayout());
		setContentPane(fundo);
	}
 
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}