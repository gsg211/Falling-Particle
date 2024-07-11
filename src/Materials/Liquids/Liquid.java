package Materials.Liquids;

import Materials.Grid.Grid;
import Materials.Material;


import static Materials.MaterialTypes.LIQUID;

//base class for liquids

public class Liquid extends Material {

    public Liquid(int x,int y){
        super(x,y);
        this.type= LIQUID;
    }

    @Override
    public void update(Grid grid) {
        super.update(grid);
        this.fall(grid);
    }
}
