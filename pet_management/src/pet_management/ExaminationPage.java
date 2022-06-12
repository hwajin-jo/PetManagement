package pet_management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ExaminationPage extends JFrame {

	List list;
	
	public ExaminationPage () {
		
	JPanel jmp = new JPanel();
	
	Label l1 = new Label("진료 관리 페이지", SwingConstants.CENTER);
	Label l2 = new Label("회원 아이디");
	Label l3 = new Label("진료 아이디");
	Label l4 = new Label("동물 이름");
	Label l5 = new Label("진료 내용");
	Label l6 = new Label("진료 비용");
	Label l7 = new Label("회원 목록");
	
	add(l1); add(l2); add(l3);
	add(l4); add(l5); add(l6);
	
	//자료값의 제목
	add(l7);
	
	//회원 아이디의 드롭다운 방식은 Uneditable ComboBox
	TextField t1 = new TextField(); //진료 아이디
	TextField t2 = new TextField(); //동물 이름
	TextField t3 = new TextField(); //진료 내용
	TextField t4 = new TextField(); // 진료 비용
	
	add(t1); add(t2); add(t3); add(t4); 
	
	Font font1 = new Font("맑은 고딕", Font.BOLD, 25);
	l1.setFont(font1);
	
	JButton register = new JButton("등록");
	JButton delete = new JButton("삭제");
	JButton search = new JButton("조회");
	JButton reset = new JButton("지우기");
	JButton back = new JButton("뒤로가기");
	add(register);
	add(delete);
	add(search);
	add(reset);
	add(back);
	
	 list = new List();
	 add(list);
	 Font font2 = new Font("맑은 고딕", 0, 15);
	 list.setFont(font2);
	
	l1.setBounds(300, 30, 200, 40); // 진료 관리 페이지 
	l2.setBounds(425, 100, 75, 30); // 회원 아이디
	l3.setBounds(585, 100, 70, 30); // 진료 아이디
	l4.setBounds(425, 130, 70, 30); // 동물 이름
	l5.setBounds(585, 130, 70, 30); // 진료 내용
	l6.setBounds(425, 160, 70, 30); //진료 비용
	
	t1.setBounds(655, 100, 80, 30); //진료 아이디
	t2.setBounds(495, 130, 80, 30);//동물 이름
	t3.setBounds(655, 130, 80, 30);//진료 내용
	t4.setBounds(495, 160, 80, 30);// 진료 비용
	
	register.setBounds(430, 200, 75, 30);
	delete.setBounds(510, 200, 75, 30);
	search.setBounds(590, 200, 75, 30);
	reset.setBounds(670, 200, 75, 30);
	back.setBounds(690, 700, 90, 30);
	
	list.setBounds(50, 260, 700, 400);
	
	add(jmp);
	setSize(800, 790);
	setTitle("진료관리화면");
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
	
//	// 리스트 아이템 선택 시 텍스트 필드로 값 넣기
//	list.addItemListener(new ItemListener() {
//		
//		@Override
//		public void itemStateChanged(ItemEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//	});
	
	//메뉴페이지로 가기 버튼
	back.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			MenuPage menuPage = new MenuPage();
			dispose();
			
		}
	});
	
	
	}
}
