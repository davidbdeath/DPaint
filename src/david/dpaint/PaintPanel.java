package david.dpaint;

import david.dpaint.shapes.*;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class PaintPanel extends JPanel {
	
	
	private ArrayList<Shape> shapes;
	private Shape drawingShape = null;
	
	public PaintPanel() {
		shapes = new ArrayList<Shape>();
		
		//MouseMotionListener is an interface
			addMouseMotionListener(new MouseMotionListener() {
				@Override
				public void mouseMoved(MouseEvent e) {
					drawingShape = null;
				}

				@Override
				//MouseDragged is an instanceof
				public void mouseDragged(MouseEvent e) {
					//drawShape is an instance of Shape
					if (drawingShape == null) {
						try {
							if (ToolFrame.getSelectedDrawTool() == "rectangle") {
								shapes.add(drawingShape = new Rectangle(e.getX(), e.getY()));
							} else if (ToolFrame.getSelectedDrawTool() == "circle") {
								shapes.add(drawingShape = new Circle(e.getX(), e.getY()));
							} else if (ToolFrame.getSelectedDrawTool() == "triangle") {
								shapes.add(drawingShape = new Triangle(e.getX(), e.getY()));
							} else {
								shapes.add(drawingShape = new Line(e.getX(), e.getY()));
							}
						} catch (Exception e1) {
							ToolFrame.setSelectedDrawTool("rectangle");
							e1.printStackTrace();
						}
						repaint();
					} else {
						drawingShape.setWidth(e.getX() - drawingShape.getX());
						drawingShape.setHeight(e.getY() - drawingShape.getY());
						repaint();
					}	
				}
			});
	}

	//@Override
	protected void paintComponent(Graphics g) {
		for (Shape shape : shapes) {
			g.setColor(shape.getColor());
			shape.paint(g);
		}
	}

}
