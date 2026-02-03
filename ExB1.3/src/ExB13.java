public class ExB13 {

    public static void main(String[] args) {
        String firstName="Bob";
        int age=43;
        double monthlyGrossSalary=3216.54;
        boolean senior=false;

        System.out.println(firstName + " is " + age + " years old. Monthly gross salary is " + monthlyGrossSalary + "€. Senior:"+senior + ".");

        double grossSalary=monthlyGrossSalary*12;

      /*  double taxRate=0;
        if (grossSalary<16320){
            taxRate=25;
        } else if (grossSalary<28800){
            taxRate=40;
        } else if (grossSalary<49840){
            taxRate=45;
        } else {
            taxRate=50;
        }

        double netSalary = monthlyGrossSalary*(1-taxRate/100.);

        System.out.println("The instructor's net salary is " + netSalary+ "€."); */

        double yearlyNetSalary = 0;
        double salaryPart = 0;

        double val1= 16320;
        double val2= 28800;
        double val3= 49840;

        if (grossSalary>=val3){
            yearlyNetSalary+=(grossSalary-val3)*0.5;
        }
        if (grossSalary<val1){
            yearlyNetSalary +=grossSalary*0.75;
        } else {
            yearlyNetSalary+=val1*0.75;
            salaryPart-=grossSalary-val1;
        }
        if (grossSalary>=val1 && grossSalary<val2){
            yearlyNetSalary+=(salaryPart)*0.60;
        } else {
            yearlyNetSalary+=(val2-val1)*0.60;
            salaryPart=grossSalary-val2;
        }
        if (grossSalary>=val2 && grossSalary<val3){
            yearlyNetSalary+=(salaryPart)*0.60;
        } else {
            yearlyNetSalary+=(val3-val2)*0.55;
            salaryPart=grossSalary-val3;
        }

        if (grossSalary>val3) {
            yearlyNetSalary += (salaryPart) * 0.50;
        }

        double netSalary = yearlyNetSalary/12;
        System.out.println("The instructor's net salary is " + netSalary + " .");

    }
}
