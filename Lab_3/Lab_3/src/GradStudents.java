
public class GradStudents extends Student {
	private int numCommittee;
	private int numExams;
	private String[] examNames;
	private String[] examGrades;
	private static final int maxExams = 6;
	
	public GradStudents(String name, String address, int idNum) {
		super(name, address, idNum);
		// TODO Auto-generated constructor stub
		numCommittee = 0;
		numExams = 0;
		examNames = new String[maxExams];
		examGrades = new String[maxExams];
	}

	public int getNumCommittee() {
		return numCommittee;
	}

	public void setNumCommittee(int numCommittee) {
		this.numCommittee = numCommittee;
	}

	public void addGrade(String name, String grade) {
		
		this.examNames[numExams] = name;
		this.examGrades[numExams] = grade;
		this.numExams = numExams +1;
	}
	public String toString() {
		String personString = super.toString();
		return "Grad "+ personString;
	}
	public void printExamGrades() {
		for (int i = 0; i <numExams; i++) {
			System.out.println(examNames[i] + "," + examGrades[i]);
		}
	}

	public static void main(String[] args) {
		Person p1 = new Person("Julia", "181 University Ave" , 121456);
		System.out.println(p1.toString());
		Student s1 = new Student("John", "189 University Ave" , 246718);
		s1.addGrade("ELEC 279", 97);
		s1.addGrade("ELEC 221", 68);
		System.out.println(s1.toString());
		s1.printGrades();
		GradStudents s2 = new GradStudents("Tom", " 92 Reg. St.", 1014);
		System.out.println(s2.toString());
		s2.addGrade("ELEC 279", 97);
		s2.addGrade("ELEC 271", 88);
		s2.setNumCommittee(6);
		s2.addGrade("Comp1", "PASS");
		s2.addGrade("COMPII", "PASS");
		s2.addGrade("Thesis Defense first trial", "FAIL");
		s2.addGrade("Thesis Defense second trial", "FAIL");
		s2.printExamGrades();
		s2.printGrades();
	}
}
