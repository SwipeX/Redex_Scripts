/*
 * Copyright (c) 2012. Redex Scripting - Unauthorized use prohibited by author.
 */

package RedexFighter.inventory;

import RedexFighter.Store;
import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Time;

/**
 * Created by IntelliJ IDEA.
 * User: Tim
 * Date: 6/22/12
 * Time: 12:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class BonesToPeaches extends Strategy implements Task {
    int Peach = 2518;

    public boolean validate() {
        return Store.B2P && Inventory.getCount(Peach) == 0 && Inventory.isFull() && Inventory.getCount(526) > 0;
    }

    @Override
    public void run() {
        Inventory.getItem(8015).getWidgetChild().click(true);
        Time.sleep(1000, 3000);
    }
}
