package com.softserve.javaweb.web;

import com.softserve.javaweb.service.PersonService;

public class App {
	public static void main(String[] args) throws Exception {

		PersonService service = new PersonService();
		service.readFile("src\\main\\java\\resources\\persons.txt");		
	}
}