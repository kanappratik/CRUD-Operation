package com.first.Crud.DAO;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.first.Crud.Entity.CrudOP;
@Repository
public interface CrudRepo extends JpaRepository<CrudOP,Long>{

}
