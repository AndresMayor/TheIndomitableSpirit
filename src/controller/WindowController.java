package controller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.*;


public class WindowController implements Initializable {

	
	private RaceCourse raceCourse;
	
	
	@FXML
	private AnchorPane ap;
	
	@FXML
	private MenuButton mb;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
			
			MenuItem siete  = new MenuItem("7");
			MenuItem ocho = new MenuItem("8");
			MenuItem nueve  = new MenuItem("9");
			MenuItem diez = new MenuItem("10");
			mb.getItems().clear();
			mb.getItems().addAll(siete,ocho,nueve,diez);
			
			siete.setOnAction(e -> {
				
					
				addHorseRider(7);
				
			
				
			});
			ocho.setOnAction(e -> {
				
					
				addHorseRider(8);
				
			
				
			});
			nueve.setOnAction(e -> {
				
					
				addHorseRider(9);
				
			
				
			});
			diez.setOnAction(e -> {
				
					
				addHorseRider(10);
				
			
				
			});
			
			
		
	
	
	}
	
	public void addHorseRider(int number) {
		
		//con ese numero que llega por  parametros pienso en respetir  eso  esas veces
		
		ap.getChildren().clear();
		
		
		
			
		Label name = new Label("Nombre del Caballo");
		name.setLayoutX(0);
		name.setLayoutY(0);
		
		TextField nameC = new TextField();
		nameC.setLayoutX(200);
		nameC.setLayoutY(0);
		
		ap.getChildren().add(name);
		ap.getChildren().add(nameC);
		Label nameJ = new Label("Nombre del Jinete");
		nameJ.setLayoutX(0);
		nameJ.setLayoutY(30);
		
		TextField nameJi = new TextField();
		nameJi.setLayoutX(200);
		nameJi.setLayoutY(30);
		ap.getChildren().add(nameJ);
		ap.getChildren().add(nameJi);
		
		
		Label track = new Label("Pista");
		track.setLayoutX(0);
		track.setLayoutY(60);
		
		TextField trackK = new TextField();
		trackK.setLayoutX(200);
		trackK.setLayoutY(60);
		ap.getChildren().add(track);
		ap.getChildren().add(trackK);
		
		Button agr  = new Button("Agregar Jinete");
		agr.setLayoutX(0);
		agr.setLayoutY(90);
		ap.getChildren().add(agr);
		
		
		
		agr.setOnAction(e ->{
			
			int n =Integer.parseInt(trackK.getText());
			String nameHorse = nameC.getText();
			String nameJinete = nameJi.getText();
			
			HorseRider hr = new HorseRider(nameHorse,nameJinete,n);
		
				raceCourse.addHorse(hr);
				
			
		}
		
		);
		
		}
		
	}

	
	


