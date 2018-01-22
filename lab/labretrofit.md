# Lab Retrofit

1. Main Activity
2. EndPoint API
3. Post Example

## MainActivity

```java
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //gson format
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://batch131.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

       final InterfaceRequest requests = retrofit.create(InterfaceRequest.class);
       Call<List<MateriEntity>> mycall = requests.materies();
       mycall.enqueue(new Callback<List<MateriEntity>>() {
           @Override
           public void onResponse(Call<List<MateriEntity>> call, Response<List<MateriEntity>> response) {
               int code = response.code();
               List<MateriEntity> listMateri = response.body();
               for(MateriEntity entity : listMateri){
                   Log.d("result : ", "idTrayek : "+ entity.getIdTrayek());
               }
           }

           @Override
           public void onFailure(Call<List<MateriEntity>> call, Throwable t) {

           }
       });
    }
}
```

## EndPoint API

```java
public interface InterfaceRequest {
    @GET("kelompok3-ws/list")
    Call<List<MateriEntity>> materies();

}
```



