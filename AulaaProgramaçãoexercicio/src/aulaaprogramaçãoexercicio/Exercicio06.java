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
public class Exercicio06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float media ;
        
        System.out.println("Informe a primeira nota: ");
        float pnota = sc.nextFloat();
        
        System.out.println("Informe a segunda nota ");
        float snota = sc.nextFloat();
        
        media = ((pnota+snota)/2);
        
        if (media >= 6){
            System.out.println("Aluno aprovado !!!");
        }
        else{
            System.out.println("Aluno reprovado !!!");
        }
        System.out.println("Sua média é : " + media);
    }
    
}
