package pet_management;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import manager.ManagerDao;


public class LoginPage extends JFrame{

	public LoginPage() {
		//판넬 만들어주기
		JPanel p = new JPanel();
		setLocationRelativeTo(p);
		
		//로그인과 아이디 이미지 주기
		BufferedImage myPicture;
		BufferedImage myPicture2;
		try {
			myPicture = ImageIO.read(new File("C:\\git\\pet_management\\id.png"));	
			myPicture2 = ImageIO.read(new File("C:\\git\\pet_management\\pwd.png"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			JLabel picLabel2 = new JLabel(new ImageIcon(myPicture2));
			add(picLabel);
			add(picLabel2);
			picLabel.setBounds(110, 150, 30, 30);
			picLabel2.setBounds(110, 190, 30, 30);
			

			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		JLabel titlelb = new JLabel("로그인");
		titlelb.setHorizontalAlignment(SwingConstants.CENTER);
		p.add(titlelb);
		
		
		TextField idtext = new TextField();
		TextField pwdtext = new TextField();
		
		add(idtext);
		add(pwdtext);
		pwdtext.setEchoChar('*');
		
		JButton loginButton = new JButton("로그인");
		
		
	
		add(loginButton);
		
		Font font = new Font ("맑은 고딕", Font.BOLD, 30);
		titlelb.setFont(font);
		
		idtext.setBounds(150, 150, 200, 30);
		pwdtext.setBounds(150, 190, 200, 30);
		
		loginButton.setBounds(200, 300, 100, 30);
			
		
		titlelb.setHorizontalAlignment(JLabel.CENTER);;	
		
		
		add(p);
		setSize(500,500);
		setTitle("동물병원 관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
//		 로그인버튼 코드 수정필요
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 로그인을 성공하면 메인화면으로 바꿔주기
			String managerID = idtext.getText();
			String managerPWD = pwdtext.getText();
			ManagerDao managerDao = new ManagerDao();
			System.out.println(managerID+managerPWD);
			int result = managerDao.login(managerID,managerPWD);
			//데이터베이스 안의 id와 비밀번호 받아서 result == 0 -> 로그인, result ==1 로그인 실패창
			if(result == 1) {
				if(managerID.equals("manager1")) {
					JOptionPane.showMessageDialog(null, "로그인에 성공했습니다.");
					MenuPage menuPage = new MenuPage();
					dispose();//이전화면 닫기
				}else {
					JOptionPane.showMessageDialog(null, "로그인에 실패했습니다.");
				}
			}else if (result == 0){
				JOptionPane.showMessageDialog(null, "로그인에 실패했습니다.");
			}
			
			
				
			}
		});	//로그인버튼 코드
		
	}


	
	
}