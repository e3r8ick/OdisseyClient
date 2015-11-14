/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odisseyclient;

import java.util.HashMap;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

/**
 *
 * @author erick
 */
public  class ScreensController extends StackPane{
    
    private HashMap<String, Node> screens = new HashMap<>();
    
    public ScreensController(){
        super();
    }
    
     /**
      * PAra agregar ventanas
      * @param name
      * @param screen 
      */
    public void addScreen(String name, Node screen) { 
       screens.put(name, screen); 
    }
    
    public Node getScreen(String name){
        return screens.get(name);
    }
     
    /**
     * arga el archivo fxml especificado por resource, y obtiene el nodo raiz
     * para la pantalla.
     * @param name
     * @param resource
     * @return 
     */
    public boolean loadScreen(String name, String resource) { 
        try { 
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource)); 
            Parent loadScreen = (Parent) myLoader.load(); 
            ControlledScreen myScreenControler = ((ControlledScreen) myLoader.getController()); 
            myScreenControler.setScreenParent(this); 
            addScreen(name, loadScreen); 
            return true; 
        }catch(Exception e) { 
            System.out.println(e.getMessage()); 
            return false; 
        } 
   } 
    
    /**
     * ste método muestra la pantalla especificada con el identificador dado
     * @param name
     * @return 
     */
    public boolean setScreen(final String name) { 
        System.out.println(screens.get(name));
        if(screens.get(name) != null) { //screen loaded 
            final DoubleProperty opacity = opacityProperty(); 

        //Is there is more than one screen 
        if(!getChildren().isEmpty()){ 
            Timeline fade= new Timeline(new KeyFrame(Duration.ZERO, 
                        new KeyValue(opacity,1.0)),
                        new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() { 

                 @Override
                 public void handle(ActionEvent t) { 
                   //remove displayed screen 
                   getChildren().remove(0); 
                   //add new screen 
                   getChildren().add(0, screens.get(name)); 
                   Timeline fadeIn = new Timeline( 
                       new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)), 
                       new KeyFrame(new Duration(800),new KeyValue(opacity, 1.0))); 
                   fadeIn.play(); 
                 } 
               }, new KeyValue(opacity, 0.0))); 
         fade.play(); 
         
        } else { 
            //no one else been displayed, then just show 
            setOpacity(0.0); 
            getChildren().add(screens.get(name)); 
            Timeline fadeIn = new Timeline( 
                new KeyFrame(Duration.ZERO, 
                             new KeyValue(opacity, 0.0)), 
                new KeyFrame(new Duration(2500), 
                             new KeyValue(opacity, 1.0))); 
            fadeIn.play(); 
       } 
        return true; 
    }else { 
         System.out.println("La ventana no ha sido cargada!\n"); 
         return false; 
    } 
   }
    
    public boolean unloadScreen(String name) { 
        if(screens.remove(name) == null) { 
            System.out.println("La ventana no existe"); 
            return false; 
        } else { 
        return true; 
        } 
    } 
     
}
