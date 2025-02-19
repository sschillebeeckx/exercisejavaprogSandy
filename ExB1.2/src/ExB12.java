public class ExB12 {

    public static void main(String[] args) {
        String firstName="Bob";
        int age=43;
        double monthlyGrossSalary=3216.54;
        boolean senior=false;

        System.out.println(firstName + " is " + age + " years old. Monthly gross salary is " + monthlyGrossSalary + "€. Senior:"+senior + ".");

        double taxRate = 0.48;
        double netSalary = monthlyGrossSalary*(1-taxRate);

        System.out.println("The instructor's net salary is " + netSalary + "€.");
    }
}
