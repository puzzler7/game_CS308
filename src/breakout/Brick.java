package breakout;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public abstract class Brick {
    protected Shape shape;
    protected int hp;
    protected ImagePattern image;
    protected boolean mustBeHit = true;

    abstract void setCenterX(double x);//FIXME do a thing with getBoundinLocal/Parent?
    abstract void setCenterY(double y);
    abstract double getCenterX();
    abstract double getCenterY();

    public void checkBallCollision(ArrayList<Ball> balls) {
        for (Ball b : balls) {
            Shape intersection = Shape.intersect(shape, b);
            if (intersection.getBoundsInLocal().getWidth() != -1) {
                onHit(b);
            }
        }
    }

    protected void onHit(Ball b) {
        b.setYVelocity(-b.getYVelocity());//FIXME side bounce
        hit(b.getDmg()); //FIXME dmg numbers vary by ball?
    }

    public int getHp() {
        return hp;
    }

    public void setHP(int health) {
        hp = health;
    }

    public Shape getShape() {
        return shape;
    }

    public void hit(int dmg) {
        hp -= dmg;
        if (hp<=0) die();
    }

    public void die() {
        setCenterX(-Main.WIDTH*2); //FIXME better soln?
        setCenterY(-Main.HEIGHT*2);
    }

    public boolean getMustBeHit() {
        return mustBeHit;
    }

    public void setMustBeHit(boolean hit) {
        mustBeHit = hit;
    }
}
