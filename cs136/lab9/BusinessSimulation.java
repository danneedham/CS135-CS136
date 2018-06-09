
import java.util.Random;
import structure5.*;

public abstract class BusinessSimulation {

	/* sequence of customers, prioritized by randomly-generated event time */
	PriorityQueue<Customer> eventQueue;

	/* series of service points where customers queue and are served */
	Vector<Queue<Customer>> servicePoints;

	/* current time step in the simulation */
	int time;

	/* seed for Random() so that simulation is repeatable */
	int seed;

	/* Used to bound the range of service times that Customers require */
	static final int MIN_SERVICE_TIME = -1; //TODO: set appropraitely
	static final int MAX_SERVICE_TIME = -1; //TODO: set appropriately

	/**
	 * Creates a BusinessSimulation.
	 * @post the step() function may be called.
	 *
	 * @param numCustomers number of random customers that appear in the
	 *                     simulation
	 * @param numSerivicePoints number of tellers in this simulation
	 * @param maxEventStart latest timeStep that a Customer may appear in the
	                        simulation
	 * @param seed used to seed a Random() so that simulation is repeatable.
	 */
	public BusinessSimulation(int numCustomers, int numServicePoints,
				  int maxEventStart, int seed) { }

	/**
	 * Generates a sequence of Customer objects, stored in a PriorityQueue.
	 * Customer priority is determined by arrival time
	 * @param numCustomers number of customers to simulate
	 * @param maxEventStart maximum timeStep that a customer arrives
	 *      in @eventQueue
	 * @param seed use Random(seed) to make customer sequence repeatable
	 * @return A PriorityQueue that represents Customer arrivals,
	 *         ordered by Customer arrival time
	 */
	public static PriorityQueue<Customer> generateCustomerSequence(int numCustomers,
								       int maxEventStart,
								       int seed) {
		//TODO: fill this in
		return null;
	}

	/**
	 * Advances @timeSteps time steps through the simulation.
	 *
	 * @post the simulation has advanced @timeSteps time steps
	 * @return true if the simulation is over, false otherwise
	 */
	abstract public boolean step(int timeSteps);

	/**
	 * Advances 1 time step through the simulation.
	 *
	 * @post the simulation has advanced 1 time step
	 * @return true if the simulation is over, false otherwise
	 */
	abstract public boolean step();

	/**
	 * @return a string representation of the simulation
	 */
	public String toString() {
		// TODO: modify if needed.
		String str = "Time: " + time + "\n";
		str = str + "Event Queue: ";
		if (eventQueue != null) {
			str = str + eventQueue.toString();
		}
		str = str + "\n";

		if (servicePoints != null)  {
			for (Queue<Customer> sp : servicePoints) {
				str = str + "Service Point: " + sp.toString() + "\n";
			}
		}

		return str;
	}
}
