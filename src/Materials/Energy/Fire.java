package Materials.Energy;

import Materials.Empty;
import Materials.Gasses.Steam;
import Materials.Grid.MaterialGrid;
import Materials.Liquids.Water;
import Materials.Material;

import static Materials.MaterialTypes.FIRE;
import static Materials.MaterialTypes.WATER;

public class Fire extends Material {
    public Fire(int x, int y){
        super(x,y);
        changeColor();
        this.type=FIRE;
        this.density=1001;
        this.lifetime=500;
    }

    public void fall(MaterialGrid grid) {
        if (this.y == grid.size - 1) {
            return;
        }
        //checks down neighbour
        if (grid.grid[this.x][this.y + 1].density < density ) {
            this.swap(grid, grid.grid[this.x][this.y + 1]);
        }
    }

    public void changeColor(){
        this.color=(Math.random() < 0.8)? color(255, 51, 0): color(255, 153, 51);
    }

    public void reactWithWater(MaterialGrid grid){
        reactWithMaterial(grid,new Water(0,0),new Steam(0,0),new Empty(0,0));
    }

    @Override
    public void update(MaterialGrid grid) {
        if(updated){
            return;
        }
        this.fall(grid);
        this.expire(grid);
        this.reactWithWater(grid);
        changeColor();
    }
}
