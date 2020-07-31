package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//오라클 DB의  student 계정에 있는 member테이블 정보 가져오기
		//1.DriverManager에 드라이버에 대한 정보를 등록
		// *드라이버등록이라고 함은 사용할 클래스는 등록하는것
		//oracle.jdbc.driver.OralceDriver(고정)오라클 DB를 사용하려면 앞에 내용을 작성
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버등록 성공!!");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		//2. 등록된 클래스를 이용해서 Connection(연결) 정보를 가져옴
		//DriverManager클래스를 이용해서 연결정보를 갖는 객체를 생성 -> Connection
		// getConnection()메소드를 이용!
		//첫번째 매개변수: DB연결주소를 전달 -> jdbc:oracle:thin@DBserver주소(ip):1521(포트번호):xe(오라클버전SID)/oracle
		// *"jdbc:oracle:thin:@localhost:1521:xe"
		//두번째 매개변수: 사용자계정명 -> "student"
		//세번째 매개변수: 사용자패스워드-> "student"
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"student","student");//SQLException을 해야한다;
			System.out.println("Connection객체 생성 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//3. Connection객체를 이용해서 DB에 쿼리문을 실행할 수 있는 객체를 생성
		// -Statement객체 -> Connection.createStatment(); 
		//|| PreparrdStatment -> Connection.prepareStatement(sql);
		try {
			Statement stmt=conn.createStatement();
			System.out.println("statement객체 생성 성공");
			//4. Statement 객체를 이용해서 sql문을 실행하고 결과값 받아오기
			// -executeQuery("쿼리문") : db에서 select문을 실행할때 사용
			// -executeUpdate("쿼리문"):DB에서  insert,update,delete문 실행할때 사용
			// sql문을 작성하기->문자열로 sql구문을 작성하면 됨.
			String sql="SELECT * FROM MEMBER";//세미콜론은 작성하지 않음
			ResultSet rs=stmt.executeQuery(sql);//select문 실행!
			System.out.println("sql문 실행 성공");
			System.out.println("rs : "+rs);
			//DB에서 가져온 데이터 출력하기
//			rs.next();//resultset의 첫번째행(data)으로 이동
//			//대소문자 구분은 하지 않는다.
//			System.out.println("첫번째 행아이디 :"+rs.getString("member_id"));
//			System.out.println("첫번째 행 나이 : "+rs.getInt("age"));
//			rs.next();//두번째 행으로 이동
//			System.out.println("두번째 행아이디 :"+rs.getString("member_id"));
//			System.out.println("두번째 행 나이 : "+rs.getInt("age"));
			//re.next()->다음행으로 이동 이동할 행이 있으면 true반환,없으면 false;
			while(rs.next()) {
				System.out.print(rs.getString("member_id")+":");
				System.out.print(rs.getString("member_pwd")+":");
				System.out.print(rs.getString("member_name")+":");
				System.out.print(rs.getString("gender")+":");
				System.out.println(rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
