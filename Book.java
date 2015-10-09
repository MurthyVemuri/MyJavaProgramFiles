import java.util.Scanner;
import java.util.ArrayList;

class Show {
	private String nameOfMovie;
	private String date;
	private String time;
	private int seatNumbers;

	Show(String nameOfMovie , String date , String time , int seatNumbers) {
		this.nameOfMovie = nameOfMovie;
		this.date = date;
		this.time = time;
		this.seatNumbers = seatNumbers;
	}

	public String getMovie() {
		return nameOfMovie;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public int getSeatNumbers() {
		return seatNumbers;
	}
	public void printShow(){
		System.out.println("Movie name is : " + nameOfMovie);
		System.out.println("Date of the movie : " + date);
		System.out.println("Time of the movie: " + time);
		System.out.println("Seat available are: " + seatNumbers);
	}
}

class Patron {
	private String customerName;
	private int mobileNumber;

	Patron(String customerName , int mobileNumber) {
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
	}

	public String getCustomerName() {
		return customerName;
	}
	
	public int getMobileNumber() {
		return mobileNumber;
	}

}

class BookYourShow {
	
	private ArrayList<Show> arrList;
	private ArrayList<Patron> arrPatron;

	BookYourShow(){
		arrList = new ArrayList<Show>();
		arrPatron = new ArrayList<Patron>();
	}

	public void addAShow(Show s) {
		arrList.add(s);
	}

	public void getAShow(String movie) {
		int i;
		for(i = 0; i < arrList.size(); i++){
			if(movie.equals(arrList.get(i).getMovie())){
				printAllShows();
			}
		}
	}

	public void addUser(Patron p) {
		arrPatron.add(p);
	}

	public void bookAShow(Patron p ,String mname , int noOfTickets) {
		
		for(int i = 0; i < arrList.size(); i++){
			if(mname.equals(arrList.get(i).getMovie())){
				if(noOfTickets <= arrList.get(i).getSeatNumbers()){
					System.out.println("Movie is present, Movie booked to " + p.getCustomerName() + " for " + mname);
					System.out.println("Tickets booked are :" + noOfTickets);
				}else{
					System.out.println("Check the movie tickets ");
				}
			}else {
				System.out.println("Movie has yet to come");
			}
		}
	}

	public void printAllShows(){
		for(int i = 0; i< arrList.size(); i++)
			arrList.get(i).printShow();
	}
}


public class Book{
	
	public static void main(String[] args){
		BookYourShow cc = new BookYourShow();
        ArrayList<Show> arrList = new ArrayList<Show>();

        Show show;
        Patron patron;
        String name, date , time , custName;
        int numbers , mNumber , noOfTickets;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1. Adding a movie");
            System.out.println("2. Book a movie");
            System.out.println("3. Printing");
            System.out.println("4. Exit");
            int ch = sc.nextInt();
            sc.nextLine();
            switch(ch){


                case 1:                                
                    System.out.println("Enter name of movie ");
                    name = sc.nextLine();

                    System.out.println("Enter date of movie ");
                    date = sc.nextLine();

                    System.out.println("Enter time of movie ");
                    time = sc.nextLine();

                    System.out.println("Enter seat numbers of movie ");
                    numbers = sc.nextInt();
                    
                    show = new Show(name , date , time , numbers);
                    cc.addAShow(show);
                    break;

                case 2:

                	System.out.println("Enter name of customer ");
                    custName = sc.nextLine();

                    System.out.println("Enter name of movie ");
                    name = sc.nextLine();

                    System.out.println("Enter mobile number of customer ");
                    mNumber = sc.nextInt();

                    System.out.println("Enter number of tickets requried :");
                    noOfTickets = sc.nextInt();

                    patron = new Patron(custName , mNumber);
                    cc.addUser(patron);
                    cc.bookAShow(patron , name , noOfTickets);
    
                    break;
                case 3:
                    cc.printAllShows();
                    break;
                default:
                    System.out.println("Not a valid number. . . ");    
                    break;

            }
            if(ch > 3){
                break;
            }
        } while (true);


    }

}
