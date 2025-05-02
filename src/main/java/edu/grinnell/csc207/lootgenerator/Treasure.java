package edu.grinnell.csc207.lootgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Treasure Class
 */
public class Treasure {
    TreeMap<String, String[]> treasureMap;

    /**
     * Reads in and stores treasure data
     * 
     * @param in the Scanner reading in text file
     */
    private void readTreasureData(Scanner in) {
        while (in.hasNextLine()) {
            String name = "";
            String one = "";
            String two = "";
            String three = "";
            String line = in.nextLine();
            int i = 0;
            char cur = line.charAt(i);
            while (cur != '\t') {
                name = name + cur;
                i++;
                cur = line.charAt(i);
            }
            i++;
            cur = line.charAt(i);
            while (cur != '\t') {
                one = one + cur;
                i++;
                cur = line.charAt(i);
            }
            i++;
            cur = line.charAt(i);
            while (cur != '\t') {
                two = two + cur;
                i++;
                cur = line.charAt(i);
            }
            i++;
            cur = line.charAt(i);
            while (i < line.length() - 1) {
                three = three + cur;
                i++;
                cur = line.charAt(i);
            }
            three = three + cur;
            treasureMap.put(name, new String[] {one, two, three });
        }
    }

    /**
     * Constructor for Treasure object
     * 
     * @throws FileNotFoundException
     */
    public Treasure() throws FileNotFoundException {
        treasureMap = new TreeMap<String, String[]>();
        File file = new File(LootGenerator.DATA_SET + "/TreasureClassEx.txt");
        Scanner in = new Scanner(file);
        readTreasureData(in);
    }

    /**
     * Returns the Treasure of of inputted treasure
     * 
     * @param treasure the treasure being searched for
     * @return String of final treasure
     */
    public String getTreasure(String treasure) {
        Random randomNumber = new Random();
        int val = randomNumber.nextInt(3);
        String newTreasure = treasureMap.get(treasure)[val];
        if (treasureMap.containsKey(newTreasure)) {
            return getTreasure(newTreasure);
        } else {
            return newTreasure;
        }
    }
}
