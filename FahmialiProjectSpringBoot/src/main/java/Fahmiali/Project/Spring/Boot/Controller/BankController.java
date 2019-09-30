package Fahmiali.Project.Spring.Boot.Controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import Fahmiali.Project.Spring.Boot.Dao.BankDao;
import Fahmiali.Project.Spring.Boot.Model.BankModel;



@RestController
@RequestMapping("/bank")
public class BankController {
	@Autowired
	BankDao bankDao;
	
	
	
	//simpan
	@PostMapping("/tabungan")
	public BankModel simpanTabungan(@Valid @RequestBody BankModel bankModel) {
		bankModel.setSaldo(bankModel.getKredit()-bankModel.getDebet());
		bankDao.save(bankModel);
		Long saldoKredit = bankDao.dataKredit(bankModel.getNik());
		Long saldoDebet = bankDao.dataDebet(bankModel.getNik());
		bankModel.setSaldo(saldoKredit-saldoDebet);

		
		return bankDao.save(bankModel);
	}
	//lihat Semua
	@GetMapping("/tabungan")
	public List<BankModel> AmbilSemuaData() {
		return bankDao.getAll();
	}
		
	//delete
	@DeleteMapping("/tabungan/{id}")
	public ResponseEntity<BankModel> deleteTabungan(@PathVariable (value="id")Long id) {
		BankModel data=bankDao.getFindOne(id);
		if(data==null) {
			return ResponseEntity.notFound().build();
		}else {
			Long saldo = bankDao.dataSaldoDelete(id); //yang akan dihapus
			String nik = bankDao.DapetNik(id); //ambil nik yang sama
			List<BankModel> nn =bankDao.getNik(nik);
				for(BankModel bm :nn) {
					if(bm.getId()>id) {

						bm.setSaldo(bm.getSaldo()-saldo);
						bankDao.save(bm);
					}
					
				}	
			bankDao.delete(id);
			return  ResponseEntity.ok().build();
		}
	}
	
	//update
	@PutMapping("/tabungan/{id}")
	public ResponseEntity<BankModel> updateTabungan(@PathVariable (value="id")Long id, @Valid @RequestBody BankModel bankModel){
		BankModel data=bankDao.getFindOne(id);
		String nik = bankDao.DapetNik(id); //ambil nik yang sama
		List<BankModel> nn =bankDao.getNik(nik);
		if(data==null) {
			return ResponseEntity.notFound().build();
		}
		else {
			data.setKredit(bankModel.getKredit());
			data.setDebet(bankModel.getDebet());
			data.setSaldo(data.getKredit()-data.getDebet());
			BankModel Hasil=bankDao.save(data);
			for(BankModel bm :nn) {
				if(bm.getId()>id) {
					Long da = bm.getKredit()-bm.getDebet(); 
					bm.setSaldo(data.getSaldo()+da);
					bankDao.save(bm);
				}
				
			}	
			
			return ResponseEntity.ok().body(Hasil);
		}
	}
	
	@GetMapping("/tabungan/{id}")
	public ResponseEntity<BankModel> getOneTabunganById(@PathVariable (value="id")Long id) {
		BankModel data=bankDao.getFindOne(id);
		if(data==null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().body(data);
		}
	}
	
	@GetMapping("/tabunganData/{nik}")
	public List<BankModel> getOneTabunganById(@PathVariable (value="nik")String nik) {
		return bankDao.getNik(nik);
		
	}
	
	
	
	
		
}
