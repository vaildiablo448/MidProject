package bicycleRent;

import java.sql.Date;

public class bicycleBean {
	private Integer caseNum;
	private java.util.Date rentTime;
	private String rentStation;
	private java.util.Date returnTime;
	private String returnStation;
	private String totalRentTime;

	public bicycleBean() {
		
	}
	
	public bicycleBean(Integer caseNum, Date rentTime, String rentStation, Date returnTime, String returnStation,
			String totalRentTime) {
		super();
		this.caseNum=caseNum;
		this.rentTime=rentTime;
		this.rentStation=rentStation;
		this.returnTime=returnTime;	
		this.returnStation=returnStation;	
		this.totalRentTime=totalRentTime;
		
	}
	@Override
	public String toString() {
		return "bicycleBean [caseNum=" + caseNum + ", rentTime=" + rentTime + ", rentStation=" + rentStation
				+ ", returnTime=" + returnTime + ", returnStation=" + returnStation + ", totlaRentTime=" + totalRentTime
				+ "]";
	}	
	public Integer getCaseNum() {
		return caseNum;
	}
	public void setCaseNum(Integer caseNum) {
		this.caseNum = caseNum;
	}
	public java.util.Date getRentTime() {
		return rentTime;
	}
	public void setRentTime(java.util.Date rentTime) {
		this.rentTime = rentTime;
	}
	public String getRentStation() {
		return rentStation;
	}
	public void setRentStation(String rentStation) {
		this.rentStation = rentStation;
	}
	public java.util.Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(java.util.Date returnTime) {
		this.returnTime = returnTime;
	}
	public String getReturnStation() {
		return returnStation;
	}
	public void setReturnStation(String returnStation) {
		this.returnStation = returnStation;
	}
	public String getTotalRentTime() {
		return totalRentTime;
	}

	public void setTotalRentTime(String totalRentTime) {
		this.totalRentTime = totalRentTime;
	}
}
