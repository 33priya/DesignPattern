package oops;

public class Polymorphism {

	public static void main(String[] args) {
		foo(null);
	}

	public static void foo(Object o) {
		System.out.println("Object impl");
	}
	
	public static void foo(String s) {
		System.out.println("String impl");
	}
}
