/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferramentas;

import dao.ClienteDAO;
import destino.Cliente;
import java.util.ArrayList;

/**
 *
 * @author anderson.collin
 */
public class GetTenantId {
    
    ClienteDAO dao = new ClienteDAO();
    //Cliente cli = new Cliente();
    private int tenantid;

    public int GetTenantId(String cpf) {
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes = dao.lista();

        for (Cliente cc : listaClientes) {
            if (cc.getCpf().equals(cpf)) {
                tenantid = cc.getTenant_id();
                break;
            }
        }
        return tenantid;
    }
}
