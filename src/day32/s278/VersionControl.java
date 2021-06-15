package day32.s278;

public class VersionControl {
    int badVersion;

    public VersionControl(int badVersion) {
        this.badVersion = badVersion;
    }

    boolean isBadVersion(int version) {
        return badVersion <= version;
    }
}
