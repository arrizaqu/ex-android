# Retrofit

Merupakan Library yang biasa digunakan untuk push atau get dari Request HTTP API,

## Pembahasan

1. Instalasi Retrofit
2. Type Data Converter yang di support
3. Mendefinisikan RequestInterfaceMethod
4. GET Example
5. POST Example
6. PUT Example
7. Mengirimkan Gambar atau File
8. Issue

## Instalasi Retrofit

Untuk Praktek pada pembahasan membutuhkan 3 library dalam penggunaan get data json menggunakan Retrofit, yaitu :

1. Retrofit
2. Converter Gson
3. OkHttp

#### Maven

```java
<dependency>
  <groupId>com.squareup.retrofit2</groupId>
  <artifactId>retrofit</artifactId>
  <version>2.3.0</version>
</dependency>
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.8.2</version>
</dependency>
<!-- https://mvnrepository.com/artifact/com.squareup.okhttp/okhttp -->
<dependency>
    <groupId>com.squareup.okhttp</groupId>
    <artifactId>okhttp</artifactId>
    <version>2.7.5</version>
</dependency>
```

#### Gradle

```java
compile 'com.squareup.retrofit2:retrofit:2.3.0'
compile 'com.squareup.retrofit2:converter-gson:2.3.0'
compile 'com.squareup.okhttp3:okhttp:3.6.0'
```

## Type Data Converter yang di Support

Berikut ini adalah library yang di support dalam menggunakan Retrofit, diantaranya adalah :

* [Gson](https://github.com/google/gson) :`com.squareup.retrofit2:converter-gson`
* [Jackson](http://wiki.fasterxml.com/JacksonHome) :`com.squareup.retrofit2:converter-jackson`
* [Moshi](https://github.com/square/moshi/) :`com.squareup.retrofit2:converter-moshi`
* [Protobuf](https://developers.google.com/protocol-buffers/) :`com.squareup.retrofit2:converter-protobuf`
* [Wire](https://github.com/square/wire) :`com.squareup.retrofit2:converter-wire`
* [Simple XML](http://simple.sourceforge.net/) :`com.squareup.retrofit2:converter-simplexml`
* Scalars \(primitives, boxed, and String\):`com.squareup.retrofit2:converter-scalars`

## Mendefinisikan RequestInterfaceMethod

Memahami untuk InterfaceEndpoint API seperti contoh script diberikut :

```java
public interface EndpointInterface {
    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter

    @GET("users/{username}")
    Call<User> getUser(@Path("username") String username);

    @GET("group/{id}/users")
    Call<List<User>> groupList(@Path("id") int groupId, @Query("sort") String sort);

    @POST("users/new")
    Call<User> createUser(@Body User user);
}
```

dari contoh script diatas ada beberapa Annotasi yang penting di ketahui, sebagai berikut :

| Annotation | Description |
| :--- | :--- |
| `@Path` | variable substitution for the API endpoint \(i.e. username will be swapped for`{username}`in the URL endpoint\). |
| `@Query` | specifies the query key name with the value of the annotated parameter. |
| `@Body` | payload for the POST call \(serialized from a Java object to a JSON string\) |
| `@Header` | specifies the header with the value of the annotated parameter |

# Issue

1. GsonConverterFactory Cannot be resolve \(Solved\) : [https://stackoverflow.com/questions/33304420/retrofit-2-example-tutorial-but-gsonconverterfactory-display-error-cannot-resol](https://www.gitbook.com/book/rizaquelativa/java-android/edit#), \(Library ini dipakai untuk mengconvert Json Format ke Object di dalam java object\)
2. Unable to create converter for java.util.List Retrofit: [https://stackoverflow.com/questions/34315499/unable-to-create-converter-for-java-util-list-retrofit-2-0-0-beta2](https://stackoverflow.com/questions/34315499/unable-to-create-converter-for-java-util-list-retrofit-2-0-0-beta2) \(secara simple dengan error ini membutuhkan 3 library yang harus ada dalam penggunaan retrofit2 : retrofit, okhttp, dan json converter\)
3. Best Praktis More Retrofit Example : [https://github.com/codepath/android\_guides/wiki/Consuming-APIs-with-Retrofit](https://github.com/codepath/android_guides/wiki/Consuming-APIs-with-Retrofit)

# Referensi

[http://square.github.io/retrofit/](http://square.github.io/retrofit/)

[https://github.com/codepath/android\_guides/wiki/Consuming-APIs-with-Retrofit](https://github.com/codepath/android_guides/wiki/Consuming-APIs-with-Retrofit)

