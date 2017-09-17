# SQLite Debuging and Check  
	* Method 1 - with Command Line
		- Entry "sdk\platform-tools" Path
		- adb device
		- adb -s emulator-5554 shell
		- Entry directory "databases" 
		- Use Database 
		- Show tables
		- Describe table target
	
## Method 1 - with Command Line
### Entry "sdk\platform-tools" Path
	C:\Users\arrizaqu>cd F:\android\sdk\platform-tools
	
### adb device
	* Result Output: 
	F:\android\sdk\platform-tools>adb devices
	List of devices attached
	emulator-5554   device
	
### adb -s emulator-5554 shell
	generic_x86_64:/ $ run-as soft.com.sqliteexample
	
### Entry directory "databases" 
	generic_x86_64:/data/data/soft.com.sqliteexample $ cd databases;
	generic_x86_64:/data/data/soft.com.sqliteexample/databases $ ls
	ONE ONE-journal shell
	
### Use Database 
	generic_x86_64:/data/data/soft.com.sqliteexample/databases $ sqlite3 ONE
	
### Show tables
	sqlite> .tables
	PHONE   android_metadata
	
### Describe table target
	sqlite> .schema PHONE
	CREATE TABLE PHONE (
			`id`    INTEGER PRIMARY KEY AUTOINCREMENT,
			`name`  TEXT,
			`email` TEXT UNIQUE
	);
	
