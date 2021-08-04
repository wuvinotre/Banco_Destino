/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class HistoricoContaDAO {

    private Connection conn;
    private Statement stmt;
    private PreparedStatement prepare;
    private String message_error;
    private String message_ok;

    public HistoricoContaDAO() {
        conn = new ConexaoMysql().conectarMySQL();
        message_error = "Erro ao processar...";
        message_ok = "Processado com sucesso...";
    }

    public ArrayList<Conta> lista() {
        String sql;
        String retorno = "false";
        ArrayList<Conta> contas = new ArrayList<Conta>();

        try {
            sql = "select * from historico_conta;";
            stmt = conn.createStatement();
            ResultSet rs;
            rs = conn.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                Conta con = new Conta();                
                con.setLimiteDeSaque((int) rs.getDouble("limite_saque"));                
                con.setSaldo(rs.getDouble("saldo"));
                con.setTenant_id(rs.getInt("tenant_id"));                
                con.setLimite_usado(rs.getDouble("limite_usado"));
                con.setData(rs.getDate("data").toString());  
                con.setTipo_transf(rs.getInt("tipo"));
                con.setValor(rs.getDouble("valor"));
                contas.add(con);
            }
            rs.close();
            stmt.close();
            return contas;
        } catch (SQLException ex) {
            retorno = ex.getMessage();
        }
        return contas;
    }

    public boolean setHistorico(int tenant_id, double saldo, double limite_saque, double limite_usado, int tipo_transf, double valor) {

        try {
            String sql = "insert into historico_conta (tenant_id, saldo,limite_saque,limite_usado, tipo, valor) values(?,?,?,?,?,?);";
            //String sql = "INSERT INTO conta (agencia,limite_saque,n_conta,saldo,tipo,tenant_id) values(?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, tenant_id);
            stmt.setDouble(2, saldo);
            stmt.setDouble(3, limite_saque);
            stmt.setDouble(4, limite_usado);
            stmt.setDouble(5, tipo_transf);
            stmt.setDouble(6, valor);
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

}
