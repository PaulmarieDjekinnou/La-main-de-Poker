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
    ArrayList<String> Liste;
    String MeilleurCombinaison;
    
    public CombinaisonJoueur(MainJoueur main){
       this.main = main;
       this.Liste = new ArrayList<>();
    }
    
    public void RechercherLesCombinaisons()
    {
        CombinaisonJeu combinaisonJ = new CombinaisonJeu(this.main);
        boolean TruePaire = combinaisonJ.CombinaisonIsPairre();
        boolean TrueBrelan = combinaisonJ.CombinaisonIsBrelan();
        boolean True2Paire = false;
        boolean TrueSuite = false;
        boolean TrueCouleur = false;
        boolean TrueFull = false;
        boolean TrueQuinte = false;
        boolean TrueCarre = false;
        
        if(TruePaire) Liste.add("Paire");
        if(TrueBrelan) Liste.add("Brelan");
        if(True2Paire) Liste.add("2Paire");
        if(TrueSuite) Liste.add("Suite");
        if(TrueCouleur) Liste.add("Couleur");
        if(TrueFull) Liste.add("Full");
        if(TrueQuinte) Liste.add("Quinte flush");
        if(TrueCarre) Liste.add("Carre");
    }
    
    public int RechercheMeilleureCombinaison()
    {
        int a = 0;
        int Max = 0;
        int NumCombi;
               
        if(Liste != null)
        {
            for(a=0;a<Liste.size();a++)
            {
                NumCombi = convertirMain(Liste.get(a));
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
    
    public String RetourneMeilleurCombinaison()
    {
        int NumCombi = this.RechercheMeilleureCombinaison();
        switch(NumCombi){
                        case 0 : this.MeilleurCombinaison = "Plus haute carte"; break;
                        case 1 : this.MeilleurCombinaison = "Paire" ; break;
                        case 2 : this.MeilleurCombinaison = "2Paire" ; break;                       
                        case 3 : this.MeilleurCombinaison = "Brelan" ; break; 
                        case 4 : this.MeilleurCombinaison = "Suite" ; break;
                        case 5 : this.MeilleurCombinaison = "Couleur" ; break;                                                                  
                        case 6 : this.MeilleurCombinaison = "Full" ; break;
                        case 7 : this.MeilleurCombinaison = "Carre" ; break;                
                        case 8 : this.MeilleurCombinaison = "Quinte flush" ;  break;                
       }
        return this.MeilleurCombinaison;
    }
                                                  
}
