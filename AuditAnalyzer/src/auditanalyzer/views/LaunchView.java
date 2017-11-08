/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auditanalyzer.views;

import java.io.File;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * This class is responsible for the GUI and providing
 * all the setters and getters
 * @author eelco
 */
public class LaunchView {
    Stage stage = new Stage();
    
    public LaunchView() {
        // Create the basic pane to interact with
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(15);
        pane.setHgap(10);
        
        // Add a message to drag drop
        Label lbl_dragdrop = new Label("Drag and Drop your audit files here");
        pane.add(lbl_dragdrop,0,0);
        GridPane.setHalignment(lbl_dragdrop, HPos.CENTER);
        lbl_dragdrop.setMaxWidth(Double.MAX_VALUE);
        
        // Init window and drag and drop handler
        Scene launchScene = new Scene(pane, 500,250);
        launchScene.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                if (db.hasFiles()) {
                    event.acceptTransferModes(TransferMode.COPY);
                } else {
                    event.consume();
                }
            }
        });
        // Dropping over surface
        launchScene.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasFiles()) {
                    success = true;
                    String filePath = null;
                    for (File file:db.getFiles()) {
                        filePath = file.getAbsolutePath();
                        System.out.println(filePath);
                        lbl_dragdrop.setText(filePath);
                    }
                }
                event.setDropCompleted(success);
                event.consume();
            }
        });        
        
        /* Set up the stage to hold the scene */
        stage.setScene(launchScene);
        stage.setTitle("MobileIron Audit Analyzer");
        //stage.getIcons().add( new Image( LaunchView.class.getResourceAsStream( "/resources/ninja_sword.png" ))); 
        stage.show();

        
    }
}
