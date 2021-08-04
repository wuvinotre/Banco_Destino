/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import destino.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author anderson.collin
 */
public class EnderecoDAO {
    
    private Connection conn;
    private Statement stmt;
    private PreparedStatement prepare;
    private String message_error;
    private String message_ok;
    
    public EnderecoDAO(){
        conn = new ConexaoMysql().conectarMySQL();
        message_error = "Erro ao processar...";
        message_ok = "Processado com sucesso...";
    }
    
    
    public String inserir(Endereco e) {
        String retorno = "false";

        try {
            String sql = "INSERT INTO endereco (nome_rua,numero,tenant_id,cidade,uf) values(?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, e.getNome_rua());
            stmt.setInt(2, e.getNumero());
            stmt.setInt(3, e.getTenant_id());
            stmt.setString(4, e.getCidade());
            stmt.setString(5, e.getUf());
                       
            stmt.execute();
            retorno = message_ok;
            stmt.close();
        } catch (SQLException ex) {
            retorno = ex.getMessage();
        }
        return retorno;
    }    
}
