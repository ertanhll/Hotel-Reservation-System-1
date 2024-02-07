
import java.util.Scanner;


	class StandardRoom {
	    private int[][] rooms;
	    private int numRooms;
	    private int personCount;
	    private int price;
	    
	    public StandardRoom() {
	        rooms = new int[20][3];
	        numRooms = 0;
	    }
	    
	    public void setPersonCount(int personCount) {
	        this.personCount = personCount;
	    }
	    
	    public int getPersonCount() {
	        return personCount;
	    }
	    
	    public void setPrice(int price) {
	        this.price = price;
	    }
	    
	    public int getPrice() {
	        return price;
	    }
	    
	    public void setNumRooms(int numRooms) {
	        this.numRooms = numRooms;
	    }
	    
	    public int getNumRooms() {
	        return numRooms;
	    }
	    
	    public void createRoom(int id, int personCount, int price) {
	        rooms[numRooms][0] = id;
	        rooms[numRooms][1] = personCount;
	        rooms[numRooms][2] = price;
	        numRooms++;
	        System.out.println("Room # " + id + " has been created.");
	    }
	    
	    public void displayInfo() {
	        for (int i = 0; i < numRooms; i++) {
	            int id = rooms[i][0];
	            int personCount = rooms[i][1];
	            int price = rooms[i][2];
	            int totalPrice = calculatePrice(price, personCount);
	            System.out.println("Room #" + id + " has " + personCount + " people with a price total of $" + totalPrice + ".");
	        }
	    }
	    
	    public int calculatePrice(int price, int personCount) {
	        return personCount * price;
	    }
	}

	class Reservation {
	    private int id;
	   
	    public Reservation(int id) {
	        this.id = id;      
	    }
	    
	    public void setId(int id) {
	        this.id = id;
	    }
	    
	    public int getId() {
	        return id;
	    }
	    
	}
	
	public class HotelReservation{
		
	    public static void main(String[] args) {
	    	
	        StandardRoom reservedRoom = new StandardRoom();
	        Reservation reservation = new Reservation(reservedRoom.getNumRooms());
	        Scanner input = new Scanner(System.in);
	       
	        int option = 1;
	        while (option != 0) {
	            System.out.println("1. Create new Standard Room");
	            System.out.println("2. Display all room information");
	            System.out.println("3. Display the total number of rooms");
	            System.out.println("0. Exit");

	            option = input.nextInt();

	            switch (option) {
	                case 1:
	                    if (reservedRoom.getNumRooms() < 20) {
	                        System.out.print("Person Count: ");
	                        reservedRoom.setPersonCount(input.nextInt());
	                        System.out.print("Price: ");
	                        reservedRoom.setPrice(input.nextInt());
	                        reservation.setId(reservedRoom.getNumRooms() + 1);
	                        reservedRoom.createRoom(reservation.getId(), reservedRoom.getPersonCount(), reservedRoom.getPrice());
	                    } else {
	                        System.out.println("Maximum number of reservations reached.");
	                    }                    
	                    break;
	                case 2:
	                    reservedRoom.displayInfo();
	                    break;
	                case 3:
	                    System.out.println(reservedRoom.getNumRooms() + ((reservedRoom.getNumRooms() < 2) ? " room has " : " rooms have ") + "been created so far.");
	                    break;
	                case 0:
	                    System.out.println("Goodbye");
	                    input.close();
	                    break;
	                default:
	                    System.out.println("Invalid input, please try again.");
	                    break;
	            }
	        }
	    }
	}



