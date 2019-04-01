package be.dominionexperts.cvtool.dto;

public class Basics {

    private String email;
    private String phone;
    private String website;
    private Location location;
    private String name;

    public Basics() {
    }

    private Basics(Builder builder) {
        email = builder.email;
        phone = builder.phone;
        website = builder.website;
        location = builder.location;
        name = builder.name;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public static final class Builder {
        private String email;
        private String phone;
        private String website;
        private Location location;
        private String name;

        private Builder() {
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder withWebsite(String website) {
            this.website = website;
            return this;
        }

        public Builder withLocation(Location location) {
            this.location = location;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Basics build() {
            return new Basics(this);
        }
    }
}
