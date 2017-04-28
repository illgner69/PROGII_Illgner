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
public class Exercicio12 {
    public static void main(String[] args) {
        float Hipotenusa ;
        float Hipotenusa ;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Informe o primeiro cateto: ");
        float pcat = sc.nextFloat();
        
        System.out.println("Informe o primeiro cateto: ");
        float scat = sc.nextFloat();
        
        Hipotenusa =  ((float) Math.pow(pcat, 2) + (float) Math.pow(scat, 2)) ;
        Hipotenusa = (float)Math.pow(Hipotenusa, (1.0/2));
        
        System.out.println("O valor da hipotenusa é :" + Hipotenusa);
    }
    
}
