package fip.challenge_3.schooling_system.enums;

public enum LevelAtService {
    seniorStaff("seniorStaff"),
    juniorStaff("juniorStaff"),
    assistantPersonnel("assistantPersonnel");

    private final  String level;
    LevelAtService(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

}
