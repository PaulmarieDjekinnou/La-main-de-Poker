/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

/**
 *
 * @author thevie
 */
public class Carte {
    private String type;
    private int valeur;
    
    
    

    public Carte(String type, int valeur) {
        this.type = type;
        this.valeur = valeur;
    }

    public String getType() {
        return type;
    }

    public int getValeur() {
        return valeur;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
    
    
    
    
    
}


