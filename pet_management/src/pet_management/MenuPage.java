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
		Label l1 = new Label("�������� ���� ������Ʈ");
		add(l1);
		
		JButton j1 = new JButton("ȸ������");
		JButton j2 = new JButton("�������");
		JButton j3 = new JButton("�������");
		JButton j4 = new JButton("�α׾ƿ�");
		add(j1);
		add(j2);
		add(j3);
		add(j4);
		
		Font font = new Font("���� ����", Font.BOLD, 30);
		l1.setFont(font);
		
		l1.setBounds(90, 10, 10000, 100);
		
		j1.setBounds(130, 150, 100, 45);
		j2.setBounds(240, 150, 100, 45);
		j3.setBounds(130, 220, 100, 45);
		j4.setBounds(240, 220, 100, 45);
		
		add(p);
		setSize(500, 500);
		setTitle("�޴� ȭ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		// ȸ������ ��ư ���� ����
		j1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ȸ������ �������� �̵�
				MemberPage mmPage= new MemberPage();
				dispose();
			}
		});
		
		// ������� ��ư ���� ����
		j2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ������� �������� �̵�
				
			}
		});
		
		// ������� ��ư ���� ����
		j3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ������� �������� �̵�	
				ExaminationPage exPage = new ExaminationPage();
				dispose();
				
			}
		});
		
		// �α׾ƿ� ��ư ���� ����
		j4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// �α׾ƿ� ��� ����
				JOptionPane.showMessageDialog(null, "�α׾ƿ� �Ǿ����ϴ�.");
				dispose();
				LoginPage login = new LoginPage();
				
			}
		});
	}
	
	
}