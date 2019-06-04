package be.dominionexperts.cvtool.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Project {

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String url;

    @NotNull
    private List<String> keywords;

    @NotNull
    private String startDate;

    @NotNull
    private String endDate;

    @NotNull
    private String sector;

    @NotNull
    private String jobTitle;

    public Project() {
    }

    private Project(Builder builder) {
        name = builder.name;
        description = builder.description;
        url = builder.url;
        keywords = builder.keywords;
        startDate = builder.startDate;
        endDate = builder.endDate;
        sector = builder.sector;
        jobTitle = builder.jobTitle;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getSector() {
        return sector;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public static final class Builder {
        private String name;
        private String description;
        private String url;
        private List<String> keywords;
        private String startDate;
        private String endDate;
        private String sector;
        private String jobTitle;

        private Builder() {
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder withKeywords(List<String> keywords) {
            this.keywords = keywords;
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

        public Builder withSector(String sector) {
            this.sector = sector;
            return this;
        }

        public Builder withJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public Project build() {
            return new Project(this);
        }
    }
}
