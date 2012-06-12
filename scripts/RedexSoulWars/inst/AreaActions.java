/*
 * Copyright (c) 2012. Redex Scripting - Unauthorized use prohibited by author.
 */

package RedexSoulWars.inst;

import RedexSoulWars.Store;
import RedexSoulWars.act.Action;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.Tile;

/**
 * Created by IntelliJ IDEA.
 * User: Tim
 * Date: 6/11/12
 * Time: 10:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class AreaActions {

    public static Action joinTeam() {
        Tile tempTile = Store.redTile;
        if (Store.method == 1) {
            return new Action() {
                @Override
                public void act() {
                    if (Calculations.distanceTo(Store.redTile) > 3) {
                        Walking.walk(Store.redTile);
                    } else {
                        SceneEntities.getNearest(Store.barriersID).click(true);
                        Time.sleep(500);
                    }
                }
            };
        }
        if (Store.method == 2) {
            return new Action() {
                @Override
                public void act() {
                    if (Calculations.distanceTo(Store.blueTile) > 3) {
                        Walking.walk(Store.blueTile);
                    } else {
                        SceneEntities.getNearest(Store.barriersID).click(true);
                        Time.sleep(500);
                    }
                }
            };
        }
        if (Store.method == 3) {
            return new Action() {
                Tile t = (Store.lastWon.equals("blue")) ? Store.redTile : Store.blueTile;

                @Override
                public void act() {
                    if (Calculations.distanceTo(t) > 3) {
                        Walking.walk(t);
                    } else {
                        SceneEntities.getNearest(Store.barriersID).click(true);
                        Time.sleep(500);
                    }
                }
            };
        }
        if (Store.method == 4) {
            return new Action() {
                Tile t = (Store.lastWon.equals("red")) ? Store.redTile : Store.blueTile;

                @Override
                public void act() {
                    if (Calculations.distanceTo(t) > 3) {
                        Walking.walk(t);
                    } else {
                        SceneEntities.getNearest(Store.barriersID).click(true);
                        Time.sleep(500);
                    }
                }
            };
        }
        //default
        return new Action() {
            @Override
            public void act() {
                if (Calculations.distanceTo(Store.redTile) > 3) {
                    Walking.walk(Store.redTile);
                } else {
                    SceneEntities.getNearest(Store.barriersID).click(true);
                    Time.sleep(500);
                }
            }
        };
    }
}



