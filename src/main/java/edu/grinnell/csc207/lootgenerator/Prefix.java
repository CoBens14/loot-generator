package edu.grinnell.csc207.lootgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Prefix Class
 */
public class Prefix {
    private ArrayList<Affix> prefixList;
    
    /**
     * Reads in prefix informaton
     * 
     * @param in the scanner reading in text file
     */
    private void readPrefixes(Scanner in) {
        String name;
        int min;
        int max;
        while (in.hasNextLine()) {
            String stat = "";
            name = in.next();
            int count = 0;
            while (!(in.hasNextInt())) {
                if (count == 0) {
                    stat = stat + in.next();
                    count++;
                } else {
                    stat = stat + " " + in.next();
                }
            }
            min = in.nextInt();
            max = in.nextInt();
            prefixList.add(new Affix(name, stat, min, max, true));

        }
    }

    /**
     * The prefix object constructor
     * 
     * @throws FileNotFoundException
     */
    public Prefix() throws FileNotFoundException {
        prefixList = new ArrayList<Affix>();
        File file = new File(LootGenerator.DATA_SET + "/MagicPrefix.txt");
        Scanner in = new Scanner(file);
        readPrefixes(in);
    }

    /**
     * @return random prefix as Affix object
     */
    public Affix returnRandomPrefix() {
        Random randomGen = new Random();
        int val = randomGen.nextInt(prefixList.size());
        return prefixList.get(val);
    }


    
    
}
