import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 
import javafx.scene.shape.Circle; 
import javafx.scene.paint.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.layout.HBoxBuilder;
import javafx.animation.Animation;
         
public class CircleExample extends Application { 
    
   public static double ballSpeed = 2;
   
   @Override 
   public void start(Stage stage) { 
      Button startStopButton = new Button("Start/Stop");
      Circle circle = new Circle();          
      circle.setCenterX(250.0f); 
      circle.setCenterY(250.0f); 
      circle.setRadius(20.0f);
      circle.setFill(Color.RED);
         
      Group root = new Group(circle);    
      root.getChildren().add(startStopButton);
      Scene scene = new Scene(root, 500, 500);  
      stage.setTitle("Circulo");         
      stage.setScene(scene);          
      stage.show();
      
      Timeline timeline = new Timeline(
      new KeyFrame(Duration.millis(17), new EventHandler<ActionEvent>() 
      {
          public void handle(ActionEvent event) 
          {
              circle.setTranslateX(circle.getTranslateX() + ballSpeed);
              circle.setTranslateY(circle.getTranslateY() + ballSpeed);              
          }
      }
      )
      );
      
      startStopButton.setOnAction(new EventHandler<ActionEvent>() 
      {
          @Override
          public void handle(ActionEvent event) 
          {
              if(!timeline.getStatus().equals(Animation.Status.PAUSED)){
                  timeline.pause();
              }
              else 
              {
                  timeline.playFromStart();               
              }               
          }
      }
      );
   
   
      
      timeline.setCycleCount(Timeline.INDEFINITE);
      timeline.play();       
   } 
   
   public static void main(String args[]) { 
      launch(args) ; 
   } 
}       