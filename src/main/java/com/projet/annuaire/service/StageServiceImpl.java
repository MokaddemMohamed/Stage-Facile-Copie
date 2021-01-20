package com.projet.annuaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projet.annuaire.model.Comment;
import com.projet.annuaire.model.Stage;
import com.projet.annuaire.model.User;
import com.projet.annuaire.repository.RoleRepository;
import com.projet.annuaire.repository.StageRepository;

import java.util.HashSet;
import java.util.List;
/**
 * 
 * @author MOKADDEM Mohamed
 *
 */

@Service
public class StageServiceImpl implements StageService {
    @Autowired
    private StageRepository stageRepository;

    @Override
    public void save(Stage stage) {
        stageRepository.save(stage);
    }

	@Override
	public void update(Stage stageForm, Long id) {
		stageForm.setId(id);
		stageRepository.save(stageForm);
		
	}


	@Override
	public void deleteById(Long id) {
		stageRepository.deleteById(id);
		
	}
	
	@Override
	public List<Stage> findByEnterpriseId(Long id) {
		return stageRepository.findByEnterpriseId(id);
		
	}

	@Override
	public void saveComment(Stage stageForm,Comment comment) {
		stageRepository.save(stageForm);
		
	}

	@Override
	public Stage findById(Long id) {
		return stageRepository.findById(id).get();
	}

	@Override
	public List<Stage> findAll() {
		return stageRepository.findAll();
	}

	@Override
	public List<Stage> findByAdministrator(String string) {
		return stageRepository.findByAdministrator(string);
	}

	@Override
	public List<Stage> findByUserId(Long id) {
		return stageRepository.findByUserId(id);
	}


}