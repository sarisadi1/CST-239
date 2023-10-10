package app;

public class Game {

	public static void main(String[] args) {
		Bomb weapon1 = new Bomb();
		Gun weapon2 = new Gun();
		weapon1.fireWeapon(10);
		weapon2.fireWeapon(5);
		weapon1.fireWeapon();
		weapon2.fireWeapon();

	}

}
