/*
 * Copyright (c) 2012. Redex Scripting - Unauthorized use prohibited by author.
 */

package RedexAlter.tasks;

import RedexAlter.Constants;
import RedexAlter.Util;
import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Time;

/**
 * Created by IntelliJ IDEA.
 * User: Tim
 * Date: 6/23/12
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class AlterTask extends Strategy implements Task {
    public boolean validate() {
        return Util.isInHouse() && Inventory.getCount(Constants.BONES) > 0 && Players.getLocal().getAnimation() != Constants.ALTER_ANIMATION;
    }

    @Override
    public void run() {
        if (Inventory.getSelectedItem() != null) {
            SceneEntities.getNearest(Constants.ALTER).click(true);
            Time.sleep(2000, 3000);
        } else {
            Inventory.getItem(0).getWidgetChild().click(true);//should be current bone
        }
    }
}
