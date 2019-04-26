package be.dominionexperts.cvtool.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Work {

    @NotNull
    private String company;

    @NotNull
    private String location;

    @NotNull
    private String website;

    @NotNull
    private String startDate;

    @NotNull
    private String endDate;

    @NotNull
    private List<String> highlights;

    public Work() {
    }

    private Work(Builder builder) {
        company = builder.company;
        location = builder.location;
        website = builder.website;
        startDate = builder.startDate;
        endDate = builder.endDate;
        highlights = builder.highlights;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getWebsite() {
        return website;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public List<String> getHighlights() {
        return highlights;
    }

    public static final class Builder {
        private String company;
        private String location;
        private String website;
        private String startDate;
        private String endDate;
        private List<String> highlights;

        private Builder() {
        }

        public Builder withCompany(String company) {
            this.company = company;
            return this;
        }

        public Builder withLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder withWebsite(String website) {
            this.website = website;
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

        public Builder withHighlights(List<String> highlights) {
            this.highlights = highlights;
            return this;
        }

        public Work build() {
            return new Work(this);
        }
    }
}
