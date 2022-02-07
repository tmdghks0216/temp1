package client;

import controll.Controller;
import model.CRAWLING;

public class Client {
	public static void main(String[] args) {
//		CRAWLING crw = new CRAWLING();
//		crw.startdb();
		Controller app = new Controller();
		app.startApp();
	}
}

