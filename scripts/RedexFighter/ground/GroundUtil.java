/*
 * Copyright (c) 2012. Redex Scripting - Unauthorized use prohibited by author.
 */

package RedexFighter.ground;

import RedexFighter.Store;
import org.powerbot.game.api.methods.node.GroundItems;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.node.GroundItem;

/**
 * Created by IntelliJ IDEA.
 * User: Tim
 * Date: 6/18/12
 * Time: 11:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class GroundUtil {

    public static void takeItems() {
        GroundItems.getNearest(new Filter<GroundItem>() {
            @Override
            public boolean accept(GroundItem groundItem) {
                for (String s : Store.lootNames) {
                    if (groundItem.getGroundItem().getName().equals(s)) {
                        return true;
                    }
                }
                return false;
            }
        }).interact("Take");
        Time.sleep(2000, 3000);

    }

    public static boolean hasItem() {
        return GroundItems.getLoaded(new Filter<GroundItem>() {
            @Override
            public boolean accept(GroundItem groundItem) {
                for (String s : Store.lootNames) {
                    if (groundItem.getGroundItem().getName().toLowerCase().equals(s)) {
                        return true;
                    }
                }
                return false;
            }
        }) == null;

    }

    public void takeItemsAboveValue(int min) {
        for (GroundItem gi : GroundItems.getLoaded()) {
            if (lookUp(gi.getId()) > min) {
                for (int j = 0; j < 5; j++) {
                    int count = Inventory.getCount();
                    gi.interact("take");
                    Time.sleep(2000, 3000);
                    if (Inventory.getCount() > count)
                        break;
                }
            }
        }
    }

    public int lookUp(int i) {
        return 0;
    }
}
