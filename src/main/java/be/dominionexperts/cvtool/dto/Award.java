package be.dominionexperts.cvtool.dto;

import javax.validation.constraints.NotNull;

public class Award {

    @NotNull
    private String title;

    @NotNull
    private String date;

    @NotNull
    private String awarder;

    @NotNull
    private String summary;

    public Award() {
    }

    private Award(Builder builder) {
        title = builder.title;
        date = builder.date;
        awarder = builder.awarder;
        summary = builder.summary;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getAwarder() {
        return awarder;
    }

    public String getSummary() {
        return summary;
    }

    public static final class Builder {
        private String title;
        private String date;
        private String awarder;
        private String summary;

        private Builder() {
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withDate(String date) {
            this.date = date;
            return this;
        }

        public Builder withAwarder(String awarder) {
            this.awarder = awarder;
            return this;
        }

        public Builder withSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public Award build() {
            return new Award(this);
        }
    }
}
