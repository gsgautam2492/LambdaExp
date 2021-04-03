package com.techstack.training.lambdaexp;

import java.util.*;

public class SessionLearningDemo{
	interface user {
		public String toString();

		public user userRegistration(String fname, String lname, String email, String mobile, String password);
		
	}

	interface validate {
		public Boolean validate(String s);
	}

	user u = new user() {
		String fname;
		String lname;
		String email;
		String mobile;
		String password;

		@Override
		public String toString() {
			return "User Details :: \t" + this.fname + "\t" + this.lname + "\t" + this.email + "\t" + this.mobile + "\t"
					+ this.password;
		}

		@Override
		public user userRegistration(String fname, String lname, String email, String mobile, String password) {
			// TODO Auto-generated method stub
			this.fname = fname;
			this.lname = lname;
			this.email = email;
			this.mobile = mobile;
			this.password = password;
			return u;
		}
	};

	public static validate getFnameValidated() {
		return (s) -> s.length() > 3 && Character.isUpperCase(s.charAt(0)) ? true : false;
	}

	public static validate getLnameValidated() {
		return (s) -> s.length() > 3 && Character.isUpperCase(s.charAt(0)) ? true : false;
	}

	public static validate getEmailValidated() {
		return (s) -> s.contains("@") && s.substring(s.indexOf("@") + 2).contains(".") ? true : false;
	}

	public static validate getMobileValidated() {
		return (s) -> s.length() >= 13 && s.contains(" ") ? true : false;
	}

	public static validate getPasswordValidated() {
		return (s) -> s.length() >= 8 && s.chars().anyMatch(Character::isLetter)
				&& s.chars().anyMatch(Character::isDigit) && s.chars().anyMatch(Character::isUpperCase)
				&& s.chars().anyMatch(Character::isLowerCase)
				&& (s.chars().filter(ch -> ch == '@').count() == 1 && !( s.chars().filter(ch -> ch == '#').count() == 1))
				&& (!(s.chars().filter(ch -> ch == '@').count() == 1) && ( s.chars().filter(ch -> ch == '#').count() == 1))
						? true
						: false;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		HashSet<user> hs = new HashSet<user>();
		System.out.println("Welcome to User Registration Program ::: \n \n");
		Scanner keyboard = new Scanner(System.in);
		String loopCheck = "Y";
		while (!loopCheck.equals("N")) {
			System.out.print("Please enter fname: ");
			String fname = keyboard.nextLine(); // local variable
			Boolean bValid = true;
			bValid = getFnameValidated().validate(fname) ? true : false;
			if (bValid.equals(false)) {
				System.out.println(
						"first name is not valid. It should contains at least 3 characters with Starting letter as upper case.");
				break;
			}
			System.out.print("Please enter lname: ");
			String lname = keyboard.nextLine(); // local variable
			bValid = getLnameValidated().validate(lname) ? true : false;
			if (bValid.equals(false)) {
				System.out.println(
						"last name is not valid. It should contains at least 3 characters with Starting letter as upper case.");
				break;
			}
			System.out.print("Please enter email: ");
			String email = keyboard.nextLine(); // local variable
			bValid = getEmailValidated().validate(email) ? true : false;
			if (bValid.equals(false)) {
				System.out.println("Email entered is not valid. It is should be in this format abc@gmail.com");
				break;
			}
			System.out.print("Please enter mobile: ");
			String mobile = keyboard.nextLine(); // local variable
			bValid = getMobileValidated().validate(mobile) ? true : false;
			if (bValid.equals(false)) {
				System.out.println("Mobile entered is not valid. It is should be in this format 91 9999912345");
				break;
			}
			System.out.print("Please enter Password: ");
			String password = keyboard.nextLine(); // local variable
			bValid = getPasswordValidated().validate(password) ? true : false;
			if (bValid.equals(false)) {
				System.out.println(
						"Password entered is not valid. It should have alteast 8 characters, with atleast one upper case,"
								+ "one number and special character ");
				break;
			}
			SessionLearningDemo a = new SessionLearningDemo();
			user u1 = a.u.userRegistration(fname, lname, email, mobile, password);
			hs.add(u1);
			System.out.println(u1.toString());
			System.out.print("\nDo you want to continue:(Y/N) ");
			loopCheck = keyboard.nextLine();

		}
		System.out.println(hs.toString());

	}
}