package jdbc_ex.dao;

import java.util.List;

import jdbc_ex.dto.Title;

public interface TitleDao {
	List<Title> selectTitleByAll();
	
	Title selectTitleByNo(Title title);
	
	int insertTitle(Title title);
	
	int updateTitle(Title title);
	
	int deleteTitle(Title title);
}
