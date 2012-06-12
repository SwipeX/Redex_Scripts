/*
 * Copyright (c) 2012. Redex Scripting - Unauthorized use prohibited by author.
 */

package RedexSoulWars.inst;

import RedexSoulWars.Store;
import RedexSoulWars.act.Action;
import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Condition;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: Tim
 * Date: 6/11/12
 * Time: 4:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class AreaManager implements Task, Condition {
    HashMap<Boolean, Action> checks = new HashMap<Boolean, Action>();

    public AreaManager() {
        checks.put(Store.inBlueBandage(), AreaActions.joinTeam());
        checks.put(Store.inBlueGraveyard(), AreaActions.joinTeam());
        checks.put(Store.inBlueRoom(), AreaActions.joinTeam());
        checks.put(Store.inBlueSpawn(), AreaActions.joinTeam());
        checks.put(Store.inBlueSpawnBig(), AreaActions.joinTeam());
        checks.put(Store.inOblesik(), AreaActions.joinTeam());
        checks.put(Store.inRedBandage(), AreaActions.joinTeam());
        checks.put(Store.inRedRoom(), AreaActions.joinTeam());
        checks.put(Store.inRedSpawn(), AreaActions.joinTeam());
        checks.put(Store.inRedSpawnBig(), AreaActions.joinTeam());
        checks.put(Store.inWaiting(), AreaActions.joinTeam());
    }

    @Override
    public boolean validate() {
        for (Boolean b : checks.keySet()) {
            if (b) {
                return true;
            }
        }
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void run() {
        for (Boolean b : checks.keySet()) {
            checks.get(b).act();
            break;
        }
    }
}
