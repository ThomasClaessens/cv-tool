package be.dominionexperts.cvtool.dto;

import javax.validation.constraints.NotNull;

public class Basics {

    @NotNull
    private String email;

    @NotNull
    private String phone;

    @NotNull
    private String website;

    @NotNull
    private Location location;

    @NotNull
    private String name;

    @NotNull
    private String dateOfBirth;

    @NotNull
    private String citizenship;

    @NotNull
    private String gender;

    public Basics() {
    }

    private Basics(Builder builder) {
        email = builder.email;
        phone = builder.phone;
        website = builder.website;
        location = builder.location;
        name = builder.name;
	    dateOfBirth = builder.dateOfBirth;
	    citizenship = builder.citizenship;
	    gender = builder.gender;
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

    public String getDateOfBirth() {
    	return dateOfBirth;
    }

	public String getCitizenship() {
		return citizenship;
	}

	public String getGender() {
		return gender;
	}

	public static final class Builder {
		private String email;
		private String phone;
		private String website;
		private Location location;
		private String name;
		private String dateOfBirth;
		private String citizenship;
		private String gender;

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
