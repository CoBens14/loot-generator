package edu.grinnell.csc207.lootgenerator;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Loot Generator Class
 */
public class LootGenerator {
    /** The path to the dataset (either the small or large set). */
    public static final String DATA_SET = "data/large";

    /**
     * Asks user to if they want to fight again
     * 
     * @param input the Scanner receiving user input
     * @return the String of user input, supposed to be a y or n
     */
    public static String askForInput(Scanner input) {
        System.out.print("Fight again [y/n]? ");
        return input.next();
    }

    /**
     * The function that runs the program. Called repeatedly until program is done
     * 
     * @param monsterObj the data of monsters
     * @param treasureObj the data of treasure
     * @param armorObj the data of armor
     * @param prefixObj the data of prefixes
     * @param suffixObj the data of suffixes
     */
    public static void battleMonster(Monsters monsterObj, Treasure treasureObj, 
        Armor armorObj, Prefix prefixObj, Suffix suffixObj) {
        String monsterName = monsterObj.getRandomMonster();

        System.out.println("Fighting " + monsterName + "...");
        System.out.println("You have slain " + monsterName + "!");
        System.out.println(monsterName + " dropped:");
        System.out.println();

        String treasureName = treasureObj.getTreasure(monsterObj.getTreasureClass(monsterName));
        Affix prefix = new Affix("", "", 0, 0, true);
        Affix suffix = new Affix("", "", 0, 0, false);
        Random randomNumber = new Random();
        int val = randomNumber.nextInt(2);
        boolean prefixExists = false;
        if (val == 0) {
            prefix = prefixObj.returnRandomPrefix();
            prefixExists = true;
        }
        val = randomNumber.nextInt(2);
        boolean suffixExists = false;
        if (val == 0) {
            suffix = suffixObj.returnRandomSuffix();
            suffixExists = true;
        }
        String itemName;
        if (prefixExists) {
            itemName = "" + prefix.getName() + " " + treasureName + " " + suffix.getName();
        } else {
            itemName = treasureName + " " + suffix.getName();
        }

        System.out.println(itemName);
        System.out.println("Defense: " + armorObj.computeBaseStat(treasureName));
        if (prefixExists) {
            System.out.println(prefix.statToString());
        }
        if (suffixExists) {
            System.out.println(suffix.statToString());
        }
        


    }
    
    /**
     * The main function of program
     * 
     * @param args the command line arguments, expecting zero
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("This program kills monsters and generates loot!");
        Monsters monsterObj = new Monsters();
        Treasure treasureObj = new Treasure();
        Armor armorObj = new Armor();
        Prefix prefixObj = new Prefix();
        Suffix suffixObj = new Suffix();
        Scanner userInput = new Scanner(System.in);
        System.out.print("Fight [y/n]? ");
        String inputLetter = userInput.next().toLowerCase();
        while (inputLetter.compareTo("n") != 0) {
            if (inputLetter.compareTo("y") != 0) {
                inputLetter = askForInput(userInput); 

            } else {
                battleMonster(monsterObj, treasureObj, armorObj, prefixObj, suffixObj);
                inputLetter = askForInput(userInput);
            }
        }
        
    }
}
