package bicycleRent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class IbicycleDAO implements bicycleDAO {

	DataSource ds = null;

	public IbicycleDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/BicycleRent");
		} catch (Exception e) {
			System.out.println("Error");
			return;
		}
	}

	private static final String SelectOne = "Select * from BicycleRent where rent_station = ?";

	@Override
	public List<bicycleBean> findRentStation(String rentStation) {
		List<bicycleBean> result = null;
		try (Connection conn = ds.getConnection(); PreparedStatement pstm = conn.prepareStatement(SelectOne);ResultSet rs = pstm.executeQuery()) {
			pstm.setString(1, rentStation);
			
			result = new Vector<>();
			while (rs.next()) {
				bicycleBean tempA = new bicycleBean();
				tempA.setCaseNum(rs.getInt("case_num"));
				tempA.setRentStation(rs.getString("rent_station"));
				tempA.setReturnStation(rs.getString("return_station"));
				tempA.setTotalRentTime(rs.getString("total_rent_time"));
				tempA.setRentTime(rs.getDate("rent_time"));
				tempA.setReturnTime(rs.getDate("return_time"));
				result.add(tempA);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String SelectAll = "Select * from BicycleRent";

	@Override
	public List<bicycleBean> findAll() {
		List<bicycleBean> result = null;

		try (Connection conn = ds.getConnection();
				PreparedStatement pstm = conn.prepareStatement(SelectAll);
				ResultSet rs = pstm.executeQuery()) {

			result = new Vector<>();
			while (rs.next()) {
				bicycleBean tempB = new bicycleBean();
				tempB.setCaseNum(rs.getInt("case_num"));
				tempB.setRentStation(rs.getString("rent_station"));
				tempB.setReturnStation(rs.getString("return_station"));
				tempB.setTotalRentTime(rs.getString("total_rent_time"));
				tempB.setRentTime(rs.getDate("rent_time"));
				tempB.setReturnTime(rs.getDate("return_time"));
				result.add(tempB);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	private static final String Insert = "Insert into BicycleRent (case_num,rent_time,rent_station,return_time,return_station,total_rent_time) values (?,?,?,?,?,?)";

	@Override
	public bicycleBean create(bicycleBean bB) {
		bicycleBean result = null;

		try (Connection conn = ds.getConnection(); PreparedStatement pstm = conn.prepareStatement(Insert)) {
			pstm.setInt(1, bB.getCaseNum());
			pstm.setString(3, bB.getRentStation());
			pstm.setString(5, bB.getReturnStation());
			pstm.setString(6, bB.getTotalRentTime());

			java.util.Date temp = bB.getRentTime();
			if (temp != null) {
				java.sql.Date rentTime = new java.sql.Date(temp.getTime());
				pstm.setDate(2, rentTime);
			} else {
				pstm.setDate(2, null);
			}
			java.util.Date temp1 = bB.getReturnTime();
			if (temp1 != null) {
				java.sql.Date returnTime = new java.sql.Date(temp1.getTime());
				pstm.setDate(4, returnTime);
			} else {
				pstm.setDate(4, null);
			}

			int i = pstm.executeUpdate();
			if (i == 1) {
				result = this.findByPk(bB.getCaseNum());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String SelectByPk = "Select * from BicycleRent where case_num = ?";
	@Override
	public bicycleBean findByPk(Integer caseNum) {
		bicycleBean result = null;
		try (Connection conn = ds.getConnection(); 
			PreparedStatement pstm = conn.prepareStatement(SelectByPk);
				
		) {
			pstm.setInt(1, caseNum);
			try (
				ResultSet rs = pstm.executeQuery();
			) {
				
				if (rs.next()) {
					result = new bicycleBean();
					result.setCaseNum(rs.getInt("case_num"));
					result.setRentStation(rs.getString("rent_station"));
					result.setReturnStation(rs.getString("return_station"));
					result.setTotalRentTime(rs.getString("total_rent_time"));
					result.setRentTime(rs.getDate("rent_time"));
					result.setReturnTime(rs.getDate("return_time"));
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String UPDATE = "update BicycleRent set rent_time=?,rent_station=?,return_time=?,return_station=?,total_rent_time=? where case_num=?";
	@Override
	public boolean update(Date rentTime, String rentStation, Date returnTime, String returnStation,
			String totalRentTime, Integer caseNum) {
		try (Connection conn = ds.getConnection(); PreparedStatement pstm = conn.prepareStatement(UPDATE)) {
			IbicycleDAO bBB = new IbicycleDAO();
			bicycleBean bBb = bBB.findByPk(caseNum);
			if (bBb.getCaseNum() != null) {
				if (rentTime != null) {
					long rentTime1 = rentTime.getTime();
					pstm.setDate(1, new java.sql.Date(rentTime1));
				} else {
					pstm.setDate(1, null);
				}
				pstm.setString(2, rentStation);
				if (returnTime != null) {
					long returnTime1 = returnTime.getTime();
					pstm.setDate(3, new java.sql.Date(returnTime1));
				} else {
					pstm.setDate(3, null);
				}
				pstm.setString(4, returnStation);
				pstm.setString(5, totalRentTime);
				pstm.setInt(6, caseNum);
				int i = pstm.executeUpdate();
				if (i == 1) {
					return true;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private static final String DELETE = "Delete from BicycleRent where case_num=?";

	@Override
	public boolean remove(Integer caseNum) {
		try (Connection conn = ds.getConnection(); 
			PreparedStatement pstm = conn.prepareStatement(DELETE);) {
			pstm.setInt(1, caseNum);
			int i = pstm.executeUpdate();
			if (i == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
