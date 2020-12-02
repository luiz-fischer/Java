package LocaCarv1.views;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import LocaCarv1.DAO.VeiculoLeveDAO;
import LocaCarv1.models.VeiculoLeve;

public class JTableVeiculoLeve extends JFrame {

    private JTable tabela;
    private JScrollPane scrollPainel;

    public JTableVeiculoLeve() throws SQLException {
        renderizarTela();
    }

    private void renderizarTela() throws SQLException {
        
        VeiculoLeveDAO dao = new VeiculoLeveDAO();
        List<VeiculoLeve> veiculosLeve = dao.listarTodosCadastros();

        //cria um objeto do nosso model
        VeiculoLeveTableModel model = new VeiculoLeveTableModel((ArrayList<VeiculoLeve>) veiculosLeve);
        
        //instancia a tabela já com o model como argumento
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
                JTableVeiculoLeve tb;
                try {
                    tb = new JTableVeiculoLeve();
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