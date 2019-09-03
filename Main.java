package com.collabera.memento;

	class Persona{
	
    private String name;
    private String title;
    private String pName;
     
    public Persona(String string, String title) {
        super();
        this.name = string;
        this.title = title;
    }
     
    public Memento createMemento(){
    	
        Memento m = new Memento(name, title, pName);
        return m;
    }
     
    public void restore(Memento m) {
        this.name = m.getname();
        this.title = m.getTitle();
        this.pName = m.getpName();
    }
 
   
    public String toString() {
        return "name = " + name + ", title = " + title + ", Persona = " + pName + "";
    }

	public void setName(String string) {
		
		this.pName = string;
	}
}

final class Memento{
	
    private final String name;
    private final String title;
    private final String pName;
     
    public Memento(String name2, String title, String Name) {
        super();
        this.name = name2;
        this.title = title;
        this.pName = Name;
    }
 
    public String getname() {
        return name;
    }
 
    public String getTitle() {
        return title;
    }
 
    public String getpName() {
        return pName;
    }
}

public class Main {
    public static void main(String[] args){
        Persona Joker = new Persona("Joker", "Phantom Thief");
        Joker.setName("Arsene");      //original Name
        System.out.println(Joker);
         
        Memento memento = Joker.createMemento();   //created immutable memento
         
        Joker.setName("Satanael");      //changed Name
        System.out.println(Joker);
         
        Joker.restore(memento);       //UNDO change
        System.out.println(Joker);    //original Name
    }
}