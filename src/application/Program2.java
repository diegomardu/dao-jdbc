package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		
		System.out.println("=== TEST 1: findById =======");
		Department dep = departmentDao.findById(4);
		System.out.println(dep);
		
		System.out.println("\n=== Test 2: department Insert ===");
		Department newDep = new Department(null, "Auto");
		departmentDao.insert(newDep);
		System.out.println("Inserted! New id : " + newDep.getId());
		
		System.out.println("\n=== Test 3: department update ===");
		dep = departmentDao.findById(3);
		dep.setName("Games");
		departmentDao.update(dep);
		System.out.println("Update Completed");
		
		System.out.println("\n=== Test 4: department delete ===");
		System.out.printf("Informe id para deleção:");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Completed");
		
		System.out.println("\n=== Test 5: findAll =======");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		
		sc.close();
		
	}

}
