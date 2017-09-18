# SQLite Debuging and Check  
	* Method 1 - Command Line
		- Entry "sdk\platform-tools" Path
		- adb device
		- adb -s emulator-5554 shell
		- Entry directory "databases" 
		- Use Database 
		- Show tables
		- Describe table target
		
	* Method 2 - Export to External
	
## Method 1 - Command Line
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
	
## Method 2 - Export to External
### adb devices
	List of devices attached
	emulator-5554   device

### adb -s emulator-5554 shell
	generic_x86_64:/ $ run-as soft.com.sqliteexample
	generic_x86_64:/data/data/soft.com.sqliteexample $ ls
	cache code_cache databases
	generic_x86_64:/data/data/soft.com.sqliteexample $ cd databases
	generic_x86_64:/data/data/soft.com.sqliteexample/databases $ ls
	ONE shell
	
### Copy sqlitedb to Sdcard
	generic_x86_64:/data/data/soft.com.sqliteexample/databases $ cp ONE /sdcard/data
	generic_x86_64:/data/data/soft.com.sqliteexample/databases $ exit
	generic_x86_64:/ $ exit
	
### adb pull
	F:\android\sdk\platform-tools>adb pull /sdcard/data/ONE
	/sdcard/data/ONE: 1 file pulled. 8.5 MB/s (24576 bytes in 0.003s)
	
### Last Step 
	Check result dbname into F:\android\sdk\platform-tools 

## Reference 
	https://www.liammoat.com/blog/2017/pull-an-sqlite-database-file-from-an-android-device-for-debugging
	
	