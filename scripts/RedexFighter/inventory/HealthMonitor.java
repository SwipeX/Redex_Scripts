/*
 * Copyright (c) 2012. Redex Scripting - Unauthorized use prohibited by author.
 */

package RedexFighter.inventory;


import RedexFighter.Store;
import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.Item;

/**
 * Created by IntelliJ IDEA.
 * User: Tim
 * Date: 6/18/12
 * Time: 11:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class HealthMonitor extends Strategy implements Task {
    @Override
    public boolean validate() {
        return Players.getLocal().getHpPercent() < Store.HP_PERCENT;
    }

    /**
     * Eats any item with an eat description
     */
    @Override
    public void run() {
        for (Item i : Inventory.getItems()) {
            for (String s : i.getWidgetChild().getActions()) {
                if (s.contains("eat")) {
                    i.getWidgetChild().click(true);
                }
            }
        }
    }
}
