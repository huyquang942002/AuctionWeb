package dao;

import java.util.List;




public interface CommodityDao {
	public List fuzzySerchBookList(String keyword);
	public List fuzzySerchWatchList(String keyword);
	public List fuzzySerchStampList(String keyword);
	public List fuzzySerchWineList(String keyword);
	public List fuzzySerch(String keyWord);
	public List getAllList();
		
}
