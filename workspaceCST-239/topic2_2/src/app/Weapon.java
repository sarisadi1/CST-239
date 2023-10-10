package app;

public abstract class Weapon {

	public void fireWeapon(int power)
	{
		System.out.println("In Weapon.fireWeapon() with a power of "+ power);
	}
	
	public void fireWeapon() 
	{
		System.out.println("In overloaded Bomb.fireWeapon()");
		
	}
	
}
