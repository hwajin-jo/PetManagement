package pet_management;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

public class LoginPage extends JFrame{

	public LoginPage() {
		//�ǳ� ������ֱ�
		JPanel p = new JPanel();
		setLocationRelativeTo(p);
		
		//�α��ΰ� ���̵� �̹��� �ֱ�
		BufferedImage myPicture;
		BufferedImage myPicture2;
		try {
			myPicture = ImageIO.read(new File("C:\\PetManagement\\id.png"));	
			myPicture2 = ImageIO.read(new File("C:\\PetManagement\\pwd.png"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			JLabel picLabel2 = new JLabel(new ImageIcon(myPicture2));
			add(picLabel);
			add(picLabel2);
			picLabel.setBounds(110, 150, 30, 30);
			picLabel2.setBounds(110, 190, 30, 30);
			

			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		JLabel titlelb = new JLabel("�α���");
		titlelb.setHorizontalAlignment(SwingConstants.CENTER);
		p.add(titlelb);
		
		
		TextField idtext = new TextField();
		TextField pwdtext = new TextField();
		
		add(idtext);
		add(pwdtext);
		pwdtext.setEchoChar('*');
		
		JButton loginButton = new JButton("�α���");
		
		
	
		add(loginButton);
		
		Font font = new Font ("���� ���", Font.BOLD, 30);
		titlelb.setFont(font);
		
		idtext.setBounds(150, 150, 200, 30);
		pwdtext.setBounds(150, 190, 200, 30);
		
		loginButton.setBounds(200, 300, 100, 30);
			
		
		titlelb.setHorizontalAlignment(JLabel.CENTER);;	
		
		
		add(p);
		setSize(500,500);
		setTitle("�������� ���� ���α׷�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		// �α��ι�ư �ڵ� �����ʿ�
//		loginButton.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// �α����� �����ϸ� ����ȭ������ �ٲ��ֱ�
//			String id = idtext.getText();
//			String pwd = pwdtext.getText();
//			
//			AdminDao dao = new AdminDao();
//			int result = dao.login(id,pwd);
//			//�����ͺ��̽� ���� id�� ��й�ȣ �޾Ƽ� result == 0 -> �α���, result ==1 �α��� ����â
//			if(result == 1) {
//				if(id.equals("admin")) {
//					JOptionPane.showMessageDialog(null, "�α��ο� �����߽��ϴ�.");
//					ManagerPage adminPage = new ManagerPage();
//					dispose();//����ȭ�� �ݱ�
//				}
//			}else if (result ==0){
//				JOptionPane.showMessageDialog(null, "�α��ο� �����߽��ϴ�.");
//			}
//			
//			
//				
//			}
//		});
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ������� �������� �̵�	
				MenuPage menuPage = new MenuPage();
				dispose();
				
			}
		});
	}


	
	
}