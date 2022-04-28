package srpfacadelab;

import java.util.List;

public interface IGameEngine {

    public void playSpecialEffect(String effectName);
    List<srpfacadelab.IEnemy> getEnemiesNear(RpgPlayer player);

}
