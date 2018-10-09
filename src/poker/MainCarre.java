/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

/**
 *
 * @author PS5_The_Beginners
 */
public class MainCarre extends MainJeu {
    
   int valeurCarre;
   
   public MainCarre(MainJoueur main,String nom)
   {
       super(main,nom);
   }
   
   int retourneValeurCarre()
    {
           this.main.rangerCarteOrdreCroissant();
           int premier = main.mainJ[0].getValeur();
           int boucle = 0;
           int compteur = 1;
           int index;
           for(boucle=1;boucle<5;boucle++)
           {
             if (main.mainJ[boucle].getValeur() == premier)
             {
                compteur = compteur + 1;
             }
           }
            
           if (compteur < 4) index = main.mainJ[4].getValeur();
           else index = main.mainJ[0].getValeur();
           this.valeurCarre = index;
           return valeurCarre;
    }
}
