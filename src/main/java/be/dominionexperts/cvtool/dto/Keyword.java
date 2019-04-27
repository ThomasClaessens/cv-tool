package be.dominionexperts.cvtool.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Keyword {
    @NotNull
    private String name;

    @Min(1)
    @Max(5)
    private int level;

    public Keyword() {
    }

    public Keyword(Builder builder) {
        name = builder.name;
        level = builder.level;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public static final class Builder {
        private String name;
        private int level;

        private Builder() {
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withLevel(int level) {
            this.level = level;
            return this;
        }

        public Keyword build() {
            return new Keyword(this);
        }
    }
}
