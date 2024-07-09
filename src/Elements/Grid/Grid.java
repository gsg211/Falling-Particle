package Elements.Grid;

import Elements.Element;
import Elements.Empty;
import processing.core.PApplet;


public class Grid extends PApplet {
    private PApplet sketch;

    public Element[][] grid;
    public int size;
    public int pixelSize;

    public Grid(){
    }

    public Grid(PApplet sketch,int size, int pixelSize){
        this.grid =new Element[size][size];
        this.size=size;
        this.pixelSize=pixelSize;
        this.sketch=sketch;

        for(int x=0;x<size;x++){
            for(int y=0;y<size;y++){
                grid[x][y]=new Empty(x,y);
            }
        }
    }

    public void setElement(int x,int y,Element element){
        grid[x][y]=element;
    }


    public void drawPixel(int x,int y,int color){
        sketch.rect(x*pixelSize,y*pixelSize,pixelSize,pixelSize);
        sketch.fill(color);
    }

    public void renderGrid(){
        //sketch.noLoop();
        for(int x=0;x<size;x++){
            for(int y=0;y<size;y++){
                Element currentElement=grid[x][y];
                drawPixel(x,y, currentElement.color);
                currentElement.updated=false;
            }
        }
        //sketch.loop();
    }
    public void updateGrid(){
        sketch.noLoop();
        for(int x=0;x<size;x++){
            for(int y=0;y<size;y++){
                Element currentElement=grid[x][y];
                /*
                if(currentElement.canFall){
                    currentElement.gravity(this);
                }

                 */
                currentElement.update(this);
                currentElement.updated=true;
            }
        }
        sketch.loop();
    }

}
