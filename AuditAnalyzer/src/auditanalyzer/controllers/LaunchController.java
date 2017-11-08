/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auditanalyzer.controllers;

import auditanalyzer.models.LaunchModel;
import auditanalyzer.views.LaunchView;

/**
 *
 * @author eelco
 * This class bridges the view to the model.
 * 
 */
public class LaunchController {
    private LaunchView c;
    private LaunchModel m;
    
    public LaunchController(LaunchModel lM, LaunchView lC) {
        this.m = lM;
        this.c = lC;
        
        
    }
}
