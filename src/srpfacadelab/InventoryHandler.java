package srpfacadelab;

public class InventoryHandler {

    private RpgPlayer player;

    public InventoryHandler(RpgPlayer player)
    {
        this.player = player;
    }


    public boolean pickUpItem(Item item) {
        int weight = player.getCurWeight();
        if (weight + item.getWeight() > player.getCarryingCapacity())
            return false;

        if (item.isUnique() && player.getInventory().contains(item))
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

        if (item.isRare())
            player.getGameEngine().playSpecialEffect("cool_swirly_particles");

        if (item.isRare() && item.isUnique())
            player.getGameEngine().playSpecialEffect("blue_swirly");

        player.getInventory().add(item);

        player.setWeight(calculateInventoryWeight());
        calculateStats();

        return true;
    }

    private int calculateInventoryWeight() {
        int sum=0;
        for (Item i: player.getInventory()) {
            sum += i.getWeight();
        }
        return sum;
    }

    private void calculateStats() {
        for (Item i: player.getInventory()) {
            player.setArmour(player.getArmour() + i.getArmour());
        }
    }
}
