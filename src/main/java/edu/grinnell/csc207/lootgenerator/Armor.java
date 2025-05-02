package edu.grinnell.csc207.lootgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Armor Class
 */
public class Armor {

    private class Pair {
        int min;
        int max;
        /**
         * Constructs a pair of ints
         * 
         * @param min the min value of the stat
         * @param max the max value of the stat
         */
        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    private HashMap<String, Pair> armorMap;

    /**
     * Reads in armor data
     * 
     * @param in the scanner of txt file storing data
     */
    private void readArmorData(Scanner in) {
        while (in.hasNextLine()) {
            String name = "";
            int count = 0;
            while (!(in.hasNextInt())) {
                if (count == 0) {
                    name = name + in.next();
                    count++;
                } else {
                    name = name + " " + in.next();
                }
                
            }
            Pair values = new Pair(in.nextInt(), in.nextInt());
            armorMap.put(name, values);
        }
    }

    /**
     * Constructor for Armor class
     * @throws FileNotFoundException
     */
    public Armor() throws FileNotFoundException {
        armorMap = new HashMap<String, Pair>();
        File file = new File(LootGenerator.DATA_SET + "/armor.txt");
        Scanner in = new Scanner(file);
        readArmorData(in);
    }

    /**
     * Returns the base stat as an int
     * @param armor the type of armor 
     * @return the base stat of armor
     */
    public int computeBaseStat(String armor) {
        Random randomGen = new Random();
        Pair armorPair = armorMap.get(armor);
        int ret = randomGen.nextInt(armorPair.max - armorPair.min + 1) + armorPair.min;
        return ret;
    }
    
}
