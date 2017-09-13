# Android Networking with OkHttp
	* Dependency 
	* Uses Permission 
	* Java Rest-api
	* Example - GET
	* JSONObject 
	* OkHttp with Parameter
	
## Dependency - gradle
	dependencies {
		compile 'com.squareup.okhttp3:okhttp:3.6.0'
	}
	
## Uses Permission
	<uses-permission android:name="android.permission.INTERNET"/>

## Java Rest-api
	@RequestMapping
	public List<Member> index(){
		List<Member> members = new ArrayList<>();
		Member member = new Member();
		member.setId(1);
		member.setName("masyda arrizaqu");
		member.setNoCreditCard("34567890");
		member.setNoHandphone("738839989");
		member.setEmail("arrizaqu@yahoo.com");
		member.setAddress("seputih banyak");
		members.add(member);
		return members;
	}
	
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
	
### Sample 3 - with Asyntask
	class MyRequest extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            String url = "http://192.168.159.1:08080/api-app";
            String result = null;
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .build();
                try{
                    Response responsess = client.newCall(request).execute();
                    result = responsess.body().string();
                }catch (Exception e){
                    e.printStackTrace();
                }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("hasil", "haslinya adalah : "+s);
        }
    }
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
	
## OkHttp with Parameter
### Android Client
	String url = "http://192.168.159.1:08080/api-app/send";
	HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
	urlBuilder.addQueryParameter("key_api", "falksdflskflasjfdlk");
	urlBuilder.addQueryParameter("requester", "admin");

	OkHttpClient client = new OkHttpClient();
	Request request = new Request.Builder()
			.url(urlBuilder.build().toString())
			.get()
			.build();
	try{
		client.newCall(request).execute();
	}catch (Exception e){
		e.printStackTrace();
	}
		
### Server 
	@RequestMapping(value="/send", method=RequestMethod.GET)
	public void serverWithParam(@RequestParam("key_api") String key, @RequestParam("requester") String user){
		System.out.println("key :" + key );
		System.out.println("User :" + user );
	}
	
## Reference
	http://www.vogella.com/tutorials/JavaLibrary-OkHttp/article.html
	