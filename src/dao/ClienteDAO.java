/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import destino.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author anderson.collin
 */
public class ClienteDAO {

    private Connection conn;
    private Statement stmt;
    private PreparedStatement prepare;
    private String message_error;
    private String message_ok;

    public ClienteDAO() {
        conn = new ConexaoMysql().conectarMySQL();
        message_error = "Erro ao processar...";
        message_ok = "Processado com sucesso...";
    }

    public String inserir(Cliente c) {
        String retorno = "false";

        try {
            String sql = "INSERT INTO cliente (cpf, nome, senha, sobrenome,nr_telefone) values(?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getCpf());
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getSenha());
            stmt.setString(4, c.getSobrenome());
            stmt.setInt(5, c.getNr_telefone());
            stmt.execute();
            retorno = message_ok;
            stmt.close();
        } catch (SQLException ex) {
            retorno = ex.getMessage();
        }
        return retorno;
    }

    public ArrayList<Cliente> lista() {
        String sql;
        String retorno = "false";
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        try {
            sql = "select * from cliente;";
            stmt = conn.createStatement();
            ResultSet rs;
            rs = conn.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setCpf(rs.getString("cpf"));
                cli.setNome(rs.getString("nome"));
                cli.setSenha(rs.getString("senha"));
                cli.setSobrenome(rs.getString("sobrenome"));
                cli.setTenant_id(rs.getInt("tenant_id"));
                cli.setNr_telefone(rs.getInt("nr_telefone"));                
                
                clientes.add(cli);
            }
            rs.close();
            stmt.close();
            return clientes;
        } catch (SQLException ex) {
            retorno = ex.getMessage();
        }
        return clientes;
    }
}
