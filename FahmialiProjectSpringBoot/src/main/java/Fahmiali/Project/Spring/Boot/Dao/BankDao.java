package Fahmiali.Project.Spring.Boot.Dao;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import Fahmiali.Project.Spring.Boot.Model.BankModel;
import Fahmiali.Project.Spring.Boot.Repository.BankRepository;




@Service
public class BankDao {
	@Autowired
	BankRepository bankRepository;
	

	
	//ambil semua data
	public List<BankModel> getAll(){
		return bankRepository.findAll();
	}
	
	//get by id
	public BankModel getFindOne(Long id) {
		return bankRepository.findOne(id);
	}
	
	
	
	public List<BankModel> getNik(String nik) {
		return bankRepository.findTabunganByNik(nik);
	}
	
	public Long dataKredit(String nik) {
		return bankRepository.findKredit(nik);
	}
	public Long dataDebet(String nik) {
		return bankRepository.findDebet(nik);
	}
	
	
	public Long dataSaldoDelete(Long id) {
		return bankRepository.findDeleteData(id);
	}
	
	public String DapetNik(Long id) {
		return bankRepository.lihatNik(id);
	}
	


	//save
	public BankModel save(BankModel bankModel) {
		return bankRepository.save(bankModel);
	}
	
	//delete
	public void delete(Long id) {
		bankRepository.delete(id);
	}
	
	
	public Long jumNik(String nik) {
		return bankRepository.findLongNik(nik);
	}
	
	
	
	
	
	
	
		
}
