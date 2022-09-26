package be.abis.courseadmin.enumeration;

public enum Gender {

    FEMALE("F","she","her","her"),
    MALE("M","he","him","his"),
    OTHER("X","they","them","their");

    private String abbreviation;
    private String personalPronoun;
    private String reflexivePronoun;
    private String possessivePronoun;

    Gender(String abbreviation, String personalPronoun, String reflexivePronoun, String possessivePronoun) {
        this.abbreviation = abbreviation;
        this.personalPronoun = personalPronoun;
        this.reflexivePronoun = reflexivePronoun;
        this.possessivePronoun = possessivePronoun;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getPersonalPronoun() {
        return personalPronoun;
    }

    public void setPersonalPronoun(String personalPronoun) {
        this.personalPronoun = personalPronoun;
    }

    public String getReflexivePronoun() {
        return reflexivePronoun;
    }

    public void setReflexivePronoun(String reflexivePronoun) {
        this.reflexivePronoun = reflexivePronoun;
    }

    public String getPossessivePronoun() {
        return possessivePronoun;
    }

    public void setPossessivePronoun(String possessivePronoun) {
        this.possessivePronoun = possessivePronoun;
    }


}
