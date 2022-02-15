package classes;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AppFrame extends JFrame {

	// �������� ������
	private TitleBar title; 
	private List list;
	private ButtonPanel btnPanel;

	private JButton addTask;
	private JButton clear;

	// Constructor
	AppFrame() {
		
		// ��ü ����
		title = new TitleBar();
		list = new List();
		btnPanel = new ButtonPanel();
		
		// Return���� addTask�� clear
		addTask = btnPanel.getAddTask();
		clear = btnPanel.getClear();

		// this�� AppFrame�̴� -> 400,700�������� â�� �����.
		this.setSize(400, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // JFrameâ ����� ���μ������� ���� �� �ִ�.
		this.setVisible(true);

		
		this.add(title, BorderLayout.NORTH); 
		this.add(list, BorderLayout.CENTER);
		this.add(btnPanel, BorderLayout.SOUTH);

		// �޼ҵ� ����
		addListeners();

	}

	
	public void addListeners() {
		addTask.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			// ���콺�� addTask�� ������ �Ͼ�� �ϵ�
			public void mousePressed(MouseEvent e) {
				Task task = new Task(); // task��� ��ü ����
				list.add(task); // task�� list�� �߰��ȴ�
				list.updateNumbers(); //list�� updateNumbers�޼ҵ� ����
				
				// �߰��� task�� done��ư�� Ŭ����
				task.getDone().addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
					}

					@Override
					// done��ư Ŭ���� task.changeState()�޼ҵ� ����
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
		// clear��ư Ŭ���� list�� removeCompletedTasks() ����
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
