/*
 * Copyright (c) 2012. Redex Scripting - Unauthorized use prohibited by author.
 */

package RedexFighter.bank;

import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.wrappers.node.SceneObject;

/**
 * Created by IntelliJ IDEA.
 * User: Tim
 * Date: 6/18/12
 * Time: 10:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankUtil {

    public Boolean inBank() {
        SceneObject bank = (SceneObject) Bank.getNearest();
        return (Calculations.distanceTo(bank) > 7);
    }

    public void walkToNearest() {
        SceneObject bank = (SceneObject) Bank.getNearest();
        Walking.walk(bank);
    }

}
