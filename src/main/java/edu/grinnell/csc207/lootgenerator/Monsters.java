package edu.grinnell.csc207.lootgenerator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Monsters Class
 */
public class Monsters {
    private HashMap<String, String> monsterMap;

    /**
     * Reads in data from monstats
     * 
     * @param in the scanner that reads in file
     */
    private void readMonsterData(Scanner in) {
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String monster = "";
            String treasureClass = "";
            int i = 0;
            char cur = line.charAt(i);
            while (cur != '\t') {
                monster = monster + cur;
                i++;
                cur = line.charAt(i);
            }
            int count = 0;
            while (count < 3) {
                if (cur == '\t') {
                    count++;
                }
                i++;
                cur = line.charAt(i);
            }
            treasureClass = treasureClass + cur;
            while (i < line.length() - 1) {
                i++;
                cur = line.charAt(i);
                treasureClass = treasureClass + cur;
            }
            monsterMap.put(monster, treasureClass);
        }
    }

    /**
     * Constructs Monster Class
     */
    public Monsters() throws FileNotFoundException {
        monsterMap = new HashMap<String, String>();
        File file = new File(LootGenerator.DATA_SET + "/monstats.txt");
        Scanner in = new Scanner(file);
        readMonsterData(in);
    }

    /**
     * @return a random monster as a String
     */
    public String getRandomMonster() {
        Random randomGen = new Random();
        int val = randomGen.nextInt(monsterMap.size());
        return (String) monsterMap.keySet().toArray()[val];
    }

    /**
     * Gets the treasure class of inputted monster
     * 
     * @param monster the monster whose treasure class is being looked for
     * @return a String of treasure Class
     */
    public String getTreasureClass(String monster) {
        return monsterMap.get(monster);
    }
}
