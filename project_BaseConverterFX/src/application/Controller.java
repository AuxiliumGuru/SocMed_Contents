package application;

import baseOperator.Compute;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;



public class Controller {
	
	private static Compute compute = new Compute();
	@FXML
	private ComboBox<String> base, ops;
	@FXML
	private TextField fNum, sNum, resField;

	@FXML
	public void compute(ActionEvent e) {
		Compute compute = new Compute();
		String result = compute.getResult(fNum.getText(), sNum.getText(), ops.getValue(), base.getValue());

		resField.setText(result);
	}

	@FXML
	public void reset(ActionEvent e) {
		fNum.setText("");
		sNum.setText("");
		resField.setText("");
		base.setValue(null);
		ops.setValue(null);
	}

	@FXML
	public void initialize() {
		initializeBase();
		initializeOps();
	}

	@FXML
	private void initializeBase() {
		base.setItems(getBase());
	}

	@FXML
	private ObservableList<String> getBase() {
		ObservableList<String> base = FXCollections.observableArrayList(
				"Base 2",
				"Base 8",
				"Base 10",
				"Base 16"
				);
		return base;
	}

	@FXML
	private void initializeOps() {
		ops.setItems(getOps());
	}

	@FXML
	private ObservableList<String> getOps() {
		ObservableList<String> ops = FXCollections.observableArrayList(
				"Add",
				"Subtract",
				"Multiply",
				"Divide"
				);
		return ops;
	}

//	private static String handleAddition(String num1, String num2, String base) {
//		return compute.getResult(num1, num2, "Add", base);
//	}
//	private static String handleSubtraction(String num1, String num2, String base) {
//		return compute.getResult(num1, num2, "Subtract", base);
//	}
//	private static String handleMultiplication(String num1, String num2, String base) {
//		return compute.getResult(num1, num2, "Multiply", base);
//	}

//	private static String handleDivision(String num1, String num2, String base) {
//		return compute.getResult(num1, num2, "Add", base);
//	}


}
