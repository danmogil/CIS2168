package inclass.aug31;

public class TestLemur {
	public static void main(String[] args) {
		Lemur lemur = new Lemur();
		System.out.println(String.format("Using the 'lemur' reference... lemur's age is: %d", lemur.age));

		Primate primate = lemur;
		System.out.println(String.format("Using the 'primate' reference... lemur has hair: %b", primate.hasHair()));

		HasTail hasTail = lemur;
		System.out
				.println(String.format("Using the 'hasTail' reference... lemur has striped tail: %b", hasTail.isTailStriped()));
	}
}

/*
	1a) No, the Primate class does not have an age field.
	1b) No, the Primate class does not have an isTailStriped method.
	1c) Yes, the Primate class contains a hasHair method.
	
	2a) No, the hasTail interface does not include an age field.
	2a) Yes, the hasTail interface includes the isTailStriped method.
	2a) No, the hasTail interface does not include the hasHair method.
	
	I learned the following:
		a. An interface typed variable can be used to store elements that implement said interface.
			 Although we've been doing this with List, I never though about it this way.
		b. When storing a class in a variable defined by its super class (e.g. Primate = Lemur),
		 	 you can cast the superclass into the subclass.
*/