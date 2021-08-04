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
public class ContaDAO {

    private Connection conn;
    private Statement stmt;
    private PreparedStatement prepare;
    private String message_error;
    private String message_ok;

    public ContaDAO() {
        conn = new ConexaoMysql().conectarMySQL();
        message_error = "Erro ao processar...";
        message_ok = "Processado com sucesso...";
    }

    public String inserir(Conta c) {
        String retorno = "false";

        try {
            String sql = "INSERT INTO conta (agencia,limite_saque,n_conta,saldo,tipo,tenant_id) values(?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, c.getAgencia());
            stmt.setDouble(2, c.getLimiteDeSaque());
            stmt.setInt(3, c.getN_conta());
            stmt.setDouble(4, c.getSaldo());
            stmt.setInt(5, c.getTipo());
            stmt.setInt(6, c.getTenant_id());
            stmt.execute();
            retorno = message_ok;
            stmt.close();
        } catch (SQLException ex) {
            retorno = ex.getMessage();
        }
        return retorno;
    }

    public ArrayList<Conta> lista() {
        String sql;
        String retorno = "false";
        ArrayList<Conta> contas = new ArrayList<Conta>();

        try {
            sql = "select * from conta;";
            stmt = conn.createStatement();
            ResultSet rs;
            rs = conn.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                Conta con = new Conta();
                con.setAgencia(rs.getInt("agencia"));
                con.setLimiteDeSaque((int) rs.getDouble("limite_saque"));
                con.setN_conta(rs.getInt("n_conta"));
                con.setSaldo(rs.getDouble("saldo"));
                con.setTenant_id(rs.getInt("tenant_id"));
                con.setTipo(rs.getInt("tipo"));
                con.setLimite_usado(rs.getDouble("limite_usado"));
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

    public boolean setSaque(double Novosaldo, double limite_usado, int tenant_id) {

        try {
            String sql = "update conta set saldo = ?, limite_usado = ?  where tenant_id = ?";
            //String sql = "INSERT INTO conta (agencia,limite_saque,n_conta,saldo,tipo,tenant_id) values(?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, Novosaldo);
            stmt.setDouble(2, limite_usado);
            stmt.setDouble(3, tenant_id);
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean setDeposito(double Novosaldo, double limite_usado, int tenant_id) {

        try {
            String sql = "update conta set saldo = ?, limite_usado = ?  where tenant_id = ?";
            //String sql = "INSERT INTO conta (agencia,limite_saque,n_conta,saldo,tipo,tenant_id) values(?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, Novosaldo);
            stmt.setDouble(2, limite_usado);
            stmt.setDouble(3, tenant_id);
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

}
