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

public class Dec11th {


	public static void main(String[] args) throws IOException {
		
		int cAddedinD2 = 0;
		int cAddedinD2p=0;
		int cDeletedinD2=0;
		int cDeletedinD2p=0;
		int similarTermsO=0;
		int similarTermsOp =0;
		
		
		
		int counter1a=0;
        int counter1b=0;
		int counter1c=0;
		int counter1d=0;
		
		int counter2a=0;
        int counter2b=0;
		int counter2c=0;
		int counter2d=0;
		
		int counter3a=0;
        int counter3b=0;
		int counter3c=0;
		int counter3d=0;
		
        int counter4a=0;
        int counter4b=0;
		int counter4c=0;
		int counter4d=0;
		
		
        int wrongAdd=0;
        int correctDel=0;
        int wrongDel=0;
        int suggestAdd=0;
		BufferedReader br = null;
		FileReader fr = null;
		//listofOandP.csv
		fr = new FileReader("/home/omar/Desktop/listofOandP.csv");
		//fr = new FileReader("/home/omar/Desktop/Pnamespace.csv");

		br = new BufferedReader(fr);

		String sCurrentLine;

		while ((sCurrentLine = br.readLine()) != null) {

			System.out.println(sCurrentLine);

			String arr[] = sCurrentLine.split(",");

			System.out.println("d1:" + arr[0] + ", d2:" + arr[1] + ",d3:" + arr[2] + ", d4:" + arr[3] + ", ns:" + arr[4]);
			
			
			InterestingCase interestingCase = new InterestingCase(arr[4],
					"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/Ontology/" + arr[0],
					"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/Ontology/" + arr[1],
					"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/PREFIXES/" + arr[2],
					"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/PREFIXES/" + arr[3]);
			
//			InterestingCase interestingCase = new InterestingCase("http://purl.org/ontology/mo/",
//			"/home/omar/Desktop/testCases/mo_2010-11-28.n3",
//			"/home/omar/Desktop/testCases/mo_2013-07-22.n3",
//			"/home/omar/Desktop/testCases/bio_2010-04-20.n3",
//			"/home/omar/Desktop/testCases/bio_2011-06-14.n3" );

			
			
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

//		InterestingCase interestingCase = new InterestingCase("http://data.ordnancesurvey.co.uk/ontology/admingeo/",
//				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/Ontology/osadm_2010-04-01.n3",
//				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/Ontology/osadm_2013-09-04.n3",
//				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/PREFIXES/dce_2008-01-14.n3",
//				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/PREFIXES/dce_2012-06-14.n3" );
		
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
        System.out.println("termsDeletedInD2"+termsDeletedInO);
        //System.out.println(termsDeletedInO.size());
        cDeletedinD2=cDeletedinD2+termsDeletedInO.size();
        
        
        Set<String> termsAddedInO = new HashSet<String>(listOfTermsInD2);
        termsAddedInO.removeAll(listOfTermsInD1);
        System.out.println("termsAddedInD2"+termsAddedInO);
       // System.out.println(termsAddedInO.size());
        cAddedinD2=cAddedinD2+termsAddedInO.size();
        
         
        Set<String> similarTermsInO= new HashSet<String>(listOfTermsInD2);
		similarTermsInO.retainAll(listOfTermsInD1);
		System.out.println("termsSimilarBetween D1_and_D2"+similarTermsInO);
        //System.out.println(similarTermsInO.size());
        similarTermsO=similarTermsO+similarTermsInO.size();
        
			
        //differences in O' (Bio ontology)
        Set<String> listOfTermsInD1p = getListOfTerms(interestingCase.getNs(), interestingCase.getD1p());
        Set<String> listOfTermsInD2p = getListOfTerms(interestingCase.getNs(), interestingCase.getD2p());
        
        System.out.println("Terms in D1p "+listOfTermsInD1p);
        System.out.println("Terms in D2p "+listOfTermsInD2p);
 
        Set<String> termsDeletedInOp = new HashSet<String>(listOfTermsInD1p);
        termsDeletedInOp.removeAll(listOfTermsInD2p);
        System.out.println("termsDeletedInD2p"+termsDeletedInOp);
       // System.out.println(termsDeletedInOp.size());
        cDeletedinD2p=cDeletedinD2p+termsDeletedInOp.size();
                 
        Set<String> termsAddedInOp = new HashSet<String>(listOfTermsInD2p);
        termsAddedInOp.removeAll(listOfTermsInD1p);
        System.out.println("termsAddedInD2p"+termsAddedInOp);
        //System.out.println(termsAddedInOp.size());
        cAddedinD2p=cAddedinD2p+termsAddedInOp.size();

        Set<String> similarTermsInOp= new HashSet<String>(listOfTermsInD2p);
		similarTermsInOp.retainAll(listOfTermsInD1p);
		System.out.println("termsSimilarBetween D1p_and_D2p"+similarTermsInOp);
        //System.out.println(similarTermsInOp.size());
        similarTermsOp=similarTermsOp+similarTermsInOp.size();
        
        System.out.println("***************************************************************************************************************************");

//1a
        
        Set<String> case1a = new HashSet<String>(termsAddedInOp);
        case1a.removeAll(listOfTermsInD1p);
        case1a.removeAll(listOfTermsInD2p);
//        termsAddedInO.removeAll(listOfTermsInD1);
//        termsAddedInO.removeAll(listOfTermsInD2);
//        case1a.retainAll(termsAddedInO); 
        System.out.println("Case1a: " + case1a);
        counter1a=counter1a+case1a.size();        
        System.out.println("size of 1a"+ case1a);           
        System.out.println("****************************");
        
        
//1b
        Set<String> case1b = new HashSet<String>(termsAddedInOp);
        case1b.removeAll(listOfTermsInD1p);
        case1b.removeAll(listOfTermsInD2p);
        case1b.retainAll(termsDeletedInO); 
        System.out.println("case1b: " + case1b);
        counter1b=counter1b+case1b.size();        
        System.out.println("size of case1b"+ case1b);           
        System.out.println("****************************");
             
//1c
        Set<String> case1c = new HashSet<String>(termsAddedInOp);
        case1c.removeAll(listOfTermsInD1p);
        case1c.removeAll(listOfTermsInD2p);
        case1c.retainAll(similarTermsInO); 
        System.out.println("case1c: " + case1c );
        counter1c=counter1c+case1c.size();        
        System.out.println("size of 1c"+ case1c);           
        System.out.println("****************************");
       
        
        
        
//1d

        Set<String> case1d = new HashSet<String>(termsAddedInOp);
        case1d.removeAll(listOfTermsInD1p);
        case1d.removeAll(listOfTermsInD2p);
        case1d.retainAll(termsAddedInO); 
        System.out.println("case1d: " + case1d);
        counter1d=counter1d+case1d.size();        
        System.out.println("size of 1d"+ case1d);           
        System.out.println("****************************");

        
//2a
        Set<String> case2a = new HashSet<String>(termsDeletedInOp);
//        termsAddedInO.removeAll(listOfTermsInD1);
//        termsAddedInO.removeAll(listOfTermsInD2);
//        case2a.retainAll(termsAddedInO); 
        System.out.println("Case2a: " + case2a);
        counter2a=counter2a+case2a.size();        
        System.out.println("size of 2a"+ case2a);           
        System.out.println("****************************");        
//2b               
        Set<String> case2b = new HashSet<String>(termsDeletedInOp);
        case2b.retainAll(termsDeletedInO); 
        System.out.println("Case2b: " + case2b );
        counter2b=counter2b+case2b .size();        
        System.out.println("size of 2b"+ case2b );           
        System.out.println("****************************");
         
//2c
        Set<String> case2c = new HashSet<String>(termsDeletedInOp);
        case2c.retainAll(similarTermsInO); 
        System.out.println("case2c: " + case2c);
        counter2c=counter2c+case2c.size();        
        System.out.println("size of 2c"+ case2c);           
        System.out.println("****************************");
        
//2d
        Set<String> case2d = new HashSet<String>(termsDeletedInOp);
        case2d.retainAll(termsAddedInO); 
        System.out.println("Case2d: " + case2d);
        counter2d=counter2d+case2d.size();        
        System.out.println("size of 2d"+ case2d);           
        System.out.println("****************************");
        
        
        
        
//3a
        Set<String> case3a = new HashSet<String>(similarTermsInOp);
//        termsAddedInO.removeAll(listOfTermsInD1);
//        termsAddedInO.removeAll(listOfTermsInD2);
//        case3a.retainAll(termsAddedInO); 
        System.out.println("Case3a: " + case3a);
        counter3a=counter3a+case3a.size();        
        System.out.println("size of 3a"+ case3a);           
        System.out.println("****************************");        
//3b               
        Set<String> case3b = new HashSet<String>(similarTermsInOp);
        case3b.retainAll(termsDeletedInO); 
        System.out.println("Case3b: " + case3b);
        counter3b=counter3b+case3b.size();        
        System.out.println("size of 3b"+ case3b);           
        System.out.println("****************************");
         
//3c
        Set<String> case3c = new HashSet<String>(similarTermsInOp);
        case3b.retainAll(similarTermsInO); 
        System.out.println("Case3c: " + case3c);
        counter3c=counter3c+case3c.size();        
        System.out.println("size of 3c"+ case3c);           
        System.out.println("****************************");
        
//3d
        Set<String> case3d = new HashSet<String>(similarTermsInOp);
        case3d.retainAll(termsAddedInO); 
        System.out.println("Case3d: " + case3d);
        counter3d=counter3d+case3d.size();        
        System.out.println("size of 3d"+ case3d);           
        System.out.println("****************************");
        
         
        
//4a
        Set<String> case4a = new HashSet<String>(termsAddedInOp);
//        termsAddedInO.removeAll(listOfTermsInD1);
//        termsAddedInO.removeAll(listOfTermsInD2);
//        case4a.retainAll(termsAddedInO); 
        System.out.println("Case 4a: " + case4a);
        counter4a=counter4a+case4a.size();        
        System.out.println("size of 4a"+ case4a);           
        System.out.println("****************************");        
//4b               
        Set<String> case4b = new HashSet<String>(termsAddedInOp); 
        case4b.retainAll(termsDeletedInO); 
        System.out.println("Case 4b: " + case4b);
        counter4b=counter4b+case4b.size();        
        System.out.println("size of 4b "+ case4b);      
        System.out.println("****************************");
//4c       
        Set<String> case4c = new HashSet<String>(termsAddedInOp); 
        case4c.retainAll(similarTermsInO);
        System.out.println("Case 4c: " + case4c);
        counter4c=counter4c+case4c.size();        
        System.out.println("size of 4c "+ case4c);
        System.out.println("****************************");
//4d    
       Set<String> case4d = new HashSet<String>(termsAddedInOp);
       case4d.retainAll(termsAddedInO);
       System.out.println("Case 4d: " + case4d);
       counter4d=counter4d+case4d.size();        
       System.out.println("size of 4d "+ counter4d);
       System.out.println("****************************");
        
        

//        Set<String> correctlyAdded = new HashSet<String>(termsAddedInOp);
//        correctlyAdded.retainAll(termsAddedInO);
//        System.out.println("correctly added terms: " + correctlyAdded);
//        correctAdd=correctAdd+correctlyAdded.size();
//        
//        Set<String> wronglyAdded = new HashSet<String>(termsDeletedInO);
//        wronglyAdded.retainAll(termsAddedInOp);
//        System.out.println("wrongly added terms: " + wronglyAdded);
//        wrongAdd=wrongAdd+wronglyAdded.size();
//        
//        Set<String> correctlyDeleted= new HashSet<String>(termsDeletedInO);
//        correctlyDeleted.retainAll(termsDeletedInOp);
//        System.out.println("correctly deleted terms: " + correctlyDeleted);
//        correctDel=correctDel+correctlyDeleted.size();
//        
        
 
//        Set<String> wronglyDeleted= new HashSet<String>(termsDeletedInO);
//        correctlyDeleted.retainAll(termsDeletedInOp);
//        System.out.println("wrongly deleted  terms: " + correctlyDeleted);
// 
//        	Set<String> maybeSuggest = new HashSet<String>(termsAddedInO);
//        	maybeSuggest.removeAll(listOfTermsInD1p);
//        	maybeSuggest.removeAll(listOfTermsInD2p);
//        	System.out.println("suggest to add terms: " + maybeSuggest);
//        	suggestAdd=suggestAdd+maybeSuggest.size();
        	
        	
//        Set<String> maybeSuggest = new HashSet<String>(termsAddedInO);
//        maybeSuggest.removeAll(listOfTermsInD1p);
//        maybeSuggest.removeAll(listOfTermsInD2p);
//        System.out.println("suggest to add terms: " + maybeSuggest);    
        	
        	
//        Set<String> suggestDelete = new HashSet<String>(listOfTermsInD1p);
//        maybeSuggest.retainAll(listOfTermsInD2p);
//        maybeSuggest.removeAll(termsDeletedInO);
//        System.out.println("suggest to delete terms: " + suggestDelete);

		
  
		
	}
        
		
//      	System.out.println("***************************************************************************************************************************");
//		System.out.println("correctly added terms: " + correctAdd);
//        System.out.println("wrongly added" + wrongAdd);
//        System.out.println("correctly deleted  "+correctDel);
//        System.out.println("suggestAdd "+suggestAdd);

		System.out.println(cAddedinD2+" AddedinD2\n"+cAddedinD2p+" AddedinD2p\n"+cDeletedinD2+" DeletedinD2 \n"+cDeletedinD2p+" DeletedinD2p \n"+similarTermsO+" similarTermsO\n"+similarTermsOp +" similarTermsOp \n");
         
		System.out.println("1a   " + counter1a + "\n1b  " + counter1b + "\n1c  " + counter1c + "\n1d  " + counter1d + "\n2a  "
				+ counter2a + "\n2b  " + counter2b + "\n2c  " + counter2c + "\n2d  " + counter2d + "\n3a  " + counter3a + "\n3b  "
				+ counter3b + "\n3c  " + counter3c + "\n3d  " + counter3d + "\n4a  " + counter4a + "\n4b  " + counter4b + "\n4c  "
				+ counter4c + "\n4d  " + counter4d + "\n");
         
         

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






/*package truth;

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

public class Dec11th {


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
         
        
		Set<String> similarTermsInO= new HashSet<String>(listOfTermsInD2);
		similarTermsInO.retainAll(listOfTermsInD1);
		
		System.out.println("exist in both: " + similarTermsInO+"\n"+similarTermsInO.size() + ",");

		
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
*/
