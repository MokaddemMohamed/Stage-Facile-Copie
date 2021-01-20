package com.projet.annuaire.service;

import java.util.List;
import java.util.Optional;

import com.projet.annuaire.model.Enterprise;


public interface EnterpriseService {
	/**
	 * Save enterprise
	 * @param enterprise enterprise to save
	 */
    void save(Enterprise enterprise);
    /**
     * update enterprise
     * @param enterprise to update with specific id
     * @param id specific id
     */
    void update(Enterprise enterprise, long id);
    /**
     * delete enterprise find by id
     * @param id enterprise id 
     */
    void delete(Long id);
    /**
     * Find enterprise by name
     * @param name enterprise name
     * @return enterprise
     */
    Enterprise findByName(String name);
    /**
     * Find enterprise by firstName
     * @param name enterprise firstName
     * @return list of enterprise
     */
    List <Enterprise> findAllByFirstName(String name);
    /**
     * Find all enterprise
     * @return list of all enterprise
     */
	List<Enterprise> findAll();
	/**
	 * search enterprise by id
	 * @param id enterprise id
	 * @return enterprise find
	 */
	Enterprise findById(Long id);
	
	
}