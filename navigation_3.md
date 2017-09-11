# Android Navigation Drawer 
# Part 3 (Add Icon and Navigation Header)
	* Material Desain Free 
	* Add Icon Menu item
	* Add Navigation Heder
		* Add Layout : navigation_header.xml
		* Include Layout navigation_header to NavigationView. 
		
## Material Desain Free 
	* https://material.io/icons/
	* https://www.flaticon.com/
## Add Icon Menu item 
	<?xml version="1.0" encoding="utf-8"?>
	<menu xmlns:android="http://schemas.android.com/apk/res/android">

		<item android:id="@+id/nav_accout"
			android:icon="@drawable/ic_account_circle_black_24dp"
			android:title="My Accout"/>
		<item android:id="@+id/nav_setting"
			android:icon="@drawable/ic_settings_black_24dp"
			android:title="Setting"/>
		<item android:id="@+id/nav_logout" android:title="Logout"/>

	</menu>
## Add Navigation header
### navigation_header.xml
	<?xml version="1.0" encoding="utf-8"?>
	<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
		xmlns:app="http://schemas.android.com/apk/res-auto"
		xmlns:tools="http://schemas.android.com/tools"
		android:layout_width="match_parent"
		android:layout_height="140dp"
		android:background="@color/colorPrimary"
		android:orientation="vertical">

		<TextView
			android:id="@+id/textView"
			android:layout_width="wrap_content"
			android:layout_height="wrap_content"
			android:padding="20dp"
			android:text="Masyda Arrizaqu"
			android:textColor="@android:color/background_light"
			tools:layout_editor_absoluteX="1dp"
			tools:layout_editor_absoluteY="4dp" />
	</android.support.constraint.ConstraintLayout>
	
### Include Layout navigation_header to NavigationView.
	<android.support.design.widget.NavigationView
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        app:headerLayout="@layout/navigation_header"
        app:menu="@menu/navigation_menu"
        android:layout_gravity="start"
        >
    </android.support.design.widget.NavigationView>

