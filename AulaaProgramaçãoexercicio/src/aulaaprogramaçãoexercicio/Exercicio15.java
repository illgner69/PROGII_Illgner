/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulaaprogramaçãoexercicio;

/**
 *
 * @author illgner
 */
public class Exercicio15 {
    public static void main(String[] args){
            
          private int numero;
          private double saldo;
          private String status;
          private double limite;
    
         public int passaNumero(){
             return numero;
       }
         public double passaSaldo(){
             return saldo;
        }
         public String passaStatus(){
              return status;
        }
          public double passaLimite(){
              return limite;
        }
            void recebeNumero (int numeroParametro){
              numero = numeroParametro;
        }
            void recebeSaldo (double saldoParametro){
              saldo = saldoParametro;
        }
            void recebeStatus (String statusParametro){
            status = statusParametro;
        }
            void recebeLimite (double limiteParametro){
             limite = limiteParametro


         }
        
      }  
}
