package edu.grinnell.csc207.lootgenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void statToStringTest() {
        for (int k = 0; k < 88; k++) {
            Affix one = new Affix("Hello", "Defense", 12, 21 + k, true);
            String message = one.statToString();
            int i = Integer.parseInt(message.substring(0, 2));
            assertTrue(i > 11 && i < (22 + k));

        }
    }

    @Test
    public void repeatedProcessTest() throws FileNotFoundException {
        Monsters monsterObj = new Monsters();
        Treasure treasureObj = new Treasure();
        Armor armorObj = new Armor();
        Prefix prefixObj = new Prefix();
        Suffix suffixObj = new Suffix();
        for (int i = 0; i < 10000; i++) {
            String monsterName = monsterObj.getRandomMonster();
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
            int k = armorObj.computeBaseStat(treasureName);
            assertTrue(k >=0 && k < 601);
        }
    }
}
