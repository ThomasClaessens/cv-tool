package be.dominionexperts.cvtool.dto;

import javax.validation.constraints.NotNull;

public class Language {

    @NotNull
    private String language;

    @NotNull
    private String skillLevel;

    public Language() {
    }

    private Language(Builder builder) {
        language = builder.language;
        skillLevel = builder.skillLevel;
    }

    public String getLanguage() {
        return language;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private String language;
        private String skillLevel;

        private Builder() {
        }

        public Builder withLanguage(String language) {
            this.language = language;
            return this;
        }

        public Builder withSkillLevel(String skillLevel) {
            this.skillLevel = skillLevel;
            return this;
        }

        public Language build() {
            return new Language(this);
        }
    }
}
