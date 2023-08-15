package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== TEST 1: Seller findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n==== TEST 2: Seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TEST 3: Seller findAll ====");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TEST 4: Seller insert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n==== TEST 5: Seller update ====");
		seller = sellerDao.findById(1);
		seller.setName("Jack Grealish");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n==== TEST 6: Seller delete ====");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		System.out.println("\n==== TEST 1: Department findById ====");
		department = departmentDao.findById(2);
		System.out.println(department);
		
		System.out.println("\n==== TEST 2: Department findAll ====");
		List<Department> listDep = departmentDao.findAll();
		for (Department obj : listDep) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TEST 3: Department insert ====");
		Department newDepartment = new Department(null, "Games");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n==== TEST 4: Department update ====");
		department = departmentDao.findById(1);
		department.setName("Notebooks");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n==== TEST 5: Department delete ====");
		System.out.print("Enter id for delete test: ");
		id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}
}
