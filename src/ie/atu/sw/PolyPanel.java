package ie.atu.sw;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class PolyPanel extends HBox {
	
	private Polygon p = new Polygon();

	public PolyPanel() {
		super();
		draw();
		super.getChildren().add(p);
		this.setOnMouseClicked(e -> draw());
		// TODO Auto-generated constructor stub
	}

	public void draw() {
		
		p.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
		
		p.setFill(Color.color(Math.random(), Math.random(), Math.random()));

		for (int i = 0; i < 6; i++) {
			p.getPoints().addAll(new Double[] { (100 + 50 * Math.cos(i * 2 * Math.PI / 6)),
					(100 + 50 * Math.sin(i * 2 * Math.PI / 6)) });
		}
	}

}
