public class DiceController {
	private InputView reader;
	private OutputView writer;
	private String p1_name;
	private String p2_name;
	
	public DiceController() {
		this.reader = new InputView();
		this.writer = new OutputView();
	}
	
	public void runGame() {
		p1_name = reader.readLine("첫번째 사용자의 이름을 입력하세요.");
		p2_name = reader.readLine("두번째 사용자의 이름을 입력하세요.");
		
		writer.showPlayerName(p1_name, p2_name);
		
		int p1d1 = new Dice().trowDice();
		int p1d2 = new Dice().trowDice();
		int p2d1 = new Dice().trowDice();
		int p2d2 = new Dice().trowDice();
		
		String winner = null;
		if (p1d1 == p1d2 && p2d1 != p2d2) winner = p1_name;
		else if (p1d1 != p1d2 && p2d1 == p2d2) winner = p2_name;
		else if (p1d1 == p1d2 && p2d1 == p2d2) {
			if (p1d1 > p2d1) winner = p1_name;
			else if (p1d1 < p2d1) winner = p2_name;
		} else if ((p1d1 + p1d2) > (p2d1 + p2d2)) winner = p1_name;
		else if ((p1d1 + p1d2) < (p2d1 + p2d2)) winner = p2_name;
		else if (Math.abs(p1d1-p1d2) < Math.abs(p2d1-p2d2)) winner = p1_name;
		else if (Math.abs(p1d1-p1d2) > Math.abs(p2d1-p2d2)) winner = p2_name;
		
		writer.showGameResult(p1d1, p1d2, p2d1, p2d2, winner);
	}
	
	public static void main(String[] args) {
		new DiceController().runGame();
	}
}
