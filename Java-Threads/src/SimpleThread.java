/**
 * Program generates two threads each of which displays its name 5 times then
 * quits. Used in CS346 (Operating Systems) Lab 4
 * 
 * (see The Java Tutorial, Lesson 15)
 * 
 * @author andrianoff
 * @version 15 Feb 2018
 */
public class SimpleThread extends Thread {
	/**
	 * Constructs a SimpleThread with name name
	 * 
	 * @param name name of thread
	 */
	public SimpleThread(String name) {
		super(name);
	}

	/**
	 * Thread's run method.<br>
	 * Displays name 5 times then declares "Done!"
	 */
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i + " " + getName());
			try {
				sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Done! " + getName());
	}

	/**
	 * The main method creates two threads and launches them.
	 */
	public static void main(String[] args) {

	//	String file = args[args.length - 1];
		SimpleThread[] values = new SimpleThread[args.length];
		//System.out.println(file);
		
		for (int i = 0; i < values.length; i++) {

			System.out.println(values[i]);
			//values[i].start(); 
		}

		// SimpleThread st1 = new SimpleThread("Windows");
		// SimpleThread st2 = new SimpleThread("Linux");

		// st1.start();
		// st2.start();
	}
}
