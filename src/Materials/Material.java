package Materials;

import processing.core.PApplet;
import Materials.Grid.Grid;

import static Materials.MaterialTypes.EMPTY;

public class Material extends PApplet{
    public int color;
    public int x,y;
    public MaterialTypes type;

    public Boolean canFall=false;
    public Boolean updated=false;
    public Material(){
    }

    public Material(int x, int y){
        this.color =color(0);
        this.x=x;
        this.y=y;
    }

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

    public void gravity(Grid grid) {
        if (!canFall || this.y == grid.size - 1) {
            return;
        }
        try {


            if (grid.grid[this.x][this.y + 1].type == EMPTY ) {
                this.swap(grid, grid.grid[this.x][this.y + 1]);
                return;
            }
            if (this.x < grid.size - 1 && grid.grid[this.x + 1][this.y + 1].type == EMPTY) {
                this.swap(grid, grid.grid[this.x + 1][this.y + 1]);
                return;
            }
            if (this.x > 0 && grid.grid[this.x - 1][this.y + 1].type == EMPTY ) {
                this.swap(grid, grid.grid[this.x - 1][this.y + 1]);
            }
        }
        catch (Exception ArrayIndexOutOfBoundsException){
            System.out.println("Out of bounds:"+x+" "+y);
        }

    }

    public void update(Grid grid){
        if(updated){
            return;
        }
        this.gravity(grid);
    }


}