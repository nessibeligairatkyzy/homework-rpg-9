package com.narxoz.rpg.artifact;

public class CurseDetector implements ArtifactVisitor {

    private int curseCount = 0;

    @Override
    public void visit(Weapon weapon) {
        System.out.println(" Curse check: " + weapon.getName() + " - seems safe");
    }

    @Override
    public void visit(Potion potion) {
        if (potion.getHealing() < 0) {
            System.out.println(" CURSE DETECTED in potion: " + potion.getName());
            curseCount++;
        } else {
            System.out.println(" Potion " + potion.getName() + " is clean");
        }
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println(" Curse check: Scroll " + scroll.getName() + " - high risk of curse");
        curseCount++;
    }

    @Override
    public void visit(Ring ring) {
        System.out.println(" Curse check: Ring " + ring.getName());
    }

    @Override
    public void visit(Armor armor) {
        System.out.println(" Armor " + armor.getName() + " - no curse detected");
    }

    public int getCurseCount() {
        return curseCount;
    }
}