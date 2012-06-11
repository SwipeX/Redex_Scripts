package RedexSoulWars.wrappers;

import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.node.SceneObject;

/**
 * Created by IntelliJ IDEA.
 * User: Tim
 * Date: 6/10/12
 * Time: 6:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class EnclosedArea {
    Area base;
    SceneObject door;
    boolean enter;

    /**
     * @param area   - area for Location
     * @param adoor  - Object of enter/exit door
     * @param aenter - true if we enter or false if we exit.
     */
    public EnclosedArea(Area area, SceneObject adoor, boolean aenter) {
        base = area;
        door = adoor;
        enter = aenter;
    }


}
