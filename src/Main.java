import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Person>people = new ArrayList<Person>();
	static ArrayList<Animal>pets = new ArrayList<Animal>();
	
	public static void main(String[] args){
		String s;
		s = fileReader2("C:\\Users\\Administrator\\Desktop\\ExData.txt");
		fileParser(s);
		
		
		getAllPeople();
		assignPets("Gareth", "Sir Meowsalot");	
		assignPets("Elliott", "Cosmo");
		assignPets("Elliott", "Bob");
		getByPerson("Gareth");
		getByPerson("Elliott");
		getByPerson("Devdetta");
		occupationToSpecies("Trainer");
		speciesToOccupation("Dolphin");
		speciesToOccupation("Cat");
		speciesToAverageEarnings("Cat");
		
	}
	
	public static String fileReader2(String fileName){
		String fileInfo = "";
		
		File x = new File(fileName);
		try{
		Scanner sc = new Scanner(x);   
		while(sc.hasNext()) {
		   
		    fileInfo += (sc.nextLine() + ",");
		  }
		  sc.close();
		  //System.out.println(fileInfo);
		  return fileInfo;
		}catch(Exception e){
			
			return "ERROR ERROR ERROR";
			
		}
		
	}
	
	public static void fileParser(String string_to_parse){
		String s = string_to_parse;
		String delims = "[&]+"; 
		String delims2 = "[%]";
		String delims3 = "[,Â£]";
		String People;  
		String Animals;
		String[] tokens = s.split(delims);
		//System.out.println(tokens[0]);
		//System.out.println(tokens[1]);
		People = tokens[0];
		Animals = tokens[1];
		
		String[] Person = People.split(delims2);		
		String[] Animal = Animals.split(delims2);
		
		for(int i = 0; i < Person.length; i++){
			//System.out.println(Person[i]);
			String test[] = Person[i].split(delims3);
			
			
			if(test[0].equals("Gareth")){
			people.add(new Person(test[0], test[1], test[2], Integer.parseInt(test[test.length-1])));
			}
			else{
			people.add(new Person(test[1], test[2], test[3], Integer.parseInt(test[test.length-1])));
			}
			
			
		}
		for(int i = 0;i<Animal.length; i++){
			String test[] = Animal[i].split(",");
					
			pets.add(new Animal(test[1],test[2]));
		}
	}
	
	public static void assignPets(String ownerName, String petName){
		for(Person p: people){
			if(p.getName().equals(ownerName)){
				for (Animal a: pets){
					if (a.getPetName().equals(petName)){
						//System.out.println(a.getPetDetails());
						p.setPets(a);
						return;
					}					
				}				
			}			
		}
	}
	
	public static void getByPerson(String ownerName){
		for(int i = 0; i < people.size(); i++){
			if(people.get(i).getName().equals(ownerName)){
				System.out.println(people.get(i).getAll());
			}
		}
	}
	
	public static void getAllPeople(){
		for(Person p: people){
			System.out.println(p.getName());
		}
	}
	
	public static void getAllPeopleDetails(){
		for(Person p: people){
			System.out.println(p.getDetails());
		}
	}
	
	public static void getAllPets(){
		for(Animal a: pets){
			System.out.println( a.getPetDetails());
		}
	}
	
	public static void occupationToSpecies(String occupation){
		for(int i = 0; i < people.size(); i++){
			if(people.get(i).getJob().equals(occupation)){
				System.out.println(occupation +"s own pets of species: "+ people.get(i).getSpecString());
			}
		}
	}
	
	public static void speciesToOccupation(String species){
		for(int i = 0; i < pets.size(); i++){
			if(pets.get(i).getPetSpec().equals(species)){
				for(int j = 0 ; j< people.size(); j++){
					if(people.get(j).petCheck(species)==true){
						System.out.println(people.get(j).getJob() + "s own " + species +"s");
					}
				}
			}				
		}
	}
	
	public static void speciesToAverageEarnings(String species){
		int total$ = 0;
		int totalPeople = 0;
		for(int i = 0; i < pets.size(); i++){
			if(pets.get(i).getPetSpec().equals(species)){
				for(int j = 0 ; j< people.size(); j++){
					if(people.get(j).petCheck(species)==true){
						total$ = total$ + (people.get(j).get$());
						totalPeople++;
					}
				}
			}
		}
		System.out.println("The average salary of "+ species + " owners is: £" + total$/totalPeople );
	}
	
}

