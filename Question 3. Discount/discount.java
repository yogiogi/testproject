import java.util.HashMap;
import java.util.Scanner;

public class discount {
	double price, total;
	int discount = 0;
	
	HashMap<String, String> map = new HashMap<String,String>();			           
	
    public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
			System.out.println("Enter user (quit to exit): "+ \n +
							   "1. Employee"+ \n +
							   "2. Affiliate"+ \n +
							   "3. Customer >2 years");
							   
			input = keyboard.nextLine();
			if(input != null) {
				if (input == 1) {
					discount = 30%;
				}else if (input == 2){
					discount = 10%;
				}else if (input == 3){
					discount = 5%;
				}
				
                System.out.println("Your input is : " + input);
                if ("quit".equals(input)) {
                    System.out.println("Exit programm");
                    exit = true;
                } else if ("x".equals(input)) {
                    //Do something
                }
            }
		}
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


