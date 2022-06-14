package pet_management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.*;

import examination.ExaminationDao;
import examination.ExaminationDto;

public class ExaminationPage extends JFrame {

	List list;
	ArrayList<String> listCombo;

	public ExaminationPage() {

		JPanel jmp = new JPanel();

		Label l1 = new Label("진료 관리 페이지", SwingConstants.CENTER);
		Label l2 = new Label("회원 아이디");
		Label l3 = new Label("진료 아이디");
		Label l4 = new Label("동물 이름");
		Label l5 = new Label("진료 내용");
		Label l6 = new Label("진료 비용");

		// 입력 레이블
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);

		TextField t1 = new TextField(); // 진료 아이디
		TextField t2 = new TextField(); // 동물 이름
		TextField t3 = new TextField(); // 진료 내용
		TextField t4 = new TextField(); // 진료 비용

		add(t1);
		add(t2);
		add(t3);
		add(t4);

		Font font1 = new Font("맑은 고딕", Font.BOLD, 25);
		l1.setFont(font1);

		JButton register = new JButton("등록");
		JButton delete = new JButton("삭제");
		JButton search = new JButton("조회");
		JButton clear = new JButton("지우기");
		JButton back = new JButton("뒤로가기");
		JButton updateEx = new JButton("수정");

		add(register);
		add(delete);
		add(search);
		add(clear);
		add(back);
		add(updateEx);

		// 회원 아이디 콤보
		listCombo = new ArrayList<String>();
		selectCombo();
		JComboBox<?> jcmemberID = new JComboBox(listCombo.toArray(new String[listCombo.size()]));

		// 드롭다운 박스 회원 아이디
		ExaminationDto dto = new ExaminationDto();
		String[] memberIDs = {Integer.toString(dto.getMemberID())};
		final JComboBox cb = new JComboBox(memberIDs);

		jcmemberID.setBounds(495, 100, 80, 30);

		add(jcmemberID);

		list = new List();
		add(list);
		Font font2 = new Font("맑은 고딕", 0, 15);
		list.setFont(font2);

		l1.setBounds(300, 30, 200, 40); // 진료 관리 페이지
		l2.setBounds(425, 100, 70, 30); // 회원 아이디
		l3.setBounds(585, 100, 70, 30); // 진료 아이디
		l4.setBounds(425, 130, 70, 30); // 동물 이름
		l5.setBounds(585, 130, 70, 30); // 진료 내용
		l6.setBounds(425, 160, 70, 30); // 진료 비용

		t1.setBounds(655, 100, 80, 30); // 진료 아이디
		t2.setBounds(495, 130, 80, 30);// 동물 이름
		t3.setBounds(655, 130, 80, 30);// 진료 내용
		t4.setBounds(495, 160, 80, 30);// 진료 비용

		register.setBounds(420, 200, 70, 30);
		delete.setBounds(490, 200, 70, 30);
		search.setBounds(560, 200, 70, 30);
		updateEx.setBounds(630, 200, 70, 30);
		clear.setBounds(700, 200, 70, 30);
		back.setBounds(690, 700, 85, 30);

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
		jmp.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// displayAll();

		// 메뉴페이지로 가기 버튼
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				MenuPage menuPage = new MenuPage();
				dispose();

			}
		});

		// 리스트 아이템 선택 시 텍스트 필드로 값 넣기
		// 리스트 아이템 클릭하면 상세 수정 페이지로 이동
		list.addItemListener((ItemListener) new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String str = list.getSelectedItem();
				System.out.println(str);
				StringTokenizer st = new StringTokenizer(str);

				cb.getSelectedItem();
				st.nextToken();
				t1.setText(st.nextToken());
				t2.setText(st.nextToken());
				t3.setText(st.nextToken());
				t4.setText(st.nextToken());

//            ExamDetailPage examDetailPage = new ExamDetailPage();
//            dispose();
			}

			private Object makeObject(String item) {
				return new Object() {
					public String toString() {
						return item;
					}
				};
			}
		});

		// 등록
		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// int examID = Integer.parseInt(t1.getText());
				String str = jcmemberID.getSelectedItem().toString();
				int memberID = Integer.parseInt(str);
				String memberName = t2.getText();
				String examContent = t3.getText();
				String examCost = t4.getText();
				ExaminationDao dao = new ExaminationDao();
				dao.registerEx(memberID, memberName, examContent, examCost);

				displayAll();
				JOptionPane.showMessageDialog(null, "저장 완료");
			}
		});

		// 삭제하기
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = jcmemberID.getSelectedItem().toString(); // 선택한 회원아이디 string으로
				if (str == "전체") {
					return;
				} else {
					int memberID = Integer.parseInt(str);
					int examID = Integer.parseInt(t1.getText());
					;

					ExaminationDao dao = new ExaminationDao();
					dao.deleteEx(memberID, examID);
					JOptionPane.showMessageDialog(null, "삭제 완료");
					displayAll();
				}

			}
		});

		// 텍스트 영역 지우기
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 지우기 버튼 코드 구현
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
			}
		});

		// 수정 버튼 눌림 감지
		updateEx.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int memberID = dto.getMemberID();
				int examID = Integer.parseInt(t1.getText());

				String memberName = t2.getText();
				String examContent = t3.getText();
				String examCost = t4.getText();
				ExaminationDao dao = new ExaminationDao();
				dao.updateEx(examID, memberName, examContent, examCost);
				JOptionPane.showMessageDialog(null, "수정 완료");

				dao = new ExaminationDao();
				displayAll();
			}
		});

		// examID 진료번호로 검색 결과		===========> 시도중
		// memberID로 검색 결과
		// 전체 검색 결과
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = jcmemberID.getSelectedItem().toString();
				System.out.println(str);

				if (str.equals("전체")) {
					t1.setText(String.valueOf("0"));// 진료 아이디
					displayAll();
				} else if (!str.equals("전체")) {
					// int memberID = Integer.parseInt(str);
					int memberID =  Integer.valueOf(str);
					ExaminationDao dao = new ExaminationDao();
					ExaminationDto dto = dao.searchExbyMemberID(memberID);

//				t1.setText(String.valueOf(dto.getExamID()));//진료 아이디
//				t2.setText(String.valueOf(dto.getMemberName()));//동물 이름
//				t3.setText(String.valueOf(dto.getExamContent()));//진료 내용
//				t4.setText(String.valueOf(dto.getExamCost()));// 진료 비용
					displayAllbyMemberID(memberID);
					// displayAll();
				}

			}
		});

		// 뒤로가기
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ManagerPage managerPage = new ManagerPage();
			}
		});

	}

	// 회원아이디 콤보
	private void selectCombo() {
		listCombo.clear();
		listCombo.add("전체");

		ExaminationDao dao = new ExaminationDao();

		ArrayList<ExaminationDto> allData = dao.selectEx();
		for (ExaminationDto dto : allData) {
			int memberID = dto.getMemberID();
			listCombo.add(memberID + "");
		}

	}

// 화면 출력
	private void displayAll() {
		list.removeAll();
		ExaminationDao dao = new ExaminationDao();
		dao.selectEx();
		ArrayList<ExaminationDto> allData = dao.selectEx();
		for (ExaminationDto dto : allData) {
			int examID = dto.getExamID();
			int memberID = dto.getMemberID();
			String memberName = dto.getMemberName();
			String examContent = dto.getExamContent();
			String examCost = dto.getExamCost();

			list.add(memberID + "                    " + examID + "                   " + memberName
					+ "                                  " + examContent + "                              " + examCost);
		}

	}

	// 화면 출력
	private void displayAllbyMemberID(int memberID) {
		list.removeAll();
		ExaminationDao dao = new ExaminationDao();
		dao.selectEx();

		ArrayList<ExaminationDto> allData = dao.selectExBymemberID(memberID);
		for (ExaminationDto dto : allData) {
			int examID = dto.getExamID();
			int memID = dto.getMemberID();
			String memberName = dto.getMemberName();
			String examContent = dto.getExamContent();
			String examCost = dto.getExamCost();

			list.add(memID + "                    " + examID + "                   " + memberName
					+ "                                  " + examContent + "                              " + examCost);
		}
	}
}
