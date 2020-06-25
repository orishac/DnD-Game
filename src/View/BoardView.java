package View;

import Model.Tile.Tile;
import Model.Tile.Units.Enemy.Enemy;
import Model.Tile.Units.Player.Player;
import Model.Tile.Units.Resource;
import Model.Tile.Units.Stat;
import Model.Tile.Units.Unit;

public class BoardView {

    private TileView[][] boardview;

    public void PrintBoard(Tile[][] board) {
        for(int i = 0; i<board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }
    }

    public void PrintCombatView(Unit attacker, Unit defender, int attackRoll, int defenseRoll, int damage) {
        System.out.print(attacker.getName()+" engaged in combat with "+defender.getName()+".\n");
        System.out.print(attacker.getName()+" rolled "+attackRoll+" attack points.\n");
        System.out.print(defender.getName()+" rolled "+defenseRoll+" defense points.\n");
        if (damage>=0) {
            System.out.print(attacker.getName() + " dealt " + damage + " damage to " + defender.getName() + ".\n");
        }
        else {
            System.out.print(attacker.getName() + " dealt " + 0 + " damage to " + defender.getName() + ".\n");
        }
    }

    public void PrintUnitIsDead(Enemy defender, Unit attacker) {
        System.out.print(defender.getName()+" died. "+attacker.getName()+" gained "+defender.getExperience()+" experience\n");
    }

    public void printWarriorStatus(String name, Resource health, Stat attack, Stat defense, Stat level, Stat experience, Stat remainingCooldown, Stat abilityCooldown) {
        System.out.print(name+"                Health: "+health.getAmount()+"/"+health.getPool()+"" +
                "         Attack: "+attack.getStatPoints()+"              Defense: "+defense.getStatPoints()+
                "              Level: "+level.getStatPoints()+"                Experience: "+experience.getStatPoints()+
                "/"+50*level.getStatPoints()+"                Cooldown: "+remainingCooldown.getStatPoints()+"/"+abilityCooldown.getStatPoints()+"\n");
    }

    public void printMageStatus(String name, Resource health, Stat attack, Stat defense, Stat level, Stat experience, Resource mana, Stat spellPower) {
        System.out.print(name + "                Health: " + health.getAmount() + "/" + health.getPool() + "" +
                "         Attack: " + attack.getStatPoints() + "              Defense: " + defense.getStatPoints() +
                "              Level: " + level.getStatPoints() + "                Experience: " + experience.getStatPoints() +
                "/" + 50 * level.getStatPoints() + "                mana: " + mana.getAmount() + "/" + mana.getPool() +
                "            Spell Power: " + spellPower.getStatPoints() + "\n");
    }

    public void printHunterStatus(String name, Resource health, Stat attack, Stat defense, Stat level, Stat experience, Stat arrowsCount, Stat range) {
        System.out.print(name + "                Health: " + health.getAmount() + "/" + health.getPool() + "" +
                "         Attack: " + attack.getStatPoints() + "              Defense: " + defense.getStatPoints() +
                "              Level: " + level.getStatPoints() + "                Experience: " + experience.getStatPoints() +
                "/" + 50 * level.getStatPoints() + "                Arrows: " + arrowsCount.getStatPoints()+
                "            Range: " + range.getStatPoints() + "\n");
    }

    public void printRogueStatus(String name, Resource health, Stat attack, Stat defense, Stat level, Stat experience, Stat currentEnergy) {
        System.out.print(name + "                Health: " + health.getAmount() + "/" + health.getPool() + "" +
                "         Attack: " + attack.getStatPoints() + "              Defense: " + defense.getStatPoints() +
                "              Level: " + level.getStatPoints() + "                Experience: " + experience.getStatPoints() +
                "/" + 50 * level.getStatPoints() + "                Energy: " + currentEnergy.getStatPoints()+
                "/" + 100 + "\n");
    }

    public void printWarriorAbility(String name, Enemy randomMonster, Stat defense, Resource health, int damage, int enemyRoll) {
        System.out.print(name+" used Avenger's Shield, healing for "+defense.getStatPoints()*10+".\n" +
                        randomMonster.getName()+" rolled "+enemyRoll+" defense points."+"\n" +
                name+" hit "+randomMonster.getName()+" for "+damage+" ability damage."+"\n");
    }
}
