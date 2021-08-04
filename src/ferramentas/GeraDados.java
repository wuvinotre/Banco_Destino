/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferramentas;

import dao.ClienteDAO;
import dao.ContaDAO;
import destino.Cliente;
import destino.Conta;
import java.util.ArrayList;


/**
 *
 * @author anderson.collin
 */
public class GeraDados {    
    ClienteDAO dao = new ClienteDAO();
    ContaDAO cdao = new ContaDAO();
    
    public Cliente GetCliente(String cpf){
        Cliente c = new Cliente();
        Conta ct = new Conta();
        ArrayList<Conta> listaContas = new ArrayList<Conta>();
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes = dao.lista();
        listaContas = cdao.lista();
        
        int tenantID = 0;
        for (Cliente cc : listaClientes) {
            if(cc.getCpf().equals(cpf)){
                c.setNome(cc.getNome());
                c.setCpf(cc.getCpf());
                c.setNr_telefone(cc.getNr_telefone());
                c.setSobrenome(cc.getSobrenome());
                c.setTenant_id(cc.getTenant_id());
                tenantID = cc.getTenant_id();
                break;
            }
        }
        
        for (Conta cont : listaContas){
            if(cont.getTenant_id() == tenantID){
                c.setAgencia(cont.getAgencia());
                c.setN_conta(cont.getN_conta());
                c.setSaldo(cont.getSaldo());
                c.setLimiteDeSaque(cont.getLimiteDeSaque());
                c.setLimite_usado(cont.getLimite_usado());
                break;
            }
        }
        return c;
    }
}
