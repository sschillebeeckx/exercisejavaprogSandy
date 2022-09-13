public class ExB14 {

    public static void main(String[] args) {
        String firstName="Bob";
        int age=43;
        double monthlyGrossSalary=3216.54;
        boolean senior=false;

        System.out.println(firstName + " is " + age + " years old. Monthly gross salary is " + monthlyGrossSalary + ".");
        System.out.println(firstName + " is" + (senior?"":" not")  + " a senior.");

        double grossSalary=monthlyGrossSalary*12;

        double taxRate=0;
        if (grossSalary<13870){
            taxRate=25;
        } else if (grossSalary>=13870 && grossSalary<24480){
            taxRate=40;
        } else if (grossSalary>=24480 && grossSalary<42370){
            taxRate=45;
        } else {
            taxRate=50;
        }

        double netSalary = monthlyGrossSalary*(1-taxRate/100);

        System.out.println("The instructor's net salary is " + netSalary);


    }
}
