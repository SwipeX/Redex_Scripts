package RedexSoulWars.wrappers;

import RedexSoulWars.act.Action;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.wrappers.Area;

/**
 * Created by IntelliJ IDEA.
 * User: Tim
 * Date: 6/10/12
 * Time: 7:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class ActionArea {
    Area area;
    Action action;

    public ActionArea(Area area, Action action) {
        this.area = area;
        this.action = action;
    }

    public void goToAndAct() {
        if (area.contains(Players.getLocal())) {
            action.act();
        } else {
            Walking.walk(area.getCentralTile());
        }
    }
}
