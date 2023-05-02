package SV;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	//1안 
	//client 단 처리 -> dup체크, 클릭한 범위 idx변환 후 
	//
	// turn 값과 같이 servlet에 request(xindx, yindx, turn) 전달
	// < form > <li type ="submit" value=""> ?</form>
	//servlet 단 처리 -> 
	private PreparedStatement pstmt;
	private Connection con;
	ResultSet rs;
	private DataSource dataFactory;
	
	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public boolean addresult(BoardVO vo) {
		boolean result = false;
//		BoardVO vo = new BoardVO();
		try { 
			con = dataFactory.getConnection();
			String query = "INSERT INTO GORESULT (whowin, gamedate) VALUES (?,?)";
			pstmt = con.prepareStatement(query);
			int pstmtInt = 1;
			pstmt.setString(pstmtInt++, vo.getWhowin());
			pstmt.setString(pstmtInt++, vo.getGamedate());
			int r = pstmt.executeUpdate();
			if (r > 0) result = true;
			pstmt.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
		
		
	
		
		
	}

}
