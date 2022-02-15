package classes;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class List extends JPanel {

	List() {
		GridLayout layout = new GridLayout(10, 1); //GridLayout Ŭ������ ���簢�� �׸��忡 �����̳��� ������Ҹ� ��ġ�ϴ� ���̾ƿ� ������
		layout.setVgap(5); // Component�� ���� ����

		this.setLayout(layout);
	}

	public void updateNumbers() {
		// Component�� �迭 listItems���� -> List�� �ִ�  components���� �޴´�
		Component[] listItems = this.getComponents();
		for (int i = 0; i < listItems.length; i++) {
			// listItems[i]�� TaskŬ������ ��ӹ޾ҳ� Ȯ��
			if (listItems[i] instanceof Task) { // true�� AppFrame����  list.add(task)�� �����ϱ�
				((Task) listItems[i]).changeIndex(i + 1); // Task�� ����ȯ?�ؼ� changeIndex()����
			}
		}
	}
	
	public void removeCompletedTasks() {
		// �迭�� ���� for�� 
		for (Component c : getComponents()) {
			if (c instanceof Task) {
				if (((Task) c).getState()) { // getState()�� true��� �� checked�� true
					remove(c); // �����ϰ�
					updateNumbers(); // �Ϸù�ȣ �ٽ� ����
				}
			}
		}
	}
}
