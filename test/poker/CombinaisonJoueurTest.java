package poker;
/**
 *
 * @author PS5_The_Beginners
 */
import org.junit.Test;

import static org.junit.Assert.*;
import static poker.CombinaisonJoueur.convertirMain;

public class CombinaisonJoueurTest {

    @Test
    public void rechercherLesCombinaisons() {
        //Paire
        CombinaisonJoueur combinaisonJoueur = new CombinaisonJoueur(new MainJoueur(new Carte("Tr",5),new Carte("Pi",3),new Carte("Ca",5),new Carte("Co",2),new Carte("Pi",4)));
        combinaisonJoueur.rechercherLesCombinaisons();
        assertEquals("Paire",combinaisonJoueur.liste.get(0));

        //Brelan
        combinaisonJoueur = new CombinaisonJoueur(new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",5),new Carte("Co",2),new Carte("Pi",3)));
        combinaisonJoueur.rechercherLesCombinaisons();
        assertEquals("Brelan",combinaisonJoueur.liste.get(0));

        //2Paire
        combinaisonJoueur = new CombinaisonJoueur(new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",2),new Carte("Co",2),new Carte("Pi",3)));
        combinaisonJoueur.rechercherLesCombinaisons();
        assertEquals("2Paire",combinaisonJoueur.liste.get(1));//Paire dab

        //Suite
        combinaisonJoueur = new CombinaisonJoueur(new MainJoueur(new Carte("Tr",2),new Carte("Pi",3),new Carte("Ca",4),new Carte("Co",5),new Carte("Pi",6)));
        combinaisonJoueur.rechercherLesCombinaisons();
        assertEquals("Suite",combinaisonJoueur.liste.get(0));

        //Couleur
        combinaisonJoueur = new CombinaisonJoueur(new MainJoueur(new Carte("Tr",2),new Carte("Tr",3),new Carte("Tr",4),new Carte("Tr",5),new Carte("Tr",8)));
        combinaisonJoueur.rechercherLesCombinaisons();
        assertEquals("Couleur",combinaisonJoueur.liste.get(0));

        //Full
        combinaisonJoueur = new CombinaisonJoueur(new MainJoueur(new Carte("Tr",2),new Carte("Co",2),new Carte("Pi",2),new Carte("Ca",3),new Carte("Tr",3)));
        combinaisonJoueur.rechercherLesCombinaisons();
        assertEquals("Full",combinaisonJoueur.liste.get(2));//Paire et brelan dab

        //Quinte Flush
        combinaisonJoueur = new CombinaisonJoueur(new MainJoueur(new Carte("Tr",2),new Carte("Tr",3),new Carte("Tr",4),new Carte("Tr",5),new Carte("Tr",6)));
        combinaisonJoueur.rechercherLesCombinaisons();
        assertEquals("Quinte flush",combinaisonJoueur.liste.get(2));//Suite et couleur dab

        //Carre
        combinaisonJoueur = new CombinaisonJoueur(new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",5),new Carte("Co",5),new Carte("Pi",3)));
        combinaisonJoueur.rechercherLesCombinaisons();
        assertEquals("Carre",combinaisonJoueur.liste.get(0));

    }

    @Test
    public void rechercheMeilleureCombinaison() {
        CombinaisonJoueur combinaisonJoueur = new CombinaisonJoueur(new MainJoueur(new Carte("Tr",5),new Carte("Pi",3),new Carte("Ca",5),new Carte("Co",2),new Carte("Pi",4)));
        combinaisonJoueur.rechercherLesCombinaisons();
        int result = combinaisonJoueur.rechercheMeilleureCombinaison();
        assertEquals(1,result);
    }

    @Test
    public void convertirMainTest() {
        CombinaisonJoueur combinaisonJoueur = new CombinaisonJoueur(new MainJoueur(new Carte("Tr",5),new Carte("Pi",3),new Carte("Ca",5),new Carte("Co",2),new Carte("Pi",4)));
        combinaisonJoueur.rechercherLesCombinaisons();
        int result = convertirMain(combinaisonJoueur.liste.get(0));
        assertEquals(1,result);
    }

    @Test
    public void retourneMeilleurCombinaison() {
        CombinaisonJoueur combinaisonJoueur = new CombinaisonJoueur(new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",5),new Carte("Co",2),new Carte("Pi",4)));
        combinaisonJoueur.rechercherLesCombinaisons();
        String result = combinaisonJoueur.retournemeilleurCombinaison();
        assertEquals("Brelan",result);
    }
}