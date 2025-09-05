package com.kh.customer.run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.kh.customer.view.CustomerView;

public class CustomerRun {

	public static void main(String[] args) {
	
		CustomerView cv = new CustomerView();
		cv.mainMenu();
	}

}
