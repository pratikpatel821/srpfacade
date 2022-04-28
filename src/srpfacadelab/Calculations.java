package srpfacadelab;

import static srpfacadelab.RpgPlayer.MAX_CARRYING_CAPACITY;

public class Calculations {
    public Calculations(){}


    void calculateStats(RpgPlayer player) {
        int armour = player.getArmour();
        for (Item i: player.getInventory()) {
            armour += i.getArmour();
        }
        player.setArmour(armour);
    }

    boolean checkIfItemExistsInInventory(RpgPlayer player, Item item) {
        for (Item i: player.getInventory()) {
            if (i.getId() == item.getId())
                return true;
        }
        return false;
    }

    int calculateInventoryWeight(RpgPlayer player) {
        int sum=0;
        for (Item i: player.getInventory()) {
            sum += i.getWeight();
        }
        return sum;
    }

    public void takeDamage(RpgPlayer player, int damage) {
        double totalDamage;
        if(player.getCarryingCapacity() < MAX_CARRYING_CAPACITY/2)
            totalDamage = damage*.75;
        else
            totalDamage = damage;
        if (totalDamage < player.getArmour()) {
            player.getGameEngine().playSpecialEffect("parry");
        }

        double damageToDeal = totalDamage - player.getArmour();
        player.setHealth((int) (player.getHealth() - damageToDeal));

        player.getGameEngine().playSpecialEffect("lots_of_gore");
    }

}
