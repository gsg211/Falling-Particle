package Materials.Grid;

import Materials.Material;
import Materials.Empty;
import processing.core.PApplet;

/*
    MaterialGrid
*/
public class MaterialGrid extends PApplet {
    private PApplet sketch;

    //a 2d array of materials
    public Material[][] grid;
    public int size;
    public int pixelSize;

    public MaterialGrid(){
    }

    public MaterialGrid(PApplet sketch, int size, int pixelSize){
        this.grid =new Material[size][size];
        this.size=size;
        this.pixelSize=pixelSize;
        this.sketch=sketch;

        //initialises the array with empty materials
        for(int x=0;x<size;x++){
            for(int y=0;y<size;y++){
                grid[x][y]=new Empty(x,y);
            }
        }
    }

    public void setElement(int x, int y, Material element){
        grid[x][y]=element;
    }

    //draws a square representing a pixel on the window
    public void drawPixel(int x,int y,int color){
        sketch.fill(color);
        sketch.stroke(color); //gives the square an outline
        sketch.rect((x)*pixelSize,(y)*pixelSize,pixelSize,pixelSize);//draws the square

    }

    //draws a square for each material
    public void renderGrid(){
        for(int x=0;x<size;x++){
            for(int y=0;y<size;y++){
                Material currentElement=grid[x][y];
                drawPixel(x,y, currentElement.color);
                currentElement.updated=false;
            }
        }
    }
    public void updateGrid(){
        sketch.noLoop();
        for(int x=0;x<size;x++){
            for(int y=0;y<size;y++){
                Material currentElement=grid[x][y];
                currentElement.update(this);
                currentElement.updated=true;
            }
        }
        sketch.loop();
    }

}
