package classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Task extends JPanel {
	
	private JLabel index;
	private JTextField taskName;
	private JButton done;
	
	private boolean checked;
	//Constructor
	Task(){
		this.setPreferredSize(new Dimension(40,20));
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		
		checked = false;
		
		index = new JLabel("");
		index.setPreferredSize(new Dimension(20,20));
		index.setHorizontalAlignment(JLabel.CENTER);
		this.add(index,BorderLayout.WEST);
		
		String newTask = JOptionPane.showInputDialog("Write your Task");
		taskName = new JTextField(newTask);
		taskName.setBorder(BorderFactory.createEmptyBorder());
		taskName.setBackground(Color.white);
		this.add(taskName,BorderLayout.CENTER);
		
		done = new JButton("done");
		done.setPreferredSize(new Dimension(40,20));
		done.setBorder(BorderFactory.createEmptyBorder());
		done.setBorderPainted(false);
		done.setContentAreaFilled(false);
		this.add(done,BorderLayout.EAST);
		
	}
	
	public JButton getDone(){
		return done;
	}
	
	public void changeIndex(int num){
		this.index.setText(num + "");
		this.revalidate();
	}
	
	
	public void changeState(){
		// checked가 false일때 -> 배경색 = gray, checked = true 로 변함
		// checked가 true일때 -> 배경색 = white, checked = false로 변함
		if(!checked){
		this.setBackground(Color.gray);
		taskName.setBackground(Color.gray);
		checked = true;
		} else {
			this.setBackground(Color.white);
			taskName.setBackground(Color.white);
			checked = false;
		}		
	}
	
	public boolean getState(){
		return checked;
	}
}
