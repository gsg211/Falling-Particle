package Materials.Solids;

import Materials.Grid.MaterialGrid;
import Materials.Material;

import static Materials.MaterialTypes.SOLID;

public class Solid extends Material {
    public Solid(int x, int y){
        super(x,y);
        this.type= SOLID;
        this.density=Integer.MAX_VALUE;
    }
    @Override
    public void update(MaterialGrid grid) {
        super.update(grid);
    }
}
