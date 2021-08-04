/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package destino;

/**
 *
 * @author anderson.collin
 */
public class HistoricoConta {
    private String Data;
    private int tipo_transf;
    private double valor;
    
    public HistoricoConta(){
        
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
        

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public int getTipo_transf() {
        return tipo_transf;
    }

    public void setTipo_transf(int tipo_transf) {
        this.tipo_transf = tipo_transf;
    }
    
}
