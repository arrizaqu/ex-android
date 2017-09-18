# Data Populate and Basic Widget
	* ListView Basic --Arrray adapter
		- String Value
		- Getting Resource String-Array
		- SetAdapter ListView
	* ListView Event Listener
	* CustomeAdapter --Base Adapter
	* ListView More Selection
		
## ListView Basic --Array adapter
### String Value 
	<resources>
		<string name="app_name">DataPopulate</string>
		<string-array name="monts_list">
			<item>Januari</item>
			<item>Februari</item>
			<item>Maret</item>
			<item>April</item>4
			<item>Mei</item>
			<item>Juni</item>
			<item>Juli</item>
			<item>Agustus</item>
			<item>September</item>
			<item>Oktober</item>
			<item>November</item>
			<item>Desember</item>
		</string-array>
	</resources>
### Getting Resource String-Array
	String[] dataMonth = this.getResources().getStringArray(R.array.monts_list);
	
### SetAdapter ListView
	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataMonth);
    listView.setAdapter(dataAdapter);
	
## ListView Event Listener
	* Anynomous method 
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				String text = listView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), ""+text, Toast.LENGTH_LONG).show();
            }
        });
		
	* Implements 
		* extends :
			AppCompatActivity implements AdapterView.OnItemClickListener{	
			
		* Implements	
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				String text = listView.getItemAtPosition(i).toString();
				Toast.makeText(getApplicationContext(), "hasil : "+text, Toast.LENGTH_LONG).show();
			}
			
## CustomeAdapter --Base Adapter
