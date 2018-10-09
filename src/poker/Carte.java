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
public class Carte {
    private String type;
    private int valeur;

    //Constructeur par défaut
    public Carte() {
        this.type = "";
        this.valeur = 0;
    }

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
    
    //Implémentation 2 joueurs, une carte chacun
    public int compareTwoCard(Carte b) {
        /*Retourne 1 si la pemiere carte est plus grande
          Retourne -1  si la deuxieme carte est plus grande
          Retourne 0 si les deux cartes ont meme valeur*/
        
        if(this.valeur>b.valeur){
         return 1; 
        }else{
            if(b.valeur>this.valeur){
                return -1;
            }else{
                return 0;
            }
        }
    }
    


    public String toString() {
        if (valeur == 11) return "V"+type;
        if (valeur == 12) return "D"+type;
        if (valeur == 13) return "R"+type;
        if (valeur == 14) return "A"+type;
        return valeur + type;
    }
}


