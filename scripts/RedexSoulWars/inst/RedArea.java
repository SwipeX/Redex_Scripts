package RedexSoulWars.inst;

import RedexSoulWars.wrappers.EnclosedArea;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.node.SceneObject;

/**
 * Created by IntelliJ IDEA.
 * User: Tim
 * Date: 6/10/12
 * Time: 8:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class RedArea extends EnclosedArea{
    /**
     * @param area   - area for Location
     * @param adoor  - Object of enter/exit door
     * @param aenter - true if we enter or false if we exit.
     */
    public RedArea(Area area, SceneObject adoor, boolean aenter) {
        super(area, adoor, aenter);
    }
}
