import javax.swing.*;
import java.awt.*;

public class OutputView extends JPanel{
	private int WIDTH = 500;
	private int HEIGHT = 300;
	private String p1_result = "";
	private String p2_result = "";
	private String p1_name = "";
	private String p2_name = "";
	private String winner = "";
	
	public OutputView() {
		JFrame f = new JFrame();
		f.getContentPane().add(this);
		f.setTitle("주사위 게임");
		f.setSize(WIDTH, HEIGHT);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);		
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT+22);
		g.setColor(Color.black);
		int text_margin = 50;
		int text_baseline = 50;
		g.drawString("주사위 두개가 같은 수가 나오면 이긴다. 둘 다 같은 수이면 큰 수가 이긴다.", text_margin, text_baseline);
		g.drawString("다른 수 끼리는 두 주사위의 합이 크면 이긴다.", text_margin, text_baseline+20);
		g.drawString("합이 동률인 경우에는 두 수의 차이가 작으면 이긴다.", text_margin, text_baseline+40);
		g.drawString("두수의 차이도 동률이면 비긴다.", text_margin, text_baseline+60);
		text_baseline += 100;
		g.drawString(p1_name, text_margin, text_baseline);
		g.drawString(p1_result, text_margin+100, text_baseline);
		g.drawString(p2_name, text_margin, text_baseline+40);
		g.drawString(p2_result, text_margin+100, text_baseline+40);
		g.drawString(winner, text_margin, text_baseline+80);
	}
	
	public void showGameResult(int p1d1, int p1d2, int p2d1, int p2d2, String winner_name) {
		p1_result = "주사위 눈: " + p1d1 + ", " + p1d2 + ", 합계 :" + (p1d1 + p1d2);
		p2_result = "주사위 눈: " + p2d1 + ", " + p2d2 + ", 합계 :" + (p2d1 + p2d2);
		
		if (winner_name != null) winner = winner_name + "(이)가 승리하였습니다.";
		else winner = "비겼습니다.";
		this.repaint();
	}
	
	public void showPlayerName(String p1_name, String p2_name) {
		this.p1_name = "Player 1 : " + p1_name;
		this.p2_name = "Player 2 : " + p2_name;
		this.repaint();
	}
	
}
