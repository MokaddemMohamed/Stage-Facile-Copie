package com.projet.annuaire.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.annuaire.model.Enterprise;
import com.projet.annuaire.model.User;
import com.projet.annuaire.repository.EnterpriseRepository;

@Service
public class EnterpriseServiceImpl implements EnterpriseService{
	 @Autowired
	 private EnterpriseRepository enterpriseRepository;
	
	 @Override
	    public void save(Enterprise enterprise) {
	        enterpriseRepository.save(enterprise);
	    }

	    @Override
	    public Enterprise findByName(String name) {
	        return enterpriseRepository.findByName(name);
	    }

		@Override
		public void update(Enterprise enterprise, long id) {
			enterprise.setId(id);
			enterpriseRepository.save(enterprise);
		}

		@Override
		public void delete(Long id) {
			enterpriseRepository.deleteById(id);
			
		}

		@Override
		public List<Enterprise> findAllByFirstName(String name) {
			return enterpriseRepository.findAllByFirstName(name);
		}

		@Override
		public List<Enterprise> findAll() {
			return enterpriseRepository.findAll();
		}

		@Override
		public Enterprise findById(Long id) {
			return enterpriseRepository.findById(id).get();
		}


}
