package pong;

import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Kulka {

    private Color color;
    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }

    private double radius;
    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    private double xSpeed;
    private double ySpeed;
    private double xPos;
    private double yPos;

    Kulka(double xPos, double yPos, double xSpeed, double ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.xPos = xPos;
        this.yPos = yPos;
        color = Color.DARKOLIVEGREEN;
        radius = 10;
    }

    Kulka(double xPos, double yPos, double xSpeed, double ySpeed, Color color) {
        this(xPos, yPos, xSpeed, ySpeed);
        this.color = color;
        radius = 10;
    }

    Kulka(double xPos, double yPos, double xSpeed, double ySpeed, Color color, double radius)
    {
        this(xPos, yPos, xSpeed, ySpeed);
        this.color = color;
        this.radius = radius;
    }

    public void checkWallCollision(double xLeft, double yTop, double xRight, double yBottom) {
        if ((xPos <= xLeft+radius) || (xPos >= xRight-radius))
            xSpeed=-xSpeed;
        if ((yPos <= yTop+radius) || (yPos >= yBottom-radius))
            ySpeed=-ySpeed;
    }

    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(color);
        graphicsContext.fillOval(xPos-radius, yPos-radius, 2*radius, 2*radius);
    }

    public void update() {
        xPos += xSpeed;
        yPos += ySpeed;
    }
}
