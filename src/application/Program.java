package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Department obj = new Department(1, "Diego");
		
		Seller seller = new Seller(21, "Diego", "diego@teste.com", new Date(), 3000.0, obj);
		
		SellerDao sallerDao = DaoFactory.createSellerDao();
		
		System.out.println(seller);
	}

}
