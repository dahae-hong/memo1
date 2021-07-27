package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

@Repository
public class OracleMemberDAO implements MemberDAO{
	@Autowired
	DriverManagerDataSource ds;
	@Override
	public int insert(String id, String password) {
		String sql ="insert into member values(?,?)";
		
		try {
			PreparedStatement pstmt = ds.getConnection().prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;	
	}
	

}


