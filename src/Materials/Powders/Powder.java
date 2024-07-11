package Materials.Powders;

import Materials.Grid.Grid;
import Materials.Material;

import static Materials.MaterialTypes.POWDER;

//Base class for powdery materials like sand

public class Powder extends Material {
    public Powder(int x, int y){
        super(x,y);
        this.type= POWDER;
    }
    @Override
    public void update(Grid grid) {
        super.update(grid);
        this.fall(grid);
    }
}
