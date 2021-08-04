/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferramentas;

import java.util.Random;


/**
 *
 * @author anderson.collin
 */
public class GerarSenha {
        private int numeroRand;
    private String SenhaConta;
        
        public String getSenha(String cpf){
        Random rand = new Random();
        String digt = cpf.substring(4, 8);        
        numeroRand = rand.nextInt(1000);
        String conca = Integer.toString(numeroRand);
        conca = conca+digt;        
        SenhaConta = conca;        
                 
        return SenhaConta;
    }
}
