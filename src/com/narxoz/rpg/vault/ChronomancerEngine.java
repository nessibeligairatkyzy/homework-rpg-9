package com.narxoz.rpg.vault;

import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.combatant.HeroMemento;
import com.narxoz.rpg.memento.Caretaker;
import java.util.List;

public class ChronomancerEngine {

    public VaultRunResult runVault(List<Hero> party) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("=== CHRONOMANCER'S VAULT ACTIVATED ===");
        System.out.println("=".repeat(60));

        if (party.isEmpty()) {
            return new VaultRunResult(0, 0, 0);
        }

        Hero hero = party.get(0);
        Caretaker caretaker = new Caretaker();


        System.out.println("\n [MEMENTO] Saving hero state before entering dangerous chamber...");
        caretaker.save(hero.createMemento());
        System.out.println("   Saved " + caretaker.size() + " snapshot(s)");


        Inventory vaultInventory = createVaultInventory();
        hero.setInventory(vaultInventory);

        System.out.println("\n Inventory loaded with " + vaultInventory.size() + " artifacts.");

        // === VISITOR: Apply multiple appraisers ===
        System.out.println("\n [VISITOR] Starting artifact appraisal with specialists...");

        GoldAppraiser appraiser = new GoldAppraiser();
        EnchantmentScanner scanner = new EnchantmentScanner();
        CurseDetector detector = new CurseDetector();

        vaultInventory.accept(appraiser);
        vaultInventory.accept(scanner);
        vaultInventory.accept(detector);

        System.out.println("\n Total estimated value by GoldAppraiser: " + appraiser.getTotalValue() + " gold");

        // === Simulate dangerous event (state change) ===
        System.out.println("\n TRAP ACTIVATED! Hero takes heavy damage!");
        hero.takeDamage(75);
        hero.spendMana(40);

        System.out.println("   Current hero state: " + hero);

        // === MEMENTO: Rewind time ===
        System.out.println("\n [MEMENTO] Chronomancer activates time crystal - REWINDING...");
        HeroMemento savedState = caretaker.undo();
        if (savedState != null) {
            hero.restoreFromMemento(savedState);
            System.out.println("   Hero successfully restored from memento!");
        }

        System.out.println("   After rewind: " + hero);

        System.out.println("\n" + "=".repeat(60));
        System.out.println("=== VAULT RUN COMPLETED ===");
        System.out.println("=".repeat(60));

        return new VaultRunResult(
                vaultInventory.size(),
                1,
                1
        );
    }

    private Inventory createVaultInventory() {
        Inventory inv = new Inventory();

        inv.addArtifact(new Weapon("Dragon Slayer", 850, 18, 35));
        inv.addArtifact(new Potion("Elixir of Life", 420, 3, 150));
        inv.addArtifact(new Scroll("Ancient Fireball", 670, 1, "Inferno Blast"));
        inv.addArtifact(new Ring("Ring of Eternal Power", 950, 1, 20));
        inv.addArtifact(new Armor("Armor of the Void", 780, 22, 28));
        inv.addArtifact(new Potion("Healing Draught", 180, 2, 50));
        inv.addArtifact(new Scroll("Teleportation", 550, 1, "Dimensional Shift"));

        return inv;
    }
}