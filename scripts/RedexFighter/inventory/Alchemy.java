/*
 * Copyright (c) 2012. Redex Scripting - Unauthorized use prohibited by author.
 */

package RedexFighter.inventory;


import RedexFighter.Store;
import RedexFighter.Util;
import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Magic;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

/**
 * Created by IntelliJ IDEA.
 * User: Tim
 * Date: 6/22/12
 * Time: 12:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Alchemy extends Strategy implements Task {
    int Staff = 1387;
    int nat = 561;
    WidgetChild AlchSpell = Widgets.get(192, 59);

    public boolean validate() {
        return Store.alchNames.size() > 0 && Util.inventoryContains(Store.alchNames.toArray(new String[Store.alchNames.size()]));
    }

    @Override
    public void run() {
        if (Util.getItem("Fire Rune") != null || Players.getLocal().getAppearance()[5] == Staff) {
            Alch();
        } else {
            if (Util.getItem("Fire Staff") != null && Util.getItem("Nature Rune") != null) {
                Util.getItem("Fire Staff").getWidgetChild().click(true);
                Time.sleep(400, 800);
            }
        }
    }

    public void Alch() {
        if (Magic.isSpellSelected()) {
            for (String s : Store.alchNames) {
                if (Util.getItem(s) != null) {
                    Util.getItem(s).getWidgetChild().click(true);
                    break;
                }
            }
        } else {
            AlchSpell.click(true);
        }
    }
}
