# Android Navigation Drawer 
# Part 2 (Create Button Navigation Drawer)
	* Steps
	* ActivityMain
		
## Steps :
### Set Navigation Drawer Id
	android:id="@+id/navigationDrawer"
### Add DrawerLayout Class
    private DrawerLayout mDrawerLayout;
### Add ActionBarDrawerToggle
	private ActionBarDrawerToggle mDrawerToogle;
### Add DrawerLayout Listener
	mDrawerLayout.addDrawerListener(mDrawerToogle);
### Synce ActionBarDrawerToggle
	mDrawerToogle.syncState();
### Display getSupportActionBar
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
### Override onOptionsItemSelected
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mDrawerToogle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
	
## ActivityMain
	public class MainActivity extends AppCompatActivity {
		private DrawerLayout mDrawerLayout;
		private ActionBarDrawerToggle mDrawerToogle;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);

			mDrawerLayout = (DrawerLayout) findViewById(R.id.navigationDrawer);
			mDrawerToogle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open_drawer, R.string.close_drawer);
			mDrawerLayout.addDrawerListener(mDrawerToogle);
			mDrawerToogle.syncState();
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		}

		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			if(mDrawerToogle.onOptionsItemSelected(item)){
				return true;
			}
			return super.onOptionsItemSelected(item);
		}
	}
