package srpfacadelab;

public class DamageHandler {

    private RpgPlayer player;

    public DamageHandler(RpgPlayer player)
    {
        this.player = player;
    }

    public void takeDamage(int damage) {
        if (damage < player.getArmour()) {
            player.getGameEngine().playSpecialEffect("parry");
        }

        int damageToDeal = damage - player.getArmour();
        if (player.getCurWeight() < (player.getCarryingCapacity() / 2))
            damageToDeal *= .75;

        player.setHealth(player.getHealth() - damageToDeal);
        player.getGameEngine().playSpecialEffect("lots_of_gore");
    }
}
