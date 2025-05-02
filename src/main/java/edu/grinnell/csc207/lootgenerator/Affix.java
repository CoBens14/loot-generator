package edu.grinnell.csc207.lootgenerator;

import java.util.Random;

/**
 * Affix Class
 */
public class Affix {
    private String name;
    private String stat;
    private int min;
    private int max;
    private boolean prefix;

    /**
     * Constructs an affix using parameters
     * 
     * @param name name of affix
     * @param stat stat of affix
     * @param min min stat value
     * @param max max stat value
     * @param prefix true if it is a prefix
     */
    public Affix(String name, String stat, int min, int max, boolean prefix) {
        this.name = name;
        this.stat = stat;
        this.min = min;
        this.max = max;
        this.prefix = prefix;
    }

    /**
     * @return stat as a String
     */
    public String statToString() {
        Random randomGen = new Random();
        int val = randomGen.nextInt(max - min + 1) + min;
        return "" + val + " " + stat; 
    }

    /**
     * @return name of affix
     */
    public String getName() {
        return name;
    }

    /**
     * @return true if affix is a prefix
     */
    public boolean isPrefix() {
        return prefix;
    }

}
