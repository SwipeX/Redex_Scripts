/*
 * Copyright (c) 2012. Redex Scripting - Unauthorized use prohibited by author.
 */

package RedexFighter.paint;

import RedexFighter.Store;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.bot.event.listener.PaintListener;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Tim
 * Date: 6/20/12
 * Time: 9:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class DebugPaint implements PaintListener {
    @Override
    public void onRepaint(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawString("Store.npcNames " + Store.npcNames.size(), 100, 30);
        g.drawString("Store.lootNames " + Store.lootNames.size(), 100, 45);
        g.drawString("Store.alchNames" + Store.alchNames.size(), 100, 60);
        g.drawString("Store.B2P " + Store.B2P, 100, 75);
        g.drawString("Store.Banking " + Store.Banking, 100, 90);
        g.drawString("Player.isInCombat() " + Players.getLocal().isInCombat(), 100, 105);
        g.drawString("Player.isMoving() " + Players.getLocal().isMoving(), 100, 120);
        // g.drawString("Ground.hasLoot() " + GroundUtil.hasItem(), 100, 135);
    }
}
