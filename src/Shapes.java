
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Shapes extends Application
{
private String aUserInput;  
private String bUserInput;
private static final String STRTRIANGLE = "triangle";
private static final String STRRECTANGLE = "rectangle";
private static final String STRHEXAGON = "hexagon";
private static final String STRRED = "red";
private static final String STRGREEN = "green";
private static final String STRGREY = "grey";
private static final String EMPTY = "";
private Polygon triangle = new Polygon(60, 125, 150, 55, 240, 125);
private Polygon hexagon = new Polygon(90.0, 15.0, 190.0, 15.0, 215.0, 65.0, 190.0, 115.0, 90.0, 115.0, 65.0, 65.0);
private Rectangle rectangle = new Rectangle(125, 65);

@Override    
public void start(Stage stage)    
{
//Setting default visibility of shapes and grouping them to be added to VBox
rectangle.setVisible(false);
triangle.setVisible(false);
hexagon.setVisible(false);
Group group = new Group(hexagon, rectangle, triangle);

//User Instructions
Label infoLabel= new Label();        
infoLabel.setTextFill(Color.BLACK);        
infoLabel.setFont(Font.font("Arial", 22));
infoLabel.setText("Enter a shape in the top box and a colour in the bottom box");

// Text field for user shape entry        
TextField shapeTextField = new TextField();        
shapeTextField.setMaxWidth(250);

//Label to display feedback        
Label shapeLabel= new Label();        
shapeLabel.setTextFill(Color.RED);        
shapeLabel.setFont(Font.font("Arial", 20));

//Button to output or feedback on user input      
Button shapeButton = new Button();        
shapeButton.setText("Select from: triangle, rectangle or hexagon");        
shapeButton.setOnAction(e ->
{
aUserInput = shapeTextField.getText();

switch(aUserInput.toLowerCase()) {
case EMPTY:
shapeLabel.setText("Nothing entered. Please enter rectangle, triangle or hexagon");
shapeLabel.setVisible(true);
rectangle.setVisible(false);
triangle.setVisible(false);
hexagon.setVisible(false);
break;
   case STRRECTANGLE:
    rectangle.setVisible(true);
triangle.setVisible(false);
hexagon.setVisible(false);
shapeLabel.setVisible(false);
break;
case STRTRIANGLE:
triangle.setVisible(true);
rectangle.setVisible(false);
hexagon.setVisible(false);
shapeLabel.setVisible(false);
break;
case STRHEXAGON:
hexagon.setVisible(true);
rectangle.setVisible(false);
triangle.setVisible(false);
shapeLabel.setVisible(false);
break;
default:
shapeLabel.setText(shapeTextField.getText() + " is not a valid shape. Please enter "
+ "rectangle, triangle or hexagon" );
shapeLabel.setVisible(true);
rectangle.setVisible(false);
triangle.setVisible(false);
hexagon.setVisible(false);
break;
}
}
);

//Text field for user colour entry  
TextField colourTextField = new TextField();        
colourTextField.setMaxWidth(250);

//Label to display feedback          
Label colourLabel= new Label();        
colourLabel.setTextFill(Color.RED);        
colourLabel.setFont(Font.font("Arial", 20));

//Button to output or feedback on user input        
Button colourButton = new Button();        
colourButton.setText("Select from: red, green or grey");  
colourButton.setOnAction(e ->
{
bUserInput = colourTextField.getText();
var colour = javafx.scene.paint.Color.BLACK;  

switch(bUserInput.toLowerCase()) {
case EMPTY:
colourLabel.setText("Nothing entered. Please enter red, green or grey");
colourLabel.setVisible(true);
break;
   case STRRED:
   colour = javafx.scene.paint.Color.RED;
colourLabel.setVisible(false);
break;
case STRGREEN:
colour = javafx.scene.paint.Color.GREEN;
colourLabel.setVisible(false);
break;
case STRGREY:
colour = javafx.scene.paint.Color.GREY;
colourLabel.setVisible(false);
break;
default:
colourLabel.setText(colourTextField.getText() + " is not a valid colour. Please select "
+ "red, green or grey" );
colourLabel.setVisible(true);
break;
} // end of Switch statement
rectangle.setFill(colour);  
triangle.setFill(colour);
hexagon.setFill(colour);
} 
);

//VBox for components              
VBox root = new VBox();        
root.setSpacing(12);        
root.setAlignment(Pos.CENTER);

//Adding components to the VBox        
root.getChildren().addAll(group, shapeTextField, shapeButton, shapeLabel, colourTextField, colourButton, colourLabel, infoLabel);

//Create scene        
Scene scene = new Scene(root, 650, 450);  

//Adding scene to stage        
stage.setScene(scene);        
stage.setTitle("Shape Creator");        
stage.show();  
}    

public static void main(String[] args)    
{        
launch(args);    
}
}
