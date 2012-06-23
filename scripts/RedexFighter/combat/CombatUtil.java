/*
 * Copyright (c) 2012. Redex Scripting - Unauthorized use prohibited by author.
 */

package RedexFighter.combat;

import org.powerbot.game.api.methods.Calculations;
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
        double distance = 50;
        NPC npc = null;
        for (NPC n : NPCs.getLoaded()) {
            for (String s : input) {
                if (n.getName().toLowerCase().equals(s.toLowerCase())) {
                    if (n.isInCombat()) {
                        break;
                    } else {
                        if (Calculations.distanceTo(n) < distance) {
                            npc = n;
                            distance = Calculations.distanceTo(n);
                        }
                    }
                }
            }

        }
        npc.interact("ttack");
        Time.sleep(500, 1000);
    }
}
