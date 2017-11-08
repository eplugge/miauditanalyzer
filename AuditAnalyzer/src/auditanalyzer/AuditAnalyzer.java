/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auditanalyzer;

import auditanalyzer.controllers.LaunchController;
import auditanalyzer.models.LaunchModel;
import auditanalyzer.views.LaunchView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author eelco
 */
public class AuditAnalyzer extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        LaunchModel m = new LaunchModel();
        LaunchView v = new LaunchView();
        LaunchController c = new LaunchController(m,v);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
