package david.dpaint.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape {

	public Triangle(int x, int y) {
		super(x, y);
	}

	public Triangle(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}

	//Overloaded getDefaultSize
	public static int getDefaultSize() {
		return 3;
	}
	
	@Override
	public void paint(Graphics g) {
		int[] xAxisArray = {getPaintingX() + (getPaintingWidth()/2), getPaintingX(), getPaintingX() + getPaintingWidth()};
		int[] yAxisArray = {getPaintingY(), getPaintingHeight() + getPaintingY(), getPaintingY() + getPaintingHeight()};
		g.fillPolygon(xAxisArray, yAxisArray, getDefaultSize());
		g.setColor(getColor());
	}
}
