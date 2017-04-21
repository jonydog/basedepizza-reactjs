package com.jpinto.basedepizza.configs;


	import java.io.File;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.jdbc.datasource.init.ScriptUtils;

	public class PizzaPersistenceTest {

		@Autowired
		private DataSource dataSource;


		@Before
		public  void initScripts() throws ScriptException, SQLException {

			File preloadScript = new File("src/main/resources/preload.sql");
			ScriptUtils.executeSqlScript(this.dataSource.getConnection(), new EncodedResource(  new FileSystemResource(preloadScript) , "UTF-8" ));
		}

	}

