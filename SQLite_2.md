# SQLite with SqliteOpenHelper
	* Intilize Class 
		- Constructor Setup
		- Implements Abstract Class
	
	* Saving Data 
	* Method 1 - Command Line
		- Entry "sdk\platform-tools" Path
		- adb device
		- adb -s emulator-5554 shell
		- Entry directory "databases" 
		- Use Database 
		- Show tables
		- Describe table target
		
	* Method 2 - Export to External
	
## Intilize Class
### Constructor Setup
	* Class Persistence
		class PersistenceClass extends SQLiteOpenHelper{
			//cosntructor
			public PersistenceClass(Context context){
				super(context, DATABASE_NAME, null,APP_VERSION);
			}
	
	* Call Class 
		public Datasource(Context context){
			this.context = context;
			pc = new PersistenceClass(context);
		}
		
### Implement Abstract Class
	 @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            try{
                sqLiteDatabase.execSQL(ENTRY_TABLE);
            }catch(Exception e){
                Log.d("createDb", "failed : "+ e.getMessage());
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);
        }
		
### Saving Data 
	//save data -- writable
    public void save(Phone phone){
        pc.getWritableDatabase();
        SQLiteDatabase db = pc.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, phone.getName());
        contentValues.put(COLUMN_EMAIL, phone.getEmail());
        db.insert(TABLE_NAME, null, contentValues);
    }
	
### Getting Data 
	public List<Phone> getAll(){
        SQLiteDatabase db = pc.getReadableDatabase();
        String[] field = {COLUMN_ID,COLUMN_EMAIL,COLUMN_NAME};
       // Cursor c = db.query(TABLE_NAME, field, null, null, null, null, null);
        String sql = "select * from "+ TABLE_NAME;
        // sql += " limit 0, 3"; // just a limit for paging
        Cursor c = db.rawQuery(sql, null);

        int iId = c.getColumnIndex(COLUMN_ID);
        int iEmail = c.getColumnIndex(COLUMN_EMAIL);
        int iName = c.getColumnIndex(COLUMN_NAME);

        List<Phone> phones = new ArrayList<>();
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            Phone phone = new Phone(c.getString(iName), c.getString(iEmail));
            phone.setId(iId);
            phones.add(phone);
        }
        
        return phones;
    }public List<Phone> getAll(){
        SQLiteDatabase db = pc.getReadableDatabase();
        String[] field = {COLUMN_ID,COLUMN_EMAIL,COLUMN_NAME};
       // Cursor c = db.query(TABLE_NAME, field, null, null, null, null, null);
        String sql = "select * from "+ TABLE_NAME;
        Cursor c = db.rawQuery(sql, null);

        int iId = c.getColumnIndex(COLUMN_ID);
        int iEmail = c.getColumnIndex(COLUMN_EMAIL);
        int iName = c.getColumnIndex(COLUMN_NAME);

        List<Phone> phones = new ArrayList<>();
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            Phone phone = new Phone(c.getString(iName), c.getString(iEmail));
            phone.setId(iId);

            phones.add(phone);
        }
        return phones;
    }
	
### 
	
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
	
	