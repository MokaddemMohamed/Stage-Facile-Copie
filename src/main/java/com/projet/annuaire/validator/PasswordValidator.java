package com.projet.annuaire.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @author MOKADDEM Mohamed
 *
 */
public class PasswordValidator{

      private Pattern pattern;
      private Matcher matcher;

      private static final String PASSWORD__PATTERN =
              "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$";

      public PasswordValidator(){
          pattern = Pattern.compile(PASSWORD__PATTERN);
      }
      
      /** 
       **  Validate password with regular expression
       **  @param password password for validation
       **  @return true valid password, false invalid password
       **/
        public boolean validate(final String password){

          matcher = pattern.matcher(password);
          return matcher.matches();

      }
}