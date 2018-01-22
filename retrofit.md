# Retrofit

Merupakan Library yang biasa digunakan untuk push atau get dari Request HTTP API,

## Pembahasan

1. Instalasi Retrofit 
2. Contoh 
3. Type Data Converter yang di Support

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

## Contoh

## Type Data Converter yang di Support

Converters can be added to support other types. Six sibling modules adapt popular serialization libraries for your convenience.

* [Gson](https://github.com/google/gson) :`com.squareup.retrofit2:converter-gson`
* [Jackson](http://wiki.fasterxml.com/JacksonHome) :`com.squareup.retrofit2:converter-jackson`
* [Moshi](https://github.com/square/moshi/) :`com.squareup.retrofit2:converter-moshi`
* [Protobuf](https://developers.google.com/protocol-buffers/) :`com.squareup.retrofit2:converter-protobuf`
* [Wire](https://github.com/square/wire) :`com.squareup.retrofit2:converter-wire`
* [Simple XML](http://simple.sourceforge.net/) :`com.squareup.retrofit2:converter-simplexml`
* Scalars \(primitives, boxed, and String\):`com.squareup.retrofit2:converter-scalars`

# Referensi

[http://square.github.io/retrofit/](http://square.github.io/retrofit/)

