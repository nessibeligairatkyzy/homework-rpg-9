package com.narxoz.rpg.artifact;

public class WeightCalculator implements ArtifactVisitor {

    private int totalWeight = 0;

    @Override
    public void visit(Weapon weapon) {
        System.out.println("  Weight calc - Weapon: " + weapon.getName() +
                " (" + weapon.getWeight() + " kg)");
        totalWeight += weapon.getWeight();
    }

    @Override
    public void visit(Potion potion) {
        System.out.println("  Weight calc - Potion: " + potion.getName() +
                " (" + potion.getWeight() + " kg)");
        totalWeight += potion.getWeight();
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println("  Weight calc - Scroll: " + scroll.getName() +
                " (" + scroll.getWeight() + " kg)");
        totalWeight += scroll.getWeight();
    }

    @Override
    public void visit(Ring ring) {
        System.out.println("  Weight calc - Ring: " + ring.getName() +
                " (" + ring.getWeight() + " kg)");
        totalWeight += ring.getWeight();
    }

    @Override
    public void visit(Armor armor) {
        System.out.println("  Weight calc - Armor: " + armor.getName() +
                " (" + armor.getWeight() + " kg)");
        totalWeight += armor.getWeight();
    }

    public int getTotalWeight() {
        return totalWeight;
    }
}