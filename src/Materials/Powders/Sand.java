package Materials.Powders;

import Materials.Empty;
import Materials.Grid.MaterialGrid;
import Materials.Liquids.Water;
import Materials.Material;

import static Materials.MaterialTypes.*;

public class Sand extends Powder {
    public Sand(int x,int y){
        super(x,y);
        this.color=(Math.random() < 0.8)? color(227,219,176): color(209, 186, 138);
        type=SAND;
        this.density=1602;
    }

    public void reactWithWater(MaterialGrid grid){
        reactWithMaterial(grid,new Water(x,y),new WetSand(x,y),new Empty(0,0));
    }

    @Override
    public void update(MaterialGrid grid) {
        if(updated){
            return;
        }
        fall(grid);
        reactWithWater(grid);
    }
}
