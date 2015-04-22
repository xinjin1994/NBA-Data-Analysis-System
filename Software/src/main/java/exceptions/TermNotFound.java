package exceptions;

import enums.Terminology;

public class TermNotFound extends Exception {
	private static final long serialVersionUID = 579756946845578362L;

	public TermNotFound(Terminology term) {
		super("Missing Terminology:  "+term.toString());
	}

}
