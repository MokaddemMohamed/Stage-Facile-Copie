package com.projet.annuaire.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.projet.annuaire.model.Enterprise;

/**
 * 
 * @author LE Dan
 *
 */



public interface EnterpriseRepository extends JpaRepository<Enterprise, Long>{
	/**
	 * Find optional enterprise by id
	 */
    Optional<Enterprise> findById(Long id);
    /**
     * Find all enterprise
     */
    List <Enterprise> findAll();
    /**
     * Find by enterprise name
     * @param name Enterprise name
     * @return enterprise find
     */
    Enterprise findByName(String name);
    
    /**
     * Delete by id
     * @return enterprise delete
     */
    @Query("delete FROM Enterprise u where id=?1")
    Enterprise deleteById();
    /**
     * Function search
     * @param val value search
     * @return list enterprise with the value
     */
    @Query("Select P From Enterprise P Where name LIKE CONCAT(:val,'%') ")
	List<Enterprise> findAllByFirstName(@Param("val") String val);
    /**
     * search enterprise by adress
     * @param adress enterprise adress
     * @return enterprise find by adress
     */
    Enterprise findByAdress(String adress);
    
    /**
     * Search enterprise by postal code
     * @param postal_code enterprise postal code
     * @return enterprise find by postal code
     */
    Enterprise findByPostalCode(String postal_code);
    
	/**
	 * delete table enterprise
	 */
	@Transactional
	@Modifying
	@Query("delete FROM Enterprise")
    void deleteEnterprise();


}