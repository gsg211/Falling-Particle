package Materials.Powders;

import Materials.Grid.MaterialGrid;

import static Materials.MaterialTypes.SAND;
import static Materials.MaterialTypes.WETSAND;

public class WetSand extends Sand{
    public WetSand(int x,int y){
        super(x,y);
        this.color=color(188, 194, 10);
        this.type=WETSAND;
    }

    @Override
    public void update(MaterialGrid grid) {
        if(updated){
            return;
        }
        fall(grid);
    }
}
