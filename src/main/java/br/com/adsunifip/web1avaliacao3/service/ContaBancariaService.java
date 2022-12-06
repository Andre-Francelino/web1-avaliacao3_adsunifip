package br.com.adsunifip.web1avaliacao3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import br.com.adsunifip.web1avaliacao3.model.ContaCorrente;
import br.com.adsunifip.web1avaliacao3.model.Depositar;
import br.com.adsunifip.web1avaliacao3.model.Sacar;

@Service
public class ContaBancariaService {
    public List<ContaCorrente> contas = new ArrayList<ContaCorrente>();

    public List<ContaCorrente> mostrarContas(){
        return contas;
    }

    public void cadastrandoNovaConta(ContaCorrente conta){
        contas.add(conta);
    }

    public void apagarConta(Long idConta){
        for (int contador = 0; contador < contas.size(); contador++){
            if(contas.get(contador).getIdConta() == idConta){
                contas.remove(contador);
            }
        }
    }

    public double Depositar(Depositar deposito, Long idConta){
        double saldoConta;
        for (ContaCorrente conta : contas) {
            if(idConta == conta.getIdConta()){
                saldoConta = conta.getSaldoConta()+deposito.getDeposito();
                conta.setSaldoConta(saldoConta);
                return conta.getSaldoConta();
            }
        }
        return 0;
    }

    public double Sacar(Sacar saque, Long idConta){
        double saldoConta;
        for (ContaCorrente conta : contas) {
            if(idConta == conta.getIdConta()){
                saldoConta = conta.getSaldoConta()-saque.getSaque();
                conta.setSaldoConta(saldoConta);
                return conta.getSaldoConta();
            }
        }
        return 0;
    }

    public double mostrarSaldo(Long idConta){
        for (ContaCorrente conta : contas) {
            if(idConta == conta.getIdConta()){
                return conta.getSaldoConta();
            }   
        }
        return 0;
    }
}
