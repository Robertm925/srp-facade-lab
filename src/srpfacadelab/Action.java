package srpfacadelab;

import java.util.List;

public class Action {

    private RpgPlayer player;

    private Item item;

    public Action(RpgPlayer player, Item item)
    {
        this.player = player;
        this.item = item;
    }

    public void useItem() {

        if (item.getName().equals("Stink Bomb"))
        {
            List<IEnemy> enemies = player.getGameEngine().getEnemiesNear(player);

            for (IEnemy enemy: enemies){
                enemy.takeDamage(100);
            }
        }
    }
}
