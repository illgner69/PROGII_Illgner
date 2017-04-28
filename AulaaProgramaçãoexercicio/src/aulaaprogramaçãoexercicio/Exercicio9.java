/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulaaprogramaçãoexercicio;
import java.util.Scanner;
/**
 *
 * @author illgner
 */
public class Exercicio9 {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite o numero da matriz: ");
        int matriz = sc.nextInt();
        
        for (int i = 0; i < matriz + 1 ; i++) {
            
            for (int v = 0; v < matriz; v++) {
            System.out.println("|" + v + "|" + i + "|");
            }
        
        }
    
    }
    
}
