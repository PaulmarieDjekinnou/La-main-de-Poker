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
        System.out.println("Instructions: Veuillez saisir une carte uniquement de type Trèfle\nExemple: 2Tr\n");
        System.out.print("Main 1: ");
        main = scanner.nextLine();
        
        /*Recuperer les 02 parties saisies*/
        String tab[] = main.split(" ");
        /* Fin */
        
        int a = 0;
        if (tab.length ==  2)
        {
                /*Verification des 02 cartes*/
                Carte TabCarte[] = new Carte[2];
                for (a=0;a<tab.length;a++)
                {
                   TabCarte[a] = paquet.controleDeMainContenant1Carte(tab[a]);
                    //System.out.println("okki");
                   if (TabCarte[a].getType().equals("") && TabCarte[a].getValeur() == 0) System.exit(0);
                }
                /* Fin */               
                MainJoueur Main1 = new MainJoueur(TabCarte[0],TabCarte[1]); 
                paquet.carteSelection(TabCarte[0]);
                
                for (a=1;a<tab.length;a++)
                {
                        if (paquet.carteIsSelected(TabCarte[a])) System.exit(0);
                }
                
                paquet.carteSelection(TabCarte[1]);
                System.out.print("Main 2: ");
                main = scanner.nextLine();
                
                String tab1[] = main.split(" ");
                if (tab1.length ==  2)
                {
                    for (a=0;a<tab.length;a++)
                    {
                       TabCarte[a] = paquet.controleDeMainContenant1Carte(tab1[a]);
                       //System.out.println("p");
                       if (TabCarte[a].getType().equals("") && TabCarte[a].getValeur() == 0) System.exit(0);
                    }
                    
                    for (a=0;a<tab.length;a++)
                    {
                        if (paquet.carteIsSelected(TabCarte[a])) System.exit(0);
                    }
                    
                    MainJoueur Main2 = new MainJoueur(TabCarte[0],TabCarte[1]);
                    //Main1.AfficherCarte();
                    //Main2.AfficherCarte();
                    
                    System.out.println("La reponse est : "+Main1.determinerLaMain());
                    System.out.println("La reponse est : "+Main2.determinerLaMain());
                    
                    int res = Main1.CompareMain(Main2);
                    if (res == 1) System.out.println("Main 1 a gagné");
                    else if (res == -1) System.out.println("Main 2 a gagné");
                    else System.out.println("Egalité");
                }
             
        }
        
    }
        
}
