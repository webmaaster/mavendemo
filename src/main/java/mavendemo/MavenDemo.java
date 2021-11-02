package mavendemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MavenDemo {

	private static final Logger logger = LogManager.getLogger(MavenDemo.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("my first maven java project");
		logger.info("info logged");
	}

}
