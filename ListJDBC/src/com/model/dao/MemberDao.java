package com.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class MemberDao {
		private Properties prop=new Properties();
		public MemberDao() {
			//기본생성자를 통해서 Properties설정
			try {
				prop.load(new FileReader("resource/member_query.properties"));
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
	public void searchMemberAll(Connection con) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty(key)
		
		
		
	}

}
