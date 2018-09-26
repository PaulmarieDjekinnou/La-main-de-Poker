/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.ArrayList;

/**
 *
 * @author thevie
 */
public class MainJoueur {
    Carte mainJ[] = new Carte[5];

    public MainJoueur(Carte... main) {
        
        for(int i=0; i<main.length;i++){          
            mainJ[i] = main[i];
        }
        
    }
    
    
    public String determinerLaMain()
    {
        
        
        /* Tri croissant des cartes */
        
        int i=0,j=0,temp=0;
        for(i=0;i<5;i++)
        {
            for(j=i+1;j<5;j++)
            {
                if (mainJ[i].getValeur() > mainJ[j].getValeur())
                {
                  Carte one = new Carte("",0);  
                  one = mainJ[j];
                  mainJ[j] = mainJ[i];
                  mainJ[i] = one;  
                }
            }
        }
        
        /* Fin */
        
        //AfficherCarte(); permet d'afficher les cartes 
         
        String Reponse = "";
         
        /* Verification du "Quinte Flusch" */       
        
         int a = 0;
         int valeur = mainJ[0].getValeur();  //Valeur de la plus petite carte
         String typeCarte = mainJ[0].getType();
         boolean trueQuinte = true;
         for(a=1;a<5;a++)
         {
             if (mainJ[a].getValeur()==valeur+1 && mainJ[a].getType().equals(typeCarte))
             {
                 valeur = mainJ[a].getValeur();
                 //System.out.println("okki");
             }
             else 
             {
                 trueQuinte = false;
                 break;
             }
             
         }
         
        /* FIN */
        
        
        
        /* Verification du "Carre" */
        
        
        boolean trueCarre = true;
        if (trueQuinte == false )   /* N"effectue la verification que ssi quinte faux */
        {
           int premier = mainJ[0].getValeur();
           int boucle = 0;
           int compteur = 1;
           
           for(boucle=1;boucle<5;boucle++)
           {
             if (mainJ[boucle].getValeur() == premier)
             {
                compteur = compteur + 1;
             }
           }
            
           if (compteur < 4)
           {
              premier = mainJ[4].getValeur();
              compteur = 1;
           
                for(boucle=0;boucle<4;boucle++)
                {
                  if (mainJ[boucle].getValeur() == premier)
                  {
                     compteur = compteur + 1;
                  }
                }
           }
           
           if (compteur >= 4) trueCarre = true;
           else trueCarre = false;
        }
        else trueCarre = false;  
        
        /* FIN */
        
        
        /* Verification de "full" */
        
        boolean trueFull = true;
        
        if (trueCarre == false )
        {
          /* Enregistrer les valeurs des differentes cartes dans la main */
          
           ArrayList<Integer> CarteVal = new ArrayList<Integer> ();
           CarteVal.add(mainJ[0].getValeur());
           
           int boucle = 0;
           for(boucle=1;boucle<5;boucle++)
           {
               if (!CarteVal.contains(mainJ[boucle].getValeur()))
                  CarteVal.add(mainJ[boucle].getValeur());
           }
          
           //System.out.println("La taille est : "+CarteVal.size());
           
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
                  if (mainJ[boucle1].getValeur() == CarteVal.get(boucle))
                  {
                      int tempo = CarteOcc.get(boucle);
                      tempo = tempo + 1;
                      CarteOcc.set(boucle,tempo);
                  }
              }
           }
           
           /* FIN COMPTAGE */
           
             /* Verifier le comportement de la liste */
             /*   int verif = 0;
                for(verif=0;verif<CarteVal.size();verif++)
                {
                    System.out.println("La valeur : "+CarteVal.get(verif)+" a pour occurence  : "+CarteOcc.get(verif));
                }  */
            /* FIN VERIFICATION */
           
            /* Verdict */
            
            if (CarteOcc.contains(2) && CarteOcc.contains(3))
            {
              trueFull = true;
            }
            else trueFull = false;
         }
        else trueFull = false;
            
        /* FIN */
        
        
        /* Verification de "COULEUR" */
        
        boolean TrueCouleur = true;
        
        if (trueFull == false )
        {
            String commun = mainJ[0].getType();
            int boucle = 0;
            int compteur = 1;
            for(boucle=1;boucle<5;boucle++)
            {
                if (commun.equals(mainJ[boucle].getType()))
                {
                    compteur = compteur + 1;
                }
                else break;
            }
            
            if (compteur == 5 ) TrueCouleur = true;
            else TrueCouleur = false;
        }
        else TrueCouleur = false; 
            
        /* FIN */
        
        /* Verification Suite */
          
         boolean TrueSuite = true;
         
         if (TrueCouleur == false )
         {
             
          int compteur = 0;
          int valeurT = mainJ[0].getValeur();  //Valeur de la plus petite carte
          int boucle = 0;
          for(boucle=1;boucle<5;boucle++)
          {
             if (mainJ[boucle].getValeur()==valeurT+1)
             {
                 valeurT = mainJ[boucle].getValeur();
                 //System.out.println("okki");
             }
             else 
             {
                 TrueSuite = false;
                 break;
             }
             
          }
         
         }
         else TrueSuite = false; 
             
        /* FIN */
    
        
        /* Verification de "Brelan" */
        
        boolean TrueBrelan = true;
        
        if (TrueSuite == false )
        {
            
           ArrayList<Integer> CarteVal = new ArrayList<Integer> ();
           CarteVal.add(mainJ[0].getValeur());
           
           int boucle = 0;
           for(boucle=1;boucle<5;boucle++)
           {
               if (!CarteVal.contains(mainJ[boucle].getValeur()))
                  CarteVal.add(mainJ[boucle].getValeur());
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
                  if (mainJ[boucle1].getValeur() == CarteVal.get(boucle))
                  {
                      int tempo = CarteOcc.get(boucle);
                      tempo = tempo + 1;
                      CarteOcc.set(boucle,tempo);
                  }
              }
           }
           
             
            if (CarteOcc.contains(3))
            {
              TrueBrelan = true;
            }
            else TrueBrelan = false;
         }
        else TrueBrelan = false;
        
        /* FIN */
        
        
        /* Verification de 02 pairres */
        
        boolean True2Pairre = true;
        
        if (TrueBrelan == false )
        {
           ArrayList<Integer> CarteVal = new ArrayList<Integer> ();
           CarteVal.add(mainJ[0].getValeur());
           
           int boucle = 0;
           for(boucle=1;boucle<5;boucle++)
           {
               if (!CarteVal.contains(mainJ[boucle].getValeur()))
                  CarteVal.add(mainJ[boucle].getValeur());
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
                  if (mainJ[boucle1].getValeur() == CarteVal.get(boucle))
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
            
            if (verif == 2 && (index[0] != index[1] ))
            {
                True2Pairre = true;
            }
            else True2Pairre = false;
         }
        else True2Pairre = false;
        
        /* Fin */
        
        
        /* Verification de "Pairre" */
        
        boolean TruePaire = true;
        
        if (True2Pairre == false )
        {
            
           ArrayList<Integer> CarteVal = new ArrayList<Integer> ();
           CarteVal.add(mainJ[0].getValeur());
           
           int boucle = 0;
           for(boucle=1;boucle<5;boucle++)
           {
               if (!CarteVal.contains(mainJ[boucle].getValeur()))
                  CarteVal.add(mainJ[boucle].getValeur());
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
                  if (mainJ[boucle1].getValeur() == CarteVal.get(boucle))
                  {
                      int tempo = CarteOcc.get(boucle);
                      tempo = tempo + 1;
                      CarteOcc.set(boucle,tempo);
                  }
              }
           }
           
             
            if (CarteOcc.contains(2))
            {
              TruePaire = true;
            }
            else TruePaire = false;
         }
        else TruePaire = false;
        
        
        /* FIN */
        
        if (!TruePaire) Reponse = "Plus haute carte";
        
        /* Donner la main en presence */
        
        if (trueQuinte)                Reponse = "Quinte flush";
        else if (trueCarre)            Reponse = "Carre";
        else if (trueFull)             Reponse = "Full";
        else if (TrueCouleur)          Reponse = "Couleur";
        else if (TrueSuite)            Reponse = "Suite";
        else if (TrueBrelan)           Reponse = "Brelan";
        else if (True2Pairre)          Reponse = "2Paire";
        else if (TruePaire)            Reponse = "Paire";
        else                           Reponse = "Plus haute carte";
        
        /* fin */
        
        
        
        return Reponse;
    }
    
    
    public void AfficherCarte()
    {
        int a = 0;
        for(a=0;a<5;a++)
        {
            System.out.println("Le type est : "+mainJ[a].getType()+" la valeur est "+mainJ[a].getValeur());       
        }
    }
    
   
    
    
}
