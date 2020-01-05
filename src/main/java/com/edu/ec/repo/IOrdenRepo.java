package com.edu.ec.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.ec.model.Orden;
@Repository
public interface IOrdenRepo extends JpaRepository<Orden,Integer>  {
	@Modifying
	@Query ( value= "INSERT INTO db_ucacue.orden_examen (id_orden, id_examen) VALUES (?1, ?2)",nativeQuery = true)
	Integer insetarQuery(Integer a,Integer b); 
}
 