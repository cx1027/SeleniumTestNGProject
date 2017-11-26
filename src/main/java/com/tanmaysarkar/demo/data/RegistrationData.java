package com.tanmaysarkar.demo.data;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.DataProvider;

import com.opencsv.CSVReader;

public class RegistrationData {

	private String firstName;
	private String lastName;
	private String address;
	
	private String userName;
	private String email;
	private String password;

//	private Properties properties = new Properties();
//
//	public RegistrationData() throws IOException {
//		properties.load(RegistrationData.class.getResourceAsStream("/registrationdata.properties"));
//		firstName = properties.getProperty("firstname");
//		lastName = properties.getProperty("lastname");
//		address = properties.getProperty("phonenumber");
//
//	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Test data provider for data hard coded with in test
	 * 
	 * @return
	 * @throws IOException
	 */
	@DataProvider(name = "regData")
	public static Object[][] getRegistrationData() throws IOException {
		RegistrationData registrationData1 = new RegistrationData();
		registrationData1.setFirstName("first name 1");
		registrationData1.setLastName("last name 1");
		registrationData1.setAddress("1234567890");
		
		return new RegistrationData[][] { { registrationData1 } };
	}

	/**
	 * Test data provider reading data from csv file
	 * 
	 * @return
	 * @throws IOException
	 */
	@DataProvider(name = "regCSVData")
	public static Object[][] getCSVData() throws IOException {
		CSVReader csvReader = new CSVReader(
				new FileReader(RegistrationData.class.getResource("/regdata.csv").getPath()));
		List<String[]> dataList = csvReader.readAll();
		Object[][] data = new Object[dataList.size()][1];
		List<RegistrationData> regList = new ArrayList<RegistrationData>();
		for (String[] strArray : dataList) {
			RegistrationData registrationData = new RegistrationData();
			registrationData.setFirstName(strArray[0].trim());
			registrationData.setLastName(strArray[1].trim());
			registrationData.setAddress(strArray[2].trim());
			
			regList.add(registrationData);
		}
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				data[i][j] = regList.get(i);
			}
		}
		csvReader.close();
		return data;
	}

	@DataProvider(name = "loginData")
	public static Object[][] getLoginData() {
		return new Object[][] { { "test1@selenium.com", "123456","aaa" }, { "test2@selenium.com", "123456","aaa" } };
	}

	
	
	/*
	 * data provider
	 * 
	 * */
	@DataProvider(name = "loginData2")
	public static Object[][] getLoginData2() throws IOException {
		RegistrationData registrationData1 = new RegistrationData();
		registrationData1.setEmail("test1@selenium.com");
		registrationData1.setUserName("test1@selenium.com");
		registrationData1.setPassword("123456");

		RegistrationData registrationData2 = new RegistrationData();
		registrationData2.setEmail("test2@selenium.com");
		registrationData2.setUserName("test2@selenium.com");
		registrationData2.setPassword("123456");

		return new RegistrationData[][] { { registrationData1 }, { registrationData2 } };
	}

	

}
