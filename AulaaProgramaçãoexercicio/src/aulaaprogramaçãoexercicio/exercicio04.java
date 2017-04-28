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
public class exercicio04 {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe um numero: ");
        double numero = sc.nextDouble();
        
        if (numero % 2 == 0){
            System.out.println("Seu número é par !!!");
        }
        
        else {
            System.out.println("Seu número é impar !!!");
        }
    }
    
}
    

