/**
 * Program generates three threads from the command line each of which displays its name 5 times then
 * quits. Used in CS346 (Operating Systems) Lab 4
 * 
 * (see The Java Tutorial, Lesson 15)
 * 
 * @author Jason Green & Maggie Sweeney
 * @version 2 Oct 2020
 */
public class SimpleThread extends Thread
{
	/**
	 * Constructs a SimpleThread with name name
	 * @param name name of thread
	 */
	public SimpleThread(String name)
	{
		super(name);
	}
	
	/**
	 * Thread's run method.<br>
	 * Displays name 5 times then declares "Done!"
	 */
	public void run()
	{
		for (int i = 0; i < 5; i++)
		{
			System.out.println(i + " " + getName());
			try
			{
				sleep((int) (Math.random() * 1000));
			} 
			catch (InterruptedException e)
			{}
		}
		System.out.println("Done! " + getName());
	}

	/**
	 * The main method creates two threads and launches them.
	 */
	public static void main(String[] args) {
print("test");
			String[] values = new String[args.length];
			
			for (int i = 0; i < values.length; i++) {

				values[i] = args[i];
				SimpleThread argThread = new SimpleThread(values[i]);
				argThread.start();
			}

	}
}
