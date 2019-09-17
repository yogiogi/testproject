import java.util.HashMap;
import java.util.Scanner;

public class discount {
	public static HashMap<Double, Double> mapBill = new HashMap<Double,Double>();
	public static HashMap<Integer, Double> mapItems = new HashMap<Integer,Double>();
	public static HashMap<Integer, String> mapText  = new HashMap<Integer,String>(); 
	
	public static void main(String[] args) {
   
		
		Scanner keyboard = new Scanner(System.in);
        
		boolean exit = false;
		boolean doneinput = false;
		boolean done = false; 
		
		
		Double price = 0.0;
		
		double discount = 0;
		int inputBill;
		int inputUser;
		Double qty;
		String text = null;
		
		Double sumFood = 0.0;
		int key=0;
		
		while (!exit) {
			System.out.println("Choose member (quit to exit): \n" +
							   "1. Employee \n" +
							   "2. Affiliate \n" +
							   "3. Customer >2 years \n"+
							   "4. Common Customer");
			System.out.println("-----------"); 
			System.out.print("Select customer : ");
			inputUser = keyboard.nextInt();
			
			if(inputUser >= 1 && inputUser <=4) {
				
				switch(inputUser){
					case 1:
						text = "Employee";
						discount = 0.3;
					break;
					case 2:
						text = "Affiliate";
						discount = 0.1;
					break;
					case 3:
						text = "Customer >2 years";
						discount = 0.05;
					break;					
					case 4:
						text = "Common Customer";
					break;
				}
            }
			
			System.out.println("-----------"); 
			while (!done) {
				
				System.out.println("Choose your items :\n"+
								   "1. Soap $ 10 \n"+
								   "2. Tooth Paste $12 \n" +
								   "3. Detergen $20 \n" +
								   "4. Olive Oil $21 \n" +
								   "5. Bread $5 \n"+
								   "6. Snack $10 \n"+
								   "7. Rice $10 \n"+
								   "8. Chocolate $13 \n"+
								   "9. COUNT TOTAL  \n"
								   );
								   
				System.out.println("-----------");
				System.out.println("type TOTAL for next :>");
				System.out.println("-----------");
				System.out.print("Select to continue : ");
				
				inputBill = keyboard.nextInt();
				System.out.println("-----------");
				
				boolean food = false;
				
				if(inputBill >= 1 && inputBill <=9){
					switch(inputBill){
						case 1:
							text = "Soap";
							price = 10.0;
							food  = false;
							break;
						case 2:
							text = "Tooth Paste";
							price = 12.0;
							food  = false;
							break;
						case 3:
							text = "Detergen";
							price = 20.0;
							food  = false;
							break;
						case 4:
							text = "Olive Oil";
							price = 21.0;
							food  = false;
							break;
						case 5:
							text = "Bread";
							price = 5.0;
							food  = false;
							break;
						case 6:
							text = "Snack";
							price = 10.0;
							food  = true;
							break;
						case 7:
							text = "Rice";
							price = 10.0;
							food  = true;
							break;
						case 8:
							text = "Chocolate";
							price = 13.0;
							food  = true;
							break;
						case 9:
							if(mapItems.size() > 0){
								System.out.println("Sub Total -->> "+ sumItems());
							}
					}
					
					System.out.println("add " + text + " $"+ price);				
					System.out.print(">> qty : ");				
					qty = keyboard.nextDouble();
					
					Double totalprice = 0.0;
					
					totalprice = qty * price;
					while(!food){
						totalprice = totalprice - (totalprice * discount);
						break;
					}
					
					System.out.println("\n");
					System.out.println("$ " + totalprice+ " -----------");
					System.out.println("-----------");
					System.out.println("\n\n");
					
					key += 1;
					
					mapBill.put(Double.valueOf(qty), price);
					mapText.put(key, text);
					mapItems.put(key, totalprice);
					
					mapText.entrySet().forEach(entry->{
						System.out.println(entry.getValue());  
					});
					
					mapItems.entrySet().forEach(entry->{
						System.out.println("$" + entry.getValue());  
					});
					
					System.out.println(mapText); 
				}else{
					System.out.println("-----------");
					System.out.println("-----------");
					System.out.println(">> plis select right item");
					System.out.println("Sub Total after discount -->> "+ sumDisc());
					System.out.println("-----------");
					System.out.println("-----------");
				}
				
	
			}
		}
    }
	
	public static Double sumItems()
	{	
		Double sum = 0.0;
		
		for (Double f : mapItems.values()) {
				 sum += f;
			}						
								
		mapText.entrySet().forEach(entry->{
			System.out.println(entry.getKey() + ", $" + entry.getValue());  
		});			
		
		return sum;
	}
	
	public static Double sumDisc(){
		Double sum = 0.0;
		
		for (Double f : mapItems.values()) {
				 sum += f;
			}						
					
		Double sums = sum/5;
		Double value = sum - sums;
		return value;
	}
}