package com.evs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserDTO extends BaseDTO {

    @Column(name = "firstName", length = 755)
    @NotEmpty(message = "First name is required")
    private String firstName;

    @Column(name = "lastName", length = 755)
    @NotEmpty(message = "Last name is required")
    private String lastName;

    @Column(name = "dob")
    @NotEmpty(message = "DOB is required")
    private String dob;

    @Column(name = "gender", length = 755)
    @NotEmpty(message = "Gender is required")
    private String gender;

    @Column(name = "email", length = 755)
    @NotEmpty(message = "Email is required")
    private String email;

    @Column(name = "password", length = 755)
    @NotEmpty(message = "Password is required")
    private String password;

    @Column(name = "phoneNumber", length = 755)
    @NotEmpty(message = "Phone number is required")
    private String phoneNumber;

    @Column(name = "userRole", length = 755)
    @NotEmpty(message = "User role is required")
    private String userRole;

    @Override
    public String toString() {
        return "UserDTO [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", gender=" + gender
                + ", email=" + email + ", password=" + password + ", phoneNumber=" + phoneNumber + ", userRole="
                + userRole + "]";
    }

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	public @NotEmpty(message = "userRole is required") String getUserRole() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setId(long id) {
		// TODO Auto-generated method stub
		
	}

	public @NotEmpty(message = "DOB name is required") String getDob() {
		// TODO Auto-generated method stub
		return null;
	}

	public @NotEmpty(message = "Last name is required") String getLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	public @NotEmpty(message = "First name is required") String getGender() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFirstName(@NotEmpty(message = "First name is required") String firstName2) {
		// TODO Auto-generated method stub
		
	}

	public void setLastName(@NotEmpty(message = "Last name is required") String lastName2) {
		// TODO Auto-generated method stub
		
	}

	public void setDob(@NotEmpty(message = "DOB name is required") String dob2) {
		// TODO Auto-generated method stub
		
	}

	public void setGender(@NotEmpty(message = "First name is required") String gender2) {
		// TODO Auto-generated method stub
		
	}

	public void setPassword(@NotEmpty(message = "First name is required") String password2) {
		// TODO Auto-generated method stub
		
	}

	public void setEmail(@NotEmpty(message = "First name is required") String email2) {
		// TODO Auto-generated method stub
		
	}

	public void setUserRole(@NotEmpty(message = "userRole is required") String userRole2) {
		// TODO Auto-generated method stub
		
	}

	public void setPhoneNumber(@NotEmpty(message = "First name is required") String phoneNumber2) {
		// TODO Auto-generated method stub
		
	}

	public @NotEmpty(message = "First name is required") String getPhoneNumber() {
		// TODO Auto-generated method stub
		return null;
	}

    // No need to manually create getter and setter methods as Lombok does it for you
}
