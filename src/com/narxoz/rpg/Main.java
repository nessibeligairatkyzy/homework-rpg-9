package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        Hero warrior = new Hero("Thorin Ironfist", 150, 45, 30);
        warrior.addGold(450);

        Hero mage = new Hero("Lirael Stormweaver", 90, 85, 22, 15, 720, null);

        System.out.println("\nHeroes entering the vault:");
        System.out.println("   • " + warrior.getName() + " (HP: " + warrior.getHp() + ")");
        System.out.println("   • " + mage.getName() + " (HP: " + mage.getHp() + ")");


        ChronomancerEngine engine = new ChronomancerEngine();
        System.out.println("\nStarting vault expedition...\n");

        VaultRunResult result = engine.runVault(List.of(warrior, mage));


        System.out.println("\n" + result);

    }
}