// Alijah Zapanta
// 1920874
// 11-09-2020
// ITP203_A
public class PythonToJava{
//Main Program
    public static void main(String args[]){
        Employee e1 = new Employee(100,"Peter Staff1","BSCS");
        
        System.out.println(e1.name + " " + e1.dept);
        
        // two teachers
        //standard
        Teacher t1 = new Teacher(200,"Gene Namo PT", "BSCS","CS",15);
        System.out.println(t1.name + " " + t1.dept);
        //use getter
        System.out.println("Load is: " + t1.getLoad());
        System.out.println();
        
        Teacher t2 = new Teacher(300,"Eddie De Paul", "BSIT","IT",24);
        System.out.println(t2.name + " " + t2.dept);
        //use getter
        System.out.println("Load is: " + Integer.toString(t2.getLoad()));
        System.out.println();
        
        //Create Staff Object
       Staff s1 = new Staff(400,"Tintin Gomez","BS Sec","CBA","secretary");
        Staff s2 = new Staff(500,"Jean Pelayo","BS LibSci","Library","Librarian");
        
        //Details
        System.out.println(s1.name + " " + s1.job + " " + s1.dept);
        System.out.println(s2.name + " " + s2.job + " " + s2.dept);
        
        System.out.println();
        //same name but behavior depends on the class of the object
        e1.prinstatus();
        t1.prinstatus();
        s1.prinstatus();     
    } 
}
class Employee{
    public int idno;
    public String name;
    public String course;
    public String dept;
    public Employee(int idno, String name, String course){
        this.idno = idno;
        this.name = name;
        this.course = course;
        this.dept = "unassigned";
    }
    //Overload is the Solution
    public Employee(int idno, String name, String course, String dept){
        this.idno = idno;
        this.name = name;
        this.course = course;
        this.dept = dept;
    }
    
    public void prinstatus(){
        System.out.println("EMP main Class");
}
    
}

// Teacher is An Employee
class Teacher extends Employee{
    //Assume as String
    // Setter is Useless if this variable is already protected
    // teacher.load convenient than teacher.getLoad()
    protected int load;
    public Teacher(int idno, String name,String course, String dept, int load){
        //call parent
        super(idno,name,course,dept);
        this.load  = load;
    }
    protected int getLoad(){
        return this.load;
    }
    // Override method in Java 
    @Override
     public void prinstatus(){
        System.out.println("      Teacher sub class");
}
    
}

// Staff is an Employee
class Staff extends Employee{
    // Constructor parameter should be an object to avoid rewriting parameters
    // Staff (EmployeeInfo info, String job)
    
    public String job;
    public Staff(int idno, String name, String course, String dept, String job){
        super(idno,name,course,dept);
        this.job = job;
    }
    public void printstatus(){
        System.out.println("         Staff sub class");
    }
}