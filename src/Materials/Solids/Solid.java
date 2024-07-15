package Materials.Solids;

import Materials.Energy.Fire;
import Materials.Grid.MaterialGrid;
import Materials.Material;
import Materials.MaterialTypes;

import static Materials.MaterialTypes.SOLID;

public class Solid extends Material {
    public Solid(int x, int y){
        super(x,y);
        this.type= SOLID;
        this.density=Integer.MAX_VALUE;
    }

    @Override
    public boolean isBurning(MaterialGrid grid){
        if(checkForMaterial(grid,new Fire(0,0)).type!= MaterialTypes.EMPTY){
            return true;
        }
        return false;
    }

    @Override
    public void burn(MaterialGrid grid){
        if(!isBurning(grid)){
            return;
        }
        if(burnDelay>0){
            burnDelay--;
            return;
        }

        reactWithMaterial(grid,new Fire(0,0),new BurningMaterial(0,0),new BurningMaterial(0,0));
    }

    @Override
    public void update(MaterialGrid grid) {
        super.update(grid);
    }
}
