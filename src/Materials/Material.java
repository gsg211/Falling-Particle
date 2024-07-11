package Materials;

import processing.core.PApplet;
import Materials.Grid.Grid;

import static Materials.MaterialTypes.EMPTY;

/*
    Base class for the materials
*/

public class Material extends PApplet{
    public int color;
    public int x,y;
    public MaterialTypes type;

    public Boolean updated=false;
    public Material(){
    }

    public Material(int x, int y){
        this.x=x;
        this.y=y;
    }

    //used to swap to materials within the grid
    public void swap(Grid grid, Material elementToSwap){
        int x1,x2,y1,y2;

        x1=this.x;
        x2=elementToSwap.x;
        y1=this.y;
        y2=elementToSwap.y;

        grid.grid[x1][y1]=elementToSwap;
        grid.grid[x2][y2]=this;

        grid.grid[x1][y1].x=x1;
        grid.grid[x1][y1].y=y1;
        grid.grid[x2][y2].x=x2;
        grid.grid[x2][y2].y=y2;
    }

    //makes a material fall to the bottom of the grid
    public void fall(Grid grid) {
        if (this.y == grid.size - 1) {
            return;
        }
        //checks down neighbour
        if (grid.grid[this.x][this.y + 1].type == EMPTY ) {
            this.swap(grid, grid.grid[this.x][this.y + 1]);
            return;
        }
        //checks down-right neighbour
        if (this.x < grid.size - 1 && grid.grid[this.x + 1][this.y + 1].type == EMPTY) {
            this.swap(grid, grid.grid[this.x + 1][this.y + 1]);
            return;
        }
        //checks down-left neighbour
        if (this.x > 0 && grid.grid[this.x - 1][this.y + 1].type == EMPTY ) {
            this.swap(grid, grid.grid[this.x - 1][this.y + 1]);
        }
    }

    public void update(Grid grid){
        //stops materials from updating twice per update cycle
        if(updated){
            return;
        }
        fall(grid);

    }


}