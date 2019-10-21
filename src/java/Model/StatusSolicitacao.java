package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum StatusSolicitacao {
    SOLICITADO("Solicitado", 0),
    EMANDAMENTO("Em Andamento", 1),
    PRONTO("Pronto", 2),
    ENTREGUE("Entregue", 3);

    private int id;
    private String nomeStatus;

    StatusSolicitacao(String status, int id) {
        this.nomeStatus = status;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getNomeStatus() {
        return this.nomeStatus;
    }

    public static List<StatusSolicitacao> obterStatusSolicitacoes() {
        ArrayList<StatusSolicitacao> status = new ArrayList<StatusSolicitacao>();
        status.addAll(Arrays.asList(StatusSolicitacao.values()));
        return status;
    }

    public static StatusSolicitacao obterStatusSolicitacao(String valor) {
        return Enum.valueOf(StatusSolicitacao.class, valor.toUpperCase().replaceAll(" ", ""));
    }

}
