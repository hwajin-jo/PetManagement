package pet_management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ExaminationPage extends JFrame {

	List list;
	
	public ExaminationPage () {
		
	JPanel jmp = new JPanel();
	
	Label l1 = new Label("���� ���� ������", SwingConstants.CENTER);
	Label l2 = new Label("ȸ�� ���̵�");
	Label l3 = new Label("���� ���̵�");
	Label l4 = new Label("���� �̸�");
	Label l5 = new Label("���� ����");
	Label l6 = new Label("���� ���");
	Label l7 = new Label("ȸ�� ���");
	
	add(l1); add(l2); add(l3);
	add(l4); add(l5); add(l6);
	
	//�ڷᰪ�� ����
	add(l7);
	
	//ȸ�� ���̵��� ��Ӵٿ� ����� Uneditable ComboBox
	TextField t1 = new TextField(); //���� ���̵�
	TextField t2 = new TextField(); //���� �̸�
	TextField t3 = new TextField(); //���� ����
	TextField t4 = new TextField(); // ���� ���
	
	add(t1); add(t2); add(t3); add(t4); 
	
	Font font1 = new Font("���� ���", Font.BOLD, 25);
	l1.setFont(font1);
	
	JButton register = new JButton("���");
	JButton delete = new JButton("����");
	JButton search = new JButton("��ȸ");
	JButton reset = new JButton("�����");
	JButton back = new JButton("�ڷΰ���");
	add(register);
	add(delete);
	add(search);
	add(reset);
	add(back);
	
	 list = new List();
	 add(list);
	 Font font2 = new Font("���� ���", 0, 15);
	 list.setFont(font2);
	
	l1.setBounds(300, 30, 200, 40); // ���� ���� ������ 
	l2.setBounds(425, 100, 75, 30); // ȸ�� ���̵�
	l3.setBounds(585, 100, 70, 30); // ���� ���̵�
	l4.setBounds(425, 130, 70, 30); // ���� �̸�
	l5.setBounds(585, 130, 70, 30); // ���� ����
	l6.setBounds(425, 160, 70, 30); //���� ���
	
	t1.setBounds(655, 100, 80, 30); //���� ���̵�
	t2.setBounds(495, 130, 80, 30);//���� �̸�
	t3.setBounds(655, 130, 80, 30);//���� ����
	t4.setBounds(495, 160, 80, 30);// ���� ���
	
	register.setBounds(430, 200, 75, 30);
	delete.setBounds(510, 200, 75, 30);
	search.setBounds(590, 200, 75, 30);
	reset.setBounds(670, 200, 75, 30);
	back.setBounds(690, 700, 90, 30);
	
	list.setBounds(50, 260, 700, 400);
	
	add(jmp);
	setSize(800, 790);
	setTitle("�������ȭ��");
	setResizable(false);
	Dimension frameSize = jmp.getSize();
	
	// ����� ũ��
	setResizable(false);
	setLocationRelativeTo(jmp);
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	jmp.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	// displayAll();
	
//	// ����Ʈ ������ ���� �� �ؽ�Ʈ �ʵ�� �� �ֱ�
//	list.addItemListener(new ItemListener() {
//		
//		@Override
//		public void itemStateChanged(ItemEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//	});
	
	//�޴��������� ���� ��ư
	back.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			MenuPage menuPage = new MenuPage();
			dispose();
			
		}
	});
	
	
	}
}
