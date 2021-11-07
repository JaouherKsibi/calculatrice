package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.GridLayout;

public class Controlleur implements ActionListener{

	JFrame frame;
	JTextField text;
	JButton[] numbers=new JButton[10];
	JButton[] functions=new JButton[9];
	JButton delButton,eqButton,virguleButton,addButton, divButton,subButton,mulButton, clearButton ,negButton;
	
	JPanel panel;
	Font myFont=new Font("Ink Free",Font.BOLD,30);
	double num1=0,num2=0,result=0;
	char operator;
	
	public Controlleur() {
		frame=new JFrame("Caclculatrice");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		text=new JTextField();
		text.setBounds(50,25,300,50);
		text.setFont(myFont);
		text.setEditable(false);
		
		addButton=new JButton("+");
		subButton=new JButton("-");
		mulButton=new JButton("X");
		divButton=new JButton("/");
		clearButton=new JButton("CLR");
		delButton=new JButton("DEL");
		negButton=new JButton("+/-");
		virguleButton=new JButton(".");
		eqButton=new JButton("=");
		
		
		functions[0]=addButton;
		functions[1]=subButton;
		functions[2]=mulButton;
		functions[3]=divButton;
		functions[4]=clearButton;
		functions[5]=delButton;
		functions[6]=negButton;
		functions[7]=virguleButton;
		functions[8]=eqButton;
		
		
		for (JButton jButton : functions) {
			jButton.addActionListener(this);
			jButton.setFont(myFont);
			jButton.setFocusable(false);
			
			}
		for (int i = 0; i < 10; i++) {
			numbers[i]=new JButton(String.valueOf(i));
			numbers[i].addActionListener(this);
			numbers[i].setFont(myFont);
			numbers[i].setFocusable(false);
		}
		
		/*addButton.setBounds(50,430,100,50);
		subButton.setBounds(150,430,100,50);
		mulButton.setBounds(250,430,100,50);
		divButton.setBounds(350,430,100,50);*/
		clearButton.setBounds(250,430,100,50);
		delButton.setBounds(150,430,100,50);
		negButton.setBounds(50,430,100,50);
		/*virguleButton.setBounds(50,430,100,50);
		eqButton.setBounds(50,430,100,50);*/
		
		panel=new JPanel();
		panel.setBounds(50,100,300,300);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.add(numbers[1]);
		panel.add(numbers[2]);
		panel.add(numbers[3]);
		panel.add(addButton);
		panel.add(numbers[4]);
		panel.add(numbers[5]);
		panel.add(numbers[6]);
		panel.add(subButton);
		panel.add(numbers[7]);
		panel.add(numbers[8]);
		panel.add(numbers[9]);
		panel.add(mulButton);
		panel.add(virguleButton);
		panel.add(numbers[0]);
		panel.add(eqButton);
		panel.add(divButton);
		
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clearButton);
		frame.add(text);
		frame.setVisible(true);
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<10;i++) {
			if(e.getSource()==numbers[i]) {
				text.setText(text.getText()+String.valueOf(i));
			}
		}
		if(e.getSource()==virguleButton) {
			text.setText(text.getText()+".");
		}
		if(e.getSource()==addButton) {
			num1=Double.parseDouble(text.getText());
			operator='+';
			text.setText("");
		}
		if(e.getSource()==subButton) {
			num1=Double.parseDouble(text.getText());
			operator='-';
			text.setText("");
		}
		if(e.getSource()==mulButton) {
			num1=Double.parseDouble(text.getText());
			operator='*';
			text.setText("");
		}
		if(e.getSource()==divButton) {
			num1=Double.parseDouble(text.getText());
			operator='/';
			text.setText("");
		}
		
		if(e.getSource()==eqButton) {
			num2=Double.parseDouble(text.getText());
			switch (operator) {
			case '+': {
				result=num1+num2;
				break;
			}
			case '-': {
				result=num1-num2;
				break;
			}
			case '*': {
				result=num1*num2;
				break;
			}
			case '/': {
				result=num1/num2;
				break;
			}
			}
			text.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clearButton) {
			text.setText("");
		}
		if(e.getSource()==delButton) {
			text.setText(text.getText().substring(0,text.getText().length()-1 ));
		}
		if(e.getSource()==negButton) {
			text.setText("-"+text.getText());
		}
	}
	
}
