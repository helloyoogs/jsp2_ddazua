package test;

import dao.MemberDAO;
import vo.MemberVO;

public class Test {
	public static void main(String[] args) {
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		
		dao.findMember().forEach(member -> {
			System.out.print(member.getId() + ",");
			System.out.print(member.getName() + ",");
			System.out.print(member.getPw() + ",");
			System.out.println(member.getAge());
		});
		
//		System.out.println(dao.findId("ȫ�浿", "1234"));
		
//		vo.setId("hds2222");
//		vo.setPw("1234");
//		vo.setName("�̼���");
//		vo.setAge(20);
		
//		if (dao.delete("hds1234")) {
//			System.out.println("ȸ��Ż�� ����");
//		}
		
//		if (dao.update(vo)) {
//			System.out.println("���� ����");
//		}
		
//		if (!dao.checkID(vo.getId())) {
//			dao.join(vo);
//		}
//		
//		if (dao.login("hds1234", "1111")) {
//			System.out.println("�α��� ����");
//		} else {
//			System.out.println("�α��� ����");
//		}
	}
}
