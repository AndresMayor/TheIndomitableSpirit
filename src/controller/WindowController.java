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
	
	private int number;
	private int cont;
	private Label name;
	private Label nameJ;
	private Label cc;
	private Label monto;
	private TextField nameC;
	private TextField nameJi;
	private TextField cc1;
	private TextField monto1;
	private Button agr;
	private AnchorPane operations;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
			raceCourse = new RaceCourse();
			
			MenuItem siete  = new MenuItem("7");
			MenuItem ocho = new MenuItem("8");
			MenuItem nueve  = new MenuItem("9");
			MenuItem diez = new MenuItem("10");
			mb.getItems().clear();
			mb.getItems().addAll(siete,ocho,nueve,diez);
			
			siete.setOnAction(e -> {
				
					
				addHorseRider(7);
				number = 7;
					
			
				
			});
			ocho.setOnAction(e -> {
				
					
				addHorseRider(8);
				number = 8;
			
				
			});
			nueve.setOnAction(e -> {
				
					
				addHorseRider(9);
				number = 9;
			
				
			});
			diez.setOnAction(e -> {
				
					
				addHorseRider(10);
				number = 10;
			
				
			});
			
			
		
	
	
	}
	
	public void addHorseRider(int number) {
		
		
		ap.getChildren().clear();
		
			
		name = new Label("Nombre del Caballo");
		name.setLayoutX(0);
		name.setLayoutY(0);
		
		nameC = new TextField();
		nameC.setLayoutX(200);
		nameC.setLayoutY(0);
		
		ap.getChildren().add(name);
		ap.getChildren().add(nameC);
		nameJ = new Label("Nombre del Jinete");
		nameJ.setLayoutX(0);
		nameJ.setLayoutY(30);
		
		nameJi = new TextField();
		nameJi.setLayoutX(200);
		nameJi.setLayoutY(30);
		ap.getChildren().add(nameJ);
		ap.getChildren().add(nameJi);
			
		agr  = new Button("Agregar Jinete");
		agr.setLayoutX(0);
		agr.setLayoutY(60);
		ap.getChildren().add(agr);
		
		
		cont=1;
		agr.setOnAction(e ->{
			
				
				if(cont< number) {
				String nameHorse = nameC.getText();
				String nameJinete = nameJi.getText();
				
				HorseRider hr = new HorseRider(nameHorse,nameJinete,cont);
			
					raceCourse.addHorse(hr);
					System.out.println(raceCourse.getHorses().toString());
					nameC.setText("");
					nameJi.setText("");
					System.out.println(cont);
					cont++;
				}else if(cont==number) {

					String nameHorse = nameC.getText();
					String nameJinete = nameJi.getText();
					
					HorseRider hr = new HorseRider(nameHorse,nameJinete,cont);
				
						raceCourse.addHorse(hr);
						System.out.println(raceCourse.getHorses().toString());
						nameC.setText("");
						nameJi.setText("");
						System.out.println(cont);
					ap.getChildren().clear();
					
					apuesta();
					
				}
			
			
		}
		
		);
		
		}
	
	
	public void inicializarPartida() {
		
		Button iniciarPartida = new Button("Iniciar Partida");
		iniciarPartida.setLayoutX(0);
		iniciarPartida.setLayoutY(0);
		
		Button apuesta = new Button("Realizar Apuesta");
		apuesta.setLayoutX(0);
		apuesta.setLayoutY(30);
		
		Button ConsultarApuesta = new Button("Consultar Apuesta");
		ConsultarApuesta.setLayoutX(0);
		ConsultarApuesta.setLayoutY(60);
		ap.getChildren().add(iniciarPartida);
		ap.getChildren().add(apuesta);
		ap.getChildren().add(ConsultarApuesta);
		
	
		
		iniciarPartida.setOnAction(e -> {
			
			raceCourse.sizeQueue(number);
			System.out.print(raceCourse.game().toString());
			
				
		
			
		});
	
		
		
	
	}
	public void apuesta() {
		cc = new Label("Numero de identificacion");
		cc.setLayoutX(0);
		cc.setLayoutY(0);
		
		cc1 = new TextField();
		cc1.setLayoutX(200);
		cc1.setLayoutY(0);
		
		ap.getChildren().add(cc);
		ap.getChildren().add(cc1);
		
		name = new Label("Nombre");
		name.setLayoutX(0);
		name.setLayoutY(30);
		
		nameC = new TextField();
		nameC.setLayoutX(200);
		nameC.setLayoutY(30);
		
		ap.getChildren().add(name);
		ap.getChildren().add(nameC);
		
		
		nameJ = new Label("Numero caballo");
		nameJ.setLayoutX(0);
		nameJ.setLayoutY(60);
		
		nameJi = new TextField();
		nameJi.setLayoutX(200);
		nameJi.setLayoutY(60);
		
		ap.getChildren().add(nameJ);
		ap.getChildren().add(nameJi);
		
		monto = new Label("Monto a apostar");
		monto.setLayoutX(0);
		monto.setLayoutY(90);
		
		monto1 = new TextField();
		monto1.setLayoutX(200);
		monto1.setLayoutY(90);
		
		ap.getChildren().add(monto);
		ap.getChildren().add(monto1);
		
		
		Button apuesta = new Button("Agregar Apuesta");
		apuesta.setLayoutX(0);
		apuesta.setLayoutY(120);
		ap.getChildren().add(apuesta);
		
		apuesta.setOnAction(e->{
			String cc = cc1.getText();
			String name = nameC.getText();
			int nameJ = Integer.parseInt(nameJi.getText());
			double monto = Double.parseDouble(monto1.getText());
			Bet b = new Bet(cc,name,nameJ,monto);
			System.out.println(raceCourse.getBets().toString());
			ap.getChildren().clear();
			apuesta();
			
		});
	}
}

	
	


