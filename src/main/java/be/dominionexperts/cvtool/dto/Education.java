package be.dominionexperts.cvtool.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
public class Education {

    @NotNull
    private String institution;

    @NotNull
    private String location;

    @NotNull
    private String area;

    @NotNull
    private String studyType;

    @NotNull
    private String startDate;

    @NotNull
    private String endDate;

    @NotNull
    private String gpa;

    public Education() {
    }

    private Education(Builder builder) {
        institution = builder.institution;
        location = builder.location;
        area = builder.area;
        studyType = builder.studyType;
        startDate = builder.startDate;
        endDate = builder.endDate;
        gpa = builder.gpa;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getInstitution() {
        return institution;
    }

    public String getLocation() {
        return location;
    }

    public String getArea() {
        return area;
    }

    public String getStudyType() {
        return studyType;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getGpa() {
        return gpa;
    }

    public static final class Builder {
        private String institution;
        private String location;
        private String area;
        private String studyType;
        private String startDate;
        private String endDate;
        private String gpa;

        private Builder() {
        }

        public Builder withInstitution(String institution) {
            this.institution = institution;
            return this;
        }

        public Builder withLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder withArea(String area) {
            this.area = area;
            return this;
        }

        public Builder withStudyType(String studyType) {
            this.studyType = studyType;
            return this;
        }

        public Builder withStartDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder withEndDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder withGpa(String gpa) {
            this.gpa = gpa;
            return this;
        }

        public Education build() {
            return new Education(this);
        }
    }
}
