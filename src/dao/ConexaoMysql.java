/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author anderson.collin
 */
public class ConexaoMysql {

    public String status = "Nao conectou...";
    public Connection connection = null;

    public Connection getConexao() {
        return connection;
    }

    public Connection conectarMySQL() {
        //Connection connection = null;          //atributo do tipo Connection
        try {
            // Carregando o JDBC Driver padrão
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            // Configurando a nossa conexão com um banco de dados//
            // String serverName = "localhost";    //caminho do servidor do BD
            String serverName = "192.168.0.254";    //caminho do servidor do BD
            String mydatabase = "destino";        //nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "dbuser";        //nome de um usuário de seu BD      
//            String username = "root";        //nome de um usuário de seu BD      
            String password = "27tpwSaByGzpdym2";      //sua senha de acesso
//            String password = "";      //sua senha de acesso
            Connection connection = DriverManager.getConnection(url, username, password);
            //Testa sua conexão//  
            if (connection != null) {
                status = ("Conectado com sucesso!");
            } else {
                status = ("Não foi possivel realizar conexão");
            }
            return connection;
        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado. "+ e);
            return null;
        } catch (SQLException e) {
            //Não conseguindo se conectar ao banco
            System.out.println("######################################################################");
            System.out.println("# Nao foi possivel conectar ao Banco de Dados. Verifique sua conexao #!");
            System.out.println("######################################################################\n"+ e);            
            return null;
        }
    }

    // Metodo que retorna o status da sua conexao//
    public String statusConection() {
        return status;
    }

    // Metodo que fecha sua conexao//
    public boolean FecharConexao() throws ClassNotFoundException {
        try {
            connection.close();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    // Metodo que reinicia sua conexao//
    public Connection ReiniciarConexao() throws ClassNotFoundException, SQLException {
        FecharConexao();
        this.conectarMySQL();
        return connection;
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        Statement pesquisa = connection.createStatement();
        String consulta = sql;
        ResultSet rs = pesquisa.executeQuery(consulta);

        return rs;
    }

    public void execute(String sql) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute(sql);
    }

}
