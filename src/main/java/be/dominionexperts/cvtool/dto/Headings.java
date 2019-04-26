package be.dominionexperts.cvtool.dto;

import javax.validation.constraints.NotNull;

public class Headings {

    @NotNull
    private String work;

    @NotNull
    private String education;

    @NotNull
    private String skills;

    @NotNull
    private String projects;

    @NotNull
    private String awards;

    public Headings() {
    }

    private Headings(Builder builder) {
        work = builder.work;
        education = builder.education;
        skills = builder.skills;
        projects = builder.projects;
        awards = builder.awards;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getWork() {
        return work;
    }

    public String getEducation() {
        return education;
    }

    public String getSkills() {
        return skills;
    }

    public String getProjects() {
        return projects;
    }

    public String getAwards() {
        return awards;
    }

    public static final class Builder {
        private String work;
        private String education;
        private String skills;
        private String projects;
        private String awards;

        private Builder() {
        }

        public Builder withWork(String work) {
            this.work = work;
            return this;
        }

        public Builder withEducation(String education) {
            this.education = education;
            return this;
        }

        public Builder withSkills(String skills) {
            this.skills = skills;
            return this;
        }

        public Builder withProjects(String projects) {
            this.projects = projects;
            return this;
        }

        public Builder withAwards(String awards) {
            this.awards = awards;
            return this;
        }

        public Headings build() {
            return new Headings(this);
        }
    }
}
