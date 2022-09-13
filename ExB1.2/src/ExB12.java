public class ExB12 {

    public static void main(String[] args) {
        String firstName="Sandy";
        int age=44;
        double monthlyGrossSalary=4321.98;
        boolean senior=true;

        System.out.println(firstName + " is " + age + " years old. Monthly gross salary is " + monthlyGrossSalary + ". Senior:"+senior);

        double netSalary = monthlyGrossSalary*0.52;

        System.out.println("The instructor's net salary is " + netSalary);
    }
}
