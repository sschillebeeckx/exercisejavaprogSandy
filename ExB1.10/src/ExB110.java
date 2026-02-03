public class ExB110 {

    public static void main(String[] args) {
        String firstName = "Bob";
        Gender gender = Gender.MALE;
        int startAge = Integer.parseInt(args[0]);
        int age = Integer.parseInt(args[1]);
        double monthlyGrossStartSalary = Double.parseDouble(args[2]);
        boolean senior = true;

        // Salary history
        int loopAge = startAge;
        double monthlyGrossSalary = monthlyGrossStartSalary;
        double monthlyNetSalary = 0;

        while (loopAge <= age && loopAge <= startAge + 35) {

            if (loopAge != startAge) {
                monthlyGrossSalary = monthlyGrossSalary * 1.05;
            }

             double yearlyGrossSalary = monthlyGrossSalary * 12;
            //System.out.println("monthly gross salary is " + salary);
            //System.out.println("yearly gross salary is " + grossSalary);

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
            //System.out.println("taxRate is " + taxRate);

            monthlyNetSalary = monthlyGrossSalary * (1 - taxRate / 100.);

            System.out.println(firstName + "'s net salary at " + loopAge + " is " + monthlyNetSalary);
            loopAge += 2;

            //System.out.println();
        }

        // pronouns based on gender
        String personalPronoun = "";
        String reflexivePronoun = "";
        String posessivePronoun = "";

        switch (gender) {
            case MALE: personalPronoun = "he"; reflexivePronoun = "him";posessivePronoun = "his";break;
            case FEMALE: personalPronoun = "she";reflexivePronoun = "her";posessivePronoun = "her";break;
            case OTHER: personalPronoun = "they";reflexivePronoun = "them";posessivePronoun = "their";
        }

        String personalPronounCapitalized = personalPronoun.substring(0, 1).toUpperCase() + personalPronoun.substring(1).toLowerCase();
        String posessivePronounCapitalized = posessivePronoun.substring(0, 1).toUpperCase() + posessivePronoun.substring(1).toLowerCase();


        //print basic data
        System.out.println("\n" + firstName + " is " + age + " years old. " + posessivePronounCapitalized + " monthly gross salary is " + monthlyGrossSalary + ".");
        System.out.println(personalPronounCapitalized + " is" + ((!senior) ? " not" : "") + " a senior.");
        System.out.println(posessivePronounCapitalized + " net salary is " + monthlyNetSalary + ".");

        //domain info
        String[] domains = {"Java", "Oracle", "XML", "SAS"};
        System.out.println("There are " + domains.length + " domains linked with " + reflexivePronoun + ":");
        for (String domain : domains) {
            System.out.println(domain);
        }


    }


}
