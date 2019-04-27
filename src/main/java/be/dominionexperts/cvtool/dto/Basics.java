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

	@NotNull
	private String jobTitle;

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
		jobTitle = builder.jobTitle;
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

	public String getJobTitle() {
		return jobTitle;
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
		private String jobTitle;

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

		public Builder withDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
			return this;
		}

		public Builder withCitizenship(String citizenship) {
			this.citizenship = citizenship;
			return this;
		}

		public Builder withGender(String gender) {
			this.gender = gender;
			return this;
		}

		public Builder withJobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
			return this;
		}

		public Basics build() {
			return new Basics(this);
		}
	}
}
