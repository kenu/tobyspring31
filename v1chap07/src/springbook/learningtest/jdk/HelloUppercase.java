package springbook.learningtest.jdk;

public class HelloUppercase implements Hello {
	Hello hello;
	
	public HelloUppercase(Hello hello) {
		this.hello = hello;
	}

	public String sayHello(String name) {
		return hello.sayHello(name).toUpperCase();
	}

	public String sayHi(String name) {
		return hello.sayHi(name).toUpperCase();
	}

	public String sayThankYou(String name) {
		return hello.sayThankYou(name).toUpperCase();
	}

}
