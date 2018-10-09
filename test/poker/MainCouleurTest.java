package poker;
/**
 *
 * @author PS5_The_Beginners
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class MainCouleurTest {

    @Test
    public void determinerLaCartePlusHaute() {
        MainJoueur mainJoueur = new MainJoueur(new Carte("Tr",5),new Carte("Tr",2),new Carte("Tr",8),new Carte("Tr",10),new Carte("Tr",4));
        mainJoueur.rangerCarteOrdreCroissant();
        MainCouleur mainCouleur = new MainCouleur(mainJoueur, "Couleur");
        int result = mainCouleur.determinerLaCartePlusHaute(4);
        assertEquals(10,result);
    }
}