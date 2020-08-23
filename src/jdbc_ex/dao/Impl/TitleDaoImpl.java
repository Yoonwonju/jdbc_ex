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
	// SingleTon!!!
	// 고정된 메모리 영역을 얻으면서 한번의 new로 인스턴스를 사용하기 때문에 메모리 낭비를 방지할 수 있음
	private static final TitleDaoImpl instance = new TitleDaoImpl();

	private TitleDaoImpl() {
	}

	public static TitleDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Title> selectTitleByAll() {
		String sql = "SELECT TITLE_NO , TITLE_NAME FROM TITLE";
		try (Connection con = JdbcUtil.getConnection(sql);
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Title> list = new ArrayList<Title>();
				do {
					list.add(getTitle(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
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
		String sql = "SELECT TITLE_NO, TITLE_NAME FROM TITLE WHERE TITLE_NO = ?";
		try (Connection con = JdbcUtil.getConnection(sql); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, title.getNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getTitle(rs);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return null;
	}
	
	@Override
	public int insertTitle(Title title) {
		String sql = "INSERT INTO TITLE VALUES (?, ?)";
		try(Connection con = JdbcUtil.getConnection(sql);
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, title.getNo());
			pstmt.setString(2, title.getName());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public int updateTitle(Title title) {
		String sql = "UPDATE TITLE SET TITLE_NAME = ? TITLE_NO = ?";
		try(Connection con = JdbcUtil.getConnection(sql);
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, title.getName());
			pstmt.setInt(2, title.getNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public int deleteTitle(Title title) {
		String sql = "DELETE FROM TITLE WHERE TITLE_NO = ?";
		try(Connection con = JdbcUtil.getConnection(sql);
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, title.getNo());
			return pstmt.executeUpdate();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}

}
