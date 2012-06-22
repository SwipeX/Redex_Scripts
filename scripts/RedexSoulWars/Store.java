/*
 * Copyright (c) 2012. Redex Scripting - Unauthorized use prohibited by author.
 */

package RedexSoulWars;

import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;

/**
 * Created by IntelliJ IDEA.
 * User: Tim
 * Date: 6/10/12
 * Time: 11:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Store {
    public static int method;
    public static String lastWon;
    public static int wins;
    public static int losses;
    public static int ties;
    public static long startTime;
    public static final int[] barriersID ={42013, 42014, 42015, 42016, 42017, 42018};
    public static Tile redTile = new Tile(1899, 3162, 0);
    public static Tile blueTile = new Tile(1880, 3162, 0);


    public final static boolean inWaiting() {
        Area area = new Area(new Tile(1880, 3186, 0), new Tile(1899, 3157, 0));
        return area.contains(Players.getLocal());
    }

    public final static boolean inRedRoom() {
        Area area = new Area(new Tile(1899, 3167, 0), new Tile(1908, 3156, 0));
        return area.contains(Players.getLocal());
    }

    public final static boolean inBlueRoom() {
        Area area = new Area(new Tile(1880, 3167, 0), new Tile(1869, 3157, 0));
        return area.contains(Players.getLocal());
    }

    public final static boolean inBlueSpawnBig() {
        Area area = new Area(new Tile(1816, 3230, 0), new Tile(1870, 3158, 0));
        return area.contains(Players.getLocal());
    }

    public final static boolean inBlueSpawn() {
        Area area = new Area(new Tile(1841, 3118, 0), new Tile(1843, 3217, 0));
        return area.contains(Players.getLocal());
    }

    public final static boolean inRedSpawnBig() {
        Area area = new Area(new Tile(1951, 3244, 0), new Tile(1958, 3235, 0));
        return area.contains(Players.getLocal());
    }

    public final static boolean inRedSpawn() {
        Area area = new Area(new Tile(1841, 3118, 0), new Tile(1843, 3217, 0));
        return area.contains(Players.getLocal());
    }

    public final static boolean inBlueBandage() {
        Area area = new Area(new Tile(1803, 3249, 0), new Tile(1811, 3256, 0));
        return area.contains(Players.getLocal());
    }

    public final static boolean inRedBandage() {
        Area area = new Area(new Tile(1961, 3211, 0), new Tile(1971, 3205, 0));
        return area.contains(Players.getLocal());
    }

    public final static boolean inBlueGraveyard() {
        Area area = new Area(new Tile(1838, 3223, 0), new Tile(1846, 3213, 0));
        return area.contains(Players.getLocal());
    }

    public final static boolean inOblesik() {
        Area area = new Area(new Tile(1884, 3223, 0), new Tile(1889, 3230, 0));
        return area.contains(Players.getLocal());
    }
}
