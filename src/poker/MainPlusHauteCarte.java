/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

/**
 *
 * @author PS5_The_Beginners
 */
public class MainPlusHauteCarte extends MainJeu {
     
    
    public MainPlusHauteCarte(MainJoueur main,String Nom)
    {
        super(main,Nom);
    }
    
    int determinerLaCartePlusHaute(int a)
    {
        main.rangerCarteOrdreCroissant();
        return main.mainJ[a].getValeur();
    }
}
