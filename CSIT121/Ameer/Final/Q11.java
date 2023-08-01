import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Q11 {

    public static void main(String[] args) {
        JFrame frame;
    
        frame = new JFrame();
        String firstNum = JOptionPane.showInputDialog(frame, "Enter First Number");
        String secondNum = JOptionPane.showInputDialog(frame, "Enter Second Number");
        int multiple = Integer.parseInt(firstNum) * Integer.parseInt(secondNum);
        String output = "The multiple is " + multiple;
        JOptionPane.showMessageDialog(frame, output, "Multiple of Two Integers", JOptionPane.INFORMATION_MESSAGE);
    }
}