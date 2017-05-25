
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;

import javafx.application.Application; 

import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.shape.Circle; 
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.*;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;

import javafx.stage.Stage;
import javafx.stage.Stage; 

import javafx.util.Duration;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.util.Random;
         
public class CircleExample extends Application { 
    
   public static final double SCENE_WIDTH = 500;
   public static final double SCENE_HEIGHT = 500; 
   public static final double RADIUS = 5; 
   
   private static double ballXSpeed;
   private static double ballYSpeed;   
   
   private static double playerXSpeed;
   
   
   @Override 
   public void start(Stage stage) 
   {
      int x = new Random().nextInt(495);
      int y = new Random().nextInt(495); 
      ballXSpeed = 2;
      ballYSpeed = 2;
      playerXSpeed = 0; 
      Text gamePaused = new Text("");      
      
      Circle circle = new Circle();          
      circle.setCenterX(x); 
      circle.setCenterY(y); 
      circle.setRadius(RADIUS);
      circle.setFill(Color.RED);
      
      Rectangle player = new Rectangle();
      player.setX(250);
      player.setY(500-15);
      player.setWidth(60);
      player.setHeight(10);
      player.setArcWidth(20);
      player.setArcHeight(20);
      player.setFill(Color.BLUE);   
         
      Group root = new Group(circle, player);    
      Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);  
      stage.setTitle("Arknoid");         
                 
      Timeline timeline = new Timeline();
      KeyFrame keyframe = new KeyFrame(Duration.millis(17), new EventHandler<ActionEvent>() 
      {
          public void handle(ActionEvent event) 
          {
              player.setTranslateX(player.getTranslateX() + playerXSpeed);
              circle.setTranslateX(circle.getTranslateX() + ballXSpeed);
              circle.setTranslateY(circle.getTranslateY() + ballYSpeed);                                          
              
              if(circle.getBoundsInParent().intersects(player.getBoundsInParent()))
              {
                  ballYSpeed *= -1;
              }              
              
              if(circle.getBoundsInParent().getMinX() <= 0 || circle.getBoundsInParent().getMaxX() >= scene.getWidth())
              {
                  ballXSpeed = -ballXSpeed;
              }    
              
              if(player.getBoundsInParent().getMinX() <= 0 || player.getBoundsInParent().getMaxX() >= scene.getWidth())
              {
                  playerXSpeed = 0;
              }                              
              
              if(circle.getBoundsInParent().getMinY() <= 0) 
              {
                  ballYSpeed = -ballYSpeed;  
              }
              else if(circle.getBoundsInParent().getMinY() >= scene.getHeight())
              {
                 Text gameOver = new Text("Game Over");
                 gameOver.setX(230) ; 
                 gameOver.setY(250) ; 
                 root.getChildren().add(gameOver);
                 timeline.stop();                 
              }
                
          }
      }
      );
      
      timeline.getKeyFrames().add(keyframe);
      
      scene.setOnKeyPressed(new EventHandler<KeyEvent>() 
      {
          public void handle(final KeyEvent event) 
          {           
              if(event.getCode() == KeyCode.LEFT)
              {
                  if(player.getBoundsInParent().getMinX() == 0)
                  {
                      playerXSpeed = 0;
                  }
                  else 
                  {
                      playerXSpeed = -2;
                  }
              }
              
              if(event.getCode() == KeyCode.RIGHT)
              {
                  if(player.getBoundsInParent().getMaxX() == SCENE_WIDTH)
                  {
                      playerXSpeed = 0;
                  }              
                  else  
                  {
                      playerXSpeed = 2;
                  }
              }
              
              if(event.getCode() == KeyCode.P)
              {
                  if(!timeline.getStatus().equals(Animation.Status.PAUSED)){
                      gamePaused.setText("Game Paused");
                      timeline.pause();
                      gamePaused.setX(230) ; 
                      gamePaused.setY(250) ; 
                      root.getChildren().add(gamePaused);                      
                  }
                  else 
                  {
                      gamePaused.setText("");                      
                      timeline.playFromStart();                  
                  }                        
              }
          }
      }
      );         
                 
      timeline.setCycleCount(Timeline.INDEFINITE);
      timeline.play();     
      
      stage.setScene(scene);          
      stage.show();      
   } 
   
   public static void main(String args[]) { 
      launch(args) ; 
   } 
}       