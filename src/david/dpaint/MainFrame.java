package david.dpaint;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private PaintPanel paintPanel;

	public MainFrame() {
		setTitle("DPaint");
		setBounds(100, 100, 1920, 1080);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//instantiate PaintPanel
		paintPanel = new PaintPanel();
		add(paintPanel);
	}
}

