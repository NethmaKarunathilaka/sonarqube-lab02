package com.example;

import java.sql.SQLException;
import java.util.logging.Logger;

public class App {
   private static final Logger logger = Logger.getLogger(App.class.getName());

   public static void main(String[] args) throws SQLException { 
      Calculator calc = new Calculator(); 
      logger.info("Result: " + calc.calculate(10, 5, "add")); 
      UserService service = new UserService(); 
      service.findUser("admin");
   } 
}

