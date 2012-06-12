/*
 * Copyright (c) 2012. Redex Scripting - Unauthorized use prohibited by author.
 */

package RedexSoulWars;

import RedexSoulWars.gui.Prefrences;
import org.powerbot.game.api.ActiveScript;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.bot.event.listener.PaintListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Tim
 * Date: 6/10/12
 * Time: 6:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Manifest(authors = {"Swipe"}, name = "RedexSoulWars", description = "Epic SoulWars", version = 1.0)
public class RedexSoulWars extends ActiveScript implements PaintListener {
    Prefrences prefs;

    @Override
    protected void setup() {
        Store.startTime = System.currentTimeMillis();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                prefs = new Prefrences();

            }
        });
        while (prefs.isValid()) {

        }
    }

    @Override
    public void onRepaint(Graphics g) {
        g.setColor(Color.RED);
        g.drawLine(Mouse.getX() - 5, Mouse.getY(), Mouse.getX() + 5, Mouse.getY());
        g.drawLine(Mouse.getX(), Mouse.getY() - 5, Mouse.getX(), Mouse.getY() + 5);
    }
}
