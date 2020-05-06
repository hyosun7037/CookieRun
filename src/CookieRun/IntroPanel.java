package CookieRun;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/* 이미지를 그리는 기능만 구현 */
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
