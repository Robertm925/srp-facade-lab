package srpfacadelab;

public class PlayerFacade {

    private RpgPlayer player;


    public void useItem(Item item)
    {
        new Action(player, item).useItem();
    }

    public void pickUpItem(Item item)
    {
        new InventoryHandler(player).pickUpItem(item);
    }

    public void takeDamage(int damage)
    {
        new DamageHandler(player).takeDamage(damage);
    }


}
