package be.dominionexperts.cvtool.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public class Skill {

    @NotNull
    private String name;

    @NotNull
    private String level;

    @NotNull
    private List<String> keywords;

    public Skill() {
    }

    private Skill(Builder builder) {
        name = builder.name;
        level = builder.level;
        keywords = builder.keywords;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public static final class Builder {
        private String name;
        private String level;
        private List<String> keywords;

        private Builder() {
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withLevel(String level) {
            this.level = level;
            return this;
        }

        public Builder withKeywords(List<String> keywords) {
            this.keywords = keywords;
            return this;
        }

        public Skill build() {
            return new Skill(this);
        }
    }
}
