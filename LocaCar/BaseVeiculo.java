package LocaCar;


public interface BaseVeiculo {
    public static int qtdLocacaoRealizada() {
        int total = 0;
        return total += Locacao.locacoes.size();
    }

    default String seloDaEmpresa() {
        String print = "Locadora Loca Car";
        return print;
    }

}
