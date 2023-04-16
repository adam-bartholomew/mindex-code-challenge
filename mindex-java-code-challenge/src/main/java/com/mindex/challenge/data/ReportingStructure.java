package com.mindex.challenge.data;

public class ReportingStructure {
	private Employee employee;
	private int totalNumberOfReports;
	
	public ReportingStructure(Employee employee, int totalNumberOfReports) {
		this.employee = employee;
		this.totalNumberOfReports = totalNumberOfReports;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public int getTotalNumberOfReports() {
		return totalNumberOfReports;
	}
	
	public void setEmployee(Employee newEmployee) {
		this.employee = newEmployee;
	}
	
	public void setTotalNumberOfReports(Employee employee) {
		Integer directReports = 0;
		for(Employee e : employee.getDirectReports()) {
			directReports += 1;
			if(!e.getDirectReports().isEmpty()) {
				directReports += e.getDirectReports().size();
			}
		}
		
		this.totalNumberOfReports = directReports;
	}
}
