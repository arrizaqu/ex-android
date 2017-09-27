# Improving Android Studio Performance 
	* Build Config
	* Gradle Config
	* Power Save Mode
	* Compile with Android Device
	* Gralde Offline Work
	* Compile modules in Paralel

## Build Config 
### Max Java Heap Size 
	1.2GB -> 512 MB
	
### Help->Edit Custom VM Option
	studio.vmoptions
	-Xmx512m
	
## Gradle Config
### Dependencies
	buildscript{
		repositories{
			jcenter()
		}
	}
	dependencies{
		classpath 'com.android.tools.build:gradle:3.0.0-beta'
	}
	
### gradle-wrapper.properties
	distributionUrl=https\://services.gradle.org/distributions/gradle-4.1-all.zip
	
## Power save mode
	File -> power save mode
	
## Gralde Offline Work
	Build Tools -> Gradle -> Offline work

## Compile modules in Paralel
	- Check compile model in paralel