import processing.core.*;

public class App extends PApplet{

    Ellipse hero;
    Ellipse bullet;
    int bulletSpeed = 15;
    float changeX = 0;
    float changeY = 0;
    public static void main(String[] args)  {
        PApplet.main("App");
    }

    public void setup(){
        hero = new Ellipse(this, 500, 500, 100, 100);
        bullet = new Ellipse(this, -100, -100, 20, 20);
        bullet.setFill(255, 0, 0);
    }

    public void settings(){
        size(1200, 1000);
        
    }

    public void draw(){
        background(100);


        bullet.move(changeX, changeY);
       hero.display();
       bullet.display();

    }

    public void mousePressed(){
        bullet.setX(hero.getX());
        bullet.setY(hero.getY());

        float differenceInX = mouseX - hero.getX();
        float differenceInY = mouseY - hero.getY();

        float slope = differenceInY/differenceInX;

        
        changeX = (float)Math.sqrt(bulletSpeed*bulletSpeed/(1+slope*slope));
        if(differenceInX < 0){
            changeX = -changeX;
        }
        changeY = slope*changeX;

        
    }
}
