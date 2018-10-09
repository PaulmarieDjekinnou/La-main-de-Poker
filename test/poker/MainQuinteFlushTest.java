package poker;
/**
 *
 * @author PS5_The_Beginners
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class MainQuinteFlushTest {

    @Test
    public void renvoitValeurQuinte() {
        MainJoueur mainJoueur = new MainJoueur(new Carte("Tr",3),new Carte("Tr",5),new Carte("Tr",4),new Carte("Tr",2),new Carte("Tr",6));
        mainJoueur.rangerCarteOrdreCroissant();
        MainQuinteFlush mainQuinteFlush = new MainQuinteFlush(mainJoueur, "Quinte flush");
        int result = mainQuinteFlush.renvoitValeurQuinte();
        assertEquals(6,result);
    }
}