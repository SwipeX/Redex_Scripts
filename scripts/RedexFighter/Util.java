/*
 * Copyright (c) 2012. Redex Scripting - Unauthorized use prohibited by author.
 */

package RedexFighter;

import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.Item;

/**
 * Created by IntelliJ IDEA.
 * User: Tim
 * Date: 6/22/12
 * Time: 12:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Util {
    public static Item getItem(String name) {
        for (Item i : Inventory.getItems()) {
            if (i.getName().equals(name))
                return i;
        }
        return null;
    }

    public static boolean inventoryContains(String[] s) {
        for (String name : s) {
            for (Item i : Inventory.getItems()) {
                if (i.getName().equals(name))
                    return true;
            }
        }
        return false;
    }
}
