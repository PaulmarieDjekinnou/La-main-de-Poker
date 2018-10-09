/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

/**
 *
 * @author PS5_The_Beginners
 */
public class Carte_P extends Carte {
    private boolean selected;

    public Carte_P(String type, int valeur, boolean selected) {
        super(type, valeur);
        this.selected = false;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
