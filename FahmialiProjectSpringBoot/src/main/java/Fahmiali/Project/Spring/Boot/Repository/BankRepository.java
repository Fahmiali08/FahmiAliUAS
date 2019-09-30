package Fahmiali.Project.Spring.Boot.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Fahmiali.Project.Spring.Boot.Model.BankModel;


public interface BankRepository extends JpaRepository<BankModel, Long>{
	
	@Query(value="SELECT * FROM tabungan_tbl WHERE nik=:nik", nativeQuery = true)
	List<BankModel> findTabunganByNik(@Param("nik") String nik);
	
	@Query(value="SELECT sum(kredit) FROM tabungan_tbl WHERE nik=:nik", nativeQuery = true)
	Long findKredit(@Param("nik") String nik);
	
	@Query(value="SELECT sum(debet) FROM tabungan_tbl WHERE nik=:nik", nativeQuery = true)
	Long findDebet(@Param("nik") String nik);
	
	
	@Query(value="SELECT saldo FROM tabungan_tbl WHERE id=:id", nativeQuery = true)
	Long findDeleteData(@Param("id") Long id);
	
	@Query(value="SELECT nik FROM tabungan_tbl WHERE id=:id", nativeQuery = true)
	String lihatNik(@Param("id") Long id);
	

	
	@Query(value="SELECT count(nik) FROM tabungan_tbl WHERE nik=:nik", nativeQuery=true)
	Long findLongNik(@Param("nik") String nik);
	

}
