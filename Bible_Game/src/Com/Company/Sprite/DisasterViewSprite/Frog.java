package Com.Company.Sprite.DisasterViewSprite;

import Com.Company.Sprite.Sprite;

import javax.swing.*;

public class Frog extends Sprite {
    public Frog(int x, int y){
        setPosition(x, y);
        img = new ImageIcon("frog.png");
    }
    @Override
    public String overlap(int x, int y) {
        return null;
    }
}
