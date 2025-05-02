package edu.grinnell.csc207.lootgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Suffix Class
 */
public class Suffix {
    private ArrayList<Affix> suffixList;

    /**
     * Reads in suffix data
     * 
     * @param in the scanner reading text file
     */
    private void readsuffixes(Scanner in) {
        while (in.hasNextLine()) {
            String name = "";
            String stat = "";
            String min = "";
            String max = "";
            int minVal;
            int maxVal;
            String nextLine = in.nextLine();
            int i = 0;
            while (nextLine.charAt(i) != '\t') {
                name = name + nextLine.charAt(i);
                i++;
            }
            i++;
            while (nextLine.charAt(i) != '\t') {
                stat = stat + nextLine.charAt(i);
                i++;
            }
            i++;
            while (nextLine.charAt(i) != '\t') {
                min = min + nextLine.charAt(i);
                i++;
            }
            i++;
            while (i < nextLine.length()) {
                max = max + nextLine.charAt(i);
                i++;
            }
            minVal = Integer.parseUnsignedInt(min);
            maxVal = Integer.parseUnsignedInt(max);
            suffixList.add(new Affix(name, stat, minVal, maxVal, false));

        }
    }

    /**
     * Constructor for Suffix object
     * 
     * @throws FileNotFoundException
     */
    public Suffix() throws FileNotFoundException {
        suffixList = new ArrayList<Affix>();
        File file = new File(LootGenerator.DATA_SET + "/MagicSuffix.txt");
        Scanner in = new Scanner(file);
        readsuffixes(in);
    }

    /**
     * @return random Suffix as Affix object
     */
    public Affix returnRandomSuffix() {
        Random randomGen = new Random();
        int val = randomGen.nextInt(suffixList.size());
        return suffixList.get(val);
    }
}
