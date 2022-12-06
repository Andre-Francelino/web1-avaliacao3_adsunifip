package br.com.adsunifip.web1avaliacao3.model;

public class ContaCorrente {
    
    private Long idConta;
    private String descricaoConta;
    private double saldoConta;

    public ContaCorrente() {}

    public ContaCorrente(Long idConta, String descricaoConta, double saldoConta) {
        this.idConta = idConta;
        this.descricaoConta = descricaoConta;
        this.saldoConta = saldoConta;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public String getDescricaoConta() {
        return descricaoConta;
    }

    public void setDescricaoConta(String descricaoConta) {
        this.descricaoConta = descricaoConta;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }

}
