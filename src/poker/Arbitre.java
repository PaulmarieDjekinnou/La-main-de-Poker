/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.ArrayList;

/**
 * @author PS5
 */

public class Arbitre {
    
    MainJoueur MainOne;
    MainJoueur MainTwo;
    String     Vainqueur;
    
    public Arbitre(MainJoueur one,MainJoueur two)
    {
        MainOne = one;
        MainTwo = two;
    }
    
    public String getVainqueur()
    {
        return Vainqueur;
    }
    
    public void ComparerLesDeuxMains()
    {
        int MainO = CombinaisonJoueur.convertirMain(MainOne.getCombinaison());
        int MainT = CombinaisonJoueur.convertirMain(MainTwo.getCombinaison());
        
        if (MainO > MainT) Vainqueur="Main1";
        else if (MainO < MainT) Vainqueur="Main2";
        else
        {
            int reponse = 0;
            switch(MainO){
                case 0 : reponse = this.departagerPlusHauteCarte(); break;
                case 1 : reponse = this.departagerPaire(); break;
                case 2 : reponse = this.departagerDeuxPaire(); break;
                case 3 : reponse = this.departagerBrelan(); break; 
            }
            
            if(reponse==1) Vainqueur="Main1";
            else if (reponse==-1) Vainqueur="Main2";
            else Vainqueur="Egalité";
        }
    }
    
    int departagerPlusHauteCarte()
    {
        MainOne.RangerCarteOrdreCroissant();
        MainTwo.RangerCarteOrdreCroissant();
        int a = 2;
        int reponse = 0;
        while (MainOne.mainJ[a].getValeur() == MainTwo.mainJ[a].getValeur())
        {
            a = a - 1;
            if (a<0) break;
        }
        if (a<0) return 0;
        else
        {
            if (MainOne.mainJ[a].getValeur() > MainTwo.mainJ[a].getValeur()) 
                return 1;
            else return -1;
        }
    }
    
      int departagerDeuxPaire()
    {
        MainOne.RangerCarteOrdreCroissant();
        MainTwo.RangerCarteOrdreCroissant();   
        MainDeuxPaire MainO = new MainDeuxPaire(MainOne,"2Paire");
        MainDeuxPaire MainT = new MainDeuxPaire(MainTwo,"2Paire");
        
        int[] tab1 = MainO.RenvoitValeur2Pairre();
        int[] tab2 = MainT.RenvoitValeur2Pairre();  
        int a = 1;
        while (tab1[a] == tab2[a])
            {
                a = a - 1;
                if (a<0) break;
            }

        if (a<0)
        {   /*
            int val1 = MainO.RetourneValeurDerniereCarte(tab1);
            int val2 = MainT.RetourneValeurDerniereCarte(tab2);
            
            if (val1 > val2) return 1;
            else if (val1 < val2) return -1;
            else */return 0;
        }
        else if (tab1[a] > tab2[a]) return 1;
        else return -1;
              
    }
      
    int departagerPaire()
    {
        MainOne.RangerCarteOrdreCroissant();
        MainTwo.RangerCarteOrdreCroissant();
        MainPaire PaireOne = new MainPaire(MainOne,"Paire");
        MainPaire PaireTwo = new MainPaire(MainTwo,"Paire");
        int Paire1 = PaireOne.RenvoitValeurPairre();
        int Paire2 = PaireTwo.RenvoitValeurPairre();
        
        if (Paire1 > Paire2)  return 1;
        else if (Paire1 < Paire2) return -1; 
        else 
        {
            int[] tab1 = PaireOne.RetourneListeDes3CartesRestantTriee();
            int[] tab2 = PaireTwo.RetourneListeDes3CartesRestantTriee();
            int a = 1;
            int reponse = 0;
            while (tab1[a] == tab2[a])
            {
                a = a - 1;
                if (a<0) break;
            }
            if (a<0) return 0;
            else
            {
                if (tab1[a] > tab2[a]) 
                    return 1;
                else return -1;
            }
        }
    }
    
    
    int departagerBrelan()
    {
        MainOne.RangerCarteOrdreCroissant();
        MainTwo.RangerCarteOrdreCroissant(); 
        MainBrelan BrelanOne = new MainBrelan(MainOne,"Brelan");
        MainBrelan BrelanTwo = new MainBrelan(MainTwo,"Brelan");
        int val1 = BrelanOne.RenvoiValeurBrelan();
        int val2 = BrelanTwo.RenvoiValeurBrelan();
        
        if(val1 > val2) return 1;
        else if (val1 < val2) return -1;
        return 0;
    }
}
