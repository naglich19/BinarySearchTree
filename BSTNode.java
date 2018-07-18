import java.text.SimpleDateFormat;
import java.util.Date;

public class BSTNode {
	String birthday;
	String firstName;
	String lastName;

	int birthMonth;
	int birthYear;
	int birthInt;
	int age;

	BSTNode lTree;
	BSTNode rTree;	

	public BSTNode(String last, String first, String birthday) {
			this.birthday = birthday;
			this.lastName = last;
			this.firstName = first;			
	
			lTree = null;
			rTree = null;
			age = getAge();
	
			System.out.println("age: " + age);
	}

	public String toString() {
			return (firstName + " " + lastName + " " + birthday + " age: " + getAge());
	}

	private int getAge() {
			int personage = 0;
			Date todaydate = new Date();
			String modfileDate = new SimpleDateFormat("yyyy-MM-dd").format(todaydate);
			String today[] = modfileDate.split("-");
			
			int todayYearInt = Integer.parseInt(today[0]);
			int todayMonthInt = Integer.parseInt(today[1]);
			int todayDayInt = Integer.parseInt(today[2]);
			
			String[] date = birthday.split("/");
			birthInt = Integer.parseInt(date[1]);
			birthMonth = Integer.parseInt(date[0]);
			birthYear = Integer.parseInt(date[2]);
			int age = 0;
			
			if (birthMonth < todayMonthInt) {
					age = ((todayYearInt - birthYear) - 1);
					return age;
			} 
				
			else if (birthMonth >= todayMonthInt) 
				age = (todayYearInt - birthYear);
			
			return age;
			

	}
}

