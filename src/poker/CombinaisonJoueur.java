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

public class CombinaisonJoueur {
    
    MainJoueur main;
    ArrayList<String> liste;
    String meilleurCombinaison;
    
    public CombinaisonJoueur(MainJoueur main){
       this.main = main;
       this.liste = new ArrayList<>();
    }
    
    public void rechercherLesCombinaisons()
    {
        CombinaisonJeu combinaisonJ = new CombinaisonJeu(this.main);
        boolean TruePaire = combinaisonJ.combinaisonIsPairre();
        boolean TrueBrelan = combinaisonJ.combinaisonIsBrelan();
        boolean True2Paire = combinaisonJ.combinaisonIs2Paire();
        boolean TrueSuite = combinaisonJ.combinaisonIsSuite();
        boolean TrueCouleur = combinaisonJ.combinaisonIsCouleur();
        boolean TrueFull = combinaisonJ.combinaisonIsFull();
        boolean TrueCarre = combinaisonJ.combinaisonIsCarre();
        boolean TrueQuinte = combinaisonJ.combinaisonIsQuinte();
      
        if(TruePaire) liste.add("Paire");
        if(TrueBrelan) liste.add("Brelan");
        if(True2Paire) liste.add("2Paire");
        if(TrueSuite) liste.add("Suite");
        if(TrueCouleur) liste.add("Couleur");
        if(TrueFull) liste.add("Full");
        if(TrueQuinte) liste.add("Quinte flush");
        if(TrueCarre) liste.add("Carre");
    }
    
    public int rechercheMeilleureCombinaison()
    {
        int a = 0;
        int Max = 0;
        int NumCombi;
               
        if(liste != null)
        {
            for(a=0;a<liste.size();a++)
            {
                NumCombi = convertirMain(liste.get(a));
                if (NumCombi > Max) Max = NumCombi;
            }
        }     
        return Max;
    }
    
    static int convertirMain(String a)
    {
        switch(a){
                        case "Plus haute carte" : a = "0";break;
                        case "Paire" : a = "1"; break;
                        case "2Paire" : a = "2"; break;                       
                        case "Brelan" : a = "3"; break; 
                        case "Suite" : a = "4"; break;
                        case "Couleur" : a = "5"; break;                                                                  
                        case "Full" : a = "6"; break;
                        case "Carre" : a = "7"; break;                
                        case "Quinte flush" : a = "8";  break;                
       }
                    
        int retour = Integer.valueOf(a).intValue();
        return retour;
    }
    
    public String retournemeilleurCombinaison()
    {
        int NumCombi = this.rechercheMeilleureCombinaison();
        switch(NumCombi){
                        case 0 : this.meilleurCombinaison = "Plus haute carte"; break;
                        case 1 : this.meilleurCombinaison = "Paire" ; break;
                        case 2 : this.meilleurCombinaison = "2Paire" ; break;                       
                        case 3 : this.meilleurCombinaison = "Brelan" ; break; 
                        case 4 : this.meilleurCombinaison = "Suite" ; break;
                        case 5 : this.meilleurCombinaison = "Couleur" ; break;                                                                  
                        case 6 : this.meilleurCombinaison = "Full" ; break;
                        case 7 : this.meilleurCombinaison = "Carre" ; break;                
                        case 8 : this.meilleurCombinaison = "Quinte flush" ;  break;                
       }
        return this.meilleurCombinaison;
    }
                                                  
}
