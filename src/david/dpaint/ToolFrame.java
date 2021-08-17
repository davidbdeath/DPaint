package david.dpaint;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ToolFrame extends JFrame {

	private JPanel tools;
	private JTextField redLabel;
	private JTextField greenLabel;
	private JTextField blueLabel;
	
//Color Variables
	private static int rValue;
	private static int gValue;
	private static int bValue;
	private static Color pickedColor = new Color(rValue, gValue, bValue);
	
//Drawing Tool
	private static String selectedDrawTool = "rectangle";
	
//Color Picker Getter
	public static Color getPickedColor() {
		return pickedColor;
	}
	
//Drawing Tool Getter & Setter
	public static String getSelectedDrawTool() {
		return selectedDrawTool;
	}

	public static void setSelectedDrawTool(String DrawTool) {
		selectedDrawTool = DrawTool;
	}
	
//Tool Menu
	public ToolFrame() {
		setResizable(false);
		setType(Type.UTILITY);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(125, 125, 90, 460);
		tools = new JPanel();
		tools.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(tools);
		tools.setLayout(null);
		
		JPanel shapeSelectionMenu = new JPanel();
		shapeSelectionMenu.setBounds(5, 5, 80, 120);
		tools.add(shapeSelectionMenu);
		shapeSelectionMenu.setLayout(null);
		
	//Tool Selection
		JButton buttonRectangle = new JButton("Rectangle");
		buttonRectangle.setBounds(0, 0, 80, 30);
		shapeSelectionMenu.add(buttonRectangle);
		buttonRectangle.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		
		JButton buttonCircle = new JButton("Circle");
		buttonCircle.setBounds(0, 30, 80, 30);
		shapeSelectionMenu.add(buttonCircle);
	
		JButton buttonTriangle = new JButton("Triangle");
		buttonTriangle.setBounds(0, 60, 80, 30);
		shapeSelectionMenu.add(buttonTriangle);
		
		JButton buttonLine = new JButton("Line");
		buttonLine.setBounds(0, 90, 80, 30);
		shapeSelectionMenu.add(buttonLine);
		
		buttonLine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setSelectedDrawTool("line");
			}
		});
		
		buttonTriangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setSelectedDrawTool("triangle");
			}
		});
		
		buttonCircle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setSelectedDrawTool("circle");
			}
		});
		
		buttonRectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setSelectedDrawTool("rectangle");
			}
		});
		
		
	//Color Picker Panel
		JPanel colorPickerMenu = new JPanel();
		colorPickerMenu.setBackground(pickedColor);
		colorPickerMenu.setBounds(14, 130, 61, 275);
		tools.add(colorPickerMenu);
		colorPickerMenu.setLayout(null);
		
	//Color Picker Labels
		redLabel = new JTextField();
		redLabel.setBounds(0, 0, 20, 26);
		colorPickerMenu.add(redLabel);
		redLabel.setEditable(false);
		redLabel.setText("R");
		redLabel.setHorizontalAlignment(SwingConstants.CENTER);
		redLabel.setColumns(10);

		greenLabel = new JTextField();
		greenLabel.setBounds(20, 0, 20, 26);
		colorPickerMenu.add(greenLabel);
		greenLabel.setEditable(false);
		greenLabel.setText("G");
		greenLabel.setHorizontalAlignment(SwingConstants.CENTER);
		greenLabel.setColumns(10);

		blueLabel = new JTextField();
		blueLabel.setBounds(40, 0, 20, 26);
		colorPickerMenu.add(blueLabel);
		blueLabel.setEditable(false);
		blueLabel.setText("B");
		blueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		blueLabel.setColumns(10);
		
	//Color Picker Sliders
		JSlider redSlider = new JSlider();
		redSlider.setBounds(1, 20, 20, 255);
		colorPickerMenu.add(redSlider);
		redSlider.setValue(0);
		redSlider.setMinimum(0);
		redSlider.setMaximum(255);
		redSlider.setOrientation(SwingConstants.VERTICAL);
		
		redSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				rValue = redSlider.getValue();
				pickedColor = new Color(rValue, gValue, bValue);
				colorPickerMenu.setBackground(pickedColor);
			}
		});
		
		JSlider greenSlider = new JSlider();
		greenSlider.setBounds(21, 20, 20, 255);
		colorPickerMenu.add(greenSlider);
		greenSlider.setValue(0);
		greenSlider.setMinimum(0);
		greenSlider.setMaximum(255);
		greenSlider.setOrientation(SwingConstants.VERTICAL);
		
		greenSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				gValue = greenSlider.getValue();
				pickedColor = new Color(rValue, gValue, bValue);
				colorPickerMenu.setBackground(pickedColor);
			}
		});

		JSlider blueSlider = new JSlider();
		blueSlider.setBounds(41, 20, 20, 255);
		colorPickerMenu.add(blueSlider);
		blueSlider.setValue(0);
		blueSlider.setMinimum(0);
		blueSlider.setMaximum(255);
		blueSlider.setOrientation(SwingConstants.VERTICAL);
		
		blueSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				bValue = blueSlider.getValue();
				pickedColor = new Color(rValue, gValue, bValue);
				try {
					colorPickerMenu.setBackground(pickedColor);
				} catch (Exception e1) {
					System.out.println("Color Slider Error");
					e1.printStackTrace();
				}
			}
		});
	}
}
