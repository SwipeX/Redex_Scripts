package RedexFisher;

import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Condition;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.ActiveScript;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.interactive.NPC;
import org.powerbot.game.api.wrappers.node.Item;
import org.powerbot.game.bot.event.listener.PaintListener;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Swipe You may not use any portions of this code without explicit
 *         permission from Swipe. (c)Powerbot.org 2012
 */
@Manifest(authors = {"Swipe"}, name = "RedexFisher", description = "Powerfishes at Barb", version = 1.0)
public class RedexFisher extends ActiveScript implements PaintListener {
    // Variables - i left blank
    final int[] FISH_ID = {331, 335};
    final int FISH_SPOT = 328;
    int startExp;
    long startTime;
    String User = "troll";
    int expGain = 0;
    int Fish = 0;
    int Profit = 0;
    public static String ROOT;

    /**
     * @author Swipe will drop all fish when the inventory is full
     */
    private class Drop implements Task, Condition {

        public void run() {
            for (Item i : Inventory.getItems()) {
                for (int id : FISH_ID) {
                    if (i.getId() == id) {
                        i.getWidgetChild().interact("drop"); // best way?
                        Fish++;
                        Time.sleep(50);
                        break;
                    }
                }
            }
        }

        @Override
        public boolean validate() {
            return Inventory.getCount() == 28;// full
        }
    }

    /**
     * @author Swipe will click on fishing spot when inventory is not full
     */
    private class Fish implements Task, Condition {
        @SuppressWarnings({"unchecked", "rawtypes"})
        public void run() {
            // A filter to return the correct object
            getNearestSpotOnScreen().click(true);
            Time.sleep(1500);
        }

        @Override
        public boolean validate() {
            return Inventory.getCount() < 28 && !isFishing();
        }
    }

    private NPC getNearestSpotOnScreen() {
        for (NPC n : NPCs.getLoaded()) {
            if (n.isOnScreen() && n.getId() == FISH_SPOT)
                return n;
        }
        return null;
    }

    /**
     * @author Swipe will click on fishing spot when inventory is not full
     */
    private class RotateCamera implements Task, Condition {
        @SuppressWarnings({"unchecked", "rawtypes"})
        public void run() {
            Camera.setAngle(Random.nextInt(30, 180));
        }

        @Override
        public boolean validate() {
            return getNearestSpotOnScreen() == null
                    && getNearestLoadedSpot() != null;
        }
    }

    private NPC getNearestLoadedSpot() {
        for (NPC n : NPCs.getLoaded()) {
            if (n.isOnScreen() && n.getId() == FISH_SPOT)
                return n;
        }
        return null;
    }

    private boolean isFishing() {
        if (Players.getLocal().getInteracting() != null) {
            if (Players.getLocal().getInteracting() instanceof NPC)
                return ((NPC) Players.getLocal().getInteracting()).getId() == FISH_SPOT;
        }
        return false;
    }

    @Override
    protected void setup() {
        try {
            ROOT = new File(".").getCanonicalPath();
            System.out.println(ROOT);
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        File f = new File(ROOT + File.separatorChar + "user.txt");
        try {
            System.out.println(f.getCanonicalPath());
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        if (f.exists()) {
            log.info("Save Exists");
            FileReader fr = null;
            try {
                fr = new FileReader(f);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            BufferedReader br = new BufferedReader(fr);
            try {
                User = br.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                br.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("User: " + User);
        } else {
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    User = JOptionPane.showInputDialog(null,
                            "Enter a Sig Username: ");
                }
            });
            Writer out = null;
            try {
                out = new OutputStreamWriter(new FileOutputStream(f));
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                out.write(User);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    out.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        // make instances
        final Fish fish = new Fish();
        final Drop drop = new Drop();
        final RotateCamera rotate = new RotateCamera();
        final Strategy Fisher = new Strategy(fish, fish);
        final Strategy Dropper = new Strategy(drop, drop);
        final Strategy Rotater = new Strategy(rotate, rotate);
        // provide them for processing
        provide(Dropper);
        provide(Fisher);
        provide(Rotater);
        startExp = Skills.getExperiences()[10];
        startTime = System.currentTimeMillis();

    }

    public String formatTime(final long milliseconds) {
        final long t_seconds = milliseconds / 1000;
        final long t_minutes = t_seconds / 60;
        final long t_hours = t_minutes / 60;
        final long seconds = t_seconds % 60;
        final long minutes = t_minutes % 60;
        final long hours = t_hours % 500;
        return hours + ":" + minutes + ":" + seconds;
    }

    @Override
    public void onRepaint(Graphics g) {
        int paintX = 10;
        int paintY = 200;
        expGain = (Skills.getExperiences()[10] - startExp);
        double expHour = (expGain * 3600000D)
                / (System.currentTimeMillis() - startTime);
        String[] paintInfo = {
                "AIO Fisher V 1.0",
                "By: Swipe",
                "Time Running: "
                        + formatTime(System.currentTimeMillis() - startTime),
                "Status:" + getStatus(), " Exp Gained: " + expGain,
                " Exp/H " + Math.round(expHour),};
        g.setColor(new Color(20, 220, 20, 180));
        Point mLoc = Mouse.getLocation();
        g.setColor(new Color(20, 230, 40, 180));
        g.drawLine(mLoc.x, 0, mLoc.x, 502);
        g.drawLine(0, mLoc.y, 764, mLoc.y);
        g.setColor(new Color(60, 60, 60, 180));
        g.fill3DRect(paintX, paintY, 150, paintInfo.length * 14, true);
        g.setColor(Color.CYAN);
        for (int i = 1; i < paintInfo.length + 1; i++) {
            g.drawString(paintInfo[i - 1], paintX, paintY + (i * 12));
        }
    }

    private String getStatus() {
        if ((Inventory.getCount() < 28 && Players.getLocal().getAnimation() == -1))
            return "Clicking Fish Spot";
        else if (isFishing())
            return "Fishing";
        return "Dropping";
    }

    public void onStop() {
        try {
            URL SIG = new URL(
                    "http://www.redexscripting.org/php/Fisher.php?user=" + User
                            + "&time="
                            + (System.currentTimeMillis() - startTime)
                            + "&exp=" + expGain + "&fish=" + Fish + "&profit="
                            + Profit);
            SIG.openStream().read();
            SIG = null;
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}