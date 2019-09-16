import java.util.HashMap;
import java.util.Scanner;

public class HelloWorld {
	HashMap<String, String> map = new HashMap<String,String>();			           
	
    public static void main(String[] args) {
		loadMap value = new loadMap();
		
		value.setValue("key1=value1;key2=value2\nkeyA=valueA;keyB=valueB");
		System.out.println("Store value: " + value.getValue());
		String text = "key1=value1;key2=value2\nkeyA=valueA;keyB=valueB";	
		
		HelloWorld st = new HelloWorld();
		st.store(text);
		st.load();
    }
	
	void store(String text){
		Scanner scanner = new Scanner(text);
						
		while(scanner.hasNextLine()){
				String[] columns = scanner.nextLine().split("\n");
				for(int i=0; i<columns.length; i++){
					String[] parts = columns[i].split("=", 2);
					if (parts.length >= 2)
					{
						String key = parts[0];
						String value = parts[1];
						map.put(key, value);
					} else {
						System.out.println("ignoring line: " + columns);
					}
				}
			}					
	};
	
	void load(){
		for (String key : map.keySet())
			{
				System.out.println(key + ":" + map.get(key));
			}
	};
}

class loadMap{
	private String value;
	
	public String getValue(){
		return value;
	}
	
	public void setValue(String value){
		this.value = value;
	}
}


