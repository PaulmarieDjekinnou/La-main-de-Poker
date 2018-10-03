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

    void RangerCarteOrdreCroissant()       
    {
        /* Tri croissant des cartes */
        
        int i=0,j=0,temp=0;
        for(i=0;i<2;i++)
        {
            for(j=i+1;j<2;j++)
            {
                if (this.mainJ[i].getValeur() > this.mainJ[j].getValeur())
                {
                  Carte one = new Carte("",0);  
                  one = this.mainJ[j];
                  this.mainJ[j] = this.mainJ[i];
                  this.mainJ[i] = one;  
                }
            }
        }
        
        /* Fin */
    }
    
    boolean verifiePairre()
    {
           boolean TruePaire = true;
           ArrayList<Integer> CarteVal = new ArrayList<Integer> ();
           CarteVal.add(mainJ[0].getValeur());
           
           int boucle = 0;
           for(boucle=1;boucle<2;boucle++)
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
              for(boucle1=0;boucle1<2;boucle1++)
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
           
           return TruePaire;
    }
    
     public String determinerLaMain()
    {
            
        this.RangerCarteOrdreCroissant();
        
        //AfficherCarte(); permet d'afficher les cartes 
         
        String Reponse = "";
        
        boolean TruePaire = this.verifiePairre();
        /* Donner la main en presence */
        
        if (TruePaire)            Reponse = "Paire";
        else                      Reponse = "Plus haute carte";
        
        return Reponse;
    }
     
     int convertirMain(String a)
    {
       
          switch(a)
                    {
                        case "Plus haute carte" : a = "0";
                                                  break;
                                                  
                        case "Paire" : a = "1";
                                                  break;  
                                                 
                    }
                    
        int retour = Integer.valueOf(a).intValue();
        return retour;
    }
     
     int departagerPlusHauteCarte(MainJoueur two)
    {
        this.RangerCarteOrdreCroissant();
        two.RangerCarteOrdreCroissant();
        
        int a = 1;
        int reponse = 0;
        
        while (this.mainJ[a].getValeur() == two.mainJ[a].getValeur())
        {
            a = a - 1;
            if (a<0) break;
        }
       
        if (a<0) return 0;
        else
        {
            if (this.mainJ[a].getValeur() > two.mainJ[a].getValeur()) 
                return 1;
            else return -1;
        }
    }
    
    int departagerPaire(MainJoueur two)
    {
        this.RangerCarteOrdreCroissant();
        two.RangerCarteOrdreCroissant();
        
        int Paire1 = this.RenvoitValeurPairre();
        int Paire2 = two.RenvoitValeurPairre();
        
        if (Paire1 > Paire2)  return 1;
        else if (Paire1 < Paire2) return -1;
        else return 0;
    }
    
    int RenvoitValeurPairre()
    {
           ArrayList<Integer> CarteVal = new ArrayList<Integer> ();
           CarteVal.add(this.mainJ[0].getValeur());
           
           int boucle = 0;
           for(boucle=1;boucle<2;boucle++)
           {
               if (!CarteVal.contains(this.mainJ[boucle].getValeur()))
                  CarteVal.add(this.mainJ[boucle].getValeur());
           }
    
        
           ArrayList<Integer> CarteOcc = new ArrayList<Integer> ();    
           for(boucle=0;boucle<CarteVal.size();boucle++)
           {
               CarteOcc.add(0);
           }
          
           int boucle1 = 0;
           for(boucle=0;boucle<CarteVal.size();boucle++)
           {
              for(boucle1=0;boucle1<2;boucle1++)
              {
                  if (this.mainJ[boucle1].getValeur() == CarteVal.get(boucle))
                  {
                      int tempo = CarteOcc.get(boucle);
                      tempo = tempo + 1;
                      CarteOcc.set(boucle,tempo);
                  }
              }
           }
           
           int retour = 0;
           for(boucle=0;boucle<CarteOcc.size();boucle++)
           {
               if (CarteOcc.get(boucle) == 2)
                   retour = CarteVal.get(boucle);
           }
           return retour;
    }
     
    public int  CompareMain(MainJoueur Main)
    {
        int MainOne = convertirMain(this.determinerLaMain());
        int MainTwo = convertirMain(Main.determinerLaMain());
        
        if (MainOne > MainTwo)
        {
            return 1;
        }
        else if (MainOne < MainTwo)
        {
            return -1;
        }
        else
        {
            int reponse = 0;
            
            switch(MainOne){
                
                case 0 : reponse = this.departagerPlusHauteCarte(Main);
                         break;
                
                case 1 : reponse = this.departagerPaire(Main);
                         break;
                         
            }
            return reponse;
        }

    }
    
   
    //AfficherCarte(); permet d'afficher le type et la valeur d'une carte
    public void AfficherCarte()
    {
        int a = 0;
        for(a=0;a<2;a++)
        {
            System.out.println("Le type est : "+mainJ[a].getType()+" la valeur est "+mainJ[a].getValeur());       
        }
    }
    
   
    
    
}
