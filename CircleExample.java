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
         
public class CircleExample extends Application { 
    
   public static double ballSpeed = 2;
   
   @Override 
   public void start(Stage stage) { 

      Circle circle = new Circle();          
      circle.setCenterX(250.0f); 
      circle.setCenterY(250.0f); 
      circle.setRadius(20.0f);
      circle.setFill(Color.RED);
         
      Group root = new Group(circle);          
      Scene scene = new Scene(root, 500, 500);  
      stage.setTitle("Circulo");         
      stage.setScene(scene);          
      stage.show();
      
      // Game loop usando Timeline
      Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() 
      {
          public void handle(ActionEvent ae) 
          {
              circle.setTranslateX(circle.getTranslateX() + ballSpeed);
              circle.setTranslateY(circle.getTranslateY() + ballSpeed);              
            }
       })                
      );
      timeline.setCycleCount(Timeline.INDEFINITE);
      timeline.play();       
   } 
   
   public static void main(String args[]) { 
      launch(args) ; 
   } 
}       