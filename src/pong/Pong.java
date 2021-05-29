package pong;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Pong extends Application {

    private static final double WIDTH = 800;
    private static final double HEIGHT = 600;
    private static final double MARGIN = 50;
    private static final double MARGINZERO = 0;
    private static final double ARENAWIDTH = WIDTH - 2*MARGIN;
    private static final double ARENAHEIGHT = HEIGHT - 2*MARGIN;;
    private static final double ARENAX1 = MARGIN;
    private static final double ARENAY1 = MARGIN;
    private static final double ARENAX2 = ARENAX1 + ARENAWIDTH;
    private static final double ARENAY2 = ARENAY1 + ARENAHEIGHT;
    private static final double R = 10;

    private double x = ARENAX1+ARENAWIDTH/2;


    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), actionEvent -> run(gc)));
        timeline.setCycleCount(Timeline.INDEFINITE);

        stage.setTitle("Kulki!");
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();

        timeline.play();


    }

    public static void main(String[] args) {
        launch(args);
    }

    private void run (GraphicsContext graphicsContext){
        graphicsContext.setFill(Color.DARKRED);
        graphicsContext.fillRect(MARGINZERO, MARGINZERO, WIDTH, HEIGHT);

        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(ARENAX1, ARENAY1, ARENAWIDTH, ARENAHEIGHT);

        graphicsContext.setFill(Color.DARKOLIVEGREEN);
        graphicsContext.fillOval(x += 5,ARENAY1+ARENAHEIGHT/2,2*R, 2*R);
    }
}
