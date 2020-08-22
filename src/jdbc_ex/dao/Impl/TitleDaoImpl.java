package jdbc_ex.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc_ex.conn.JdbcUtil;
import jdbc_ex.dao.TitleDao;
import jdbc_ex.dto.Title;

public class TitleDaoImpl implements TitleDao {
	//SingleTon!!!
	//고정된 메모리 영역을 얻으면서 한번의 new로 인스턴스를 사용하기 때문에 메모리 낭비를 방지할 수 있음
	private static final TitleDaoImpl instance = new TitleDaoImpl();

	private TitleDaoImpl() {}
	
	public static TitleDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Title> selectTitleByAll() {
		String sql = "SELECT TITLE_NO , TITLE_NAME FROM TITLE";
		try(Connection con = JdbcUtil.getConnection(sql);
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Title> list = new ArrayList<Title>();
				do {
					list.add(getTitle(rs));
				}while(rs.next());
				return list;
			}
		}catch(SQLException e) {
			throw new RuntimeException();
		}
				
		return null;
	}

	private Title getTitle(ResultSet rs) throws SQLException {
		int no = rs.getInt("TITLE_NO");
		String name = rs.getString("TITLE_NAME");
		return new Title(no, name);
	}

	@Override
	public Title selectTitleByNo(Title title) {
		return null;
	}

	@Override
	public int insertTitle(Title title) {
		return 0;
	}

	@Override
	public int updateTitle(Title title) {
		return 0;
	}

	@Override
	public int deleteTitle(Title title) {
		return 0;
	}

}
