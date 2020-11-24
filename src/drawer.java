
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.db.connecToDb;

import javafx.application.Application;
	import javafx.scene.Node;
	import javafx.scene.Scene;
	import javafx.scene.canvas.Canvas;
	import javafx.scene.canvas.GraphicsContext;
	import javafx.scene.control.Button;
	import javafx.scene.control.TextField;
	import javafx.scene.layout.BorderPane;
	import javafx.scene.layout.Pane;
	import javafx.scene.paint.Color;
	import javafx.scene.shape.ArcType;
	import javafx.stage.Stage;

import javafx.event.EventHandler;
	import javafx.event.ActionEvent;
	
public class drawer extends Application  {

	
	

 
	
		public void start (Stage primaryStage)
		{
			
			
			
	
	
			 
			 
			 
			 primaryStage.setTitle("Assignment 3");
		        Canvas canvas = new Canvas(1000, 1000);
		        GraphicsContext gc = canvas.getGraphicsContext2D();
		        gpadraw.drawpiechart(gc,3);
		      
		        BorderPane root = new BorderPane(canvas);
		        primaryStage.setScene(new Scene(root));
		        primaryStage.show();
		}
		
		
		public static void main(String[] args)
		{
			launch(args); 
		}// TODO Auto-generated method stub

		
		
		
}

