# Android ROOM

* Definition 
* Installation
  1. setup root build gradle
  2. setup modul build gradle
* Define Object Persistance 
* DAO and Query Annotation
* Database Instance
* 
* Reference 

## Installation

1. setup root build gradle 
   ext {

    buildToolsVersion = "25.0.2"
    supportLibVersion = "25.3.1"
    archRoomVersion = "1.0.0-alpha1"
   }

allprojects {  
    repositories {  
        google\(\)  
        jcenter\(\)  
        maven { url '[https://maven.google.com](https://maven.google.com)' }  
    }  
}

    2. setup modul build gradle
    ```java
    implementation 'android.arch.persistence.room:runtime:1.0.0'
    annotationProcessor 'android.arch.persistence.room:compiler:1.0.0'

## Define Object Persistance

```java
@Entity
public class Repo {
    @PrimaryKey
    public final String id;
    public final String name;
    public final String url;

    public Repo(int id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }
}
```

## Reference

1. [https://medium.com/@ajaysaini.official/building-database-with-room-persistence-library-ecf7d0b8f3e9](https://medium.com/@ajaysaini.official/building-database-with-room-persistence-library-ecf7d0b8f3e9)
2. [https://android.jlelse.eu/android-architecture-components-room-introduction-4774dd72a1ae](https://android.jlelse.eu/android-architecture-components-room-introduction-4774dd72a1ae)
3. 


