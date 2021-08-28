import javax.swing.JOptionPane;

public class InputView {

	public String readLine(String message) {
		return JOptionPane.showInputDialog(message);
	}
}
