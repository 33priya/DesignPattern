package oops;

public class Inheritence {

	public static void main(String[] args) {
		Producer p = new DerivedProducer();
		Consumer c = new DerivedConsumer();
		p.accept(c);
		p.accept(null);	
	}
}

class Producer {
	void accept(Consumer consumer) {
		System.out.println("Producer : Consumer");
	}

	void accept(DerivedConsumer derivedConsumer) {
		System.out.println("Producer : DerivedConsumer");
	}
}

class DerivedProducer extends Producer {}

class NonConsumer {}

class Consumer {
	void accept(Producer producer) {
		System.out.println("Consumer : Producer");
	}

	void accept(DerivedProducer derivedProducer) {
		System.out.println("Consumer : DerivedProducer");
	}
}

class DerivedConsumer extends Consumer {}
