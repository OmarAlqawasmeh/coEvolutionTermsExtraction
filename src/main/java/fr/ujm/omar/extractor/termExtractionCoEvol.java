package fr.ujm.omar.extractor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;

public class termExtractionCoEvol {

	public static void main(String[] args) throws IOException {
		System.out.println("Calculating .... ");
		int cAddedinD2 = 0;
		int cAddedinD2p = 0;
		int cDeletedinD2 = 0;
		int cDeletedinD2p = 0;
		int similarTermsO = 0;
		int similarTermsOp = 0;

		int counter1a = 0;
		List<InterestingCase> cases1a = new ArrayList<>();

		int counter1b = 0;
		List<InterestingCase> cases1b = new ArrayList<>();

		int counter1c = 0;
		List<InterestingCase> cases1c = new ArrayList<>();

		int counter1d = 0;
		List<InterestingCase> cases1d = new ArrayList<>();

		int counter2a = 0;
		List<InterestingCase> cases2a = new ArrayList<>();

		int counter2b = 0;
		List<InterestingCase> cases2b = new ArrayList<>();

		int counter2c = 0;
		List<InterestingCase> cases2c = new ArrayList<>();

		int counter2d = 0;
		List<InterestingCase> cases2d = new ArrayList<>();

		int counter3a = 0;
		List<InterestingCase> cases3a = new ArrayList<>();

		int counter3b = 0;
		List<InterestingCase> cases3b = new ArrayList<>();

		int counter3c = 0;
		List<InterestingCase> cases3c = new ArrayList<>();

		int counter3d = 0;
		List<InterestingCase> cases3d = new ArrayList<>();

		int counter4a = 0;
		List<InterestingCase> cases4a = new ArrayList<>();

		int counter4b = 0;
		List<InterestingCase> cases4b = new ArrayList<>();

		int counter4c = 0;
		List<InterestingCase> cases4c = new ArrayList<>();

		int counter4d = 0;
		List<InterestingCase> cases4d = new ArrayList<>();

		BufferedReader br = null;
		FileReader fr = null;

		fr = new FileReader("target/classes/Pnamespace.csv");

		br = new BufferedReader(fr);

		String sCurrentLine;

		while ((sCurrentLine = br.readLine()) != null) {

			// System.out.println(sCurrentLine);

			String arr[] = sCurrentLine.split(",");

			// System.out.println(
			// "v1:" + arr[0] + ", v2:" + arr[1] + ",v1p:" + arr[2] + ", v2p" +
			// arr[3] + ", nsp:" + arr[4]);

			PotentialInterestingCase interestingCase = new PotentialInterestingCase(arr[4], "Ontologies/" + arr[0],
					"Ontologies/" + arr[1], "Ontologies/" + arr[2], "Ontologies/" + arr[3]);

			// differences in O (Music ontology)
			Set<String> listOfTermsInD1 = getListOfTerms(interestingCase.getNs(), interestingCase.getD1());
			Set<String> listOfTermsInD2 = getListOfTerms(interestingCase.getNs(), interestingCase.getD2());

			// System.out.println("Terms in D1 " + listOfTermsInD1);
			// System.out.println("Terms in D2 " + listOfTermsInD2);

			Set<String> termsDeletedInO = new HashSet<>(listOfTermsInD1);
			termsDeletedInO.removeAll(listOfTermsInD2);
			// System.out.println("termsDeletedInD2" + termsDeletedInO);
			// System.out.println(termsDeletedInO.size());
			cDeletedinD2 = cDeletedinD2 + termsDeletedInO.size();

			Set<String> termsAddedInO = new HashSet<>(listOfTermsInD2);
			termsAddedInO.removeAll(listOfTermsInD1);
			// System.out.println("termsAddedInD2" + termsAddedInO);
			// System.out.println(termsAddedInO.size());
			cAddedinD2 = cAddedinD2 + termsAddedInO.size();

			Set<String> similarTermsInO = new HashSet<>(listOfTermsInD2);
			similarTermsInO.retainAll(listOfTermsInD1);
			// System.out.println("termsSimilarBetween D1_and_D2" +
			// similarTermsInO);
			// System.out.println(similarTermsInO.size());
			similarTermsO = similarTermsO + similarTermsInO.size();

			// differences in O' (Bio ontology)
			Set<String> listOfTermsInD1p = getListOfTerms(interestingCase.getNs(), interestingCase.getD1p());
			Set<String> listOfTermsInD2p = getListOfTerms(interestingCase.getNs(), interestingCase.getD2p());

			// System.out.println("Terms in D1p " + listOfTermsInD1p);
			// System.out.println("Terms in D2p " + listOfTermsInD2p);

			Set<String> termsDeletedInOp = new HashSet<>(listOfTermsInD1p);
			termsDeletedInOp.removeAll(listOfTermsInD2p);
			// System.out.println("termsDeletedInD2p" + termsDeletedInOp);
			// System.out.println(termsDeletedInOp.size());
			cDeletedinD2p = cDeletedinD2p + termsDeletedInOp.size();

			Set<String> termsAddedInOp = new HashSet<>(listOfTermsInD2p);
			termsAddedInOp.removeAll(listOfTermsInD1p);
			// System.out.println("termsAddedInD2p" + termsAddedInOp);
			// System.out.println(termsAddedInOp.size());
			cAddedinD2p = cAddedinD2p + termsAddedInOp.size();

			Set<String> similarTermsInOp = new HashSet<>(listOfTermsInD2p);
			similarTermsInOp.retainAll(listOfTermsInD1p);
			// System.out.println("termsSimilarBetween D1p_and_D2p" +
			// similarTermsInOp);
			// System.out.println(similarTermsInOp.size());
			similarTermsOp = similarTermsOp + similarTermsInOp.size();

			// 1a
			// case does not make sense, always 0

			// 1b
			Set<String> case1b = new HashSet<>(termsDeletedInO);
			case1b.removeAll(listOfTermsInD1p);
			case1b.removeAll(listOfTermsInD2p);
			// System.out.println("case1b: " + case1b);
			counter1b = counter1b + case1b.size();
			if (case1b.size() != 0) {
				cases1b.add(new InterestingCase(interestingCase, case1b));
			}
			// System.out.println("size of case1b" + case1b);
			// System.out.println("****************************");

			// 1c
			Set<String> case1c = new HashSet<>(similarTermsInO);
			case1c.removeAll(listOfTermsInD1p);
			case1c.removeAll(listOfTermsInD2p);
			// System.out.println("case1c: " + case1c);
			counter1c = counter1c + case1c.size();
			if (case1c.size() != 0) {
				cases1c.add(new InterestingCase(interestingCase, case1c));
			}
			// System.out.println("size of 1c" + case1c);
			// System.out.println("****************************");

			// 1d
			Set<String> case1d = new HashSet<>(termsAddedInO);
			case1d.removeAll(listOfTermsInD1p);
			case1d.removeAll(listOfTermsInD2p);
			// System.out.println("case1d: " + case1d);
			counter1d = counter1d + case1d.size();
			if (case1d.size() != 0) {
				cases1d.add(new InterestingCase(interestingCase, case1d));
			}
			// System.out.println("size of 1d" + case1d);
			// System.out.println("****************************");

			// 2a
			Set<String> case2a = new HashSet<>(termsDeletedInOp);
			case2a.removeAll(listOfTermsInD1);
			case2a.removeAll(listOfTermsInD2);
			// System.out.println("Case2a: " + case2a);
			counter2a = counter2a + case2a.size();
			// System.out.println("size of 2a" + case2a);
			// System.out.println("****************************");

			// 2b
			Set<String> case2b = new HashSet<>(termsDeletedInO);
			case2b.retainAll(termsDeletedInOp);
			// System.out.println("Case2b: " + case2b);
			counter2b = counter2b + case2b.size();
			// System.out.println("size of 2b" + case2b);
			// System.out.println("****************************");

			// 2c
			Set<String> case2c = new HashSet<>(similarTermsInO);
			case2c.retainAll(termsDeletedInOp);
			// System.out.println("case2c: " + case2c);
			counter2c = counter2c + case2c.size();
			// System.out.println("size of 2c" + case2c);
			// System.out.println("****************************");

			// 2d
			Set<String> case2d = new HashSet<>(termsAddedInO);
			case2d.retainAll(termsDeletedInOp);
			// System.out.println("Case2d: " + case2d);
			counter2d = counter2d + case2d.size();
			// System.out.println("size of 2d" + case2d);
			// System.out.println("****************************");

			// 3a
			Set<String> case3a = new HashSet<>(similarTermsInOp);
			case3a.removeAll(listOfTermsInD1);
			case3a.removeAll(listOfTermsInD2);
			// System.out.println("Case3a: " + case3a);
			counter3a = counter3a + case3a.size();
			// System.out.println("size of 3a" + case3a);
			// System.out.println("****************************");

			// 3b
			Set<String> case3b = new HashSet<>(termsDeletedInO);
			case3b.retainAll(similarTermsInOp);
			// System.out.println("Case3b: " + case3b);
			counter3b = counter3b + case3b.size();
			if (case3b.size() != 0) {
				cases3b.add(new InterestingCase(interestingCase, case3b));
			}
			// System.out.println("size of 3b" + case3b);
			// System.out.println("****************************");

			// 3c
			Set<String> case3c = new HashSet<>(similarTermsInO);
			case3b.retainAll(similarTermsInOp);
			// System.out.println("Case3c: " + case3c);
			counter3c = counter3c + case3c.size();
			// System.out.println("size of 3c" + case3c);
			// System.out.println("****************************");

			// 3d
			Set<String> case3d = new HashSet<>(termsAddedInO);
			case3d.retainAll(similarTermsInOp);
			// System.out.println("Case3d: " + case3d);
			counter3d = counter3d + case3d.size();
			if (case3d.size() != 0) {
				cases3d.add(new InterestingCase(interestingCase, case3d));
			}
			// System.out.println("size of 3d" + case3d);
			// System.out.println("****************************");

			// 4a
			Set<String> case4a = new HashSet<>(termsAddedInOp);
			case4a.removeAll(listOfTermsInD1);
			case4a.removeAll(listOfTermsInD2);
			// System.out.println("Case 4a: " + case4a);
			counter4a = counter4a + case4a.size();

			if (case4a.size() != 0) {
				cases4a.add(new InterestingCase(interestingCase, case4a));
			}

			// System.out.println("size of 4a" + case4a);
			// System.out.println("****************************");

			// 4b
			Set<String> case4b = new HashSet<>(termsDeletedInO);
			case4b.retainAll(termsAddedInOp);
			// System.out.println("Case 4b: " + case4b);
			counter4b = counter4b + case4b.size();
			// System.out.println("size of 4b " + case4b);
			// System.out.println("****************************");

			// 4c
			Set<String> case4c = new HashSet<>(similarTermsInO);
			case4c.retainAll(termsAddedInOp);
			// System.out.println("Case 4c: " + case4c);
			counter4c = counter4c + case4c.size();
			// System.out.println("size of 4c " + case4c);
			// System.out.println("****************************");

			// 4d
			Set<String> case4d = new HashSet<>(termsAddedInOp);
			case4d.retainAll(termsAddedInO);
			// System.out.println("Case 4d: " + case4d);
			counter4d = counter4d + case4d.size();
			// System.out.println("size of 4d " + counter4d);
			// System.out.println("****************************");

		}

		System.out.println(cAddedinD2 + " AddedinD2\n" + cAddedinD2p + " AddedinD2p\n" + cDeletedinD2
				+ " DeletedinD2 \n" + cDeletedinD2p + " DeletedinD2p \n" + similarTermsO + " similarTermsO\n"
				+ similarTermsOp + " similarTermsOp \n");

		System.out.println("1a   " + counter1a + "\n1b  " + counter1b + "\n1c  " + counter1c + "\n1d  " + counter1d
				+ "\n2a  " + counter2a + "\n2b  " + counter2b + "\n2c  " + counter2c + "\n2d  " + counter2d + "\n3a  "
				+ counter3a + "\n3b  " + counter3b + "\n3c  " + counter3c + "\n3d  " + counter3d + "\n4a  " + counter4a
				+ "\n4b  " + counter4b + "\n4c  " + counter4c + "\n4d  " + counter4d + "\n");

		System.out.println("cases 1c: ");
		System.out.println(cases1c);
		System.out.println("cases 1d: ");
		System.out.println(cases1d);

		System.out.println("cases 3b: ");
		System.out.println(cases3b);

		System.out.println("cases 3d: ");
		System.out.println(cases3d);

		System.out.println("cases 4a: ");
		System.out.println(cases4a);

	}

	static Set<String> getListOfTerms(String ns, String distribution) {

		// initialize the result
		Set<String> result = new HashSet<>();

		// load the model from distribution string
		Model model = FileManager.get().loadModel("target/classes/" + distribution);

		model.listStatements().forEachRemaining((s) -> {

			Resource subject = s.getSubject();
			if (subject.isURIResource() && subject.getURI().startsWith(ns)) {
				result.add(subject.getURI());
			}

			Resource predicate = s.getPredicate();
			if (predicate.getURI().startsWith(ns)) {
				result.add(predicate.getURI());
			}

			RDFNode object = s.getObject();

			if (object.isURIResource() && object.asResource().getURI().startsWith(ns)) {
				result.add(object.asResource().getURI());
			} else if (object.isLiteral() && object.asLiteral().getDatatypeURI().startsWith(ns)) {
				result.add(object.asLiteral().getDatatypeURI());
			}

		});
		return result;

	}

}
