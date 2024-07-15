package Materials.Gasses;

import Materials.Grid.MaterialGrid;
import Materials.Material;

import static Materials.MaterialTypes.EMPTY;
import static Materials.MaterialTypes.LIQUID;

public class Gas extends Material {
    int dispersal=2;
    int timeToDisperse=0;
    public Gas(int x,int y){
        super(x,y);
        this.type= LIQUID;
    }

    public void floatUp(MaterialGrid grid) {
        try {
            if (this.y == 0) {
                return;
            }
            //checks up neighbour
            if (grid.grid[this.x][this.y - 1].density < density) {
                this.swap(grid, grid.grid[this.x][this.y - 1]);
                return;
            }
            //checks upper-right neighbour
            if (this.x < grid.size - 1 && grid.grid[this.x + 1][this.y - 1].density < density
                    && grid.grid[this.x + 1][this.y].density < density) {
                this.swap(grid, grid.grid[this.x + 1][this.y - 1]);
                return;
            }
            //checks upper-left neighbour
            if (this.x > 0 && grid.grid[this.x - 1][this.y - 1].density < density
                    && grid.grid[this.x - 1][this.y].density < density) {
                this.swap(grid, grid.grid[this.x - 1][this.y - 1]);
            }
        }
        catch (Exception ArrayIndexOutOfBoundsException){
            println(x+" "+y);
        }
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
        if(this.y==0 || this.x==0 || this.x == grid.size-1){
            return;
        }
        if (grid.grid[this.x][this.y - 1].type == EMPTY) {
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
        this.floatUp(grid);
        this.disperse(grid);
        this.expire(grid);
    }
}
