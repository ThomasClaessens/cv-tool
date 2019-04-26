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

    public Project() {
    }

    private Project(Builder builder) {
        name = builder.name;
        description = builder.description;
        url = builder.url;
        keywords = builder.keywords;
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

    public static final class Builder {
        private String name;
        private String description;
        private String url;
        private List<String> keywords;

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

        public Project build() {
            return new Project(this);
        }
    }
}
