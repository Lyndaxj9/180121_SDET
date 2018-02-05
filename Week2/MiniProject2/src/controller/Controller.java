package controller;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import beans.Pilot;
import beans.Ship;
import dao.PilotDao;
import dao.PilotDaoImpl;
import dao.ShipDao;
import dao.ShipDaoImpl;
import functions.AdminFunctions;
import functions.CreateUser;
import functions.UserLogIn;

/*
 * Key features:
 * Users can login with password and change bank balance only after being approved by administrator
 * Data is persisted in a file
 * Prevents duplicate accounts from being created
 * Ensures each id is unique on creation
 * Admin cannot have banking account
 * Admin can login, authorize or delete users
 * 
 */
public class Controller {
	
	final static Logger logger = Logger.getLogger(Controller.class);
	
	private static final String USERS = "users.txt";
	
	public static void main(String[] args) {
		logger.debug("Application started");
//		ShipDao dao = new ShipDaoImpl();
//		PilotDao pDao = new PilotDaoImpl();
//		pDao.chooseShip(new Pilot(1), new Scanner(System.in));
//		pDao.logInPilot(pDao.getAllPilots());
//		Ship ship = new Ship(1004, "XK41", false, 104);
//		dao.flyShip(new Ship(1004), -1);
//		System.out.println(dao.getAllShips());
//		System.out.println(dao.shipsWithoutPilots());
		mainMenu();
	}
	
	
	public static void mainMenu() {
		Scanner scan = new Scanner(System.in);
		ShipDao shipDao = new ShipDaoImpl();
		PilotDao pilotDao = new PilotDaoImpl();
		while(true) {
			scan = new Scanner(System.in);
			System.out.println("\n=============================================");
			System.out.println("Welcome to the StarFleet Management Portal. \nYour base number is 12683 in the Andromeda galaxy");
			System.out.println("\nAll spaceships must be approved \nby a mechanic before \nbeing allowed to fly\n");
			System.out.println("0 to add fuel to a ship");
			System.out.println("1 for mechanic login");
			System.out.println("2 to buy a new spaceship");
			System.out.println("3 to display all ship data");
			System.out.println("or \'q\'");
			String s = scan.nextLine();
			
			if (s.equals("0")) {
				logger.debug("Chose login");
				pilotDao.logInPilot(pilotDao.getAllPilots());
			}
			if (s.equals("1")) {
				logger.debug("Chose admin");
				AdminFunctions.mechanicLogin(scan);
			}
			if (s.equals("2")) {
				logger.debug("Chose create");
				Ship ship = new Ship();
				System.out.println("Name: ");
				String input = scan.nextLine();
				ship.setName(input);
				System.out.println("Load it with some fuel (max 10,000): ");
				Integer i = scan.nextInt();
				ship.setFuel_level(i);				
				shipDao.addShip(ship);
			}
			if (s.equals("3")) {
				logger.debug("Chose show");
				List<Ship> ships = shipDao.getAllShips();
				System.out.println(ships);
			}
			if (s.equals("quit") || s.equals("q")) {
				logger.debug("Application closed");
				break;
			}
			break;
		}
		scan.close();		
	}
	
	public static void mechanicMenu(Scanner scan) {

		logger.debug("Accessed mechanicMenu");
		ShipDao shipDao = new ShipDaoImpl();
		PilotDao pilotDao = new PilotDaoImpl();
		
		String s = "";
		while(true) {
			System.out.println("Mechanic main menu:");
			System.out.println("0 to inspect a spaceship");
			System.out.println("1 to decommission and recycle a ship");
			System.out.println("2 for main menu");
			s = scan.nextLine();		
			
			if (s.equals("0")) {
				logger.debug("accessing authenticate");
				List<Ship> ships = shipDao.getAllShips();
				for (Ship ship : ships) {
					System.out.println(ship.getName());
				}
				System.out.println("Choose a ship to inspect");
				String input = scan.nextLine();
				for (Ship ship : ships) {
					if (input.equals(ship.getName())) {
						shipDao.approveShip(ship);
						break;
					}
				}
				
				//AdminFunctions.authenticateUser(scan, USERS, -1);
			}
			
			if (s.equals("1")) {
				logger.debug("accessing delete");
				AdminFunctions.deleteUser(scan, USERS, null);

			}
			
			if (s.equals("2")) {
				logger.debug("quit mechanic menu");
				mainMenu();
				break;
			}
		}		
	}
	
}
