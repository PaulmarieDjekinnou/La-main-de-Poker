/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.ArrayList;

/**
 *
 * @author KOFFI Merveille
 */
public class MainDeuxPaire extends MainJeu{
    
    int[] Valeur2Paire;
    int   DerniereValeure;
    
    public MainDeuxPaire(MainJoueur main,String Nom){
        super(main,Nom);
    }
    
    int[] RenvoitValeur2Pairre()
    {
           ArrayList<Integer> CarteVal = new ArrayList<Integer> ();
           CarteVal.add(main.mainJ[0].getValeur());
           
           int boucle = 0;
           for(boucle=1;boucle<5;boucle++)
           {
               if (!CarteVal.contains(main.mainJ[boucle].getValeur()))
                  CarteVal.add(main.mainJ[boucle].getValeur());
           }
          
           ArrayList<Integer> CarteOcc = new ArrayList<Integer> ();    
           for(boucle=0;boucle<CarteVal.size();boucle++)
           {
               CarteOcc.add(0);
           }
         
           int boucle1 = 0;
           for(boucle=0;boucle<CarteVal.size();boucle++)
           {
              for(boucle1=0;boucle1<5;boucle1++)
              {
                  if (main.mainJ[boucle1].getValeur() == CarteVal.get(boucle))
                  {
                      int tempo = CarteOcc.get(boucle);
                      tempo = tempo + 1;
                      CarteOcc.set(boucle,tempo);
                  }
              }
           }
           
            int verif = 0;
            int[] index = new int[2];
            int base = 0;
            
            for(boucle=0;boucle<CarteOcc.size();boucle++)
            {
                if (CarteOcc.get(boucle) == 2)
                {
                    index[base] = CarteVal.get(boucle);
                    verif = verif + 1; 
                    base = base + 1;
                }
            }
            this.Valeur2Paire = index;
            return Valeur2Paire;
    }
    
    int RetourneValeurDerniereCarte(int[] index)
    {
        int a = 0;
        int retour = 0;
        for(a=0;a<5;a++)
            {
                if ((main.mainJ[a].getValeur() != index[0]) && (main.mainJ[a].getValeur() != index[1]))
                {          
                  retour = main.mainJ[a].getValeur();         
                }
            }
        this.DerniereValeure = retour;
        return this.DerniereValeure;
    }
}
