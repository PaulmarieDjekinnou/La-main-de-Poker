package poker;
/**
 *
 * @author PS5_The_Beginners
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class MainDeuxPaireTest {

    @Test
    public void renvoitValeur2Pairre() {
        MainJoueur mainJoueur = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",2),new Carte("Co",2),new Carte("Pi",3));
        mainJoueur.rangerCarteOrdreCroissant();
        MainDeuxPaire mainDeuxPaire = new MainDeuxPaire(mainJoueur, "2Paire");
        int[] result = mainDeuxPaire.renvoitValeur2Pairre();
        assertEquals(2,result[0]);
        assertEquals(5,result[1]);
    }

    @Test
    public void retourneValeurDerniereCarte() {
        MainJoueur mainJoueur = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",2),new Carte("Co",2),new Carte("Pi",3));
        mainJoueur.rangerCarteOrdreCroissant();
        MainDeuxPaire mainDeuxPaire = new MainDeuxPaire(mainJoueur, "2Paire");
        int result = mainDeuxPaire.retourneValeurDerniereCarte(mainDeuxPaire.renvoitValeur2Pairre());
        assertEquals(3,result);
    }
}