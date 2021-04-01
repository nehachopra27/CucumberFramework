package manager;

import dataProvider.PropertyReader;

public class FileReaderManager {
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static PropertyReader propertyReader;

	private FileReaderManager() {
	}

	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}

	public PropertyReader getPropertyReader() {
		return (propertyReader == null) ? new PropertyReader() : propertyReader;
	}
}
