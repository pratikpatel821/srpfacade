package srpfacadelab;

import java.util.List;

public class ItemActions {
    public ItemActions(){}

    public void useItem(RpgPlayer player, Item item) {
        if (item.getName().equals("Stink Bomb"))
        {
            List<IEnemy> enemies = player.getGameEngine().getEnemiesNear(player);

            for (IEnemy enemy: enemies){
                enemy.takeDamage(100);
            }
        }
    }

    public boolean pickUpItem(RpgPlayer player, Item item, Calculations calc) {
        int weight = calc.calculateInventoryWeight(player);
        if (weight + item.getWeight() > player.getCarryingCapacity())
            return false;

        if (item.isUnique() && calc.checkIfItemExistsInInventory(player, item))
            return false;

        // Don't pick up items that give health, just consume them.
        if (item.getHeal() > 0) {
            player.setHealth(player.getHealth() + item.getHeal());

            if (player.getHealth() > player.getMaxHealth())
                player.setHealth(player.getMaxHealth());

            if (item.getHeal() > 500) {
                player.getGameEngine().playSpecialEffect("green_swirly");
            }

            return true;
        }


        if (item.isRare()) {
            if(item.isUnique()){
                player.getGameEngine().playSpecialEffect("blue_swirly");
            }else{
                player.getGameEngine().playSpecialEffect("cool_swirly_particles");
            }
        }

        player.setInventory(player.getInventory().add(item));

        calc.calculateStats(player);

        return true;
    }

}
