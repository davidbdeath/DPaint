package david.dpaint.shapes;

import david.dpaint.ToolFrame;
import java.awt.*;

//Abstract Class
//Polymorphism - Rectangle, Circle, Line, Triangle.

public abstract class Shape {
	
	private int x, y, width, height;
	private int paintingX, paintingY, paintingWidth, paintingHeight;
	private Color color;
	private static final int DEFAULT_SIZE = 50;
	
	//Constructor
	public Shape (int x, int y) {
		this.setX(x);
		this.setY(y);
		this.setWidth(DEFAULT_SIZE);
		this.setHeight(DEFAULT_SIZE);
		this.setColor(ToolFrame.getPickedColor());
	}
	
	public Shape(int x, int y, int width, int height, Color color) {
		this.setX(x);
		this.setY(y);
		this.setWidth(width);
		this.setHeight(height);
		this.setColor(color);
	}
	
	public abstract void paint(Graphics g);

	public static int getDefaultSize() {
		return DEFAULT_SIZE;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		paintingX = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		paintingY = y;
	}

	public int getWidth() {
		return width;
	}

//Set Width adjusted for Negative and Positive Painting.
	public void setWidth(int width) {
		this.width = width;
		paintingWidth = Math.abs(width);
		if(width < 0) {
			paintingX = x + width;
		}
	}

	public int getHeight() {
		return height;
	}

//Set Height adjusted for Negative and Positive Painting.
	public void setHeight(int height) {
		this.height = height;
		paintingHeight = Math.abs(height);
		if (height < 0) {
			paintingY = y + height;
		}
	}
	
	public int getPaintingX() {
		return paintingX;
	}

	public int getPaintingY() {
		return paintingY;
	}

	public int getPaintingWidth() {
		return paintingWidth;
	}

	public int getPaintingHeight() {
		return paintingHeight;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
