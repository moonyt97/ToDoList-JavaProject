package classes;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AppFrame extends JFrame {

	// 여러가지 변수들
	private TitleBar title; 
	private List list;
	private ButtonPanel btnPanel;

	private JButton addTask;
	private JButton clear;

	// Constructor
	AppFrame() {
		
		// 객체 생성
		title = new TitleBar();
		list = new List();
		btnPanel = new ButtonPanel();
		
		// Return값인 addTask와 clear
		addTask = btnPanel.getAddTask();
		clear = btnPanel.getClear();

		// this는 AppFrame이다 -> 400,700사이즈의 창을 만든다.
		this.setSize(400, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // JFrame창 종료시 프로세스까지 닫을 수 있다.
		this.setVisible(true);

		
		this.add(title, BorderLayout.NORTH); 
		this.add(list, BorderLayout.CENTER);
		this.add(btnPanel, BorderLayout.SOUTH);

		// 메소드 실행
		addListeners();

	}

	
	public void addListeners() {
		addTask.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			// 마우스로 addTask를 누르면 일어나는 일들
			public void mousePressed(MouseEvent e) {
				Task task = new Task(); // task라는 객체 생성
				list.add(task); // task가 list에 추가된다
				list.updateNumbers(); //list의 updateNumbers메소드 실행
				
				// 추가된 task의 done버튼을 클릭시
				task.getDone().addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
					}

					@Override
					// done버튼 클릭시 task.changeState()메소드 실행
					public void mousePressed(MouseEvent e) {
						task.changeState();
						revalidate();
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub

					}
				});
				revalidate();
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		// clear버튼 클릭시 list의 removeCompletedTasks() 실행
		clear.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				list.removeCompletedTasks();
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
	}

}
