/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package destino;

import dao.ClienteDAO;

/**
 *
 * @author anderson.collin
 */
public class Cliente extends Conta{

    private String nome = "";
    private String sobrenome = "";
    private String cpf = "";
    private String senha = "";
    private int tenant_id = 0;
    private ClienteDAO dao;
    private int nr_telefone;

    public Cliente() {

    }

    public int getNr_telefone() {
        return nr_telefone;
    }

    public void setNr_telefone(int nr_telefone) {
        this.nr_telefone = nr_telefone;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(int tenant_id) {
        this.tenant_id = tenant_id;
    }

    public String incluir() {
        dao = new ClienteDAO();
        return dao.inserir(this);
    }
}
