package poker;
/**
 *
 * @author PS5_The_Beginners
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class MainCarreTest {

    @Test
    public void retourneValeurCarre() {
        MainJoueur mainJoueur = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",5),new Carte("Co",5),new Carte("Pi",2));
        mainJoueur.rangerCarteOrdreCroissant();
        MainCarre mainCarre = new MainCarre(mainJoueur, "Carre");
        int result = mainCarre.retourneValeurCarre();
        assertEquals(5,result);
    }
}