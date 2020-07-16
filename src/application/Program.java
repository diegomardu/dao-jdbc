package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		System.out.println("=== Test 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== Test 2: seller findByDepartment ===");
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 3: seller findAll ===");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 4: seller Insert ===");
		Seller newseller = new Seller(null, "Juvenal", "juvenal@teste", new Date(), 3500.0, department);
		sellerDao.insert(newseller);
		System.out.println("Inserted! New id : " + newseller.getId());
		
		System.out.println("\n=== Test 5: seller update ===");
		seller = sellerDao.findById(6);
		seller.setName("Albafica de Peixes");
		sellerDao.update(seller);
		System.out.println("Update Completed");
		
		System.out.println("\n=== Test 6: seller delete ===");
		System.out.printf("Informe id para deleção:");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete Completed");
		
		sc.close();
	}
	
	
}
