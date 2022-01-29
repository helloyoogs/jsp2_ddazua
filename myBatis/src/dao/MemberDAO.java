package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import config.MyBatisConfig;
import vo.MemberVO;

public class MemberDAO {
	SqlSessionFactory sqlSession_f = MyBatisConfig.getSqlsession_f();
	SqlSession sqlSession;
	
	public MemberDAO() {
		sqlSession = sqlSession_f.openSession(true);
	}
	//���̵� �ߺ��˻�
	public boolean checkID(String id) {
		//���׸� Ÿ���� parseInt()�� �����ϸ� ���ڿ��� �ƴ� ���� �����߱� ������ ������ �߻��Ѵ�.
		//�̷� ������ Down Casting�� ����Ͽ� IntegerŸ������ ���� ����ȯ���ش�.
		return (Integer)(sqlSession.selectOne("Member.checkId", id)) == 1;

	}
	//ȸ������
	public void join(MemberVO member) {
		sqlSession.insert("Member.join", member);

	}
	//�α���
	public boolean login(String id, String pw) {
		HashMap<String, String> loginMap = new HashMap<>();
		loginMap.put("id", id);
		loginMap.put("pw", pw);
		
		return (Integer)(sqlSession.selectOne("Member.login", loginMap)) == 1;
	}
	//���� ����
	public boolean update(MemberVO member) {
		return sqlSession.update("Member.modify", member) == 1;
	}
	
	//ȸ�� Ż��
	public boolean delete(String id) {
		return sqlSession.delete("Member.remove", id) == 1;

	}
	//���̵� ��ȸ(�̸��� ��й�ȣ)
	public String findId(String name, String pw) {
		HashMap<String, String> findIdMap = new HashMap<>();
		findIdMap.put("name", name);
		findIdMap.put("pw", pw);
		return sqlSession.selectOne("Member.findId", findIdMap);
	}
	//���� ��ȸ(20���� �ƴ� ��)
	public List<MemberVO> findMember() {
		return sqlSession.selectList("Member.findMember");
	}
}
