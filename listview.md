# Data Populate and Basic Widget
	* ListView Basic --Arrray adapter
		- String Value
		- Getting Resource String-Array
		- SetAdapter ListView
		
	* ListView Event Listener
		- Anonymous method
		- Implement Method
		
	* CustomeAdapter --Base Adapter
		- Extends ArrayAdapter
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
```java
String[] dataMonth = this.getResources().getStringArray(R.array.monts_list);
```

### SetAdapter ListView
```java
ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataMonth);
listView.setAdapter(dataAdapter);
```

## ListView Event Listener
```java
listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
			String text = listView.getItemAtPosition(i).toString();
	Toast.makeText(getApplicationContext(), ""+text, Toast.LENGTH_LONG).show();
    }
});
```
```java
AppCompatActivity implements AdapterView.OnItemClickListener{					
	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
	String text = listView.getItemAtPosition(i).toString();
		Toast.makeText(getApplicationContext(), "hasil : "+text, Toast.LENGTH_LONG).show();
	}
}
```			
## CustomeAdapter --Base Adapter
### Extends ArrayAdapter
```java
public class PhoneAdapter extends ArrayAdapter<Phone>{
	Context context;
	List<Phone> phones;

	public PhoneAdapter(Context context,List<Phone> phones) {
		super(context, 0, phones);
		this.phones = phones;
		this.context = context;
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.phone_row, null);
		PhoneHolder phoneHolder = new PhoneHolder();
		phoneHolder.setName((TextView) view.findViewById(R.id.textName));
		phoneHolder.setEmail((TextView) view.findViewById(R.id.textEmail));
		phoneHolder.setId((TextView)view.findViewById(R.id.textId));

		phoneHolder.getName().setText(phones.get(position).getName().toString());
		phoneHolder.getEmail().setText(phones.get(position).getEmail().toString());
		phoneHolder.getId().setText(String.valueOf(phones.get(position).getId()));

		return view;
	}
}
```

### ClassHolder
```java
public class PhoneHolder {
	private TextView id;
	private TextView name;
	private TextView email;

	public TextView getId() {
		return id;
	}

	public void setId(TextView id) {
		this.id = id;
	}

	public TextView getName() {
		return name;
	}

	public void setName(TextView name) {
		this.name = name;
	}

	public TextView getEmail() {
		return email;
	}

	public void setEmail(TextView email) {
		this.email = email;
	}
}
```
	
### Custome SetAdapter
```java
listPhoneBook = (ListView) findViewById(R.id.phonebooklist);
List<Phone> phones = new ArrayList<>();
//phone 1
Phone phone1 = new Phone("masyda arrizaqu", "arrizaqu@yahoo.com");
//phone 2
Phone phone2 = new Phone("aldi", "aldi@yahoo.com");
//phone 3
Phone phone3 = new Phone("agung", "agung@yahoo.com");
phones.add(phone1);
phones.add(phone2);
phones.add(phone3);

PhoneAdapter myAdapter = new PhoneAdapter(this, phones);
listPhoneBook.setAdapter(myAdapter);
```

### SetTag ConvertView
```java
@NonNull
@Override
public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
PhoneHolder phoneHolder = null;
convertView = null;

if(convertView == null){
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    convertView = inflater.inflate(R.layout.phone_row, null);
    phoneHolder = new PhoneHolder();
    phoneHolder.setName((TextView) convertView.findViewById(R.id.textName));
    phoneHolder.setEmail((TextView) convertView.findViewById(R.id.textEmail));
    phoneHolder.setId((TextView)convertView.findViewById(R.id.textId));
    convertView.setTag(phoneHolder);
} else {
    phoneHolder = (PhoneHolder) convertView.getTag();
}


phoneHolder.getName().setText(phones.get(position).getName().toString());
phoneHolder.getEmail().setText(phones.get(position).getEmail().toString());
phoneHolder.getId().setText(String.valueOf(phones.get(position).getId()));

return convertView;
}
```	
