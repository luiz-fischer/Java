package LocaCarv1.views;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import LocaCarv1.models.VeiculoLeve;

public class VeiculoLeveTableModel extends AbstractTableModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // aqui transformei em coluna cada propriedade de Funcionario
    //que eu quero que seja exibida na tabela  
    private String colunas[] = {"Marca", "Modelo", "Ano", "Cor", "Valor da Diária"};
    private ArrayList<VeiculoLeve> veiculosLeve;
    private final int COLUNA_MARCA = 0;
    private final int COLUNA_MODELO = 1;
    private final int COLUNA_ANO = 2;
    private final int COLUNA_COR = 3;
    private final int COLUNA_VALOR_DIARIA = 4;

    public VeiculoLeveTableModel(ArrayList<VeiculoLeve> veiculosLeve) {
        this.veiculosLeve = veiculosLeve;
    }

    //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    //retorna o total de itens(que virarão linhas) da nossa lista
    @Override
    public int getRowCount() {
        return veiculosLeve.size();
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
            case COLUNA_MARCA:
                return String.class;
            case COLUNA_MODELO:
                return String.class;
            case COLUNA_ANO:
                return Integer.class;
            case COLUNA_COR:
                return String.class;
            case COLUNA_VALOR_DIARIA:
                return Double.class;
            default:
                return String.class;
        }
    }

    //preenche cada célula da tabela
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VeiculoLeve veiculoLeve = this.veiculosLeve.get(rowIndex);

        switch (columnIndex) {
            case COLUNA_MARCA:
                return veiculoLeve.getMarca();
            case COLUNA_MODELO:
                return veiculoLeve.getModelo();
            case COLUNA_ANO:
                return veiculoLeve.getAno();
            case COLUNA_COR:
                return veiculoLeve.getCor();
            case COLUNA_VALOR_DIARIA:
                return veiculoLeve.getValorLocacao();
        }
        return null;
    }
    //altera o valor do objeto de acordo com a célula editada
    //e notifica a alteração da tabela, para que ela seja atualizada na tela
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        VeiculoLeve veiculoLeve = this.veiculosLeve.get(rowIndex);
        //de acordo com a coluna, ele preenche a célula com o valor
        //respectivo do objeto de mesmo indice na lista
        switch (columnIndex) {
            case COLUNA_MARCA:
                veiculoLeve.setMarca(String.valueOf(aValue));
                break;
            case COLUNA_MODELO:
                veiculoLeve.setModelo(String.valueOf(aValue));
                break;
            case COLUNA_ANO:
                veiculoLeve.setAno((int) aValue);
                break;
            case COLUNA_COR:
                veiculoLeve.setCor(String.valueOf(aValue));
            case COLUNA_VALOR_DIARIA:
                veiculoLeve.setValorLocacao((Double) aValue);
        }
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }
}
