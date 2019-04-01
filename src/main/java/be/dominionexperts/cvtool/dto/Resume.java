package be.dominionexperts.cvtool.dto;

import java.util.List;

public class Resume {

    private int selectedTemplate;
    private Headings headings;
    private Basics basics;
    private List<Education> education;
    private List<Work> work;
    private List<Skill> skills;
    private List<Project> projects;
    private List<Award> awards;
    private List<String> sections;

    public Resume() {
    }

    private Resume(Builder builder) {
        selectedTemplate = builder.selectedTemplate;
        headings = builder.headings;
        basics = builder.basics;
        education = builder.education;
        work = builder.work;
        skills = builder.skills;
        projects = builder.projects;
        awards = builder.awards;
        sections = builder.sections;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getSelectedTemplate() {
        return selectedTemplate;
    }

    public Headings getHeadings() {
        return headings;
    }

    public Basics getBasics() {
        return basics;
    }

    public List<Education> getEducation() {
        return education;
    }

    public List<Work> getWork() {
        return work;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<Award> getAwards() {
        return awards;
    }

    public List<String> getSections() {
        return sections;
    }

    public static final class Builder {
        private int selectedTemplate;
        private Headings headings;
        private Basics basics;
        private List<Education> education;
        private List<Work> work;
        private List<Skill> skills;
        private List<Project> projects;
        private List<Award> awards;
        private List<String> sections;

        private Builder() {
        }


        public Builder withSelectedTemplate(int selectedTemplate) {
            this.selectedTemplate = selectedTemplate;
            return this;
        }


        public Builder withHeadings(Headings headings) {
            this.headings = headings;
            return this;
        }


        public Builder withBasics(Basics basics) {
            this.basics = basics;
            return this;
        }


        public Builder withEducation(List<Education> education) {
            this.education = education;
            return this;
        }


        public Builder withWork(List<Work> work) {
            this.work = work;
            return this;
        }


        public Builder withSkills(List<Skill> skills) {
            this.skills = skills;
            return this;
        }


        public Builder withProjects(List<Project> projects) {
            this.projects = projects;
            return this;
        }


        public Builder withAwards(List<Award> awards) {
            this.awards = awards;
            return this;
        }


        public Builder withSections(List<String> sections) {
            this.sections = sections;
            return this;
        }


        public Resume build() {
            return new Resume(this);
        }
    }
}
