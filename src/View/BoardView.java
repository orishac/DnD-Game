package View;

import Model.Tile.Tile;
import Model.Tile.Units.Enemy.Enemy;
import Model.Tile.Units.Player.Mage;
import Model.Tile.Units.Player.Player;
import Model.Tile.Units.Resource;
import Model.Tile.Units.Stat;
import Model.Tile.Units.Unit;

public class BoardView {//this class is used to print out messages to the user.

    public void PrintBoard(Tile[][] board) {
        for(int i = 0; i<board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j].toString());
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

    public void printWarriorAbility(String name, Enemy randomMonster, Stat defense, Resource health, int damage) {
        System.out.print(name+" used Avenger's Shield, healing for "+defense.getStatPoints()*10+".\n" +
                name+" hit "+randomMonster.getName()+" for "+damage+" ability damage."+"\n");
    }

    public void printMageSpecialAbility(Mage mage, Enemy monster, int monsterDefense, int statPoints) {
        System.out.print(mage.getName()+" cast Blizzard.\n"+
                monster.getName()+" rolled "+monsterDefense+" defense points.\n" +
                mage.getName()+" hit "+monster.getName()+" for "+statPoints+" ability damage.\n");
    }

    public void printHunterSpecialAbility(String name,String enemyName,int defense, int statPoints) {
        System.out.println(name+" used Shoot.\n"+
                enemyName+" rolled "+defense+ "defense points.\n"+
                name+" hit "+enemyName+" for "+statPoints+" ability damage.\n");
    }

    public void printRogueSpecialAbility(String name,String enemyName, int defense, int statPoints) {
        System.out.println(name+" used Fan Of Knives.\n"+
                enemyName+" rolled "+defense+ "defense points.\n"+
                name+" hit "+enemyName+" for "+statPoints+" ability damage.\n");
    }

    public void abilityError() {
        System.out.println("cannot use special ability");
    }

    public void printGameOver() {
        System.out.println("You lost.\n"+
                "Game Over.\n"+
                "Run the program again to play again.");
    }

    public void printGameFinish() {
        System.out.println("You Won!\n+" +
                "Run the program again to play again.");
    }

    public void showPlayers() {
        System.out.println("Select player:\n" +
                "1. Jon Snow             Health: 300/300         Attack: 30              Defense: 4              Level: 1                Experience: 0/50                Cooldown: 0/3 \n" +
                "2. The Hound            Health: 400/400         Attack: 20              Defense: 6              Level: 1                Experience: 0/50                Cooldown: 0/5 \n" +
                "3. Melisandre           Health: 100/100         Attack: 5               Defense: 1              Level: 1                Experience: 0/50                Mana: 75/300            Spell Power: 15 \n" +
                "4. Thoros of Myr        Health: 250/250         Attack: 25              Defense: 4              Level: 1                Experience: 0/50                Mana: 37/150            Spell Power: 20 \n" +
                "5. Arya Stark           Health: 150/150         Attack: 40              Defense: 2              Level: 1                Experience: 0/50                Energy: 100/100 \n" +
                "6. Bronn                Health: 250/250         Attack: 35              Defense: 3              Level: 1                Experience: 0/50                Energy: 100/100 \n" +
                "7. Ygritte              Health: 220/220         Attack: 30              Defense: 2              Level: 1                Experience: 0/50                Arrows: 10              Range: 6 \n");
    }
}
