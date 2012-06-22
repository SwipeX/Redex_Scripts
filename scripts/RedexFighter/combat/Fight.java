/*
 * Copyright (c) 2012. Redex Scripting - Unauthorized use prohibited by author.
 */

package RedexFighter.combat;

import RedexFighter.Store;
import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.interactive.Players;

/**
 * Created by IntelliJ IDEA.
 * User: Tim
 * Date: 6/19/12
 * Time: 6:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class Fight extends Strategy implements Task {
    @Override
    public boolean validate() {
        return !Players.getLocal().isInCombat() && !Players.getLocal().isMoving(); //&& Store.combatArea.contains(Players.getLocal());
    }

    @Override
    public void run() {
        System.out.println("Fighter Running");
        CombatUtil.attackNearest(Store.npcNames.toArray(new String[Store.npcNames.size()]));
    }
}
