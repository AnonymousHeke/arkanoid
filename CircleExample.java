import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 
import javafx.scene.shape.Circle; 
import javafx.scene.paint.*;
         
public class CircleExample extends Application { 
   @Override 
   public void start(Stage stage) { 

      Circle circle = new Circle() ; 
         
      circle.setCenterX(250.0f) ; 
      circle.setCenterY(250.0f) ; 
      circle.setRadius(20.0f) ;
      circle.setFill(Color.RED) ;
         
      Group root = new Group(circle) ; 
         
      Scene scene = new Scene(root, 500, 500) ;  

      stage.setTitle("Circulo") ; 
         
      stage.setScene(scene) ; 
         
      stage.show() ;
   } 
   public static void main(String args[]) { 
      launch(args) ; 
   } 
}       