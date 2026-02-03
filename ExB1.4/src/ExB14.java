public class ExB14 {

    public static void main(String[] args) {
        String firstName="Bob";
        int age=43;
        double monthlyGrossSalary=3216.54;
        boolean senior=false;

        System.out.println(firstName + " is " + age + " years old. Monthly gross salary is " + monthlyGrossSalary + ".");
        System.out.println(firstName + " is" + (senior?"":" not")  + " a senior.");

        double yearlyGrossSalary=monthlyGrossSalary*12;

        double taxRate=0;
        if (yearlyGrossSalary<16320){
            taxRate=25;
        } else if (yearlyGrossSalary<28800){
            taxRate=40;
        } else if (yearlyGrossSalary<49840){
            taxRate=45;
        } else {
            taxRate=50;
        }

        double netSalary = monthlyGrossSalary*(1-taxRate/100);

        System.out.println("The instructor's net salary is " + netSalary + " .");


    }
}
