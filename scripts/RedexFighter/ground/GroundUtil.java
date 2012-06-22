/*
 * Copyright (c) 2012. Redex Scripting - Unauthorized use prohibited by author.
 */

package RedexFighter.ground;

import RedexFighter.Store;
import org.powerbot.game.api.methods.node.GroundItems;
import org.powerbot.game.api.methods.tab.Inventory;
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
        GroundItem item = null;
        for (String s : Store.lootNames) {
            for (GroundItem g : GroundItems.getLoaded()) {
                if (g.getGroundItem().getName().toLowerCase().equals(s.toLowerCase())) {
                    item = g;
                }
            }
            item.interact("take");
            Time.sleep(2000, 3000);

        }

    }

    public static boolean hasItem() {
        for (String s : Store.lootNames) {
            for (GroundItem g : GroundItems.getLoaded()) {
                if (g.getGroundItem().getName().toLowerCase().equals(s.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;

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
