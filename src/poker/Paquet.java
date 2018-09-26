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
public class Paquet {
    //Jeu de 52 cartes
    Carte_P cartes[] = new Carte_P[52];

    public Paquet() {
        //On initialise les cartes en commencant par 2 pour chaque type
        int i=0;
        for(i=0; i<13;i++){
            //System.out.println("oki");
            Carte_P one = new Carte_P("Tr",(i+2),false);
            //this.cartes[i].setType("Tr");
            //this.cartes[i].setValeur(i+2);
            cartes[i] = one;
        }
        
        for(i=13; i<26;i++){
            //System.out.println("oki");
            Carte_P one = new Carte_P("Ca",(i+2-13),false);
            //this.cartes[i].setType("Tr");
            //this.cartes[i].setValeur(i+2);
            cartes[i] = one;
            
        }
        
        for(i=26; i<39;i++){
            //System.out.println("oki");
            Carte_P one = new Carte_P("Co",(i+2-26),false);
            //this.cartes[i].setType("Tr");
            //this.cartes[i].setValeur(i+2);
            cartes[i] = one;
            
        }
        for(i=39; i<52;i++){
           // System.out.println("oki");
            Carte_P one = new Carte_P("Pi",(i+2-39),false);
            //this.cartes[i].setType("Tr");
            //this.cartes[i].setValeur(i+2);
            cartes[i] = one;
        
        }
        
    }
    
    public void controleDeMain(String main){
        
        
    }
    
    public void affichepaquet()
    {
        int a = 0;
        for(a=0;a<52;a++)
        {
            System.out.println("Le type est : "+cartes[a].getType()+" la valeur est "+cartes[a].getValeur());       }
    }
    
    
    
    
}
