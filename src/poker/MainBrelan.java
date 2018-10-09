/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.ArrayList;

/**
 *
 * @author PS5_The_Beginners
 */
public class MainBrelan extends MainJeu{
    
    int valeurBrelan;
    
    public MainBrelan(MainJoueur main,String Nom)
    {
        super(main,Nom);
    }
    
    
    int renvoiValeurBrelan()
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
           
            int retour = 0;
            for(boucle=0;boucle<CarteVal.size();boucle++)          
            {
              if (CarteOcc.get(boucle) == 3)
                  retour = CarteVal.get(boucle);
            }   
            
            valeurBrelan = retour;
            return valeurBrelan;
    }
    
    
}
