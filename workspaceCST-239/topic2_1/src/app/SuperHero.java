package app;

import java.util.Random;

public class SuperHero {

	private String name;
	private int health;
	private boolean isDead;
	
	public SuperHero(String name, int health) {
		this.name=name;
		this.health=health;
	}
	
	public void attack(SuperHero opponent) {
		 Random rand= new Random();
		int damage = rand.ints(1,(10+1)).findFirst().getAsInt();
		
		opponent.determineHealth(damage);
		System.out.print(String.format("%s has damage of %d and health of %d", opponent.name,damage,opponent.health));
	}
	
	public boolean isDead() {
		return this.isDead;
	}
	private void determineHealth(int damage) {
		if(this.health-damage<=0)
		{
			this.health=0;
			this.isDead=true;
			
		}
		else 
		{
			this.health=this.health-damage;
		}
	}
	
}

