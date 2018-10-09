/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

/**
 *
 * @author KOFFI Merveille
 */
public class MainQuinteFlush extends MainJeu{
 
    int valeurCarteHaute;
    
    public MainQuinteFlush(MainJoueur main,String nom)
    {
        super(main,nom);
    }
    
    int renvoitValeurQuinte()
    {
        this.main.rangerCarteOrdreCroissant();
        this.valeurCarteHaute = this.main.mainJ[4].getValeur();
        return valeurCarteHaute;
    }
}
