/*
 * Copyright (c) 2012. Redex Scripting - Unauthorized use prohibited by author.
 */

package RedexAlter.bank;

import RedexAlter.Constants;
import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;

/**
 * Created by IntelliJ IDEA.
 * User: 0xe9
 * Date: 6/23/12
 * Time: 5:06 PM
 */
public class BankUtil extends Strategy implements Task {
    boolean needsBank;

    public BankUtil(boolean b) {
        needsBank = b;
    }

    @Override
    public void run() {
        if (Inventory.getCount() == 0) {
            Bank.withdraw(Constants.HERB, 2);
            Bank.withdraw(Constants.BONE, 26);
        }
    }
}
