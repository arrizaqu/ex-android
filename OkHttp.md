# Android Networking with OkHttp
	* Dependency 
	* Uses Permission 
	* Example
	
## Dependency - gradle
	dependencies {
		compile 'com.squareup.okhttp3:okhttp:3.6.0'
	}
	
## Uses Permission
	<uses-permission android:name="android.permission.INTERNET"/>
	
## Example
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