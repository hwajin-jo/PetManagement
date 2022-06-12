package pet_management;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuPage extends JFrame{
	
	public MenuPage() {
		
		JPanel p = new JPanel();
		setLocationRelativeTo(p);
		Label l1 = new Label("동물병원 관리 프로젝트");
		add(l1);
		
		JButton j1 = new JButton("회원관리");
		JButton j2 = new JButton("예약관리");
		JButton j3 = new JButton("진료관리");
		JButton j4 = new JButton("로그아웃");
		add(j1);
		add(j2);
		add(j3);
		add(j4);
		
		Font font = new Font("맑은 고딕", Font.BOLD, 30);
		l1.setFont(font);
		
		l1.setBounds(90, 10, 10000, 100);
		
		j1.setBounds(130, 150, 100, 45);
		j2.setBounds(240, 150, 100, 45);
		j3.setBounds(130, 220, 100, 45);
		j4.setBounds(240, 220, 100, 45);
		
		add(p);
		setSize(500, 500);
		setTitle("메뉴 화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		// 회원관리 버튼 눌림 감지
		j1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 회원관리 페이지로 이동
				MemberPage mmPage= new MemberPage();
				dispose();
			}
		});
		
		// 예약관리 버튼 눌림 감지
		j2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 예약관리 페이지로 이동
				ReservationPage exPage = new ReservationPage();
				dispose();
			}
		});
		
		// 진료관리 버튼 눌림 감지
		j3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 진료관리 페이지로 이동	
				ExaminationPage exPage = new ExaminationPage();
				dispose();
				
			}
		});
		
		// 로그아웃 버튼 눌림 감지
		j4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 로그아웃 기능 수행
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.");
				dispose();
				LoginPage login = new LoginPage();
				
			}
		});
	}
	
	
}
