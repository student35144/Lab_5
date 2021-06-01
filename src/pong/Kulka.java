package pong;

import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Kulka {

    private static final double R = 10;
    private double xSpeed;
    private double ySpeed;
    private double xPos;
    private double yPos;

    Kulka(double xPos, double yPos, double xSpeed, double ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void checkWallCollision(double xLeft, double yTop, double xRight, double yBottom) {
        if ((xPos <= xLeft+R) || (xPos >= xRight-R))
            xSpeed=-xSpeed;
        if ((yPos <= yTop+R) || (yPos >= yBottom-R))
            ySpeed=-ySpeed;
    }

    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.DARKOLIVEGREEN);
        graphicsContext.fillOval(xPos-R, yPos-R, 2*R, 2*R);
    }

    public void update() {
        xPos += xSpeed;
        yPos += ySpeed;
    }
}
