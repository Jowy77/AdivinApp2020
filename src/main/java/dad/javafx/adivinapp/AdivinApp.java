package dad.javafx.adivinapp;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {

	// ELEMENTOS DE LA INTERFAZ
	private Label infoLabel;
	private TextField numberTextField;
	private Button checkButton;

	// NUMERO A ADIVINAR
	private int AdivinNumber;
	
	//ALERTAS
	private Alert infoAlert;
	private Alert warningAlertMenor;
	private Alert warningAlertMayor;
	private Alert errorAlert;

	@Override
	public void start(Stage primaryStage) throws Exception {

		// INICIALIZO LOS ELEMENTOS
		infoLabel = new Label("Introduce un numero del 1 al 100");

		numberTextField = new TextField("0");
		numberTextField.setAlignment(Pos.CENTER);
		numberTextField.setPrefWidth(100);

		checkButton = new Button("Comprobar");
		checkButton.setOnAction(e -> checkar());
		
		//CONSIGO EL NUMERO A ADIVINAR
		AdivinNumber = getNumeroAleatorio();
		
		//INICIALIZO LOS ALERT
		infoAlert = new Alert(AlertType.INFORMATION);
		infoAlert.setTitle("MADRE MIA WILLY");
		infoAlert.setHeaderText("ERES UN CRACK");
		infoAlert.setContentText("HAS ACERTADO, LO HAS CONSEGUIDO, VUELVE A CASA CON TU MUJER!!!\nAHORA SE REINICIARA EL NUMERO");
		//--------------------------------------------------------
		warningAlertMenor = new Alert(AlertType.WARNING);
		warningAlertMenor.setTitle("UFFFF");
		warningAlertMenor.setHeaderText("CASI MAQUINA");
		warningAlertMenor.setContentText("EL NUMERO ES MENOR!!!");
		//--------------------------------------------------------
		warningAlertMayor = new Alert(AlertType.WARNING);
		warningAlertMayor.setTitle("UFFFF");
		warningAlertMayor.setHeaderText("CASI MAQUINA");
		warningAlertMayor.setContentText("EL NUMERO ES MAYOR!!!");
		//--------------------------------------------------------
		errorAlert = new Alert(AlertType.ERROR);
		errorAlert.setTitle("CUIDADO LOCOOO");
		errorAlert.setHeaderText("TE LA ESTAS JUGANDO!!");
		errorAlert.setContentText("SOLO PUEDES INTRODUCIR NUMEROS ENTEROS!!");
		
		
		VBox root = new VBox(5, infoLabel, numberTextField, checkButton);
		root.setFillWidth(false);
		root.setAlignment(Pos.CENTER);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("AdivinApp");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	// ESTO SE ENCARGA DE PROCESAR EL NUMERO INTRODUCIDO
	private void checkar() {
		try {

			int checkNumero = Integer.parseInt(numberTextField.getText());

			if (checkNumero == AdivinNumber) {

				infoAlert.showAndWait();
				AdivinNumber = getNumeroAleatorio();

				} else if (checkNumero > AdivinNumber) {

					warningAlertMenor.showAndWait();

					} else {
			
						warningAlertMayor.showAndWait();
					}

		} catch (NumberFormatException e) {
			
			errorAlert.showAndWait();
			
		}

	}

	// FUNCION QUE ME PROPORCIONA UN NUMERO ALEATORIO
	private int getNumeroAleatorio() {
		return (int) (Math.random() * 100 + 1);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
