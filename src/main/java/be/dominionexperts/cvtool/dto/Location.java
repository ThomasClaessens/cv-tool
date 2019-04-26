package be.dominionexperts.cvtool.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
public class Location {

    @NotNull
    private String address;

    public Location() {
    }

    private Location(Builder builder) {
        address = builder.address;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getAddress() {
        return address;
    }

    public static final class Builder {
        private String address;

        private Builder() {
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }
}
