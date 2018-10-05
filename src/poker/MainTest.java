package poker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    private MainJoueur Main1 ;
    private MainJoueur Main2 ;

    @BeforeAll public void setUp(){
        Main1 = new MainJoueur(new Carte("Tr",6));
        Main2 = new MainJoueur(new Carte("",0));
    }
     @Test public void LireMain(){
         Paquet paquet = new Paquet();
         MainJoueur Lu1 = Main1.LireMain(paquet,2);
         MainJoueur Lu2 = Main2.LireMain(paquet,2);
         assertFalse();

    }
    @Test public void determinerLaMain(){

    }

}