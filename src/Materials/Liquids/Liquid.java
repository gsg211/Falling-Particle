package Materials.Liquids;

import Materials.Grid.Grid;
import Materials.Material;

import static Materials.MaterialTypes.*;

//base class for liquids

public class Liquid extends Material {
    int dispersal=2;
    int timeToDisperse=0;
    public Liquid(int x,int y){
        super(x,y);
        this.type= LIQUID;
    }

    public void disperseRight(Grid grid){
            if (grid.grid[this.x + 1][this.y].type==EMPTY){
                moveRight(grid);
            }
    }

    public void disperseLeft(Grid grid){
        if (grid.grid[this.x - 1][this.y].type==EMPTY) {
            moveLeft(grid);
        }
    }

    public void disperse(Grid grid){
        if(this.y==grid.size-1 || this.x==0 || this.x == grid.size-1){
            return;
        }
        //if (grid.grid[this.x][this.y + 1].type == EMPTY) {
         //   return;
        //}
        if(timeToDisperse!=0){
            timeToDisperse--;
            return;
        }
        if (grid.grid[this.x][this.y + 1].type != EMPTY) {
            timeToDisperse=dispersal;
            //if both left and right are free move right
            if (grid.grid[this.x + 1][this.y].type == EMPTY &&
                    grid.grid[this.x - 1][this.y].type == EMPTY) {
                disperseRight(grid);
            } else if (grid.grid[this.x + 1][this.y].type == EMPTY) {
                disperseRight(grid);
            } else if (grid.grid[this.x - 1][this.y].type == EMPTY) {
                disperseLeft(grid);
            }
        }
    }

    @Override
    public void update(Grid grid) {
        if(updated){
            return;
        }
        super.update(grid);
        this.fall(grid);
        this.disperse(grid);
    }
}
