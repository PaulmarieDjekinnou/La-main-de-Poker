/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PS5
 */
public class MainJoueur {
    
    Carte mainJ[] = new Carte[5];
    String combinaison;
    
    public MainJoueur(Carte... main) {
        
        for(int i=0; i<main.length;i++){          
            mainJ[i] = main[i];
        }
        
    }

    public MainJoueur(){   
    }
    
    void rangerCarteOrdreCroissant()       
    {
        /* Tri croissant des cartes */
        
        int i=0,j=0,temp=0;
        for(i=0;i<5;i++)
        {
            for(j=i+1;j<5;j++)
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
    
   
    public String determinerLaMain()
    {       
        this.rangerCarteOrdreCroissant();
        String Reponse = "";
        CombinaisonJoueur combinaison = new CombinaisonJoueur(this);
        combinaison.rechercherLesCombinaisons();
        Reponse = combinaison.retournemeilleurCombinaison();       
        this.combinaison = Reponse;
        return Reponse;
    }
    
    public String getCombinaison()
    {
        return combinaison;
    }
     
     
    public String compareMain(MainJoueur Main)
    {
        Arbitre arbitre = new Arbitre(this,Main);
        arbitre.ComparerLesDeuxMains();
        String reponse = arbitre.getreponseArbitre();
        return reponse;
    }
    
   
    //AfficherCarte(); permet d'afficher le type et la valeur d'une carte
    public void afficherCarte()
    {
        int a = 0;
        for(a=0;a<5;a++)
        {
            System.out.println("Le type est : "+mainJ[a].getType()+" la valeur est "+mainJ[a].getValeur());       
        }
    }
    
   
    void lireMain(Paquet paquet,int b)
    {
        Scanner scanner = new Scanner(System.in);   
        String main;
        main = scanner.nextLine();
          
        int a = 0;
        String tab[] = main.split(" ");
        if (tab.length ==  b)
        {
                for (a=0;a<tab.length;a++)
                {
                   this.mainJ[a] = paquet.controleDeSaisieDe1Carte(tab[a]);
                   if (this.mainJ[a].getType().equals("") && this.mainJ[a].getValeur() == 0)
                   {
                       System.out.println("Saisie Non Valide !");
                       System.exit(0);
                   }
                }        
                for (a=0;a<tab.length;a++)
                {
                        if (paquet.carteIsSelected(this.mainJ[a])) 
                        {
                            System.out.println("Saisie Non Valide !");
                            System.exit(0);
                        }
                        else paquet.carteSelection(this.mainJ[a]);
                }
           }else
        {
            System.out.println("Saisie Non Valide !");
            System.exit(0);
        }
    }
    
}
