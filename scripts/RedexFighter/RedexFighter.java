/*
 * Copyright (c) 2012. Redex Scripting - Unauthorized use prohibited by author.
 */

package RedexFighter;

import RedexFighter.combat.Fight;
import RedexFighter.ground.Pickup;
import RedexFighter.gui.GUI;
import RedexFighter.inventory.Alchemy;
import RedexFighter.inventory.BonesToPeaches;
import RedexFighter.inventory.HealthMonitor;
import RedexFighter.paint.DebugPaint;
import RedexFighter.paint.MousePaint;
import org.powerbot.game.api.ActiveScript;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.interactive.NPC;
import org.powerbot.game.bot.event.listener.PaintListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Tim
 * Date: 6/18/12
 * Time: 10:16 PM
 * To change this template use File | Settings | File Templates.
 */
@Manifest(authors = {"Swipe"}, name = "RedexFighter", description = "AIO Fighter", version = 1.0)
public class RedexFighter extends ActiveScript implements PaintListener {
    GUI g;

    @Override
    protected void setup() {
        g = new GUI();
        for (NPC n : NPCs.getLoaded()) {
            g.Names.add(n.getName());
        }
        g.setComboBox();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                g.setVisible(true);
            }
        });
        while (g.isVisible()) {
            Time.sleep(150);
        }
        Tile p = Players.getLocal().getLocation();
        Store.combatArea = new Area(new Tile(p.getX() - 20, p.getY() - 20, 0), new Tile(p.getX() + 20, p.getY() + 20, 0));
        provide(new HealthMonitor());
        provide(new Pickup());
        provide(new BonesToPeaches());
        provide(new Alchemy());
        provide(new Fight());
    }

    DebugPaint Debug = new DebugPaint();
    MousePaint MPaint = new MousePaint();

    @Override
    public void onRepaint(Graphics graphics) {
        Debug.onRepaint(graphics);
        MPaint.onRepaint(graphics);
    }

}
