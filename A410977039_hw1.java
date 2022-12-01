
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class A410977039_hw1 extends JFrame {
	JPanel upPan = new JPanel();
	JPanel downPan = new JPanel();
	JTextField tfDisplay = new JTextField();
	JButton btnReset = new JButton("Reset");
	JButton btn0 = new JButton("0");
	JButton btn1 = new JButton("1");
	JButton btn2 = new JButton("2");
	JButton btn3 = new JButton("3");
	JButton btn4 = new JButton("4");
	JButton btn5 = new JButton("5");
	JButton btn6 = new JButton("6");
	JButton btn7 = new JButton("7");
	JButton btn8 = new JButton("8");
	JButton btn9 = new JButton("9");
	JButton btnPlus = new JButton("+");
	JButton btnMinus = new JButton("-");
	JButton btnMultiply = new JButton("*");
	JButton btnDivide = new JButton("/");
	JButton btnPoint = new JButton(".");
	JButton btnEqual = new JButton("=");
	String num1 = "";
	String op = "";
	String num2 = "";
	boolean isFirst = true;
	boolean pointAdded = false;
	int operation = 0;

	A410977039_hw1() {
		setLayout(new BorderLayout());
		upPan.setLayout(new GridLayout(2, 1));
		upPan.add(tfDisplay);
		upPan.add(btnReset);
		add(upPan, BorderLayout.NORTH);

		downPan.setLayout(new GridLayout(4, 4));
		downPan.add(btn1);
		downPan.add(btn2);
		downPan.add(btn3);
		downPan.add(btnPlus);

		downPan.add(btn4);
		downPan.add(btn5);
		downPan.add(btn6);
		downPan.add(btnMinus);

		downPan.add(btn7);
		downPan.add(btn8);
		downPan.add(btn9);
		downPan.add(btnMultiply);

		downPan.add(btn0);
		downPan.add(btnPoint);
		downPan.add(btnDivide);
		downPan.add(btnEqual);
		add(downPan, BorderLayout.CENTER);

		Lis lis = new Lis();
		btn1.addActionListener(lis);
		btn2.addActionListener(lis);
		btn3.addActionListener(lis);
		btn4.addActionListener(lis);
		btn5.addActionListener(lis);
		btn6.addActionListener(lis);
		btn7.addActionListener(lis);
		btn8.addActionListener(lis);
		btn9.addActionListener(lis);
		btn0.addActionListener(lis);
		btnPoint.addActionListener(lis);
		btnPlus.addActionListener(lis);
		btnMinus.addActionListener(lis);
		btnMultiply.addActionListener(lis);
		btnDivide.addActionListener(lis);
		btnEqual.addActionListener(lis);
		btnReset.addActionListener(lis);

	}

	class Lis implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Object touch = arg0.getSource();
			if (isFirst) {
				if (touch == btn0) num1 += "0";
				else if (touch == btn1) num1 += "1";
				else if (touch == btn2) num1 += "2";
				else if (touch == btn3) num1 += "3";
				else if (touch == btn4) num1 += "4";
				else if (touch == btn5) num1 += "5";
				else if (touch == btn6) num1 += "6";
				else if (touch == btn7) num1 += "7";
				else if (touch == btn8) num1 += "8";
				else if (touch == btn9) num1 += "9";
				else if (touch == btnPoint) {
					if (pointAdded) return;
					else {
						num1 += ".";
						pointAdded = true;
					}
				}
			}
			else {
				if (touch == btn0) num2 += "0";
				else if (touch == btn1) num2 += "1";
				else if (touch == btn2) num2 += "2";
				else if (touch == btn3) num2 += "3";
				else if (touch == btn4) num2 += "4";
				else if (touch == btn5) num2 += "5";
				else if (touch == btn6) num2 += "6";
				else if (touch == btn7) num2 += "7";
				else if (touch == btn8) num2 += "8";
				else if (touch == btn9) num2 += "9";
				else if (touch == btnPoint) {
					if (pointAdded) return;
					else {
						num2 += ".";
						pointAdded = true;
					}
				}
			}
			if (touch == btnPlus) {
				op = "+";
				isFirst = false;
				pointAdded = false;
			}
			else if (touch == btnMinus) {
				op = "-";
				operation = 1;
				isFirst = false;
				pointAdded = false;
			}
			else if (touch == btnMultiply) {
				op = "*";
				operation = 2;
				isFirst = false;
				pointAdded = false;
			}
			else if (touch == btnDivide) {
				op = "/";
				operation = 3;
				isFirst = false;
				pointAdded = false;
			}
			else if (touch == btnEqual) {
				double n1 = Double.valueOf(num1), n2 = Double.valueOf(num2), total = 0;
				switch (operation) {
					case 0:
						total = n1 + n2;
						break;
					case 1:
						total = n1 - n2;
						break;
					case 2:
						total = n1 * n2;
						break;
					case 3:
						total = n1 / n2;
						break;
				}
				String t = Double.toString(total);
				tfDisplay.setText(t);
				return;
			}
			else if (touch == btnReset) {
				operation = 0;
				num1 = "";
				op = "";
				num2 = "";
				isFirst = true;
				pointAdded = false;
				tfDisplay.setText("");
				return;
			}
			tfDisplay.setText(num1 + op + num2);
		}

		public static void main(String[] args){
			A410977039_hw1 calculator = new A410977039_hw1();
			calculator.setSize(350, 350);
			calculator.setTitle( "HW1");
			calculator.setVisible(true);
			calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
}