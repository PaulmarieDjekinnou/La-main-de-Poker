package poker;
/**
 *
 * @author PS5_The_Beginners
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class CombinaisonJeuTest {

    @Test
    public void combinaisonIsPairre() {
        CombinaisonJeu combinaisonJeu = new CombinaisonJeu(new MainJoueur(new Carte("Tr",5),new Carte("Pi",3),new Carte("Ca",5),new Carte("Co",4),new Carte("Pi",2)));
        assertTrue("C'est normalement une paire",combinaisonJeu.combinaisonIsPairre());
    }

    @Test
    public void combinaisonIsBrelan() {
        CombinaisonJeu combinaisonJeu = new CombinaisonJeu(new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",5),new Carte("Co",2),new Carte("Pi",3)));
        assertTrue("C'est normalement un brelan",combinaisonJeu.combinaisonIsBrelan());
    }

    @Test
    public void combinaisonIs2Paire() {
        CombinaisonJeu combinaisonJeu = new CombinaisonJeu(new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",2),new Carte("Co",2),new Carte("Pi",3)));
        assertTrue("C'est normalement une double paire",combinaisonJeu.combinaisonIs2Paire());
    }

    @Test
    public void combinaisonIsSuite() {
        CombinaisonJeu combinaisonJeu = new CombinaisonJeu(new MainJoueur(new Carte("Tr",2),new Carte("Pi",3),new Carte("Ca",4),new Carte("Co",5),new Carte("Pi",6)));
        assertTrue("C'est normalement une suite",combinaisonJeu.combinaisonIsSuite());
    }

    @Test
    public void combinaisonIsCouleur() {
        CombinaisonJeu combinaisonJeu = new CombinaisonJeu(new MainJoueur(new Carte("Tr",5),new Carte("Tr",8),new Carte("Tr",10),new Carte("Tr",2),new Carte("Tr",3)));
        assertTrue("C'est normalement une Couleur",combinaisonJeu.combinaisonIsCouleur());
    }

    @Test
    public void combinaisonIsFull() {
        CombinaisonJeu combinaisonJeu = new CombinaisonJeu(new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",5),new Carte("Co",2),new Carte("Pi",2)));
        assertTrue("C'est normalement un Full",combinaisonJeu.combinaisonIsFull());
    }

    @Test
    public void combinaisonIsCarre() {
        CombinaisonJeu combinaisonJeu = new CombinaisonJeu(new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",5),new Carte("Co",5),new Carte("Pi",3)));
        assertTrue("C'est normalement un Carré",combinaisonJeu.combinaisonIsCarre());
    }

    @Test
    public void combinaisonIsQuinte() {
        CombinaisonJeu combinaisonJeu = new CombinaisonJeu(new MainJoueur(new Carte("Tr",2),new Carte("Tr",3),new Carte("Tr",4),new Carte("Tr",5),new Carte("Tr",6)));
        assertTrue("C'est normalement une Quinte Flush",combinaisonJeu.combinaisonIsQuinte());
    }
}