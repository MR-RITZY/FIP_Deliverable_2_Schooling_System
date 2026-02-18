package fip.challenge_3.schooling_system.enums;




public enum AcademicRank {
    MSC("MSC"),
    PHD("PHD"),
    PROF("PROF");

    private final String rank;

    AcademicRank(String rank) {
        this.rank = rank;

    }

    public String getRank() {
        return rank;
    }

}
