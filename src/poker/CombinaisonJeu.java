/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.ArrayList;

/**
 *
 * @author PS5
 */
public class CombinaisonJeu {
    
    MainJoueur main;
    
    public CombinaisonJeu(MainJoueur main)
    {
        this.main = main;
    }
    
    public boolean combinaisonIsPairre()
    {
           boolean TruePaire = true;
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
           if (CarteOcc.contains(2)) TruePaire = true;
             else TruePaire = false;
           
           return TruePaire;
    }
    
    boolean combinaisonIs2Paire()
    {
           boolean True2Pairre = false;
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
            
            if (verif == 2 && (index[0] != index[1] )) True2Pairre = true;
            return True2Pairre;
    }
    
     boolean combinaisonIsBrelan()
     {
           boolean TrueBrelan = false;
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
            if (CarteOcc.contains(3))TrueBrelan = true;
            else TrueBrelan = false;
            return TrueBrelan;
    }
     
     boolean combinaisonIsSuite()
    {
          boolean TrueSuite = true;
          int compteur = 0;
          int valeurT = main.mainJ[0].getValeur();  //Valeur de la plus petite carte
          int boucle = 0;
          for(boucle=1;boucle<5;boucle++)
          {
             if (main.mainJ[boucle].getValeur()==valeurT+1)   valeurT = main.mainJ[boucle].getValeur();
             else 
             {
                 TrueSuite = false;
                 break;
             }
             
          }
          return TrueSuite;
    }
     
    boolean combinaisonIsCouleur()
    {
            boolean TrueCouleur = false;
            String commun = main.mainJ[0].getType();
            int boucle = 0;
            int compteur = 1;
            for(boucle=1;boucle<5;boucle++)
            {
                if (commun.equals(main.mainJ[boucle].getType())) compteur = compteur + 1;
                  else break;
            }
            if (compteur == 5 ) TrueCouleur = true;
            else TrueCouleur = false;    
            return TrueCouleur;
    }
    
    boolean combinaisonIsFull()
    {
        
           boolean trueFull = false;
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
          
           /* Fin enregistrement */
           
           /* Comptage des occurences */
           
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
           
           
            if (CarteOcc.contains(2) && CarteOcc.contains(3)) trueFull = true;
                 else trueFull = false;
            return trueFull;
    }
    
    boolean CombinaisonIsCarre()
    {  
           boolean trueCarre = false;
           int premier = main.mainJ[0].getValeur();
           int boucle = 0;
           int compteur = 1;
           
           for(boucle=1;boucle<5;boucle++)
           {
             if (main.mainJ[boucle].getValeur() == premier)
             {
                compteur = compteur + 1;
             }
           }
            
           if (compteur < 4)
           {
              premier = main.mainJ[4].getValeur();
              compteur = 1;
           
                for(boucle=0;boucle<4;boucle++)
                {
                  if (main.mainJ[boucle].getValeur() == premier)
                  {
                     compteur = compteur + 1;
                  }
                }
           }
           
           if (compteur >= 4) trueCarre = true;
           else trueCarre = false;
           return trueCarre;
    }
}
