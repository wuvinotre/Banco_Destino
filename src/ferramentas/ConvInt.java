/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferramentas;

/**
 *
 * @author anderson.collin
 */
public class ConvInt {

    public int convInt(String valor) {
        int temporario;
        int tmp = Integer.parseInt(valor);
        temporario = tmp;

        return temporario;
    }

    public float convFloat(String valor) {
        float temporario;
        float tmp = Float.parseFloat(valor);
        temporario = tmp;

        return temporario;
    }
}
