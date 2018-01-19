# Activity

Sebutannya adalah Activity, merupakan sebuah class yang sudah secara default telah disediakan oleh Android. Activity merupakan Class yang dirancang untuk meng-handle atau berperan untuk menangani User Interface \(UI\) ketika UI tersebut dapat berinteraksi dengan Pengguna. untuk mengimplentasikan Activity dalam aplikasi yang sedang dibuat, maka Class tersebut harus meng-extends Activity class, seperti berikut :

```java
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
```

# Life Cycle Activity

Android Activity memiliki method - method dasar yang akan dijalankan ketika sebuah Activity dijalankan, sehingga ketika program harus memodifikasi method - method tersebut maka developer harus meng-override method tersebut, diantara method - method Activity yang menjadi Life Cycle Activity android, diantaranya adalah :

1. _onCreate\(\)_
2. _onStart\(\)_
3. _onResume\(\)_
4. _onPause\(\)_
5. _onRestart\(\)_
6. _onStop\(\)_
7. _onDestroy\(\)_

Untuk siklus dari method Android Activity diatas dapat digambarkan sebagai berikut dibawah ini : 

![](/assets/1_BmgNxyQaWUflgZDK96i9cg.png)



# Registrasi Activity

Dalam membuat Activity baru hal yang tidak boleh lupa adalah mendaftarkan Java Class yang telah di set sebagai Activity di dalam File Manifest, seperti berikut : 

```java
<activity android:name=".HelloActivity" />
```

# Referensi

[https://developer.android.com/reference/android/app/Activity.html](https://developer.android.com/reference/android/app/Activity.html)

