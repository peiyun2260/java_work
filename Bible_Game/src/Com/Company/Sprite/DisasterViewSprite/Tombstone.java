package Com.Company.Sprite.DisasterViewSprite;

import Com.Company.Sprite.Sprite;

import javax.swing.*;

public class Tombstone extends Sprite {
    public Tombstone(int x, int y){
        setPosition(x, y);
        img = new ImageIcon("tombstone.png");
    }
    @Override
    public String overlap(int x, int y) {
        return null;
    }
}
