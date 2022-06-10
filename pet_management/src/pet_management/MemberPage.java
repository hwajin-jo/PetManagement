package pet_management;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class MemberPage extends JFrame{
	
	 List list;

	// 회원관리 페이지
	public MemberPage() {
		
		JPanel jmp = new JPanel();
		
		Label l1 = new Label("회원 관리 페이지", SwingConstants.CENTER);
		Label l2 = new Label("동물 이름");
		Label l3 = new Label("동물 종");
		Label l4 = new Label("보호자 이름");
		Label l5 = new Label("전화번호");
		Label l6 = new Label("방문 이유");
		add(l1); add(l2); add(l3);
		add(l4); add(l5); add(l6);
		
		TextField t1 = new TextField(); // 동물 이름
		TextField t2 = new TextField(); // 동물 종
		TextField t3 = new TextField(); // 보호자 이름
		TextField t4 = new TextField(); // 전화번호
		TextField t5 = new TextField(); // 방문 이유
		add(t1); add(t2); add(t3); add(t4); add(t5);
		
		Font font1 = new Font("맑은 고딕", Font.BOLD, 25);
		l1.setFont(font1);
		
		JButton save = new JButton("저장");
		JButton update = new JButton("수정");
		JButton delete = new JButton("삭제");
		JButton search = new JButton("조회");
		JButton reset = new JButton("지우기");
		JButton back = new JButton("뒤로가기");
		add(save);
		add(update);
		add(delete);
		add(search);
		add(reset);
		add(back);
		
		 list = new List();
		 add(list);
		 Font font2 = new Font("맑은 고딕", 0, 15);
		 list.setFont(font2);
		
		l1.setBounds(300, 30, 200, 40); // 회원관리 페이지 
		l2.setBounds(450, 100, 55, 30); // 동물 이름
		l3.setBounds(610, 100, 50, 30); // 둥물 종
		l4.setBounds(450, 130, 70, 30); // 보호자 이름
		l5.setBounds(610, 130, 50, 30); // 전화보호
		l6.setBounds(450, 160, 55, 30); // 방문이유
		
		t1.setBounds(525, 100, 80, 30);
		t2.setBounds(665, 100, 80, 30);
		t3.setBounds(525, 130, 80, 30);
		t4.setBounds(665, 130, 80, 30);
		t5.setBounds(525, 160, 80, 30);
		
		save.setBounds(350, 200, 75, 30);
		update.setBounds(430, 200, 75, 30);
		delete.setBounds(510, 200, 75, 30);
		search.setBounds(590, 200, 75, 30);
		reset.setBounds(670, 200, 75, 30);
		back.setBounds(690, 700, 90, 30);
		
		list.setBounds(50, 260, 700, 400);
		
		add(jmp);
		setSize(800, 790);
		setTitle("회원관리화면");
		setResizable(false);
		Dimension frameSize = jmp.getSize();
		
		// 모니터 크기
		setResizable(false);
		setLocationRelativeTo(jmp);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		jmp.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// displayAll();
		
		// 리스트 아이템 선택 시 텍스트 필도로 값 넣기
		list.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

}
