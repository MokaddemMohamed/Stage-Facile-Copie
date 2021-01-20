package com.projet.annuaire.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.annuaire.model.Tutor;
import com.projet.annuaire.repository.TutorRepository;

/**
 * 
 * @author MOKADDEM Mohamed
 *
 */
@Service
public class TutorServiceImpl implements TutorService{
	 @Autowired
	 private TutorRepository tutorRepository;
	
	 @Override
	    public void save(Tutor tutor) {
	        tutorRepository.save(tutor);
	    }

	    @Override
	    public Tutor findById(Long id) {
	        return tutorRepository.findById(id).get();
	    }

		@Override
		public void update(Tutor tutor, Long id) {
			tutor.setId(id);
			tutorRepository.save(tutor);
		}

		@Override
		public void deleteById(Long id) {
			tutorRepository.deleteById(id);
			
		}

		@Override
		public List<Tutor> findAll() {
			// TODO Auto-generated method stub
			return tutorRepository.findAll();
		}


}
