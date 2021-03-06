package david.dpaint.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {

	public Circle(int x, int y) {
		super(x, y);
	}
	
	public Circle(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}

	@Override
	public void paint(Graphics g) {
		g.fillOval(getPaintingX(), getPaintingY(), getPaintingWidth(), getPaintingHeight());
		g.setColor(getColor());
		
	}

}
