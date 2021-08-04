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
public class GeraNrConta {
    private int numeroRand;
    private int numeroConta;
    private int numeroAgencia;
    
    public int getNrConta(String cpf){
        Random rand = new Random();
        String digt = cpf.substring(0, 4);        
        numeroRand = rand.nextInt(600);
        String conca = Integer.toString(numeroRand);
        conca = conca+digt;        
        numeroConta = Integer.parseInt(conca);        
                 
        return numeroConta;
    }
    
    public int getAgencia(String numero){
        Random rand = new Random();        
        numeroRand = rand.nextInt(99);
        String conca = Integer.toString(numeroRand);
        conca = numero+conca;        
        numeroAgencia = Integer.parseInt(conca);        
                 
        return numeroAgencia;        
    }
    
    
}
