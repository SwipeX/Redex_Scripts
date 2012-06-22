/*
 * Copyright (c) 2012. Redex Scripting - Unauthorized use prohibited by author.
 */

package RedexFighter.ground;

import RedexFighter.Store;
import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.interactive.Players;

/**
 * Created by IntelliJ IDEA.
 * User: Tim
 * Date: 6/20/12
 * Time: 10:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class Pickup extends Strategy implements Task {
    public boolean validate() {
        return GroundUtil.hasItem() && !Players.getLocal().isInCombat();
    }

    @Override
    public void run() {
        GroundUtil.takeItems();
    }
}
