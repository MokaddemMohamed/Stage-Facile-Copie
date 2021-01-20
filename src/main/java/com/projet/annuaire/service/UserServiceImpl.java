package com.projet.annuaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projet.annuaire.model.User;
import com.projet.annuaire.repository.RoleRepository;
import com.projet.annuaire.repository.UserRepository;

import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    @Override 
    public void update(User user, String name) {
        user.setId(userRepository.findByUsername(name).getId());
        user.setPassword(userRepository.findByUsername(name).getPassword());
        user.setPasswordConfirm(userRepository.findByUsername(name).getPassword());
        user.setRole(userRepository.findByUsername(name).getRole());
        
        userRepository.save(user);
    }

	@Override
	public User findBytel(String tel) {
		return userRepository.findByTel(tel);
	}

	@Override
	public User findByFirstName(String first_name) {
		return userRepository.findByFirstName(first_name);
	}

	@Override
	public User findByLastName(String last_name) {
		return userRepository.findByLastName(last_name);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findByMail(String mail) {
		return userRepository.findByMail(mail);
	}
}