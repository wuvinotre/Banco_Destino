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
public class Deposito {

    protected double saldo;
    protected double limite;
    private int tenant_id;
    private double limite_usado;

    public Deposito(double bSaldo, double sLimite, double zLimiteUsado, int bTenant) {
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
        this.limite_usado = limite_usado;
    }

    private double getLimiteSaldo() {
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

    public boolean doDeposito(double valor) {
        boolean ret = false;
        double temporario, temporario2;
        ContaDAO dao = new ContaDAO();
        HistoricoContaDAO hstdao = new HistoricoContaDAO();

        if (getLimite_usado() > 0) {            
            temporario = (getLimite_usado() - valor);
            if (temporario < 0) {
                double tmp = Math.abs(temporario);
                setSaldo(tmp);
                setLimite_usado(0);
                ret = dao.setSaque(getSaldo(), getLimite_usado(), getTenant_id());
            }else {
                setLimite_usado(temporario);
                ret = dao.setSaque(getSaldo(), getLimite_usado(), getTenant_id());
            }
        }else {
            temporario = (getSaldo() + valor);
            setSaldo(temporario);
            ret = dao.setSaque(getSaldo(), getLimite_usado(), getTenant_id());
        }

        if (ret) {
            hstdao.setHistorico(getTenant_id(), getSaldo(), getLimite(), getLimite_usado(),2,valor);
        }
        return ret;
    }

}
