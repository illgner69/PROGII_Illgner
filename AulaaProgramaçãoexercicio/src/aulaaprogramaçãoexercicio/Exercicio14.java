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
public class Exercicio14 {
    public static void main(String[] args) {
    
        TimeFutebol time = new TimeFutebol();
        time.nomeNome("programação");
        time.rendaRenda(1000000);
        time.presidentePresidente("usabilidadeo");
        time.tecnicoTecnico("bancodados");
               
          System.out.print("Qual é o seu time? ");
          System.out.print(time.getNome());
          
          System.out.print("\nQual o valor da renda? ");
          System.out.print(time.getRenda());
          
          System.out.print("\nQuem é o técnico? ");
          System.out.print(time.getTecnico());
          
          System.out.print("\nQual o Presidente? ");
          System.out.print(time.getPresidente());
          
          
    
}

}
