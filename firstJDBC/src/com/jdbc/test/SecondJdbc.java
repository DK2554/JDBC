package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SecondJdbc {

	public static void main(String[] args) {
		//DB에서 데이터를 가져온 후 닫아줘야하는 객체 맨위에 미리 선언함.
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			//1.드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버등록 성공");
			//2.Connection 객체 생성
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
//			//3.Statement 객체 생성
//			stmt=conn.createStatement();
//			//4. 실행할 쿼리문 작성
//			String sql="SELECT * FROM MEMBER";
//			//5. 쿼리문실행 결과를 받아옴
	//		rs=stmt.executeQuery(sql);
//			//6. rs에 저장된 데이터 확인!
//			//rs.next() :가져온 DB테이블의 다음 row로 이동하는 메소드 다음 row가 있으면 true를 반환, 없으면 false를 반환
//			//컬럼의 데이터를 가져오는 메소드
//			//rs.getString(컬럼명||컬럼의 인덱스값):컬럼의 자료형이 문자(char,varcha2,ncahr,nvarchar2)일때
//			//rs.getInt(컬럼명||컬럼의 인덱스값):커럶의 자료형이 숫자(number)
//			//rs.getDate(컬럼명||컬럼인덱스값):컬럼의 자료형이 날짜(date)
//			//rs.getDouble(컬럼명||컬럼의 인덱스 값):z컬럼의 자료형이 숫자(실수 일때)(number)
//			while(rs.next()) {
//				System.out.print(rs.getString("member_id"));
//				System.out.print(rs.getString("member_pwd"));
//				System.out.print(rs.getString("member_name"));
//				System.out.print(rs.getString("gender"));
//				System.out.print(rs.getInt("age"));
//				System.out.print(rs.getString("email"));
//				System.out.print(rs.getString("phone"));
//				System.out.print(rs.getString("address"));
//				System.out.print(rs.getString("hobby"));
//				System.out.println(rs.getDate("enroll_date"));
//			}
			//jDBC를 이용해 DB에 데이터 넣기
			//insert문 실행하기//
			stmt=conn.createStatement();
			String insert="INSERT INTO MEMBER VALUES('USER33','USER33','유저삼','F',30,'USER33@USER33.COM','010123123','서울시 테헤란로','독서',SYSDATE)";
			//DML구문(INSERT,UPDATE,DELETE)을 실행하려면
			//Statement.executeUpdate()메소드를 이용함
			//executeUpdate구문은 반환형이 int형으로 반환된,데이터 변경갯수가 출력됨
			int result=stmt.executeUpdate(insert);
			//insert,update,delete로 데이터를 수정하면.. 트랜젝션처리를 해줘야함
			//트렌젝션관련 내용은 접속을 관리하는 Connection객체에
			//commit(): DB에 commit명령을 실행
			//rollback():DB에 rollback명령을 실행
			if(result>0) {
				//커밋처리
				System.out.println("커밋완료");
				conn.commit();//SQLException 처리를 해줘야함
			}else {
				//롤백처리
				conn.rollback();
			}
			System.out.println("실행결과 : "+result);
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					//rs.close();//null이 아닐때
					stmt.close();
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		
	
	

	}

}
