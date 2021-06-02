package pong;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

public class Rugby extends Kulka {

    protected double rx;
    protected double ry;
    protected double omega;
    protected double rot;

    public Rugby(double xPos, double yPos, double xSpeed, double ySpeed, Color color, double rx, double ry, double omega) {
        super(xPos, yPos, xSpeed, ySpeed, color);
        this.rx = rx;
        this.ry = ry;
        this.omega = omega;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.save();
        graphicsContext.setFill(color);
        graphicsContext.transform(new Affine(new Rotate(rot, xPos, yPos)));
        graphicsContext.fillOval(xPos-rx, yPos-ry, 2*rx, 2*ry);
        graphicsContext.restore();
    }

    @Override
    public void update() {
        super.update();
        rot += omega;
    }

    @Override
    public void checkWallCollision(double xLeft, double yTop, double xRight, double yBottom) {
        if ((xPos <= xLeft+ry*1.5) || (xPos >= xRight-ry*1.5))
            xSpeed = -xSpeed;
        if ((yPos <= yTop+ry*1.5) || (yPos >= yBottom-ry*1.5))
            ySpeed = -ySpeed;
    }
}
