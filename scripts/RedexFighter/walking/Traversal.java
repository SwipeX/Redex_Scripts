/*
 * Copyright (c) 2012. Redex Scripting - Unauthorized use prohibited by author.
 */

package RedexFighter.walking;

import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.Locatable;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.map.LocalPath;
import org.powerbot.game.api.wrappers.map.TilePath;
import org.powerbot.game.api.wrappers.node.SceneObject;

/**
 * Created by IntelliJ IDEA.
 * User: Tim
 * Date: 6/18/12
 * Time: 10:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Traversal {

    public void traverseTo(Locatable loc) {
        LocalPath lp = Walking.findPath(loc);
        TilePath tp = lp.getTilePath();
        for (Tile t : tp.toArray()) {
            if (Calculations.distanceTo(t) > 4 && Calculations.distanceTo(t) < 16) {
                if (t.canReach()) {
                    t.clickOnMap();
                    Time.sleep(500, 1000);
                } else {
                    System.out.println("Cannot reach next tile, performing radial object debug!");
                    SceneObject[] lol = SceneEntities.getLoaded();
                    for (SceneObject lul : lol) {
                        System.out.println("Found an object at: " + lul.getLocation().toString() + " with ID of: " + lul.toString());
                    }
                }
            }
        }
    }
}
