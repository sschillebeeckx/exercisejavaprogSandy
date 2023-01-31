package be.abis.demo.model;

public class Instructor {

    private String firstName;
    private Gender gender;
    private int startAge=0;
    private int age;
    private double monthlyGrossSalary=0.0;
    private boolean senior;
    private Address address=null;

    private static int maxYearsOfSeniority=35;

    public Instructor(){
        System.out.println("instructor created");
    }

    public Instructor(String firstName, Gender gender, int age, double monthlyGrossSalary){
        this();
        this.firstName=firstName;
        this.gender=gender;
        this.age=age;
        this.monthlyGrossSalary=monthlyGrossSalary;
    }

    public Instructor(String firstName, Gender gender, int startAge, int age, double monthlyGrossSalary, boolean senior) {
        this(firstName, gender, age, monthlyGrossSalary);
        this.startAge = startAge;
        this.senior = senior;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setMonthlyGrossSalary(double monthlyGrossSalary){
        if (monthlyGrossSalary>1000.) {
            this.monthlyGrossSalary = monthlyGrossSalary;
        } else {
            System.out.println("salary not high enough");
        }
    }

    public double getMonthlyGrossSalary(){
        return monthlyGrossSalary;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getStartAge() {
        return startAge;
    }

    public void setStartAge(int startAge) {
        this.startAge = startAge;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSenior() {
        return senior;
    }

    public void setSenior(boolean senior) {
        this.senior = senior;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double calculateNetSalary(){
        double yearlyGrossSalary=monthlyGrossSalary*12;
        //System.out.println("monthly gross salary is " + salary);
        //System.out.println("yearly gross salary is " + grossSalary);

        double taxRate = this.determineTaxRate(yearlyGrossSalary);
        //System.out.println("taxRate is " + taxRate);

        //double monthlyNetSalary =;
        return  monthlyGrossSalary*(1-taxRate/100.);
    }

   private double determineTaxRate(double yearlyGrossSalary){
        double taxRate=0;
        if (yearlyGrossSalary<13870){
            taxRate=25;
        } else if (yearlyGrossSalary>=13870 && yearlyGrossSalary<24480){
            taxRate=40;
        } else if (yearlyGrossSalary>=24480 && yearlyGrossSalary<42370){
            taxRate=45;
        } else {
            taxRate=50;
        }
        return taxRate;
    }


    void printInfo(){
        String personalPronoun="";
        String reflexivePronoun="";
        String posessivePronoun="";
        switch(gender){
            case MALE:
                personalPronoun="he";
                reflexivePronoun="him";
                posessivePronoun="his";
                break;
            case FEMALE: personalPronoun="she"; reflexivePronoun="her"; posessivePronoun="her"; break;
            case OTHER:  personalPronoun="they"; reflexivePronoun="them"; posessivePronoun="their";

        }
        System.out.println(firstName + " is " + age + " years old." + personalPronoun + " is a " + gender );
    }

    public void teach(String subject1){
        System.out.println(firstName + " is teaching about " + subject1 );
    }

    public void teach(String... subjects){
        for (String subject : subjects) this.teach(subject);
    }

     @Deprecated
    public void teach(){
        System.out.println(firstName + " is teaching." );
    }

    public void teach(int numberOfDays){
        this.teach("Java");
        System.out.println(firstName + " is teaching for " + numberOfDays +" days." );
    }

    public static int getMaxYearsOfSeniority() {
        return maxYearsOfSeniority;
    }

    public static void setMaxYearsOfSeniority(int maxYearsOfSeniority) {
        Instructor.maxYearsOfSeniority = maxYearsOfSeniority;
    }
}
