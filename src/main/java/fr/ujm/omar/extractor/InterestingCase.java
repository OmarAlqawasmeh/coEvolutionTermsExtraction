package fr.ujm.omar.extractor;

public class InterestingCase {

	public InterestingCase(String ns, String d1, String d2, String d1p, String d2p) {
		this.ns = ns;
		this.d1 = d1;
		this.d2 = d2;
		this.d1p = d1p;
		this.d2p = d2p;

	}

	private String ns , d1, d2, d1p, d2p;

	public String getNs() {
		return ns;
	}
	
	public String getD1() {
		return d1;
	}

	public String getD2() {
		return d2;
	}

	public String getD1p() {
		return d1p;
	}

	public String getD2p() {
		return d2p;
	}
}
