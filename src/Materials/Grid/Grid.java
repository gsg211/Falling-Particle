package Materials.Grid;

import Materials.Liquids.Liquid;
import Materials.Material;
import Materials.Empty;
import processing.core.PApplet;

public class Grid extends PApplet {
    private PApplet sketch;

    public Material[][] grid;
    public int size;
    public int pixelSize;

    public Grid(){
    }

    public Grid(PApplet sketch,int size, int pixelSize){
        this.grid =new Material[size][size];
        this.size=size;
        this.pixelSize=pixelSize;
        this.sketch=sketch;

        for(int x=0;x<size;x++){
            for(int y=0;y<size;y++){
                grid[x][y]=new Empty(x,y);
            }
        }
    }

    public void setElement(int x, int y, Material element){
        grid[x][y]=element;
    }


    public void drawPixel(int x,int y,int color){
        /*
        sketch.square(x*pixelSize,y*pixelSize,pixelSize+2,pixelSize+2);
        sketch.fill(color);
        sketch.arc();
         */
        //sketch.rectMode(CORNER);
        sketch.fill(color);
        sketch.stroke(color);
        sketch.rect((x)*pixelSize,(y)*pixelSize,5,5);
        //sketch.set(x,y,color);
    }

    public void renderGrid(){
        for(int x=0;x<size;x++){
            for(int y=0;y<size;y++){
                Material currentElement=grid[x][y];
                drawPixel(x,y, currentElement.color);
                currentElement.updated=false;
                //System.out.print(x+" ");
            }
           // System.out.println();
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
