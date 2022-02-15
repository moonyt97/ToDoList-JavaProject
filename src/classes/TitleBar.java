package classes;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitleBar extends JPanel {

//Constructor
	TitleBar(){
		//this.setSize(400, 80); 이거사용하면 높이가 제대로 안잡힐 때가 있음
        this.setPreferredSize(new Dimension(400,80));
        
        JLabel titleText = new JLabel("To Do List");
        titleText.setPreferredSize(new Dimension(400,80));
        titleText.setFont(new Font("Sans-serif",Font.BOLD,20));
        titleText.setHorizontalAlignment(JLabel.CENTER);
        
        this.add(titleText);
	}
	
}
