package srpfacadelab;

public class PlayerFacade {

    private Calculations calculations;
    private ItemActions actions;

    public PlayerFacade(Calculations calculations, ItemActions actions) {
        this.calculations = calculations;
        this.actions = actions;
    }

    public void useItem(RpgPlayer player, Item item) {
        this.actions.useItem(player, item);
    }

    public boolean pickUpItem(RpgPlayer player, Item item) {
        this.actions.pickUpItem(player, item, this.calculations);
    }

    private void calculateStats(RpgPlayer player) {
        this.calculations.calculateStats(player);
    }

    private boolean checkIfItemExistsInInventory(RpgPlayer player, Item item) {
        this.calculations.checkIfItemExistsInInventory(player, item);
    }

    private int calculateInventoryWeight(RpgPlayer player) {
        this.calculations.checkIfItemExistsInInventory(player);
    }

    public void takeDamage(RpgPlayer player, int damage) {
        this.calculations.takeDamage(player, damage);
    }
}
