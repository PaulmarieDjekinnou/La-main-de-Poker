/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

/**
 *
 * @author PS5
 */
public class Paquet {
    //Jeu de 52 cartes
    Carte_P cartes[] = new Carte_P[52];

    public Paquet() {
        //On initialise les cartes en commencant par 2 pour chaque type
        int i=0;
        //Trèfle
        for(i=0; i<13;i++){
            Carte_P one = new Carte_P("Tr",(i+2),false);
            cartes[i] = one;
        }
        //Carreau
        for(i=13; i<26;i++){
            Carte_P one = new Carte_P("Ca",(i+2-13),false);
            cartes[i] = one;
        }
        //Coeur
        for(i=26; i<39;i++){
            Carte_P one = new Carte_P("Co",(i+2-26),false);
            cartes[i] = one;
        }
        //Pique
        for(i=39; i<52;i++){
            Carte_P one = new Carte_P("Pi",(i+2-39),false);
            cartes[i] = one;
        }
        
    }

    public void carteSelection(Carte carte){
        for (int i=0; i<=51; i++){
            if(carte.getType().equals(cartes[i].getType()) && carte.getValeur() == cartes[i].getValeur()){
                cartes[i].setSelected(true);
                break;
            }
        }
    }

    public boolean carteIsSelected(Carte carte){
        for (int i=0; i<=51; i++){
            if(carte.getType().equals(cartes[i].getType()) && carte.getValeur() == cartes[i].getValeur() && cartes[i].isSelected()){
                return true;
            }
        }
        return false;
    }

    public int nbOccurences(String chaine, String Text) {
        int nbOccurences = 0;
        int position = 0;
        while ((Text.contains(chaine)) && (!chaine.equals(""))) {
            position = Text.indexOf(chaine);
            Text = Text.substring(position + chaine.length(), Text.length());
            nbOccurences++;
        }
        //System.out.println("Le nombre d'occurences de la chaine=" + chaine + " est égale à " + nbOccurences);
        return nbOccurences;
    }

    public static boolean isANumber(String chaine){
        try{
            Integer.parseInt(chaine);
            return true;
        }catch(NumberFormatException nfe){
            return false;
        }
    }

    public Carte controleDeSaisieDe1Carte(String main){
        int posTr, posCa, posCo, posPi;
        int nbTr, nbCa, nbCo, nbPi;

        //On crée la carte à retourner comme main valide
        Carte mainV = new Carte();
        //On traite la chaine en entrée
        String chaine = new String("");
        chaine = main.trim();
        chaine = chaine.replaceAll("\\s", "");
        //Position des cartes pour se repérer
        //System.out.println(chaine);
        posTr = chaine.indexOf("Tr");
        posCa = chaine.indexOf("Ca");
        posCo = chaine.indexOf("Co");
        posPi = chaine.indexOf("Pi");
        //Nombre d'occurences des types de carte
        nbTr = nbOccurences("Tr", chaine);
        nbCa = nbOccurences("Ca", chaine);
        nbCo = nbOccurences("Co", chaine);
        nbPi = nbOccurences("Pi", chaine);

        if(chaine.length() > 4) return new Carte();
        else {
            //System.out.println(chaine);
            if (nbOccurences("10", chaine) == 0 && chaine.length() == 4) return new Carte();
            else {
                if (chaine.length() == 3){
                    //On vérifie en premier lieu le type
                    String sousChaine = new String("");
                    sousChaine = chaine.substring(chaine.length() - 2);
                    //System.out.println(sousChaine);
                    if (sousChaine.equals("Tr") || sousChaine.equals("Ca") || sousChaine.equals("Co") || sousChaine.equals("Pi"))
                    {
                        //mainV.setType("Tr");
                        if (sousChaine.equals("Tr")) mainV.setType("Tr");
                        if (sousChaine.equals("Ca")) mainV.setType("Ca");
                        if (sousChaine.equals("Co")) mainV.setType("Co");
                        if (sousChaine.equals("Pi")) mainV.setType("Pi");
                        //On vérifie la valeur
                        if (nbOccurences("10", chaine) == 1){
                            mainV.setValeur(10);
                            return mainV;
                        }else {
                            sousChaine = chaine.substring(0,1);
                            if (sousChaine.equals("V")) mainV.setValeur(11);
                            else if (sousChaine.equals("D")) mainV.setValeur(12);
                            else if (sousChaine.equals("R")) mainV.setValeur(13);
                            else if (sousChaine.equals("A")) mainV.setValeur(14);
                            else if (isANumber(sousChaine) == true){
                                //System.out.println(isANumber(sousChaine));
                                int testTrueInt = 0;
                                testTrueInt = Integer.parseInt(sousChaine);
                                if (testTrueInt < 2) return new Carte();
                                else {
                                    mainV.setValeur(testTrueInt);
                                    return mainV;
                                }
                            }
                            else return new Carte();
                        }
                    }
                }else return new Carte();
            }

        } return mainV;
    }
    
    public void affichepaquet()
    {
        int a = 0;
        for(a=0;a<52;a++)
        {
            System.out.println("Le type est : "+cartes[a].getType()+" la valeur est "+cartes[a].getValeur());
        }
    }
    
}
