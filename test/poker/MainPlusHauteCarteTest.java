package poker;
/**
 *
 * @author PS5_The_Beginners
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class MainPlusHauteCarteTest {

    @Test
    public void determinerLaCartePlusHaute() {
        MainJoueur mainJoueur = new MainJoueur(new Carte("Tr",3),new Carte("Pi",5),new Carte("Ca",4),new Carte("Co",2),new Carte("Pi",10));
        mainJoueur.rangerCarteOrdreCroissant();
        MainPlusHauteCarte mainPlusHauteCarte = new MainPlusHauteCarte(mainJoueur, "Plus haute carte");
        int result = mainPlusHauteCarte.determinerLaCartePlusHaute(4);
        assertEquals(10,result);
    }
}