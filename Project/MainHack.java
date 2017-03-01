package Project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
// import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JTextField;

public class MainHack implements ActionListener {
	
	public JFrame jframe;
	
	public RenderPanel renderPanel;
	
	public static MainHack game_window;
	
	public Timer timer = new Timer (50, this);
	
	public JTextField textField = new JTextField("Enter a password!", 15);
	
	public static int health;
	
	public static final int DOWN = 0, UP = 1, SCALE = 20;
	
	public static int ticks = 0, width = 800, height = 600;
	
	public boolean isExecuted = false;
	
	Dimension dim;
	
	public MainHack() {
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		jframe = new JFrame("Game");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
		jframe.setResizable(false);
		jframe.setSize(width,height);
		jframe.setLocation(dim.width / 2 - jframe.getWidth() / 2, dim.height / 2 - jframe.getHeight() / 2);
		jframe.add(renderPanel = new RenderPanel());
		renderPanel.add(textField);
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setLocation(width,height); 
		
		textField.addActionListener(this);
		textField.addKeyListener
			(new KeyListener() {
			public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                	PasswordEvaluator ob = new PasswordEvaluator();
                	health = ob.pass_strength(textField.getText());	
                	textField.setBackground(Color.BLACK);
                	textField.setBorder(BorderFactory.createLineBorder(Color.black));
                	timer.start();
                }
            }
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
        });
	}
		
	
	public void actionPerformed(ActionEvent e) {
//		if ((!isExecuted) && ((e.getKeyCode() == KeyEvent.VK_ENTER)) {
//			PasswordEvaluator ob = new PasswordEvaluator();
//			health = ob.pass_strength(textField.getText());	
//			textField.setBackground(Color.BLACK);
//			textField.setBorder(BorderFactory.createLineBorder(Color.black));
//			timer.start();
//			isExecuted = true;
//		}
		if (timer.isRunning()) {
			renderPanel.repaint();
			ticks++;
			if (ticks % 100 == 0)
				RenderPanel.wall_spacing--;
			if (RenderPanel.wall_spacing < 5)
				RenderPanel.wall_spacing = 5;
			if (ticks % RenderPanel.wall_spacing == 0) {
				// Generate Player
				// Move player up or down
				// Check for collision
					// Deduct points
				// Check for game over
			}
		}
	}
	
	public static void main(String [] args) {
		game_window = new MainHack();
	}
}
