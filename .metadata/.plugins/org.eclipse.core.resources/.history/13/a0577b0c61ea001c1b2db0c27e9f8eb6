package pet_management;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import member.MemberDao;
import member.MemberDto;

public class MemberPage extends JFrame{
	
	 List list;

	// ȸ������ ������
	public MemberPage() {
		
		JPanel jmp = new JPanel();
		
		Label l1 = new Label("회원관리 페이지", SwingConstants.CENTER);
		Label l2 = new Label("회원아이디");
		Label l3 = new Label("동물 이름");
		Label l4 = new Label("동물 종");
		Label l5 = new Label("보호자 이름");
		Label l6 = new Label("전호번호");
		Label l7 = new Label("방문이유");
		add(l1); add(l2); add(l3);
		add(l4); add(l5); add(l6); add(l7);
		
		TextField t1 = new TextField(); // 회원아이디
		TextField t2 = new TextField(); // 동물 이름
		TextField t3 = new TextField(); // 동물 종
		TextField t4 = new TextField(); // 보호자 이름
		TextField t5 = new TextField(); // 전화번호
		TextField t6 = new TextField(); // 방문 이유
		add(t1); add(t2); add(t3); add(t4); add(t5); add(t6);
		
		Font font1 = new Font("���� ���", Font.BOLD, 25);
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
		
		l1.setBounds(300, 30, 200, 40); 
		
		
		l2.setBounds(350, 100, 70, 30); 
		l3.setBounds(530, 100, 70, 30); 
		l4.setBounds(350, 130, 70, 30); 
		l5.setBounds(530, 130, 70, 30); 
		l6.setBounds(350, 160, 70, 30); 
		l7.setBounds(530, 160, 70, 30); 
		
		t1.setBounds(430, 100, 80, 30);
		t2.setBounds(600, 100, 100, 30);
		t3.setBounds(430, 130, 80, 30);
		t4.setBounds(600, 130, 100, 30);
		t5.setBounds(430, 160, 80, 30);
		t6.setBounds(600, 160, 100, 30);
		
		save.setBounds(350, 200, 75, 30);
		update.setBounds(430, 200, 75, 30);
		delete.setBounds(510, 200, 75, 30);
		search.setBounds(590, 200, 75, 30);
		reset.setBounds(670, 200, 75, 30);
		back.setBounds(660, 700, 90, 30);
		
		list.setBounds(50, 260, 700, 400);
		
		add(jmp);
		setSize(800, 790);
		setTitle("회원관리화면");
		setResizable(false);
		Dimension frameSize = jmp.getSize();
		
		// ����� ũ��
		setResizable(false);
		setLocationRelativeTo(jmp);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		jmp.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		 displayAll();
		
		// 리스트 클릭하면 텍스트로 나타내기
		list.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String str = list.getSelectedItem();
				StringTokenizer st = new StringTokenizer(str);
				t1.setText(st.nextToken());
				t2.setText(st.nextToken());
				t3.setText(st.nextToken());
				t4.setText(st.nextToken());
				t5.setText(st.nextToken());
				t6.setText(st.nextToken());
				
			}
		});
		
		// 저장버튼
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int memberID = Integer.parseInt(t1.getText());
				String memberName = t2.getText();
				String memberSpecies = t3.getText();
				String hostName = t4.getText();
				String hostPhoneNum = t5.getText();
				String visitReason = t6.getText();
				MemberDao dao = new MemberDao();
				dao.insertMember(memberID, memberName, memberSpecies, hostName, hostPhoneNum, visitReason);
				JOptionPane.showMessageDialog(null, "저장 완료");
				displayAll();
				
			}
		});
		
		// 수정버튼
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int memberID = Integer.parseInt(t1.getText());
				String memberName = t2.getText();
				String memberSpecies = t3.getText();
				String hostName = t4.getText();
				String hostPhoneNum = t5.getText();
				String visitReason = t6.getText();
				MemberDao dao = new MemberDao();
				dao.updateMember(memberID, memberName, memberSpecies, hostName, hostPhoneNum, visitReason);
				JOptionPane.showMessageDialog(null, "수정 완료");
				displayAll();
			}
		});
		
		// 삭제버튼
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int memberID = Integer.parseInt(t1.getText());
				MemberDao dao = new MemberDao();
				dao.deleteMember(memberID);
				JOptionPane.showMessageDialog(null, "삭제 완료");
				displayAll();
			}
		});
		
		// 조회버튼
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = t1.getText();
				int memberID = Integer.parseInt(str);
				MemberDao dao = new MemberDao();
				MemberDto dto = dao.searchMember(memberID);
				
				t1.setText(String.valueOf(dto.getMemberID()));
				t2.setText(dto.getMemberName());
				t3.setText(dto.getMemberSpecies());
				t4.setText(dto.getHostName());
				t5.setText(dto.getHostPhoneNum());
				t6.setText(dto.getVisitReason());
			}
		}); 
		
		// 지우기 버튼
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuPage managerPage = new MenuPage();
            }
        });
        
        // 뒤로가기
        reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				
			}
		});
        
        	
	}
	
	// ȭ�� ���
    private void displayAll() {
    	list.removeAll();
    	MemberDao dao = new MemberDao();
    	dao.selectMember();
    	ArrayList<MemberDto> allData = dao.selectMember();
    	for(MemberDto dto : allData) {
    		int memberID = dto.getMemberID();
    		String memberName = dto.getMemberName();
    		String memberSpecies = dto.getMemberSpecies();
    		String hostName = dto.getHostName();
    		String hostPhoneNum = dto.getHostPhoneNum();
    		String visitReason = dto.getVisitReason();
    		list.add(memberID+"              "
    				+memberName+"            "
    				+memberSpecies+"         "
    				+hostName+"                  "
    				+hostPhoneNum+"            "
    				+visitReason
    				);
    	}
    	
    }

}
