package david.dpaint.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {

	public Line(int x, int y) {
		super(x, y);
	}
	
	public Line(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}

	@Override
	public void paint(Graphics g) {
		g.drawLine(getX(), getY(), getX()+getWidth(), getY()+getHeight());
		g.setColor(getColor());
	}

}
