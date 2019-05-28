package bicycleRent;

import java.util.List;

public interface bicycleDAO {
	List<bicycleBean> findRentStation(String rentStation);
	List<bicycleBean> findAll();
	bicycleBean create(bicycleBean bB);
	boolean update(java.util.Date rentTime,String rentStation,
			java.util.Date returnTime,String returnStation,String totalRentTime,Integer caseNum);
	boolean remove(Integer caseNum);
	bicycleBean findByPk(Integer caseNum);
}
