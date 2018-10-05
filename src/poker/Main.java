/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;


/**
 *
 * @author PS5
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Paquet paquet = new Paquet();
        MainJoueur Main1 = new MainJoueur();
        MainJoueur Main2 = new MainJoueur();

        System.out.println("*****Kata - La main de Poker*****\n");
        System.out.println("Bienvenue!!!\n");
        System.out.print("Main 1: ");
        Main1.LireMain(paquet,3);
        System.out.print("Main 2: ");
        Main2.LireMain(paquet,3);
       
        System.out.println("Main 1 : "+Main1.determinerLaMain());
        System.out.println("Main 2 : "+Main2.determinerLaMain());
                    
        if (Main1.CompareMain(Main2) == 1) System.out.println("Main 1 a gagné");
        else if (Main1.CompareMain(Main2) == -1) System.out.println("Main 2 a gagné");
        else System.out.println("Egalité");
        
     }
}
