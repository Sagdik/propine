package qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	public Properties propertiesFile;

	// Check the file and Read Property

	public PropertyReader() {

		PropertyReaderfile();

	}

	public Properties PropertyReaderfile() {
		try {
			propertiesFile = new Properties();

			File file = new File("./config.properties");

			FileInputStream fileConnection = new FileInputStream(file);

			// Check the property file
			propertiesFile.load(fileConnection);

		} catch (FileNotFoundException e) {
			// Generate the Exception Message for unable to Read File
			System.out.println("********Unable to Read Properties File**********");
		} catch (IOException e) {
			System.out.println("******** IOException **********");
		}
		return propertiesFile;
	}
	
}
