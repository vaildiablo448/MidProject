package bicycleRent;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class bicycleService {
	IbicycleDAO ibd=null;	
	public bicycleService() {
		ibd = new IbicycleDAO();
	}	
	public List<bicycleBean> findRentStation(String rentStation) {
		return ibd.findRentStation(rentStation);
	}
	public List<bicycleBean> findAll() {
		return ibd.findAll();
	}
	public bicycleBean findByPk(Integer caseNum) {
		return ibd.findByPk(caseNum);
	}
	public boolean update(Date rentTime, String rentStation, Date returnTime, String returnStation,
			String totalRentTime,Integer caseNum) {
		return ibd.update(rentTime, rentStation, returnTime, returnStation, totalRentTime,caseNum);
	}
	public bicycleBean create(bicycleBean bB) throws SQLException {
		return ibd.create(bB);
	}
	public boolean remove(Integer caseNum) {
		return ibd.remove(caseNum);
	}
}
