package Elements;

import processing.core.PApplet;
import Elements.Grid.Grid;

import java.lang.annotation.ElementType;

public class Element extends PApplet{
    public int color;
    public int x,y;
    public ElementTypes type;

    public Boolean canFall=false;
    public Boolean updated=false;
    public Element(){
    }

    public Element(int x, int y){
        this.color =color(0);
        this.x=x;
        this.y=y;
    }

    public void swap(Grid grid,Element elementToSwap){
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

    public void gravity(Grid grid){

    }

    public void update(Grid grid){
        if(updated){
            return;
        }
        if(canFall){
            this.gravity(grid);
        }
    }


}