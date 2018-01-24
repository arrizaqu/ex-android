# Lab Retrofit

1. Main Activity
2. POJO Example
3. EndPoint API
4. Post Example

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

## POJO Example

```java
public class MateriEntity {

    String jamPesan;
    String confirmJamPesan;
    String statusConfirm;
    String atasNamaPemabayaran;
    int idTrayek;
    int idPemesan;
    
    ... setter and getter
}
```

## EndPoint API

```java
public interface InterfaceRequest {
    @GET("kelompok3-ws/list")
    Call<List<MateriEntity>> materies();

    @POST("kelompok3-ws/save")
    Call<RequestBody> save(@Body RequestBody materiEntity);

}
```

## Post Example

* Define JSON TYPE variable
* Prepare Json Object Data
* Execution Function

#### Define JSON TYPE variable

```java
 public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
```

#### Prepare Json Object Data

```java
try{
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("codePesan", "bsik123");
    jsonObject.put("idTrayek", 56789);
   // jsonObject.put("statusConfirm", "pending");
    exampleInsertData(jsonObject);
} catch(Exception e){
    e.printStackTrace();
}
```

#### Execution Function

```java
public void exampleInsertData(JSONObject entity) throws IOException {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://batch131.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    final InterfaceRequest requests = retrofit.create(InterfaceRequest.class);
    Log.d("ss", entity.toString());
    RequestBody requestBody = RequestBody.create(JSON, entity.toString());
    Call<RequestBody> call = requests.save(requestBody);
    call.enqueue(new Callback<RequestBody>() {

        @Override
        public void onResponse(Call<RequestBody> call, Response<RequestBody> response) {

        }

        @Override
        public void onFailure(Call<RequestBody> call, Throwable t) {

        }
    });
}
```


