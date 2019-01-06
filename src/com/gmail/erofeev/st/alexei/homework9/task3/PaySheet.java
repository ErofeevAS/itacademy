package com.gmail.erofeev.st.alexei.homework9.task3;

public class PaySheet {

	public void showPaySheet(Employee[] employees) {
		for (Employee employee : employees) {
			if (employee != null) {
				String employeeInfo = employee.getName().concat(" ").concat(employee.getSurName()).concat(" ")
						.concat(employee.getPosition()).concat(" ").concat("salary:").concat(String.valueOf(employee.getSalary()));
				System.out.println(employeeInfo);
			}
		}
	}

}
