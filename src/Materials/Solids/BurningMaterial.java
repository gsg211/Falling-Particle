package Materials.Solids;

import Materials.Empty;
import Materials.Gasses.Steam;
import Materials.Grid.MaterialGrid;
import Materials.Liquids.Water;
import Materials.Material;
import Materials.Powders.Ash;
import Materials.Powders.Sand;

import static Materials.MaterialTypes.FIRE;


public class BurningMaterial extends Solid{
    public BurningMaterial(int x, int y){
        super(x,y);
        this.color=(Math.random() < 0.8)? color(255, 51, 0): color(255, 153, 51);
        type=FIRE;
        this.lifetime=250;
    }

    public void changeColor(){
        this.color=(Math.random() < 0.8)? color(255, 51, 0): color(255, 153, 51);
    }

    @Override
    public void expire(MaterialGrid grid){
        lifetime--;
        if(lifetime==0){
            replaceMaterial(grid,new Ash(0,0));
        }
    }

    public void reactWithWater(MaterialGrid grid){
        reactWithMaterial(grid,new Water(0,0),new Steam(0,0),new Wood(0,0));
    }

    @Override
    public void update(MaterialGrid grid) {
        super.update(grid);
        changeColor();
        reactWithWater(grid);
        expire(grid);

    }
}
