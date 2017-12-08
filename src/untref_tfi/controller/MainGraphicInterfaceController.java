package untref_tfi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class MainGraphicInterfaceController {
	
	private Image kinectImage;
	private ImageView kinectImageView;
	private ImageView imageRosaView;
	private ImageView imageRosaIconView;
	private ImageCaptureController imageCapture;
	private Scene mainScene;
	
	public MainGraphicInterfaceController(){
		
		imageCapture = new ImageCaptureController(this);
		imageCapture.startImageCapture();
		createKinectImageView(kinectImage);
		createImageRosaView();
		createImageRosaIconView();
		
	}
	
	public Scene getMainScene(){
		
		AnchorPane anchorpane = createAnchorPane();
		StackPane mainPane = new StackPane();
		mainPane.getChildren().add(anchorpane);
		mainPane.setAlignment(Pos.CENTER);
		mainScene = new Scene(mainPane);
		
		return mainScene;
	}
	
	public ImageCaptureController getImageCaptureController(){
		return imageCapture;
	}
		
	public void setImageController(ImageCaptureController imageController) {
		imageCapture = imageController;
	}

	public Image getKinectImage() {
		return kinectImage;
	}

	public void setKinectImage(Image image) {
		kinectImage = image;
	}

	public ImageView getKinectImageView() {
		return kinectImageView;
	}

	public void setKinectImageView(ImageView imageView) {
		kinectImageView = imageView;
	}

	public ImageView getImageRosaView() {
		return imageRosaView;
	}

	public ImageView getImageRosaIconView() {
		return imageRosaIconView;
	}
	
	private void createKinectImageView(Image imagen){
		
		kinectImageView = new ImageView(kinectImage);
		kinectImageView.setPreserveRatio(true);
		kinectImageView.setFitHeight(480);
		kinectImageView.setFitWidth(640);
		kinectImageView.boundsInLocalProperty();
		kinectImageView.setPickOnBounds(true);
		kinectImageView.setOnMouseClicked((MouseEvent e) -> {  System.out.println("["+e.getX()+", "+e.getY()+"]");  });
		
	}

	private AnchorPane createAnchorPane(){
		
		List<Node> principalPaneChildrens = new ArrayList<Node>();
		principalPaneChildrens.addAll(Arrays.asList(imageRosaView,kinectImageView,imageRosaIconView));
		AnchorPane anchorpane = new AnchorPane();
		anchorpane.getChildren().addAll(principalPaneChildrens);
		AnchorPane.setTopAnchor(imageRosaIconView, 20.0);
		AnchorPane.setRightAnchor(imageRosaIconView, 15.0);	
		AnchorPane.setTopAnchor(imageRosaView, 2.0);
		AnchorPane.setBottomAnchor(imageRosaView, 6.0);
		AnchorPane.setLeftAnchor(imageRosaView, 128.0);
		AnchorPane.setTopAnchor(kinectImageView, 272.0);
		AnchorPane.setBottomAnchor(kinectImageView, 272.0);
		AnchorPane.setLeftAnchor(kinectImageView, 320.0);
		
		return anchorpane;
	}
	
	private void createImageRosaIconView() {
		Image imageRosaDeLosVientos = new Image(getClass().getResource("../../resource/images/rosa_de_los_vientos.jpg").toString());
		imageRosaIconView = new ImageView(imageRosaDeLosVientos);
		imageRosaIconView.setPreserveRatio(true);
		imageRosaIconView.setFitHeight(120);
		imageRosaIconView.setFitWidth(160);
	}

	private void createImageRosaView() {
		Image imageRosaDeLosVientos = new Image(getClass().getResource("../../resource/images/rosa_de_los_vientos.jpg").toString());
		imageRosaView = new ImageView(imageRosaDeLosVientos);
		imageRosaView.setPreserveRatio(true);
		imageRosaView.setFitHeight(1024);
		imageRosaView.setFitWidth(1280);
	}

}