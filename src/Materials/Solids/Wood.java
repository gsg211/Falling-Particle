package Materials.Solids;

import Materials.Grid.MaterialGrid;
import Materials.Material;

import static Materials.MaterialTypes.WOOD;

public class Wood extends Solid {
    public Wood(int x,int y){
        super(x,y);
        this.color=(Math.random() < 0.8)? color(128, 85, 0): color(102, 68, 0);
        this.type=WOOD;
        this.burnDelay=5;
    }

    @Override
    public void update(MaterialGrid grid) {
        super.update(grid);
        super.burn(grid);
    }
}
