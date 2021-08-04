/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferramentas;

import dao.ClienteDAO;
import dao.ConexaoMysql;
import destino.Cliente;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author anderson.collin
 */
public class ValidaLogin {

    ClienteDAO dao = new ClienteDAO();
    Cliente cli = new Cliente();

    public boolean ValidaLogin(String cpf, String senha) {
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes = dao.lista();
        boolean ret = false;
        for (Cliente cc : listaClientes) {
            if (cc.getCpf().equals(cpf) && cc.getSenha().equals(senha)) {
                ret = true;
                break;
            }
        }
        return ret;
    }
}
