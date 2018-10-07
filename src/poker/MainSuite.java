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
public class MainSuite extends MainJeu{
    
    int ValeurSuite;
    
    public MainSuite(MainJoueur main,String Nom)
    {
        super(main,Nom);
    }
    
    int RenvoitValeurSuite()
    {
        this.main.RangerCarteOrdreCroissant();
        this.ValeurSuite = this.main.mainJ[4].getValeur();
        return ValeurSuite;
    }
}
