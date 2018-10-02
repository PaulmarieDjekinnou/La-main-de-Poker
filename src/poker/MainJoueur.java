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


    //AfficherCarte(); permet d'afficher le type et la valeur d'une carte
    public void AfficherCarte()
    {
        int a = 0;
        for(a=0;a<5;a++)
        {
            System.out.println("Le type est : "+mainJ[a].getType()+" la valeur est "+mainJ[a].getValeur());       
        }
    }
    
   
    
    
}
