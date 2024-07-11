package Materials.Powders;

import Materials.Grid.Grid;

import static Materials.MaterialTypes.LIQUID;
import static Materials.MaterialTypes.SAND;

public class Sand extends Powder {
    public Sand(int x,int y){
        super(x,y);
        this.color=color(239, 245, 66);
        this.type=SAND;
    }

    @Override
    public void update(Grid grid) {
        if(updated){
            return;
        }
        fall(grid);
    }
}
