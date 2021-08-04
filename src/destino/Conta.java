/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package destino;

import dao.ClienteDAO;
import dao.ContaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import destino.Conta;
import java.util.ArrayList;

/**
 *
 * @author anderson.collin
 */
public class Conta extends HistoricoConta{

    private int n_conta;
    private int agencia;
    private int tenant_id;  // digito verificador
    private double saldo;
    private int tipo;
    private float limiteDeSaque;
    private double limite_usado;
    private int saques;
    private ContaDAO dao;
    
    public Conta(){
        
    }

    public double getLimite_usado() {
        return limite_usado;
    }

    public void setLimite_usado(double limite_usado) {
        this.limite_usado = limite_usado;
    }
    
    
    
    public String geraNumConta(){
        
        return "";
    }

    public int getN_conta() {
        return n_conta;
    }

    public void setN_conta(int n_conta) {
        this.n_conta = n_conta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(int tenant_id) {
        this.tenant_id = tenant_id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public float getLimiteDeSaque() {
        return limiteDeSaque;
    }

    public void setLimiteDeSaque(float limiteDeSaque) {
        this.limiteDeSaque = limiteDeSaque;
    }

    public int getSaques() {
        return saques;
    }

    public void setSaques(int saques) {
        this.saques = saques;
    }
    
        public String incluir() {
        dao = new ContaDAO();
        return dao.inserir(this);
    }
    
}
