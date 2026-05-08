package com.narxoz.rpg.artifact;

public class EnchantmentScanner implements ArtifactVisitor {

    @Override
    public void visit(Weapon weapon) {
        System.out.println(" Enchantment scan - Weapon: " + weapon.getName() +
                " → Attack bonus: +" + weapon.getAttackBonus());
    }

    @Override
    public void visit(Potion potion) {
        System.out.println(" Enchantment scan - Potion: " + potion.getName() +
                " → Healing: " + potion.getHealing());
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println(" Enchantment scan - Scroll: " + scroll.getName() +
                " → Spell: " + scroll.getSpellName() + " (powerful magic!)");
    }

    @Override
    public void visit(Ring ring) {
        System.out.println(" Enchantment scan - Ring: " + ring.getName() +
                " → Magic bonus: +" + ring.getMagicBonus());
    }

    @Override
    public void visit(Armor armor) {
        System.out.println(" Enchantment scan - Armor: " + armor.getName() +
                " → Defense bonus: +" + armor.getDefenseBonus());
    }
}