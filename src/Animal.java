
public class Animal {
	String name;
	String species;
	
	public Animal(String name, String species){
		this.name = name;
		this.species = species;
	}
	public Animal(String[] split) {
		this.name = split[0];
		this.species = split[1];
		
	}
	public String getPetDetails(){
		String details = name + " the " + species;
		return details.toString();
	}
	public String getPetName(){
		return name;
	}
	public String getPetSpec(){
		return species;
	}
}
