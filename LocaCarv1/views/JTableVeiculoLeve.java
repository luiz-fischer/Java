package LocaCarv1.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import LocaCarv1.DAO.VeiculoLeveDAO;
import LocaCarv1.models.VeiculoLeve;
import frame.CellRenderer;

public class JTableVeiculoLeve extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JTable tabela;
    private JScrollPane scrollPainel;

    public JTableVeiculoLeve() throws SQLException {
        renderizarTela();
    }

    private void renderizarTela() throws SQLException {
        
        VeiculoLeveDAO dao = new VeiculoLeveDAO();
        List<VeiculoLeve> veiculosLeve = dao.listarTodosCadastrosVeiculoLeve();

        //cria um objeto do nosso model
        VeiculoLeveTableModel model = new VeiculoLeveTableModel((ArrayList<VeiculoLeve>) veiculosLeve);
        
        //instancia a tabela já com o model como argumento
        this.tabela = new JTable(model);
        this.scrollPainel = new JScrollPane(tabela);
        this.tabela.setFont(new Font("Courier PLAIN", Font.BOLD, 13));
        this.tabela.setDefaultRenderer(Object.class, new CellRenderer());

        this.add(scrollPainel);
        this.pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JTableVeiculoLeve table;
                try {
                    table = new JTableVeiculoLeve();
                    table.setLocationRelativeTo(null);
                    table.setVisible(true);
                } catch (SQLException e) {
                    System.out.println("ERRO:" + e);
                    e.printStackTrace();
                }
                
            }
        });
    }
}