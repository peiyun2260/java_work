package Com.Company.Sprite;

import Com.Company.GameView.DisasterView;
import Com.Company.GameView.RedSeaGameView;
import Com.Company.GameView.TenCommandmentView;
import Com.Company.Main;
import Com.Company.Sprite.DisasterViewSprite.Bug;
import Com.Company.Sprite.DisasterViewSprite.Frog;
import Com.Company.Sprite.DisasterViewSprite.Ice;
import Com.Company.Sprite.DisasterViewSprite.Tombstone;
import Com.Company.Sprite.RedSeaViewSprite.Anubis;
import Com.Company.Sprite.RedSeaViewSprite.Cat;
import Com.Company.Sprite.RedSeaViewSprite.Pharoah;
import Com.Company.Sprite.TenCommandmentSprite.TenCommandment;

import javax.swing.*;
import java.util.ArrayList;

public class Moses extends Sprite{
    public Moses(int x, int y){
        setPosition(x, y);
        img = new ImageIcon("Moses.png");
    }

    @Override
    public String overlap(int x, int y) {
        if (Main.gameView instanceof DisasterView){
            //check for bugs and frogs
            ArrayList<Frog> frogs = ((DisasterView) Main.gameView).getFrogs();
            ArrayList<Bug> bugs = ((DisasterView) Main.gameView).getBugs();
            for (Frog f : frogs){
                if (f.getRelativePosition() != null && x == f.getRelativePosition().x && y ==f.getRelativePosition().y){
                    return "Die";
                }
            }
            for (Bug b : bugs){
                if (b.getRelativePosition() != null && x == b.getRelativePosition().x && y == b.getRelativePosition().y){
                    return "Die";
                }
            }
            //check for ice and tombstone
            ArrayList<Ice> ices = ((DisasterView) Main.gameView).getIceCubes();
            ArrayList<Tombstone> tombstones = ((DisasterView) Main.gameView).getStones();
            for (Ice i : ices){
                if (i.getRelativePosition() != null && x == i.getRelativePosition().x && y == i.getRelativePosition().y){
                    return "Cannot move";
                }
            }
            for (Tombstone t : tombstones){
                if (t.getRelativePosition() != null && x == t.getRelativePosition().x && y == t.getRelativePosition().y){
                    return "Cannot move";
                }
            }
            // check for door
            Door door = Main.gameView.getDoor();
            if (x == door.getRelativePosition().x && y == door.getRelativePosition().y){
                return "Next level";
            }
        } else if (Main.gameView instanceof RedSeaGameView){
            // check for cat
            ArrayList<Cat> cats = ((RedSeaGameView) Main.gameView).getCats();
            for (Cat t : cats){
                if (t.getRelativePosition() != null && x == t.getRelativePosition().x && y == t.getRelativePosition().y){
                    return "Cannot move";
                }
            }
            // Check pharaoh and anubis
            ArrayList<Anubis> anubis = ((RedSeaGameView) Main.gameView).getAnubis();
            ArrayList<Pharoah> pharoahs = ((RedSeaGameView) Main.gameView).getPharoahs();
            for (Anubis b : anubis){
                if (b.getRelativePosition() != null && x == b.getRelativePosition().x && y == b.getRelativePosition().y){
                    return "Die";
                }
            }
            for (Pharoah f : pharoahs){
                if (f.getRelativePosition() != null && x == f.getRelativePosition().x && y ==f.getRelativePosition().y){
                    return "Die";
                }
            }
            // check for door
            Door door = Main.gameView.getDoor();
            if (x == door.getRelativePosition().x && y == door.getRelativePosition().y){
                return "Next level";
            }
        } else if (Main.gameView instanceof TenCommandmentView){
            ArrayList<TenCommandment> stones = ((TenCommandmentView) Main.gameView).getStones();
            for (TenCommandment stone : stones){
                if (stone.getRelativePosition() != null && stone.getRelativePosition().x == x && stone.getRelativePosition().y == y){
                    stone.setNullPosition();
                    ((TenCommandmentView) Main.gameView).setCount(1);
                    if (((TenCommandmentView) Main.gameView).getCount() == 10){
                        return "Game over";
                    } else {
                        return "none";
                    }
                }
            }
        }
        return "none";
    }
}
