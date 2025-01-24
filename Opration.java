package com.first.Crud.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.first.Crud.DAO.CrudRepo;
import com.first.Crud.Entity.CrudOP;

@Service
public class Opration{
	 @Autowired
	    private CrudRepo crudRepo;
	public void saveform(CrudOP crudop) {
			crudRepo.save(crudop);
			
		}
		 public List<CrudOP> getAllUsers() {
		        return crudRepo.findAll();  // Fetch all users from the "crud" table
		    }
		 
		 public void deleteUserById(long ID) {
			 crudRepo.deleteById(ID);  // Using JPA's deleteById method
		    }
		 
		 
		public void update(long ID) {
			crudRepo.findById(ID);
		}
}