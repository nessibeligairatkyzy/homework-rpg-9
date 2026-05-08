package com.narxoz.rpg.artifact;

public class GoldAppraiser implements ArtifactVisitor {

    private int totalValue = 0;

    @Override
    public void visit(Weapon weapon) {
        System.out.println(" Appraising weapon: " + weapon.getName() +
                " (value: " + weapon.getValue() + ", attack +" + weapon.getAttackBonus() + ")");
        totalValue += weapon.getValue();
    }

    @Override
    public void visit(Potion potion) {
        System.out.println(" Appraising potion: " + potion.getName() +
                " (healing: " + potion.getHealing() + ")");
        totalValue += potion.getValue();
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println(" Appraising scroll: " + scroll.getName() +
                " (spell: " + scroll.getSpellName() + ")");
        totalValue += scroll.getValue() * 2;
    }

    @Override
    public void visit(Ring ring) {
        System.out.println(" Appraising ring: " + ring.getName() +
                " (magic +" + ring.getMagicBonus() + ")");
        totalValue += ring.getValue() + ring.getMagicBonus() * 10;
    }

    @Override
    public void visit(Armor armor) {
        System.out.println("️ Appraising armor: " + armor.getName() +
                " (defense +" + armor.getDefenseBonus() + ")");
        totalValue += armor.getValue();
    }

    public int getTotalValue() {
        return totalValue;
    }
}