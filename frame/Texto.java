package frame;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
public class Texto implements ActionListener 
{
    // Declara Componentes
    JLabel rotulo;
    JTextArea area;
    JTextField texto;
    JButton botao;
     
    // Cria painel
    public Container CriaPainel()
    {
        // Cria conteudo da area de texto
        String conteudo =  "Escreva um texto dentro da caixa de texto \n" +
                           "Você também pode adicionar novas linhas nesta caixa" +
                            "Escrevendo no editor e clicando no botão";
         
        // Cria componentes
        rotulo = new JLabel("Insira um texto na caixa:");
        area = new JTextArea(conteudo);
        texto = new JTextField();
        botao = new JButton("Ok");
         
        // Cria evento do botão
        botao.addActionListener(this);
             
        // Adiciona valores as propriedades da area de texto
        area.setFont(new Font("Serif", Font.ITALIC, 12));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
         
        // Cria barra de rolagem e adiciona a area de texto
        JScrollPane scrooll = new JScrollPane(area);
         
        // Adiciona valores as propriedades da barra de rolagem
         
        // Barra vertical
        scrooll.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        // Tamanho da barra
        scrooll.setPreferredSize(new Dimension(250, 250));
         
        // Borda com titulo
        scrooll.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Caixa de Texto"),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                                scrooll.getBorder()));
         
         
        // Cria o painel
        JPanel painel = new  JPanel();
         
        // Cria um layout para os componentes
        painel.setLayout(new BoxLayout(painel,BoxLayout.PAGE_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
         
        // Alinha componentes
        rotulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        area.setAlignmentX(Component.CENTER_ALIGNMENT);
        texto.setAlignmentX(Component.CENTER_ALIGNMENT);
        botao.setAlignmentX(Component.CENTER_ALIGNMENT);
         
        // Adiciona componentes no painel
        painel.add(rotulo);
        painel.add(Box.createVerticalStrut(10));
         
        // Adiciona a barra de rolagem pois a area de texto
        // está já foi adiciona dentro dela logo acima.
        painel.add(scrooll);
        painel.add(Box.createVerticalStrut(5));
        painel.add(texto);
        painel.add(Box.createVerticalStrut(5));
        painel.add(botao);
                     
        // Retorna o painel
        return painel;
    }   
     
    public void actionPerformed(ActionEvent arg0)
    {
        // Cria evento para o botão     
        if (arg0.getSource() == botao)
        {
            area.append(texto.getText() + "\n");
        }       
    }   
     
    // Cria a GUI
    public static void criaGUI()
    {
        // Cria formulario
        JFrame formulario = new JFrame("DA - JTextArea");
         
        formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        // Cria nova instancia da classe
        Texto texto = new Texto();
         
        // adiciona painel ao formulario
        formulario.setContentPane(texto.CriaPainel());
                 
        // Compacta componetes no formulario
        formulario.pack();
         
        // Mostra formulario
        formulario.setVisible(true);
    }
     
    public static void main(String[] args)
    {
        // Cria thread do swing
        javax.swing.SwingUtilities.invokeLater(new Runnable() {         
            @Override
            public void run() {
                 
                // Chama a GUI
                criaGUI();              
            }
        });
 
    }
     
}