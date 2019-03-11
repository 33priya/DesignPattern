package java8;

public class DefaultMethodTest implements A,B/*extends ConcreteClass implements SuperClass, SubClass/*, A, B, Beta, Gamma*/{

	public static void main(String []args){
		DefaultMethodTest obj = new DefaultMethodTest();
		obj.sayHello();
	}

	@Override
	public void sayHello() {
		A.super.sayHello();
	}

	/*public void sayHello() {
		Beta.super.sayHello();
	}*/
}

//Rule 1 - Classes take higher precedence
class ConcreteClass {
	public void sayHello() {
		System.out.println("Hello from ConcreteClass");
	}  
}

//Rule 2 - Sub-Interface take higher precedence
interface SuperClass {
	default void sayHello() {
		System.out.println("Hello from SuperClass");
	}
} 

interface SubClass extends SuperClass {
	default void sayHello() {
		System.out.println("Hello from SubClass");
	}
}

//Rule 3 - Specifically Override
interface A {
	default void sayHello() {
		System.out.println("Hello from A");
	}
}

interface B {
	default void sayHello() {
		System.out.println("Hello from B");
	}
}

//Diamond Problem Resolution
interface Alpha {
	default void sayHello() {
		System.out.println("Hello from Alpha");
	}
}

interface Beta extends Alpha {
	default void sayHello() {
		System.out.println("Hello from Beta");
	}
}

interface Gamma extends Alpha {
	default void sayHello() {
		System.out.println("Hello from Gamma");
	}
}

