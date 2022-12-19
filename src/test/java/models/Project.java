package models;

public class Project {
    private String name;
    private String announcement;
    private int type;
    private boolean showAnon;

    public static class Builder {
        private final Project project;

        public Builder() {
            project = new Project();
        }

        public Builder nameTest(String value) {
            project.name = value;
            return this;
        }

        public Builder announcement(String value) {
            project.announcement = value;
            return this;
        }

        public Builder typeOfTest(int value) {
            project.type = value;
            return this;
        }

        public Builder showAnon(boolean value) {
            project.showAnon = value;
            return this;
        }

        public Project build() {
            return project;
        }
    }

    public String getName() {
        return name;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public int getType() {
        return type;
    }

    public boolean isShowAnon() {
        return showAnon;
    }
}
