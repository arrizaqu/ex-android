# Android Navigation Drawer 
# Part 4 (Custome Action Bar)
	* Steps
	* MainActivity

## Steps
### 1. Turn Off Default Action Bar
	<!-- Base application theme. -->
    <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
	
### 2. Create Toolbar (ex : navigation_ection.xml)
	<?xml version="1.0" encoding="utf-8"?>
	<android.support.v7.widget.Toolbar xmlns:android="http://schemas.android.com/apk/res/android"
		xmlns:app="http://schemas.android.com/apk/res-auto"
		android:id="@+id/nav_action"
		android:layout_width="match_parent"
		android:layout_height="wrap_content"
		android:background="@color/colorPrimary"
		android:orientation="vertical"
		android:theme="@style/Base.ThemeOverlay.AppCompat.Dark.ActionBar">

	</android.support.v7.widget.Toolbar>
	
### 3. Set SupportActionBar with Toolbar
	mToolbar = (Toolbar) findViewById(R.id.nav_action) ;
    setSupportActionBar(mToolbar);
	
## MainActivity
	public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToogle;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.nav_action) ;
        setSupportActionBar(mToolbar);
