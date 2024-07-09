import Elements.Element;
import Elements.Grid.Grid;
import Elements.Liquids.Liquid;
import processing.core.PApplet;
import processing.core.PSurface;

public class Main extends PApplet{
    int x,y;
    int matrixSize=100;
    int pixelSize=5;

    Grid m=new Grid(this,matrixSize,pixelSize);

    public void settings() {
        size(500, 500);
        x=50;
        y=50;
        m.setElement(x,y,new Liquid(x,y));
    }

    public void draw() {
        //loop();
        m.renderGrid();
        //noLoop();
        m.updateGrid();
    }

    public void mousePressed(){
        int x=mouseX/pixelSize;
        int y=mouseY/pixelSize;
        Element element=new Liquid(x,y);
        m.setElement(x,y,element);

    }

    public static void main(String[] args) {
        String[] processingArgs = {"mySketch"};
        Main mySketch = new Main();
        PApplet.runSketch(processingArgs, mySketch);
    }
}