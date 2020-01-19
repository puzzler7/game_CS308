package breakout;

import javafx.scene.image.Image;

public class TeleBrick extends CircleBrick {
    private TeleBrick portal;

    public TeleBrick(double x, double y) {
        super(x, y);
    }

    public TeleBrick(double x, double y, int health) {
        super(x, y, health);
    }

    public TeleBrick(double x, double y, Image i) {
        super(x, y, i);
    }

    public TeleBrick(double x, double y, int health, double radius) {
        super(x, y, health, radius);
    }

    public static void pair(TeleBrick a, TeleBrick b) {
        a.portal = b;
        b.portal = a;
    }

    @Override
    protected void onHit(Ball b) {
        die();
        b.setCenterX(portal.getCenterX());
        b.setCenterY(portal.getCenterY());
        portal.die();
    }
}
