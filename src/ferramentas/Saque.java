/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferramentas;

import dao.ContaDAO;
import dao.HistoricoContaDAO;


// tipo transf: 1 - Saque 2 - Deposito 3 - Transferencia
/**
 *
 * @author anderson.collin
 */
public class Saque {

    protected double saldo;
    protected double limite;
    private int tenant_id;
    private double limite_usado;

    public Saque(double bSaldo, double sLimite, double zLimiteUsado, int bTenant) {        
            setSaldo(bSaldo);
            setLimite(sLimite);
            setTenant_id(bTenant);
            setLimite_usado(zLimiteUsado);
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public double getLimite_usado() {
        return limite_usado;
    }

    public void setLimite_usado(double limite_usado) {
        this.limite_usado = (getLimite_usado() + limite_usado);
    }

    private double getLimiteSaldo(){
        double temp = getSaldo() + (getLimite() - getLimite_usado());
        return (getSaldo() + (getLimite() - getLimite_usado()));
    }    
    
    public int getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(int tenant_id) {
        this.tenant_id = tenant_id;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    private void setLimite(double limite) {
        this.limite = limite;
    }

    public boolean doSaque(double valor) {     
        boolean ret = false;            
        ContaDAO dao = new ContaDAO();
        HistoricoContaDAO hstdao = new HistoricoContaDAO();
        
        if (getSaldo() >= valor) {            
            double temporario, temporario2;
            temporario = getSaldo();
            temporario -= valor;
            setSaldo(temporario);
            ret = dao.setSaque(getSaldo(), getLimite_usado(), getTenant_id());            
        } else if (getLimiteSaldo() >= valor) {            
            double temporario, temporario2;
            temporario = getSaldo();
            temporario -= valor;
            double tmp = Math.abs(temporario);
            setLimite_usado(tmp);
            setSaldo(0);            
            ret = dao.setSaque(getSaldo(), getLimite_usado(), getTenant_id());
        } else {
            //System.out.println("Sem saldo para efeturar saque");
            ret = false;
        }
        
        if(ret){
            hstdao.setHistorico(getTenant_id(), getSaldo(), getLimite(), getLimite_usado(),1, valor);
        }        
        return ret;
    }

}
