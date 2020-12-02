package LocaCarv1.views;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import LocaCarv1.DAO.VeiculoPesadoDAO;
import LocaCarv1.models.VeiculoPesado;

public class JtableVeiculoPesado extends JFrame {

    private JTable tabela;
    private JScrollPane scrollPainel;

    public JtableVeiculoPesado() throws SQLException {
        renderizarTela();
    }

    private void renderizarTela() throws SQLException {

        VeiculoPesadoDAO dao = new VeiculoPesadoDAO();
        List<VeiculoPesado> veiculosPesado = dao.listarTodosCadastros();

        // cria um objeto do nosso model
        VeiculoPesadoTableModel model = new VeiculoPesadoTableModel((ArrayList<VeiculoPesado>) veiculosPesado);

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
                JtableVeiculoPesado tb;
                try {
                    tb = new JtableVeiculoPesado();
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