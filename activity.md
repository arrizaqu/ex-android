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

Android Activity memiliki method dasar

![](/assets/1_BmgNxyQaWUflgZDK96i9cg.png)

# Referensi

[https://developer.android.com/reference/android/app/Activity.html](https://developer.android.com/reference/android/app/Activity.html)

