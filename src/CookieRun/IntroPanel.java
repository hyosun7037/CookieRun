package CookieRun;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/* �̹����� �׸��� ��ɸ� ���� */
public class IntroPanel extends JPanel{
	ImageIcon introIc = new ImageIcon("img/intro.png");
	
	@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(
					introIc.getImage(), 
					-60, 
					0, 
					/* this.getWith()
					 * , this.getHeight
					 * , */ 
					null);
		}
}
