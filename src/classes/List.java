package classes;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class List extends JPanel {

	List() {
		GridLayout layout = new GridLayout(10, 1); //GridLayout 클래스는 직사각형 그리드에 컨테이너의 구성요소를 배치하는 레이아웃 관리자
		layout.setVgap(5); // Component들 사이 간격

		this.setLayout(layout);
	}

	public void updateNumbers() {
		// Component의 배열 listItems생성 -> List에 있는  components들을 받는다
		Component[] listItems = this.getComponents();
		for (int i = 0; i < listItems.length; i++) {
			// listItems[i]가 Task클래스를 상속받았나 확인
			if (listItems[i] instanceof Task) { // true임 AppFrame에서  list.add(task)를 했으니깐
				((Task) listItems[i]).changeIndex(i + 1); // Task로 형변환?해서 changeIndex()실행
			}
		}
	}
	
	public void removeCompletedTasks() {
		// 배열을 위한 for문 
		for (Component c : getComponents()) {
			if (c instanceof Task) {
				if (((Task) c).getState()) { // getState()가 true라면 즉 checked가 true
					remove(c); // 제거하고
					updateNumbers(); // 일련번호 다시 지정
				}
			}
		}
	}
}
