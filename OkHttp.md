# Android Networking with OkHttp
	* Dependency 
	* Uses Permission 
	* Example 
	* JSONObject 
	
## Dependency - gradle
	dependencies {
		compile 'com.squareup.okhttp3:okhttp:3.6.0'
	}
	
## Uses Permission
	<uses-permission android:name="android.permission.INTERNET"/>
	
## Example
### Sample 1 
	Request request = new Request.Builder()
            .url(url)
            .get()
            .build();
			
	OkHttpClient client = new OkHttpClient();
	Response response = client.newCall(request).execute();
	String jsonResponse = response.body.string();
	
### Sample 2 
	Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

	client.newCall(request).enqueue(new Callback() {

		@Override
		public void onFailure(Call call, IOException e) {

		}

		@Override
		public void onResponse(Call call, Response response) throws IOException {
			final String textResponse = response.body().string();
			runOnUiThread(new Runnable() {
				@Override
				public void run() {
					processData(textResponse);
				}
			});
		}
	});
	
## JSONObject
	public void processData(String data){
        try{
            JSONArray jsonArray = new JSONArray(data);
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name  = jsonObject.getString("name");
                Log.d("hasil", name);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }