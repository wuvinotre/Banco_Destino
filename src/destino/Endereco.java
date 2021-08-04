/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package destino;

import dao.EnderecoDAO;

/**
 *
 * @author anderson.collin
 */
public class Endereco {

    private String nome_rua;
    private int numero;
    private int tenant_id;
    private String cidade;
    private String uf;
    EnderecoDAO dao;

    public Endereco() {

    }

    public String getNome_rua() {
        return nome_rua;
    }

    public void setNome_rua(String nome_rua) {
        this.nome_rua = nome_rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(int tenant_id) {
        this.tenant_id = tenant_id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String incluir() {
        dao = new EnderecoDAO();
        return dao.inserir(this);
    }
}
