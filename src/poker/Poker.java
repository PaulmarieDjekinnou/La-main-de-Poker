/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.Scanner;
import static poker.Carte.*;

/**
 *
 * @author thevie
 */
public class Poker {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Paquet paquet = new Paquet();
        Scanner scanner = new Scanner(System.in);
        String main;

        System.out.println("*****Kata - La main de Poker*****\n");
        System.out.println("Bienvenue!!!\n");
        System.out.println("Instruczions: Veuillez saisir une carte uniquement de type Trèfle\nExemple: 2Tr\n");
        System.out.print("Main 1: ");
        main = scanner.nextLine();
        Carte testCarte1 = paquet.controleDeMainContenant1Carte(main);



        if (testCarte1.getType().equals("") && testCarte1.getValeur() == 0) System.out.println("Carte non valide!!!");
        else{
            paquet.carteSelection(testCarte1);
            System.out.print("Main 2: ");
            main = scanner.nextLine();
            Carte testCarte2 = paquet.controleDeMainContenant1Carte(main);

            if (testCarte2.getType().equals("") && testCarte2.getValeur() == 0) System.out.println("Carte non valide!!!");
            else{
                if (!paquet.carteIsSelected(testCarte2)){
                    System.out.print("Main 1: "+testCarte1.toString()+"\n");
                    System.out.print("Main 2: "+testCarte2.toString()+"\n");
                    int res = compareTwoCard(testCarte1, testCarte2);
                    if (res == 1) System.out.println("Main 1 a gagné");
                    else System.out.println("Main 2 a gagné");
                }
            }
        }
        
    }
    
}
