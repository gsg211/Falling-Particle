package Materials.Powders;

import Materials.Grid.MaterialGrid;
import Materials.Material;

import static Materials.MaterialTypes.ASH;

public class Ash extends Powder{
    public Ash(int x, int y){
        super(x,y);
        this.color=(Math.random() < 0.8)? color(153, 153, 153): color(102, 102, 102);
        type=ASH;
        this.density=1702;
    }

    @Override
    public void update(MaterialGrid grid) {
        if(updated){
            return;
        }
        super.update(grid);
        this.fall(grid);
    }
}
