/*
 * Copyright (c) 2012. Redex Scripting - Unauthorized use prohibited by author.
 */

package RedexFighter.paint;

import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.bot.event.listener.PaintListener;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Tim
 * Date: 6/20/12
 * Time: 10:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class MousePaint implements PaintListener {


    @Override
    public void onRepaint(Graphics g) {
        if (System.currentTimeMillis() - Mouse.getPressTime() < 500) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Alphaize(Color.GREEN, 160));
        }
        g.drawOval(Mouse.getX() - 5, Mouse.getY() - 5, 10, 10);
        g.drawLine(Mouse.getX() - 5, Mouse.getY(), Mouse.getX() + 5, Mouse.getY());
        g.drawLine(Mouse.getX(), Mouse.getY() - 5, Mouse.getX(), Mouse.getY() + 5);
    }

    public Color Alphaize(Color c, int alpha) {
        return new Color(c.getRed(), c.getBlue(), c.getGreen(), alpha);
    }
}
