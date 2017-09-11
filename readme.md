# Android Navigation Drawer 
# Part 1

	* Steps
	* Desain Google Icon
	* Create Project 
	* Setting Gradle desain Support
	* Change ActivityMain to Drawer Layout
		* Add Navigation view (MainActivity.xml)
			- layout_width: wrap content
			- layout_height: match parent
		* Create Menu 
			- Create Folder Menu in Res
			- Add Navigation Menu
			
## Steps
	1. Change Root Template to Drawer Layout
	2. Add Navigation View 
	3. Add Navigation Menu
	
## Desain google Icon 
https://material.io/icons/

## Setting Gradle desain Support
	compile 'com.android.support:design:26.0.0-alpha1'
	
## Change ActivityMain to Drawer Layout
### Add Navigation view (MainActivity.xml)
	<?xml version="1.0" encoding="utf-8"?>
	<android.support.v4.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
		xmlns:app="http://schemas.android.com/apk/res-auto"
		xmlns:tools="http://schemas.android.com/tools"
		android:layout_width="match_parent"
		android:layout_height="match_parent"
		tools:context="navigation.android.arrizaqu.soft.com.mynavigation.MainActivity">


		<LinearLayout
			android:layout_width="match_parent"
			android:layout_height="match_parent">

			<TextView
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:layout_gravity="center"
				android:gravity="center"
				android:text="Main Content"
				android:textSize="24dp" />
		</LinearLayout>

		<android.support.design.widget.NavigationView
			android:layout_width="wrap_content"
			android:layout_height="match_parent"
			app:menu="@menu/navigation_menu"
			android:layout_gravity="start"
			>
		</android.support.design.widget.NavigationView>
	</android.support.v4.widget.DrawerLayout>

	
### Create Menu 
	<?xml version="1.0" encoding="utf-8"?>
	<menu xmlns:android="http://schemas.android.com/apk/res/android">

		<item android:id="@+id/nav_accout" android:title="My Accout"/>
		<item android:id="@+id/nav_setting" android:title="Setting"/>
		<item android:id="@+id/nav_logout" android:title="Logout"/>

	</menu>
	