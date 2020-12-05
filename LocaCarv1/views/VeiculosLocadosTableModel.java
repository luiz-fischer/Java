package LocaCarv1.views;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import LocaCarv1.models.VeiculoLeve;
import LocaCarv1.models.VeiculosLocados;

public class VeiculosLocadosTableModel extends AbstractTableModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // aqui transformei em coluna cada propriedade de Funcionario
    // que eu quero que seja exibida na tabela
    private String colunas[] = { "idVeiculosAlugados", "idAluguel", "idVeiculoLeve",  "Marca", "Modelo", "Ano", "Cor", "Valor da Diária", "fk_idCliente", "nome", "Data locacao", "Data Devolucao" };
    private ArrayList<VeiculosLocados> veiculosLocados;
    private final int COLUNA_IDVEICULOCADO = 1;
    private final int COLUNA_IDALUGUEL = 2;
    private final int COLUNA_IDVEICULEVE = 3;
    private final int COLUNA_MARCA = 4;
    private final int COLUNA_MODELO = 5;
    private final int COLUNA_ANO = 6;
    private final int COLUNA_COR = 7;
    private final int COLUNA_VALOR_DIARIA = 8;
    private final int COLUNA_IDCLienTE = 9;
    private final int COLUNA_NOME = 10;
    private final int COLUNA_DTLOCACAO = 11;
    private final int COLUNA_DTDEVOLUCAO = 12;

    


    public VeiculosLocadosTableModel(ArrayList<VeiculosLocados> veiculosLocados) {
        this.veiculosLocados = veiculosLocados;
    }

    //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    //retorna o total de itens(que virarão linhas) da nossa lista
    @Override
    public int getRowCount() {
        return veiculosLocados.size();
    }
    //retorna o total de colunas da tabela
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    //retorna o nome da coluna de acordo com seu indice
    @Override
    public String getColumnName(int indice) {
        return colunas[indice];
    }

    //determina o tipo de dado da coluna conforme seu indice
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {

            case COLUNA_IDVEICULOCADO:
                return Integer.class;
            case COLUNA_IDALUGUEL:
                return Integer.class;
            case COLUNA_IDVEICULEVE:
                return Integer.class;
            case COLUNA_MARCA:
                return String.class;
            case COLUNA_MODELO:
                return String.class;
            case COLUNA_ANO :
                return Integer.class;
            case COLUNA_COR :
                return String.class;
            case COLUNA_VALOR_DIARIA :
                return Double.class;
            case COLUNA_IDCLienTE :
                return Integer.class;
            case COLUNA_NOME :
                return String.class;
            case COLUNA_DTLOCACAO :
               return String.class;
            case COLUNA_DTDEVOLUCAO :
               return String.class;
            default:
                return String.class;
        }
    }

    //preenche cada célula da tabela
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VeiculosLocados veiculoLeve = this.veiculosLocados.get(rowIndex);
        for (VeiculoLeve string : VeiculoLeve.veiculosLeves) {
            
        switch (columnIndex) {
            case COLUNA_MARCA:
                return string.getMarca();
            case COLUNA_MODELO:
                return string.getModelo();
            case COLUNA_ANO:
                return string.getAno();
            case COLUNA_COR:
                return string.getCor();
            case COLUNA_VALOR_DIARIA:
                return string.getValorLocacao();
        }
    }
        return null;
    }
    //altera o valor do objeto de acordo com a célula editada
    //e notifica a alteração da tabela, para que ela seja atualizada na tela
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //o argumento recebido pelo método é do tipo Object
        //mas como nossa tabela é de funcionários, é seguro(e até recomendável) fazer o cast de suas propriedades
        VeiculosLocados veiculoLeve = this.veiculosLocados.get(rowIndex);
        //de acordo com a coluna, ele preenche a célula com o valor
        //respectivo do objeto de mesmo indice na lista
        for (VeiculoLeve veiculoLeve2 : VeiculoLeve.veiculosLeves) {
        
        switch (columnIndex) {
            case COLUNA_MARCA:
                veiculoLeve2.setMarca(String.valueOf(aValue));
                break;
            case COLUNA_MODELO:
                veiculoLeve2.setModelo(String.valueOf(aValue));
                break;
            case COLUNA_ANO:
                veiculoLeve2.setAno((int) aValue);
                break;
            case COLUNA_COR:
                veiculoLeve2.setCor(String.valueOf(aValue));
            case COLUNA_VALOR_DIARIA:
                veiculoLeve2.setValorLocacao((Double) aValue);
        }}
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }
}
