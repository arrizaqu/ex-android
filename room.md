# Android ROOM
* Overview 
* Installation
  1. setup root build gradle
  2. setup modul build gradle
* Define Object Persistance 
* DAO and CRUD Annotation
* Database Instance
* Reference 

## Overview
Lebih tepatnya dikenal sebagai ROOM persistence Library, merupakan library yang digunakan untuk mempermudah developer mengembangkan aplikasi yang dibuat berdasarkan DAO Pattern, yang sebenarnya mirip dengan greenDao dan OrmLite.

## Installation
### 1. setup root build gradle 

```java
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
```

### 2. setup modul build gradle
```java
implementation 'android.arch.persistence.room:runtime:1.0.0'
annotationProcessor 'android.arch.persistence.room:compiler:1.0.0'
```

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

## DAO and CRUD Annotation
```java
@Dao
public interface EmployeeDao {
    @Query("select * from employee")
    public List<Employee> getAllEmployee();
    @Insert
    public void insert(Employee... employees);
    @Delete
    public void delete(Employee... employees);
    @Update
    public void update(Employee... employees);
}
```

## Database Instance
```java
@Database(entities = { Employee.class }, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "app.db";
    private static volatile AppDatabase instance;

    static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static AppDatabase create(final Context context) {
        return Room.databaseBuilder(
            context,
            AppDatabase.class,
            DB_NAME).build();
    }

    public abstract EmployeeDao employeeDao();
}
```
## Reference

1. [https://medium.com/@ajaysaini.official/building-database-with-room-persistence-library-ecf7d0b8f3e9](https://medium.com/@ajaysaini.official/building-database-with-room-persistence-library-ecf7d0b8f3e9)
2. [https://android.jlelse.eu/android-architecture-components-room-introduction-4774dd72a1ae](https://android.jlelse.eu/android-architecture-components-room-introduction-4774dd72a1ae)


