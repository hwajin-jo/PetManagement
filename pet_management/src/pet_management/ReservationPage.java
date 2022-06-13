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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import member.MemberDao;
import member.MemberDto;
import reservation.ReservationDao;
import reservation.ReservationDto;

public class ReservationPage extends JFrame { // 예약관리페이지

	List list;
	ArrayList<String> listCombo;

	public ReservationPage() {

		JPanel jp = new JPanel();

		Label lblTitle = new Label("예약 관리 페이지", SwingConstants.CENTER);
		Label lblMemberID = new Label("회원 아이디");
		Label lblReserverID = new Label("예약 아이디");
		Label lblMemberName = new Label("동물 이름");
		Label lblNext = new Label("예약 일자");
		add(lblTitle);
		add(lblMemberID);
		add(lblReserverID);
		add(lblMemberName);
		add(lblNext);

		// TextField t1 = new TextField(); // 회원 아이디 회원목록보여주기

		listCombo = new ArrayList<String>();
		selectCombo();
		JComboBox<?> jcmemberID = new JComboBox(listCombo.toArray(new String[listCombo.size()]));
		TextField txtReserverID = new TextField(); // 예약 아이디
		TextField txtMemberName = new TextField(); // 동물 이름
		TextField txtNext = new TextField(); // 예약 일자
		add(jcmemberID);
		add(txtReserverID);
		add(txtMemberName);
		add(txtNext);

		txtReserverID.setEnabled(false);// 회원아이디'수정막기'인데 이거 아닌 거 같음
		txtMemberName.setEnabled(false);

		Font font1 = new Font("맑은 고딕", Font.BOLD, 25);
		lblTitle.setFont(font1);

		JButton btnSave = new JButton("등록");
		JButton btnUpdate = new JButton("수정");
		JButton btnDelete = new JButton("삭제");
		JButton btnSearch = new JButton("조회");
		JButton btnReset = new JButton("지우기");
		JButton btnBack = new JButton("뒤로가기");
		add(btnSave);
		add(btnUpdate);
		add(btnDelete);
		add(btnSearch);
		add(btnReset);
		add(btnBack);

		list = new List();
		add(list);
		Font font2 = new Font("맑은 고딕", 0, 15);
		list.setFont(font2);

		lblTitle.setBounds(300, 30, 200, 40); // 예약 관리 페이지

		lblMemberID.setBounds(65, 120, 70, 30); // 회원 아이디
		jcmemberID.setBounds(135, 120, 70, 30);

		lblMemberName.setBounds(225, 120, 70, 30); // 동물 이름
		txtMemberName.setBounds(295, 120, 70, 30);

		lblReserverID.setBounds(385, 120, 70, 30); // 예약 아이디
		txtReserverID.setBounds(455, 120, 70, 30);

		lblNext.setBounds(545, 120, 70, 30); // 예약 일자
		txtNext.setBounds(615, 120, 120, 30);

		btnSave.setBounds(350, 200, 75, 30);
		btnUpdate.setBounds(430, 200, 75, 30);
		btnDelete.setBounds(510, 200, 75, 30);
		btnSearch.setBounds(590, 200, 75, 30);
		btnReset.setBounds(670, 200, 75, 30);
		btnBack.setBounds(660, 700, 90, 30);

		list.setBounds(50, 260, 700, 400);

		add(jp);

		setSize(800, 790);
		setTitle("예약관리화면");
		setResizable(false);
		Dimension frameSize = jp.getSize();

		// 모니터 크기
		setResizable(false);
		setLocationRelativeTo(jp);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		jp.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// 리스트 아이템 선택 시 텍스트 필드로 값 넣기
		list.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				String str = list.getSelectedItem();
				StringTokenizer st = new StringTokenizer(str);
				jcmemberID.setSelectedItem(st.nextToken());

				txtReserverID.setText(st.nextToken());
				txtMemberName.setText(st.nextToken());
				txtNext.setText(st.nextToken() + " " + st.nextToken()); // 예약일자

			}
		});

		jcmemberID.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String str = jcmemberID.getSelectedItem().toString();

				txtReserverID.setText("");
				txtMemberName.setText("");
				txtNext.setText("");

				if (str == "전체") {
					//System.out.println("전체..............."); // test
					return;
				}
				int memberID = Integer.parseInt(str);
				ReservationDao dao = new ReservationDao();
				ReservationDto dto = dao.searchMemberName(memberID);
				System.out.println("memberID:  " + memberID);
				System.out.println("getMemberName: " + dto.getMemberName());
				String t3string = dto.getMemberName();
				txtMemberName.setText(t3string);
				// txtMemberName.setVisible(true);
			}
		});

		// 등록하기
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = jcmemberID.getSelectedItem().toString();
				String nextReserve = txtNext.getText();
				// ------에러체크 -------------------------------------
				if (str == "전체") {
					JOptionPane.showMessageDialog(null, "회원아이디를 선택하세요.");
					return;
				}
				if (nextReserve == null) {
					JOptionPane.showMessageDialog(null, "예약 일자를 입력하세요.");
					return;
				}

				int memberID = Integer.parseInt(str);
				// int reservationID = Integer.parseInt(txtReserverID.getText());
				String memberName = txtMemberName.getText();

				// ------저장 -------------------------------------
				ReservationDao dao = new ReservationDao();
				int iCnt = dao.insertReserve(memberID, memberName, nextReserve);

				if (iCnt == 0) {
					JOptionPane.showMessageDialog(null, "예약 일자를 입력하세요.");

				} else {

					JOptionPane.showMessageDialog(null, "저장 완료");
					displayAll(memberID);
				}
			}
		});

		// 수정하기
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = jcmemberID.getSelectedItem().toString();
				String nextReserve = txtNext.getText();
				// ------에러체크 -------------------------------------
				if (str == "전체") {
					JOptionPane.showMessageDialog(null, "회원아이디를 선택하세요.");
					return;
				}

				int memberID = Integer.parseInt(str);
				int reservationID = Integer.parseInt(txtReserverID.getText());

				ReservationDao dao = new ReservationDao();
				dao.updateReserve(reservationID, memberID, nextReserve);
				JOptionPane.showMessageDialog(null, "수정 완료");
				displayAll(memberID);
			}
		});

		// 삭제하기
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = jcmemberID.getSelectedItem().toString();
				// ------에러체크 -------------------------------------
				if (str == "전체") {
					JOptionPane.showMessageDialog(null, "회원아이디를 선택하세요.");
					return;
				}

				int memberID = Integer.parseInt(str);
				int reservationID = Integer.parseInt(txtReserverID.getText());
				ReservationDao dao = new ReservationDao();
				dao.deleteReserve(memberID, reservationID);
				JOptionPane.showMessageDialog(null, "삭제 완료");
				displayAll(memberID);
			}
		});

		// 조회하기
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = jcmemberID.getSelectedItem().toString();
				if (str == "전체")
					str = "0";
				int memberID = Integer.parseInt(str);
				ReservationDao dao = new ReservationDao();
				ReservationDto dto = dao.searchMemberName(memberID);
				txtMemberName.setText(dto.getMemberName()); // 동물이름

				displayAll(memberID);

			}
		});

		// 뒤로가기(메뉴)
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuPage managerPage = new MenuPage();
			}
		});

		// 지우기
		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				txtReserverID.setText("");
				// txtMemberName.setText("");
				txtNext.setText("");

			}
		});
	}

	// 회원아이디 콤보
	private void selectCombo() {
		listCombo.clear();
		listCombo.add("전체");

		ReservationDao dao = new ReservationDao();

		ArrayList<ReservationDto> allData = dao.selectMemberID();
		for (ReservationDto dto : allData) {
			int memberID = dto.getMemberID();
			listCombo.add(memberID + "");
			// System.out.println(listCombo);
		}

	}

	// 화면 출력
	private void displayAll(int memberID) {
		list.removeAll();
		ReservationDao dao = new ReservationDao();
		ArrayList<ReservationDto> allData = dao.selectListReserve(memberID);
		for (ReservationDto dto : allData) {
			int memberID2 = dto.getMemberID();
			int reservationID = dto.getReservationID();
			String memberName = dto.getMemberName();
			String nextReserve = dto.getNextReserve();
			list.add(memberID2 + "              " + reservationID + "            " + memberName + "         "
					+ nextReserve + "                  ");

		}

	}

}
