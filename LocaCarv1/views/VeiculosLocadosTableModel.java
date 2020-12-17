package LocaCarv1.views;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import LocaCarv1.models.Cliente;
import LocaCarv1.models.Locacao;
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
    public List<?> veiculosLeve;

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


    public VeiculosLocadosTableModel(ArrayList<String> veiculosLeve) {
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
        VeiculosLocados vl = (VeiculosLocados) this.veiculosLeve.get(rowIndex);
        VeiculoLeve veiculeve = (VeiculoLeve) this.veiculosLeve.get(rowIndex);
        Cliente cliente = (Cliente) this.veiculosLeve.get(rowIndex);
        Locacao locacao = (Locacao) this.veiculosLeve.get(rowIndex);


            
        switch (columnIndex) {
                case COLUNA_IDVEICULOCADO:
                    return vl.getIdVeiculoLocado();
                case COLUNA_IDALUGUEL:
                    return vl.getIdLocacao();
                case COLUNA_IDVEICULEVE:
                    return vl.getIdVeiculoLeve();
                case COLUNA_MARCA:
                    return veiculeve.getMarca();
                case COLUNA_MODELO:
                    return veiculeve.getModelo();
                case COLUNA_ANO :
                    return veiculeve.getAno();
                case COLUNA_COR :
                    return veiculeve.getCor();
                case COLUNA_VALOR_DIARIA :
                    return veiculeve.getValorLocacao();
                case COLUNA_IDCLienTE:
                    return cliente.getIdCliente();
                case COLUNA_NOME :
                    return cliente.getNome();
                case COLUNA_DTLOCACAO :
                   return Locacao.getDataDeLocacao();
                case COLUNA_DTDEVOLUCAO :
                   return Locacao.getDataDeDevolucao();
                }
        return null;
    }
    //altera o valor do objeto de acordo com a célula editada
    //e notifica a alteração da tabela, para que ela seja atualizada na tela
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //o argumento recebido pelo método é do tipo Object
        //mas como nossa tabela é de funcionários, é seguro(e até recomendável) fazer o cast de suas propriedades
        VeiculosLocados vl = (VeiculosLocados) this.veiculosLeve.get(rowIndex);
        VeiculoLeve veiculeve = (VeiculoLeve) this.veiculosLeve.get(rowIndex);
        Cliente cliente = (Cliente) this.veiculosLeve.get(rowIndex);
        Locacao locacao = (Locacao) this.veiculosLeve.get(rowIndex);
        //de acordo com a coluna, ele preenche a célula com o valor
        //respectivo do objeto de mesmo indice na lista
        
        switch (columnIndex) {
            case COLUNA_MARCA:
                locacao.setDataDeDevolucao(String.valueOf(aValue));
                break;
            case COLUNA_MODELO:
                locacao.setDataDeLocacao(String.valueOf(aValue));
                break;
            case COLUNA_ANO:
                veiculeve.setAno((int) aValue);
                break;
            case COLUNA_COR:
                locacao.setDataDeDevolucao(String.valueOf(aValue));
            // case COLUNA_VALOR_DIARIA:
            //     lista.set((Double) aValue);
        }
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }
}
