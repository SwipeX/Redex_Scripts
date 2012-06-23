/*
 * Copyright (c) 2012. Redex Scripting - Unauthorized use prohibited by author.
 */

package RedexAlter.walk;

import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.wrappers.Area;

/**
 * Created by IntelliJ IDEA.
 * User: 0xe9
 * Date: 6/23/12
 * Time: 4:54 PM
 */
public class Walker extends Strategy implements Task {

    boolean isActive;
    Area target;

    public Walker(Area target, boolean b) {
        this.isActive = b;
        this.target = target;
    }

    public boolean validate() {
        return isActive;
    }

    @Override
    public void run() {
        Walking.walk(target.getNearest());
    }
}
