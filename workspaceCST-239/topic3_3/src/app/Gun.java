package app;

public class Gun implements WeaponInterface {

	@Override
	public void fireWeapon() {
		System.out.println("In Bomb.fireWeapon()");
		
	}

	@Override
	public void fireWeapon(int power) {
		System.out.println("In bomb.fireWeapon() with a power of "+ power);
		
	}

	@Override
	public void activate(boolean enable) {
		System.out.println("In the bomb.activate() with an enable of "+enable);
		
	}
}
