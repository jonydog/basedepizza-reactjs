package com.jpinto.basedepizza.utils;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

public class CamelCaseNamingStrategy extends SpringPhysicalNamingStrategy{

	@Override
	public Identifier toPhysicalColumnName(Identifier name,
			JdbcEnvironment jdbcEnvironment) {
		return new Identifier( name.getText().substring(0, 1).toLowerCase() + toCamelCase( name.getText() ).substring(1)  , name.isQuoted());
	}
	
	private static String toCamelCase(String s){
		   String[] parts = s.split("_");
		   if(parts.length==1){
			   return s;
		   }
		   String camelCaseString = "";
		   for (String part : parts){
		      camelCaseString = camelCaseString + toProperCase(part);
		   }
		   return camelCaseString;
		}

	private static String toProperCase(String s) {
		    return s.substring(0, 1).toUpperCase() +
		               s.substring(1).toLowerCase();
	}
}
