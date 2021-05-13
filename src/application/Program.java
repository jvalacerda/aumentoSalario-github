package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import employed.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		List<Employee> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			System.out.print("Employee #" + (i + 1) + ":\n");
			System.out.print("Id:");
			Integer id = sc.nextInt();

			System.out.print("Name:");
			sc.nextLine();
			String name = sc.nextLine();

			System.out.print("Salary:");
			Double salary = sc.nextDouble();

			Employee emp = new Employee(id, name, salary);

			list.add(emp);
		}

		System.out.print("Enter the employee id that will have salary increase :");
		int employeeId = sc.nextInt();

		Employee emp = list.stream().filter(x -> x.getId() == employeeId).findFirst().orElse(null);

		if (emp == null) {
			System.out.print("This id does not exist!\n");

		} else {
			System.out.print("Enter the percentage:");
			double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}

		System.out.print("List of employees:\n");

		for (Employee obj : list) {
			System.out.println(obj);
		}
		
		sc.close();
	}

}
