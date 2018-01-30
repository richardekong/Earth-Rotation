/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EarthRotation;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Ekong Richard
 */
public class EarthRotation extends Application
{
    //start method 
    @Override public void start(Stage s)
    {
        
        
        //create aan image object
        Image img=new Image(getClass().getResource("worldMap.jpg").toExternalForm());
        //create a PhongMaterial
        PhongMaterial pm=new PhongMaterial();
        pm.setDiffuseMap(img);
        //created 3d sphere
        Sphere sp1=new Sphere(200);
        sp1.setTranslateX(0);
        sp1.setTranslateY(0);
        sp1.setRotationAxis(new Point3D(1.0d,1.0d,1.0d));
        sp1.setRotate(0);
        sp1.setMaterial(pm);
        
        //create timeline for animating the soh1
        Timeline t = null;
        int moveTime=0;
        for (int i=0;i<=360;i+=60)
        {
         t=new Timeline(new KeyFrame(Duration.seconds(moveTime),new KeyValue(sp1.rotateProperty(),i))
                                );   
         moveTime++;
        }
        t.setCycleCount(Animation.INDEFINITE);
        t.play();
        
        
        
        //reference layoutout objects
        BorderPane bp=new BorderPane();
        Group g=new Group(sp1);
        bp.setCenter(g);
        //set up the scene
        s.setTitle("Earth Rotation Animation");
        s.setScene(new Scene(bp,1200,1200));
        s.show();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
}
