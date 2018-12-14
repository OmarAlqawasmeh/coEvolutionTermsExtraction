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

public class mainTest {

	public static void main(String[] args) throws IOException {
		

        
        // compute interesting cases
//      List<InterestingCase> interestingCases = null;
		
//		InterestingCase interestingCase = new InterestingCase("http://schema.org/",
//				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/Ontology/adms_2012-06-25.n3",
//				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/Ontology/adms_2013-05-24.n3",
//				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/PREFIXES/schema_2012-04-27.n3",
//				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/PREFIXES/schema_2013-04-05.n3" );
		
		
//		InterestingCase interestingCase = new InterestingCase("http://purl.org/ontology/mo/",
//				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/Ontology/mo_2010-11-28.n3",
//				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/Ontology/mo_2013-07-22.n3",
//				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/PREFIXES/bio_2010-04-20.n3",
//				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/PREFIXES/bio_2011-06-14.n3" );
		
//		InterestingCase interestingCase = new InterestingCase("http://purl.org/dc/elements/1.1/",
//				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/Ontology/dce_2010-10-11.n3",
//				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/Ontology/dce_2012-06-14.n3",
//				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/PREFIXES/dcterms_2010-10-11.n3",
//				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/PREFIXES/dcterms_2012-06-14.n3" );
 
//		InterestingCase interestingCase = new InterestingCase("http://purl.org/dc/dcmitype/",
//		"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/Ontology/dctype_2008-01-14.n3",
//		"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/Ontology/dctype_2010-10-11.n3",
//		"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/PREFIXES/dcterms_2008-01-14.n3",
//		"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/PREFIXES/dcterms_2010-10-11.n3" );

		InterestingCase interestingCase = new InterestingCase("http://data.ordnancesurvey.co.uk/ontology/admingeo/",
				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/Ontology/osadm_2010-04-01.n3",
				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/Ontology/osadm_2013-09-04.n3",
				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/PREFIXES/dce_2008-01-14.n3",
				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/PREFIXES/dce_2012-06-14.n3" );
		
//		InterestingCase interestingCase = new InterestingCase("http://purl.org/dc/terms/",
//				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/Ontology/dcterms_2008-01-14.n3",
//				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/Ontology/dcterms_2010-10-11.n3",
//				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/PREFIXES/dcam_2008-01-14.n3",
//				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/PREFIXES/dcam_2010-10-11.n3" );
		
		
		
		//differences in O (Music ontology)
        Set<String> listOfTermsInD1 = getListOfTerms(interestingCase.getNs(), interestingCase.getD1());
        Set<String> listOfTermsInD2 = getListOfTerms(interestingCase.getNs(), interestingCase.getD2());
        
        System.out.println("Terms in D1 "+listOfTermsInD1);
        System.out.println("Terms in D2 "+listOfTermsInD2);
 
        Set<String> termsDeletedInO = new HashSet<String>(listOfTermsInD1);
        termsDeletedInO.removeAll(listOfTermsInD2);
        System.out.println("termsDeletedInO"+termsDeletedInO);
        System.out.println(termsDeletedInO.size());
                 
        Set<String> termsAddedInO = new HashSet<String>(listOfTermsInD2);
        termsAddedInO.removeAll(listOfTermsInD1);
        System.out.println("termsAddedInO"+termsAddedInO);
        System.out.println(termsAddedInO.size());
         
        //differences in O' (Bio ontology)
        Set<String> listOfTermsInD1p = getListOfTerms(interestingCase.getNs(), interestingCase.getD1p());
        Set<String> listOfTermsInD2p = getListOfTerms(interestingCase.getNs(), interestingCase.getD2p());
        
        System.out.println("Terms in D1p "+listOfTermsInD1p);
        System.out.println("Terms in D2p "+listOfTermsInD2p);
 
        Set<String> termsDeletedInOp = new HashSet<String>(listOfTermsInD1p);
        termsDeletedInOp.removeAll(listOfTermsInD2p);
        System.out.println("termsDeletedInOp"+termsDeletedInOp);
      //  System.out.println(termsDeletedInOp.size());
                 
        Set<String> termsAddedInOp = new HashSet<String>(listOfTermsInD2p);
        termsAddedInOp.removeAll(listOfTermsInD1p);
        System.out.println("termsAddedInOp"+termsAddedInOp);
        System.out.println(termsAddedInOp.size());
         
 
        Set<String> correctlyAdded = new HashSet<String>(termsAddedInOp);
        correctlyAdded.retainAll(termsAddedInO);
        System.out.println("correctly added terms: " + correctlyAdded);
         
        Set<String> wronglyAdded = new HashSet<String>(termsDeletedInO);
        wronglyAdded.retainAll(termsAddedInOp);
        System.out.println("wrongly added terms: " + wronglyAdded);
         
        Set<String> correctlyDeleted= new HashSet<String>(termsDeletedInO);
        correctlyDeleted.retainAll(termsDeletedInOp);
        System.out.println("correctly deleted terms: " + correctlyDeleted);
 
        Set<String> wronglyDeleted= new HashSet<String>(termsDeletedInO);
        correctlyDeleted.retainAll(termsDeletedInOp);
        System.out.println("wrongly deleted  terms: " + correctlyDeleted);
 
        Set<String> maybeSuggest = new HashSet<String>(termsAddedInO);
        maybeSuggest.removeAll(listOfTermsInD1p);
        maybeSuggest.removeAll(listOfTermsInD2p);
        System.out.println("suggest to add terms: " + maybeSuggest);
         
        Set<String> suggestDelete = new HashSet<String>(listOfTermsInD1p);
        maybeSuggest.retainAll(listOfTermsInD2p);
        maybeSuggest.removeAll(termsDeletedInO);
        System.out.println("suggest to delete terms: " + suggestDelete);

		
		
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
