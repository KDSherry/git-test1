import java.util.ArrayList;

public class Person {
	 String name;
	 String dob;
	 String occupation;
	 int salary;
	 ArrayList<Animal>pets2 = new ArrayList<Animal>();	 
	 
	
	public Person(String name, String dob, String occupation, int salary){
		this.name = name;
		this.dob = dob;
		this.occupation = occupation;
		this.salary = salary;
	}

	public  Person(String[] split) {
		this.name = split[0];
		this.dob = split[1];
		this.occupation = split[2];
		this.salary = Integer.parseInt(split[split.length]);
	}
	
	public String getDetails(){
		String details = name + "  " + dob + "  " + occupation + " £" + salary;
		return details.toString();
	}
		
	public void setPets(Animal animal){
		
		pets2.add(new Animal(animal.getPetName(),animal.getPetSpec()));
		
		
		
	}
	public String getName(){
		return name;
	}
	
	public int get$(){
		return salary;
	}
	
	public String getAll(){
		String details = name + "  Date of Birth: " + dob + "  Occupation: " + occupation + " Salary: £" + salary + " Owns: " + getPetsString();
		return details.toString();
	}
	
	public String getPetsString(){
		String petString = "";
		for(Animal p: pets2){
			petString = petString + (p.getPetDetails()) + " "; 
		}
		return petString;
	}
	
	public String getJob(){
		return occupation;
	}
	
	public String getSpecString(){
		String petSpeciesString = "";
		for(Animal p: pets2){
			petSpeciesString = petSpeciesString + (p.getPetSpec()) + " "; 
		}
		return petSpeciesString;
	}
	public boolean petCheck(String petspec){
		for(Animal p :pets2){
			if (p.getPetSpec().equals(petspec)){
				return true;
			}
		}
			
		return false;
				
	}
	
	public static void main(String[] args){
		
	}
}
