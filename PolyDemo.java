
public class PolyDemo extends Utility{

	public static void main(String args[]){

		// Address Obj
		Address addr1 = new Address("Rizal Street","Brgy. 17", "Bacolod City", "Negros Occidental", 6100);
		Address addr2 = new Address("Mandalagan Street", "Bgry. Mandalagan", "Bacolod City","Negros Occidental", 6100);
		// Personal Infomation
		PersonalInfo info1 = new PersonalInfo("Juan","Beiber", 23, "Male", addr1);
		PersonalInfo info2 = new PersonalInfo("Liza","Soberano", 23, "Female", addr2);

		//  Departments
		Student collegeStd = new College(info1,"1611211", 4, "BSCS");
		Student liceoStd = new Liceo(info2, "1811211",12,"STEM");



		printLine(collegeStd.message());
		printLine(collegeStd.toString());

		printLine(liceoStd.message());
		printLine(liceoStd.toString());

	}


}

// Student Information
class Student {
	public String idNumber;
	public PersonalInfo info;
	public Student(PersonalInfo info, String idNumber)
	{
		this.idNumber = idNumber;
		this.info = info;
	}

	public String message(){
		return "Enrolling Student";
	}

}
// COLLEGE STUDENT
class College extends Student {
	public int currentLevel;
	public String courseCode;

	public College(PersonalInfo info, String idNumber,int level,String course){
		super(info,idNumber);
		this.currentLevel = level;
		this.courseCode = course;
	}

	@Override
	public String message(){
		return "\n\t\tEnrolling College Student";
	}
	public String toString(){
		return
		"\n\t\t++++++++++++++++++++++++++++++++++"+
		"\n\t\tID Number: " + this.idNumber + 
		"\n\t\tLevel: " + this.currentLevel +
		"\n\t\tCourse: " + this.courseCode +
		"\n\t\t+++++++++ Personal Info +++++++++"+
		"\n\t\tFirstname: " + this.info.firstname +
		"\n\t\tLastname: " + this.info.lastname +
		"\n\t\tAge: " + this.info.age +
		"\n\t\tGender: " + this.info.gender +
		"\n\t\tStreet" + this.info.address.street +
		"\n\t\tBarangay" + this.info.address.barangay +
		"\n\t\tCity" + this.info.address.city +
		"\n\t\tProvince" + this.info.address.province +
		"\n\t\tZip" + this.info.address.zip +
		"\n";


	}


}
// LICEO STUDENT
class Liceo extends Student{
	public int gradeLevel;
	public String strand;

	public Liceo(PersonalInfo info,String idNumber,int grade, String strand){
		super(info,idNumber);
		this.gradeLevel = grade;
		this.strand = strand;
	}
	@Override
	public String message(){
		return "\n\t\tEnrolling Liceo Student";
	}
	public String toString(){
		return
		"\n\t\t++++++++++++++++++++++++++++++++++"+
		"\n\t\tID Number: " + this.idNumber + 
		"\n\t\tLevel: " + this.gradeLevel +
		"\n\t\tCourse: " + this.strand +
		"\n\t\t+++++++++ Personal Info +++++++++"+
		"\n\t\tFirstname: " + this.info.firstname +
		"\n\t\tLastname: " + this.info.lastname +
		"\n\t\tAge: " + this.info.age +
		"\n\t\tGender: " + this.info.gender +
		"\n\t\tStreet" + this.info.address.street +
		"\n\t\tBarangay" + this.info.address.barangay +
		"\n\t\tCity" + this.info.address.city +
		"\n\t\tProvince" + this.info.address.province +
		"\n\t\tZip" + this.info.address.zip +
		"\n";


	}
}



// PERONAL INFO OF THE STUDENT
class PersonalInfo{
	public String firstname;
	public String lastname;
	public int age;
	public String gender;
	public Address address;

	public PersonalInfo(String firstname,String lastname,int age,String gender,Address address){
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	

}
// ADDRESS OF THE STUDENT
class Address{
	public String street;
	public String barangay;
	public String city;
	public String province;
	public int zip;


	public Address(String street, String barangay,String city, String province,int zip){
		this.street = street;
		this.barangay = barangay;
		this.city = city;
		this.province = province;
		this.zip = zip;
	}



}


class Utility{

	public static void print(String msg){
		System.out.print(msg);
	}
	public static void printLine(String msg){
		System.out.println(msg);
	}




}