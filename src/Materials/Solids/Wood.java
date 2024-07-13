package Materials.Solids;

import Materials.Grid.MaterialGrid;
import Materials.Material;

import static Materials.MaterialTypes.WOOD;

public class Wood extends Solid {
    public Wood(int x,int y){
        super(x,y);
        this.color=color(153, 102, 0);
        this.type=WOOD;
    }

    @Override
    public void update(MaterialGrid grid) {
        super.update(grid);
    }
}
