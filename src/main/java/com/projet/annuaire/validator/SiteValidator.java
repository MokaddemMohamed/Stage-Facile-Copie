package com.projet.annuaire.validator;

import java.net.URL;
/**
 * 
 * @author LE Dan
 *
 */
public class SiteValidator {
public boolean isValid(String url) {

    try { 
        new URL(url).toURI(); 
        return true; 
    } 
      
    catch (Exception e) { 
        return false; 
    } 
}
}