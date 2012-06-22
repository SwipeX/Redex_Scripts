/*
 * Copyright (c) 2012. Redex Scripting - Unauthorized use prohibited by author.
 */

package RedexFighter.combat;

import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.interactive.NPC;

/**
 * Created by IntelliJ IDEA.
 * User: Tim
 * Date: 6/18/12
 * Time: 11:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class CombatUtil {
    public static void attackNearest(String[] input) {
        boolean breakable = false;
        for (NPC n : NPCs.getLoaded()) {
            for (String s : input) {
                if (n.getName().toLowerCase().equals(s.toLowerCase())) {
                    if (n.isInCombat()) {
                        break;
                    } else {
                        n.interact("ttack");
                        breakable = true;
                        break;
                    }
                }
            }
            if (breakable) {
                breakable = false;
                break;
            }
        }
        Time.sleep(500, 1000);
    }
}
