package Project;

import java.awt.*;

import javax.swing.JPanel;


public class RenderPanel extends JPanel{

	protected static final long serialVersionUID = 1L;
	public static Color background = Color.black;
	public static Color text = Color.white;
	public static Color wall = Color.green;
	Font currentFont = new Font("Comic Sans MS", Font.PLAIN, 16);
	public int num_obstacles = 3;
	public static int wall_spacing = 50;
	boolean obs [] [] = new boolean [800] [600];

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(background);
		g.fillRect(0, 0, 800, 600);
		g.setColor(text);
		g.setFont(currentFont);
		g.drawString("Health: " + MainHack.health, 30, 30);
		g.drawString("Score: "+ (MainHack.ticks / 10), 700, 30);
		g.setColor(wall);
		// Move the columns to the left	
		for (int m = 0; m <= MainHack.width - MainHack.SCALE; m+=MainHack.SCALE) {
			for (int k = 30; k < MainHack.height; k++) {
				if (obs[m][k]) {
					g.setColor(wall);
					obs[m][k] = false;
					if (! (m - MainHack.SCALE < 0)) {
						obs[m-MainHack.SCALE][k] = true;
						g.fillRect(m-MainHack.SCALE,k, MainHack.SCALE, MainHack.SCALE);
					}
					g.setColor(background);
					g.fillRect(m,k, MainHack.SCALE, MainHack.SCALE);
					}
				}
			}
		
		//Generate Column
		g.setColor(wall);
		if ((MainHack.ticks % 50 == 0) && (wall_spacing >= 5))
			wall_spacing--;
		if (MainHack.ticks % wall_spacing == 0) {
			for (int i = 0; i < 5; i++) {
				int a = (int) (Math.random() * 600);
				obs[MainHack.width - MainHack.SCALE][a] = true;
				g.fillRect(MainHack.width - MainHack.SCALE, a, MainHack.SCALE, MainHack.SCALE);
			}
		}	
	}
}
		



//					list.get(m).set(0, (list.get(0).get(0) - 5));
//					System.out.print(list.get(m).get(0));
//					if (list.get(m).get(0) < 20)
//						list.remove(m);
//					g.fillRect(list.get(0).get(0), list.get(0).get(1), MainHack.SCALE, MainHack.SCALE);
