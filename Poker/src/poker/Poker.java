/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.Scanner;

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
        //Instantiation
        Paquet paquetDeCartes = new Paquet();
        String mainJoueur;
        Scanner scanner = new Scanner(System.in);
        System.out.println("*****Kata - La main de Poker*****\n");
        System.out.println("Bienvenue!!!\n");
        //paquetDeCartes.affichepaquet();
        
        /*test de pairre*/
        Carte one = new Carte("Tr",2);
        Carte two = new Carte("Tr",0);
        Carte three = new Carte("Tr",8);
        Carte four = new Carte("Ca",3);
        Carte five = new Carte("Tr",1);
        
        Carte[] test = new Carte[]{one,two,three,four,five};
        
        /* Transformation des cartes speciales */
        /*int z=0;
        for(z=0;z<5;z++)
        {
            Switch (test[z].getValeur())
                    {
                        case 'V' : {
                                   mainJ[z].setValeur(11);
                                   }break;
                        case 'D' :
                        case 'R' :
                        case 'A' :
                        default : ;
                    }
        }*/
        /* FIN */
        
        MainJoueur J = new MainJoueur(test);
        System.out.println("La reponse est : "+J.determinerLaMain());
        /* fin controle */
        
        System.out.println("Joueur 1, saisissez vos cartes:\n");
        mainJoueur = scanner.nextLine();
        //On analyse la main
        paquetDeCartes.controleDeMain(mainJoueur);
        
        
        
    }
    
}
