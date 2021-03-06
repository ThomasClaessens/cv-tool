package be.dominionexperts.cvtool.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Skill {

    @NotNull
    private String name;

    @NotNull
    private List<Keyword> keywords;

    public Skill() {
    }

    private Skill(Builder builder) {
        name = builder.name;
        keywords = builder.keywords;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public static final class Builder {
        private String name;
        private List<Keyword> keywords;

        private Builder() {
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withKeywords(List<Keyword> keywords) {
            this.keywords = keywords;
            return this;
        }

        public Skill build() {
            return new Skill(this);
        }
    }
}
