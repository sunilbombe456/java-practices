package singleton;

public class Singleton {
	private static Singleton uniqueInstance = new Singleton();

	private Singleton() {
		System.out.println("Sigleton Instance is created");
	}

	public static Singleton getInstance() {
			return uniqueInstance;
		}

}
