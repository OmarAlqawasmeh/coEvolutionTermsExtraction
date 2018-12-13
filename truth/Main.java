package truth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;

public class Main {

	public static void main(String[] args) throws IOException {

		// compute interesting cases
		// List<InterestingCase> interestingCases = null;

		BufferedReader br = null;
		FileReader fr = null;

		PrintWriter out = new PrintWriter(new FileWriter("/home/omar/Desktop/Dec11output.csv", true), true);

		int ctermsAddedInO=0;
		int ctermsAddedInOp=0;
		int ctermsDeletedInO=0;
		int ctermsDeletedInOp=0;
		try {

			// br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader("/home/omar/Desktop/Pnamespace.csv");
			//fr = new FileReader("/home/omar/Desktop/listofOandP_Pnamespaces.csv");
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {

			//	System.out.println(sCurrentLine);

				String arr[] = sCurrentLine.split(",");
//				dcterms	2008-01-14.n3	dcterms	2010-10-11.n3	dcam	2008-01-14.n3	dcam	2010-10-11.n3	http://purl.org/dc/terms/

				System.out.println(
						"d1:" + arr[0] + ", d2:" + arr[1] + ",d3:" + arr[2] + ", d4:" + arr[3] + ", ns:" + arr[4]);
				//adms_2012-06-25.n3	adms_2013-05-24.n3	schema_2012-04-27.n3	schema_2013-04-05.n3
				InterestingCase interestingCase = new InterestingCase(arr[4],
						"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/Ontology/" + arr[0],
						"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/Ontology/" + arr[1],
						"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/PREFIXES/" + arr[2],
						"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/PREFIXES/" + arr[3]);

				Set<String> listOfTermsInD1 = getListOfTerms(interestingCase.getNs(), interestingCase.getD1());

				Set<String> listOfTermsInD2 = getListOfTerms(interestingCase.getNs(), interestingCase.getD2());

				//Deleted
				Set<String> termsDeletedInO = new HashSet<String>(listOfTermsInD1);
				termsDeletedInO.removeAll(listOfTermsInD2);
				//System.out.println("Terms deleted in O: " + termsDeletedInO);
				System.out.println("Del in O: " + termsDeletedInO.size() + ",");
				// System.out.print(termsDeletedInO + ",");
//				out.write(termsDeletedInO + ",");
				// System.out.print(termsDeletedInO.size()+",");
				ctermsDeletedInO=ctermsDeletedInO+termsDeletedInO.size();
				//Added
				Set<String> termsAddedInO = new HashSet<String>(listOfTermsInD2);
				termsAddedInO.removeAll(listOfTermsInD1);
//				System.out.println("Terms added in O: " + termsAddedInO);
				System.out.println("Add in O: " + termsAddedInO.size() + ",");
				ctermsAddedInO=ctermsAddedInO+termsAddedInO.size();
				// System.out.print(termsAddedInO + ",");
//				out.write(termsAddedInO+",");
				// System.out.print(termsAddedInO.size()+",");
				
				Set<String> similarTerms= new HashSet<String>(listOfTermsInD2);
				similarTerms.retainAll(listOfTermsInD1);
				
				System.out.println("exist in both: " + similarTerms+"\n"+similarTerms.size() + ",");
				
				
				
				Set<String> listOfTermsInD1p = getListOfTerms(interestingCase.getNs(), interestingCase.getD1p());
				Set<String> listOfTermsInD2p = getListOfTerms(interestingCase.getNs(), interestingCase.getD2p());

				Set<String> termsDeletedInOp = new HashSet<String>(listOfTermsInD1p);
				termsDeletedInOp.removeAll(listOfTermsInD2p);
//				System.out.println("Terms deleted in Op: " + termsDeletedInOp);
				System.out.println("Del in Op: " + termsDeletedInOp.size() + ",");
//				out.write(termsDeletedInOp+",");
				// System.out.print(termsDeletedInOp.size()+",");
				ctermsDeletedInOp=ctermsDeletedInOp+termsDeletedInOp.size();

				Set<String> termsAddedInOp = new HashSet<String>(listOfTermsInD2p);
				termsAddedInOp.removeAll(listOfTermsInD1p);
//				System.out.println("Terms added in Op: " + termsAddedInOp);
				System.out.println("Add in Op: " + termsAddedInOp.size());
				ctermsAddedInOp=ctermsAddedInOp+termsAddedInOp.size();
//				out.write(termsAddedInOp + "\n");
//				System.out.println(termsAddedInOp.size());
			
				
				
				
//				 Set<String> correctlyAdded = new HashSet<String>(termsAddedInOp);
//				 correctlyAdded.retainAll(termsAddedInO);
//				 System.out.println("correctly added terms: " + correctlyAdded);
//				 out.write(correctlyAdded+"\n");
				 
				 
//				 Set<String> wronglyAdded = new HashSet<String>(termsDeletedInO);
//				 wronglyAdded.retainAll(termsAddedInOp);
//				 System.out.println("wrongly added terms: " + wronglyAdded);
//				 
//				 out.write(wronglyAdded.size()+"\n");
				 
//				
//				 Set<String> correctlyDeleted= new HashSet<String>(termsDeletedInO);
//				 correctlyDeleted.retainAll(termsDeletedInOp);
//				 System.out.println("correctly deleted terms: " + correctlyDeleted);
//				 out.write(correctlyDeleted+"\n");
				 
//				
//				 Set<String> wronglyDeleted= new HashSet<String>(termsDeletedInO);
//				 correctlyDeleted.retainAll(termsDeletedInOp);
//				 System.out.println("correctly deleted terms: " + wronglyDeleted);
//				
//				 Set<String> maybeSuggest = new HashSet<String>(termsAddedInO);
//				 maybeSuggest.removeAll(listOfTermsInD1p);
//				 maybeSuggest.removeAll(listOfTermsInD2p);
//				 System.out.println("suggest to add " + maybeSuggest);
//				 out.write(maybeSuggest+"\n");
				 
//				 Set<String> suggestDelete = new HashSet<String>(listOfTermsInD1p);
//				 maybeSuggest.retainAll(listOfTermsInD2p);
//				 maybeSuggest.removeAll(termsDeletedInO);
//				 System.out.println("suggest to delete: " + suggestDelete);
//				 out.write(suggestDelete+"\n");


				 Set<String> mistakeFixed= new HashSet<String>(termsDeletedInO);
				 mistakeFixed.retainAll(termsAddedInOp);
				 System.out.println("correctly deleted terms: " + mistakeFixed);
				 out.write(mistakeFixed+"\n");

				
				
				System.out.println("**********************************************");
			}
			
			System.out.println(ctermsAddedInO+" added to d2");
			System.out.println(ctermsDeletedInO+" Deleted from d2");

			System.out.println(ctermsAddedInOp+" added to d2'");
			
			System.out.println(ctermsDeletedInOp+" Deleted from d2'");


		}

		//The 16 cases
		
		
		//[1] !add(O), !add(Op) we dont care
		//[1] !add(O), !add(Op) we dont care
		//[1] !add(O), !add(Op) we dont care
		//[1] !add(O), add(Op) we dont care
		
		
		
		
		//[1] add(O), !add(Op) we dont care
		//[1] add(O), !add(Op) we dont care
		//[1] add(O), !add(Op) we dont care
		//[1] add(O), !add(Op) we dont care
		//[1] add(O), !add(Op) we dont care
		//[1] add(O), !add(Op) we dont care
		//[1] add(O), !add(Op) we dont care
		//[1] add(O), !add(Op) we dont care
		//[1] add(O), !add(Op) we dont care
		//[1] add(O), !add(Op) we dont care
		//[1] add(O), !add(Op) we dont care
		//[1] add(O), !add(Op) we dont care
		// Set<String> correctlyAdded = new HashSet<String>(termsAddedInOp);
		// correctlyAdded.retainAll(termsAddedInO);
		// System.out.println("correctly added terms: " + correctlyAdded);
		//
		// Set<String> wronglyAdded = new HashSet<String>(termsDeletedInO);
		// wronglyAdded.retainAll(termsAddedInOp);
		// System.out.println("wrongly added terms: " + wronglyAdded);
		//
		// Set<String> correctlyDeleted= new HashSet<String>(termsDeletedInO);
		// correctlyDeleted.retainAll(termsDeletedInOp);
		// System.out.println("correctly deleted terms: " + correctlyDeleted);
		//
		// Set<String> wronglyDeleted= new HashSet<String>(termsDeletedInO);
		// correctlyDeleted.retainAll(termsDeletedInOp);
		// System.out.println("correctly deleted terms: " + correctlyDeleted);
		//
		// Set<String> maybeSuggest = new HashSet<String>(termsAddedInO);
		// maybeSuggest.removeAll(listOfTermsInD1p);
		// maybeSuggest.removeAll(listOfTermsInD2p);
		// System.out.println("maybe suggest terms: " + maybeSuggest);
		//
		// Set<String> suggestDelete = new HashSet<String>(listOfTermsInD1p);
		// maybeSuggest.retainAll(listOfTermsInD2p);
		// maybeSuggest.removeAll(termsDeletedInO);
		// System.out.println("suggest to delete: " + suggestDelete);

		// Set<String> suggestDelete = new HashSet<String>(listOfTermsInD1p);
		// maybeSuggest.retainAll(listOfTermsInD2p);
		// maybeSuggest.removeAll(termsDeletedInO);
		// System.out.println("suggest to delete: " + suggestDelete);

		catch (IOException e) {

			e.printStackTrace();

		} finally {

			out.close();
			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

	static Set<String> getListOfTerms(String ns, String distribution) {

		// initialize the result
		Set<String> result = new HashSet<>();

		// load the model from distribution string
		Model model = FileManager.get().loadModel(distribution);

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
