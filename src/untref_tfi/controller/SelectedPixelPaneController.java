package untref_tfi.controller;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class SelectedPixelPaneController {

	private static final String EMPTY_VALUE = "";
	private final TextField yPos;
	private final VBox pane;
	private final TextField xPos;

	public SelectedPixelPaneController(String paneName) {
		Label title = new Label(paneName);
		Label x = new Label("x");
		xPos = new TextField(EMPTY_VALUE);
		xPos.setEditable(false);
		xPos.setMaxWidth(40);
		Label y = new Label("y");
		this.yPos = new TextField(EMPTY_VALUE);
		this.yPos.setEditable(false);
		this.yPos.setMaxWidth(40);
		this.pane = new VBox();
		this.pane.getChildren().addAll(title, x, this.xPos, y, this.yPos);
	}

	public VBox getPane() {
		return this.pane;
	}

	public boolean setedValues() {
		return !EMPTY_VALUE.equals(xPos.getText()) && !EMPTY_VALUE.equals(yPos.getText());
	}

	public void setXYvalues(int x, int y) {
		xPos.setText(String.valueOf(x));
		yPos.setText(String.valueOf(y));
	}

	public void clearValues() {
		xPos.setText(EMPTY_VALUE);
		yPos.setText(EMPTY_VALUE);
	}

	public XYpoint getXYpoint(){
		return new XYpoint(Integer.valueOf(yPos.getText()), Integer.valueOf(xPos.getText()));
	}
}