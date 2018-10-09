package poker;
/**
 *
 * @author PS5_The_Beginners
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class MainBrelanTest {

    @Test
    public void renvoiValeurBrelan() {
        MainJoueur mainJoueur = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",5),new Carte("Co",2),new Carte("Pi",2));
        mainJoueur.rangerCarteOrdreCroissant();
        MainBrelan mainBrelan = new MainBrelan(mainJoueur, "Brelan");
        int result = mainBrelan.renvoiValeurBrelan();
        assertEquals(5,result);
    }
}