
public class Student extends Person {
	private int numCourses;
	private String[] courseCode;
	private int[] grades;
	private static final int maxNum = 20;

	public Student(String name, String address, int idNum) {
		super(name, address, idNum);
		// TODO Auto-generated constructor stub
		numCourses = 0;
		courseCode = new String[maxNum];
		grades = new int[maxNum];
	}
	
	public String toString() {
		String personString = super.toString();
		return "Student: "+ personString;
	}
	
	public void addGrade(String code, int grade) {
		this.courseCode[numCourses] = code;
		this.grades[numCourses] = grade;
		this.numCourses = numCourses+1;
	}
	
	public void printGrades() {
		for(int i = 0; i<numCourses; i++) {
			System.out.println(courseCode[i] + ", " + grades[i]);
		}
	}

}

