package br.com.adsunifip.web1avaliacao3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.adsunifip.web1avaliacao3.model.Depositar;
import br.com.adsunifip.web1avaliacao3.model.Sacar;

import br.com.adsunifip.web1avaliacao3.model.ContaCorrente;
import br.com.adsunifip.web1avaliacao3.service.ContaBancariaService;

@RestController
@RequestMapping(path = "/")
public class ContaBancariaController {
    List<ContaCorrente> contas;

    @Autowired
    private ContaBancariaService servico;

    @GetMapping(path = {"", "/"})
    public List<ContaCorrente> listarContas(){
        return servico.mostrarContas();
    }

    @PostMapping(path = {"/contabancaria"})
    public ContaCorrente novaConta(@RequestBody ContaCorrente conta){
        servico.cadastrandoNovaConta(conta);
        return conta;
    }

    @DeleteMapping(path = "/contabancaria/{id}")
    public String apagarConta(@PathVariable(name = "id") Long idConta){
        servico.apagarConta(idConta);
        return "A sua conta foi removida conforme o solicitado!";
    }

    @PutMapping(path = "/contabancaria/{idConta}/deposito")
    public double depositar(@PathVariable Long idConta, @RequestBody Depositar deposito){
            return servico.Depositar(deposito, idConta);
    }

    @PutMapping(path = "/contabancaria/{idConta}/saque")
    public double saque(@PathVariable Long idConta, @RequestBody Sacar saque){
        return servico.Sacar(saque, idConta);
    }
    
    @GetMapping(path = "/contabancaria/{idConta}/saldo")
    public double saldo(@PathVariable Long idConta){
        return servico.mostrarSaldo(idConta);
    }
}

