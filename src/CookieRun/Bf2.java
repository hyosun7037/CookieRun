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
	List<Foot> fieldList = new ArrayList<>(); // 발판 리스트
	
	int[][] colorArr; // 이미지의 x,y좌표의 색값을 저장하는 2차원배열 colorArr[0][0]을 호출하면 16777215
	int[] sizeArr; // 이미지의 넓이와 높이를 가져오는 1차원 배열 temp

	static int[] getSize(String src) throws Exception { // 이미지의 사이즈를 가져오는 메서드
		File imgf = new File(src); // 이미지 경로를 입력받아서 파일객체를 만든다.
		BufferedImage img = ImageIO.read(imgf); // 이미지를 버퍼드이미지에 넣는다.
		int width = img.getWidth(); // 이미지의 넓이
		int height = img.getHeight(); // 이미지의 높이
		int[] temPos = {width, height}; // 넓이 높이를 배열로 만들기
		return temPos;
	}
	
	static int[][] getPic(String src) throws Exception{ // 아래코드는 복사해서 사용가능
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
