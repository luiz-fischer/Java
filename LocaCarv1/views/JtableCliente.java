package LocaCarv1.views;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import LocaCarv1.DAO.ClienteDAO;
import LocaCarv1.models.Cliente;

public class JtableCliente extends JFrame {

    private JTable tabela;
    private JScrollPane scrollPainel;

    public JtableCliente() throws SQLException {
        renderizarTela();
    }

    private void renderizarTela() throws SQLException {

        ClienteDAO dao = new ClienteDAO();
        List<Cliente> clientes = dao.listarTodosCadastros();

        // cria um objeto do nosso model
        ClienteTableModel model = new ClienteTableModel((ArrayList<Cliente>) clientes);

        // instancia a tabela já com o model como argumento
        this.tabela = new JTable(model);
        this.scrollPainel = new JScrollPane(tabela);

        this.add(scrollPainel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JtableCliente tb;
                try {
                    tb = new JtableCliente();
                    tb.setLocationRelativeTo(null);
                    tb.setVisible(true);
                } catch (SQLException e) {
                    System.out.println("ERRO:" + e);
                    e.printStackTrace();
                }
                
            }
        });
    }
}
