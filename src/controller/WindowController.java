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
import thread.ThreadMinute;



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
	private Label amount;
	private Label showHorse;
	private Label bet;
	private TextField nameC;
	private TextField nameHo;
	private TextField cc1;
	private TextField amount1;
	private Button agr;
	private int contt;
	
	@Override
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
			raceCourse = new RaceCourse();
			startt();
			
			
		
	}
	
	public void startt() {
		
		MenuItem seven  = new MenuItem("7");
		MenuItem eight = new MenuItem("8");
		MenuItem nine  = new MenuItem("9");
		MenuItem ten = new MenuItem("10");
		mb.getItems().clear();
		mb.getItems().addAll(seven,eight,nine,ten);
		
		seven.setOnAction(e -> {
			
			addHorseRider(7);
			number = 7;
			
		});
		eight.setOnAction(e -> {
				
			addHorseRider(8);
			number = 8;
			
		});
		nine.setOnAction(e -> {
				
			addHorseRider(9);
			number = 9;
			
		});
		ten.setOnAction(e -> {

			addHorseRider(10);
			number = 10;
			
		});
	
	}
	public void addHorseRider(int number) {
		
		ap.getChildren().clear();
			
		name = new Label("Horse name");
		name.setLayoutX(0);
		name.setLayoutY(0);
		
		nameC = new TextField();
		nameC.setLayoutX(200);
		nameC.setLayoutY(0);
		
		ap.getChildren().add(name);
		ap.getChildren().add(nameC);
		nameJ = new Label("Rider's name");
		nameJ.setLayoutX(0);
		nameJ.setLayoutY(30);
		
		nameHo = new TextField();
		nameHo.setLayoutX(200);
		nameHo.setLayoutY(30);
		ap.getChildren().add(nameJ);
		ap.getChildren().add(nameHo);
			
		agr  = new Button("Add Rider");
		agr.setLayoutX(0);
		agr.setLayoutY(60);
		ap.getChildren().add(agr);
		
		cont=1;
		
		agr.setOnAction(e ->{
				
				if(cont< number) {
				String nameHorse = nameC.getText();
				String nameJinete = nameHo.getText();
				
				HorseRider hr = new HorseRider(nameHorse,nameJinete,cont);
				
					raceCourse.addHorse(hr);
					
					nameC.setText("");
					nameHo.setText("");
					System.out.println(cont);
					cont++;
				}else if(cont==number) {

					String nameHorse = nameC.getText();
					String nameJinete = nameHo.getText();
					
					HorseRider hr = new HorseRider(nameHorse,nameJinete,cont);
				
						raceCourse.addHorse(hr);
						
						nameC.setText("");
						nameHo.setText("");
						System.out.println(cont);
						ap.getChildren().clear();
					
					Runnable minuteThreads = new ThreadMinute();
					Thread bets = new Thread(minuteThreads);
					bets.start();
					bet(bets);
					contt++;
				}
			
			}
		
		);
		
	}
	
	public void initializeGame() {
		
		Button startGame = new Button("Start Game");
		startGame.setLayoutX(0);
		startGame.setLayoutY(0);
		ap.getChildren().add(startGame);
	
		Button consultBet = new Button("Consult Bet");
		consultBet.setLayoutX(0);
		consultBet.setLayoutY(150);
		
		startGame.setOnAction(e -> {
			cc = new Label(" ------------ PODIUM ------------ ");
			cc.setLayoutX(60);
			cc.setLayoutY(0);
			
			raceCourse.sizeQueue(number);
			
			raceCourse.game();
			startGame.setVisible(false);
			try {
				
				showHorse = new Label(raceCourse.show());
			} catch (Exception e1) {
			
				e1.printStackTrace();
			}
			showHorse.setLayoutX(0);
			showHorse.setLayoutY(30);
			
			ap.getChildren().add(showHorse);
			ap.getChildren().add(consultBet);
			ap.getChildren().add(cc);
	
			
		});
		consultBet.setOnAction(e -> {
		
			searchBet();	
		
		});
	
	
	}
	
	public void searchBet(){
	
		ap.getChildren().clear();
		cc = new Label("Identification number");
		cc.setLayoutX(0);
		cc.setLayoutY(0);
		
		cc1 = new TextField();
		cc1.setLayoutX(200);
		cc1.setLayoutY(0);
		
		ap.getChildren().add(cc);
		ap.getChildren().add(cc1);
		
		Button consultBet = new Button("Consult Bet");
		consultBet.setLayoutX(0);
		consultBet.setLayoutY(30);
		
		ap.getChildren().add(consultBet);

		consultBet.setOnAction(e->{

			bet = new Label( raceCourse.searchBet( cc1.getText()) );
			
			bet.setLayoutX(0);
			bet.setLayoutY(150);
			
			
			ap.getChildren().add(bet);
			cc1.setText("");
			
		});
		
		Button consultNewBet = new Button("Delete and check new bet");
		consultNewBet.setLayoutX(0);
		consultNewBet.setLayoutY(60);
		ap.getChildren().add(consultNewBet);
		consultNewBet.setOnAction(e->{
		
			bet.setText("");
			searchBet();
			
		});
		
		Button remacth = new Button("Rematch");
		remacth.setLayoutX(0);
		remacth.setLayoutY(90);
		
		ap.getChildren().add(remacth);
		
		
		remacth.setOnAction(e->{
			
			ap.getChildren().clear();
			try {
				raceCourse.rematch();
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}	
			
			Runnable minuteThreads = new ThreadMinute();
			Thread bets = new Thread(minuteThreads);
			bets.start();
			
			bet(bets);
			
		});
		
		Button nuevaPartida = new Button("Nueva Partida");
		nuevaPartida.setLayoutX(0);
		nuevaPartida.setLayoutY(120);
		
		ap.getChildren().add(nuevaPartida);
		nuevaPartida.setOnAction(e->{
		
			
		});
		
	}
	
	/*private void remacth() {
		ap.getChildren().clear();
		try {
			raceCourse.rematch();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			showHorse = new Label(raceCourse.showRematch());
		} catch (Exception e1) {
		
			e1.printStackTrace();
		}
		showHorse.setLayoutX(0);
		showHorse.setLayoutY(0);
		
		ap.getChildren().add(showHorse);
		
		Button consultBet = new Button("Consult Bet");
		consultBet.setLayoutX(0);
		consultBet.setLayoutY(150);
		
		ap.getChildren().add(consultBet);

		consultBet.setOnAction(e->{
		
			searchBet();
	});
	}*/

	public void bet(Thread bets) {
		
	
		
		cc = new Label("Identification Number");
		cc.setLayoutX(0);
		cc.setLayoutY(0);
		
		cc1 = new TextField();
		cc1.setLayoutX(200);
		cc1.setLayoutY(0);
		
		ap.getChildren().add(cc);
		ap.getChildren().add(cc1);
		
		name = new Label("Name");
		name.setLayoutX(0);
		name.setLayoutY(30);
		
		nameC = new TextField();
		nameC.setLayoutX(200);
		nameC.setLayoutY(30);
		
		ap.getChildren().add(name);
		ap.getChildren().add(nameC);
		
		nameJ = new Label("Horse track");
		nameJ.setLayoutX(0);
		nameJ.setLayoutY(60);
		
		nameHo = new TextField();
		nameHo.setLayoutX(200);
		nameHo.setLayoutY(60);
		
		ap.getChildren().add(nameJ);
		ap.getChildren().add(nameHo);
		
		amount = new Label("Bet Amount");
		amount.setLayoutX(0);
		amount.setLayoutY(90);
		
		amount1 = new TextField();
		amount1.setLayoutX(200);
		amount1.setLayoutY(90);
		
		ap.getChildren().add(amount);
		ap.getChildren().add(amount1);
		
		Button bett = new Button("Add Bet");
		bett.setLayoutX(0);
		bett.setLayoutY(120);
		ap.getChildren().add(bett);
		
		
		
		try {
			showHorse = new Label(raceCourse.show());
		} catch (Exception e1) {
		
			e1.printStackTrace();
		}
		
		
		showHorse.setLayoutX(0);
		showHorse.setLayoutY(150);
		
		ap.getChildren().add(showHorse);
	
		if(bets.isAlive()){
		
			bett.setOnAction(e->{
		
			String cc = cc1.getText();
			String name = nameC.getText();
			int nameJ = Integer.parseInt(nameHo.getText());
			double monto = Double.parseDouble(amount1.getText());
			Bet b = new Bet(cc,name,nameJ,monto);
			raceCourse.addBet(b);
			
			ap.getChildren().clear();
			
			bet(bets);

		});
		
		}
		else {
			ap.getChildren().clear();
			initializeGame();
		}	
	}

}