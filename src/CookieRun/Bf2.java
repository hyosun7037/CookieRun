package CookieRun;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bf2 {
	
	List<Jelly> jellyList = new ArrayList<>();
	List<Foot> fieldList = new ArrayList<>(); // ���� ����Ʈ
	
	int[][] colorArr; // �̹����� x,y��ǥ�� ������ �����ϴ� 2�����迭 colorArr[0][0]�� ȣ���ϸ� 16777215
	int[] sizeArr; // �̹����� ���̿� ���̸� �������� 1���� �迭 temp

	static int[] getSize(String src) throws Exception { // �̹����� ����� �������� �޼���
		File imgf = new File(src); // �̹��� ��θ� �Է¹޾Ƽ� ���ϰ�ü�� �����.
		BufferedImage img = ImageIO.read(imgf); // �̹����� ���۵��̹����� �ִ´�.
		int width = img.getWidth(); // �̹����� ����
		int height = img.getHeight(); // �̹����� ����
		int[] temPos = {width, height}; // ���� ���̸� �迭�� �����
		return temPos;
	}
	
	static int[][] getPic(String src) throws Exception{ // �Ʒ��ڵ�� �����ؼ� ��밡��
		File imgf = new File(src);
		BufferedImage img = ImageIO.read(imgf);
		int width = img.getWidth();
		int height = img.getHeight();
		int[] pixels = new int[width*height];
		PixelGrabber grab = new PixelGrabber(img, 0, 0, width, height, pixels, 0, width);
		grab.grabPixels();
		
		int[][] picture = new int[width][height];
		for(int i=0; i<pixels.length; i++)
			picture[i%width][i/width]= pixels[i] + 16777216;
		return picture;
	}
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		int x = 10;
		int y = 21;
		try {
			int[] tempArr1 = getSize("img/firstMap.png");
			int maxX = tempArr1[0];
			int maxY = tempArr1[1];
			
			int[][] tempArr = getPic("img/firstMap.png");
			
			for (int i = 0; i < maxX; i+=1) {
				for (int j = 0; j < maxY; j+=1) {
					System.out.println(tempArr[i][j]);
				}
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bf2 window = new Bf2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Bf2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
	}

}