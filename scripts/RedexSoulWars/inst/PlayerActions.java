package RedexSoulWars.inst;

import RedexSoulWars.act.Action;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.wrappers.interactive.Player;

/**
 * Created by IntelliJ IDEA.
 * User: Tim
 * Date: 6/10/12
 * Time: 8:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlayerActions extends Action {
    @Override
    public void act() {
        if (!Players.getLocal().isInCombat()) {
            Player toAttack = null;
            double dist = 10;
            for (Player p : Players.getLoaded()) {
                if (Calculations.distance(Players.getLocal(), p) < dist)
                    toAttack = p;
            }
            if (toAttack == null)
                return;
            toAttack.interact("Attack");
        }
    }
}
