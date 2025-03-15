package Materials.Liquids;

import Materials.Grid.MaterialGrid;
import Materials.Material;
import Materials.MaterialStates;

import static Materials.MaterialTypes.*;

//base class for liquids

public class Liquid extends Material {
    int dispersal=2;
    int timeToDisperse=0;
    public Liquid(int x,int y){
        super(x,y);
        this.type= LIQUID;
        this.state= MaterialStates.FLUID;
    }

    public void disperseRight(MaterialGrid grid){
        if (grid.grid[this.x + 1][this.y].type==EMPTY){
            moveRight(grid);
        }
    }

    public void disperseLeft(MaterialGrid grid){
        if (grid.grid[this.x - 1][this.y].type==EMPTY) {
            moveLeft(grid);
        }
    }

    public void disperse(MaterialGrid grid){
        if(this.y==grid.size-1 || this.x==0 || this.x == grid.size-1){
            return;
        }
        if (grid.grid[this.x][this.y + 1].type == EMPTY) {
            return;
        }
        if(timeToDisperse!=0){
            timeToDisperse--;
            return;
        }
        timeToDisperse=dispersal;
        if (grid.grid[this.x + 1][this.y].type == EMPTY &&
                grid.grid[this.x - 1][this.y].type == EMPTY) {
            //disperseRight(grid);
            if ((Math.random() > 0.5)) {
                disperseRight(grid);
            } else {
                disperseLeft(grid);
            }
        }
        else if (grid.grid[this.x + 1][this.y].type == EMPTY) {
            disperseRight(grid);
        }
        else if (grid.grid[this.x - 1][this.y].type == EMPTY) {

            disperseLeft(grid);
        }
    }

    @Override
    public void update(MaterialGrid grid) {
        if(updated){
            return;
        }
        super.update(grid);
        this.fall(grid);
        this.disperse(grid);
    }
}
