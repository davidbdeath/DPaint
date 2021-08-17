package david.dpaint.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	public Rectangle(int x, int y) {
		super(x, y);
	}
	
	public Rectangle(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}

	@Override
	public void paint(Graphics g) {
		g.fillRect(getPaintingX(), getPaintingY(), getPaintingWidth(), getPaintingHeight());
		g.setColor(getColor());
	}
}
