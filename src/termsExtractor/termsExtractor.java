package termsExtractor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.apache.jena.iri.impl.Main;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFactory;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.query.ResultSetRewindable;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.util.FileManager;
import org.apache.jena.util.PrintUtil;

public class termsExtractor {

	public static void countClasses(String outFile, String inOntology) throws FileNotFoundException {

		FileManager.get().addLocatorClassLoader(termsExtractor.class.getClassLoader());

		OutputStream output = new FileOutputStream(outFile, true);

		Model model = FileManager.get().loadModel(inOntology);

		String queryStringCountClasses = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
				
				
				+ "SELECT DISTINCT ?class {" 
//				+"SELECT (COUNT(DISTINCT ?class) AS ?cnt){"
				+ "{"
				+ "{?class rdf:type rdfs:Class.} " 
				+ "UNION " 
				+ "{?class rdf:type owl:Class.}" 
				+ "}"
				+ "}";

		Query query = QueryFactory.create(queryStringCountClasses);
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		try {
			ResultSetRewindable results = ResultSetFactory.makeRewindable(qexec.execSelect());

			// System.out.println("---- Text ----");
			// ResultSetFormatter.out(System.out, results);
			// results.reset();

			System.out.println("---- Text ----");
			ResultSetFormatter.out(System.out, results);
			results.reset();

			System.out.println("save to file");

			ResultSetFormatter.outputAsCSV(output, results);

		} finally {
			qexec.close();
		}

	}

	public static void countProp(String outFile, String inOntology) throws FileNotFoundException {

		FileManager.get().addLocatorClassLoader(termsExtractor.class.getClassLoader());

		OutputStream output = new FileOutputStream(outFile, true);

		Model model = FileManager.get().loadModel(inOntology);

		String queryStringCountProp = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
			+	"SELECT ?prop {" + "{"	
				//+ "SELECT (COUNT(DISTINCT ?prop) AS ?propCount){" +"{"
				
		

				+ "{?prop rdf:type rdf:Property.}" 
				+ " UNION " 
				
				+ "{?prop rdf:type owl:DatatypeProperty}"
				+ "}" 
				+ "}";

		Query query = QueryFactory.create(queryStringCountProp);
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		try {
			ResultSetRewindable results = ResultSetFactory.makeRewindable(qexec.execSelect());

			// System.out.println("---- Text ----");
			// ResultSetFormatter.out(System.out, results);
			// results.reset();

			System.out.println("---- Text ----");
			ResultSetFormatter.out(System.out, results);
			results.reset();

			System.out.println("save to file");

			ResultSetFormatter.outputAsCSV(output, results);

		} finally {
			qexec.close();
		}

	}

	public static void getOutgoingLinks(String outFile, String inOntology) throws IOException {

		FileManager.get().addLocatorClassLoader(termsExtractor.class.getClassLoader());

		OutputStream output = new FileOutputStream(outFile, true);

		Model model = FileManager.get().loadModel(inOntology);

		String queryStringCountProp = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
				// (COUNT(DISTINCT ?prop) AS ?propCount)
				+ "SELECT ?prefix {" + "{"

				+ "{?prefix rdf:type rdf:Property.}" + " UNION " + "{?prop rdf:type owl:DatatypeProperty}"

				+ "}" + "}";

		Query query = QueryFactory.create(queryStringCountProp);
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		try {
			ResultSetRewindable results = ResultSetFactory.makeRewindable(qexec.execSelect());

			// System.out.println("---- Text ----");
			// ResultSetFormatter.out(System.out, results);
			// results.reset();

			System.out.println("---- Text ----");
			ResultSetFormatter.out(System.out, results);
			results.reset();

			System.out.println("save to file");

			ResultSetFormatter.outputAsCSV(output, results);

		} finally {
			qexec.close();
		}

	}

	
	public static void compareLists(){
		Collection D1 = new ArrayList() {{
			add("http://schema.org/latitud");

			add("http://schema.org/applicationCategor");

			add("http://schema.org/ratingCoun");

			add("http://schema.org/totalTim");

			add("http://schema.org/subEvent");

			add("http://schema.org/printPag");

			add("http://schema.org/alternativeHeadlin");

			add("http://schema.org/reviewRatin");

			add("http://schema.org/performe");

			add("http://schema.org/locatio");

			add("http://schema.org/cookingMetho");

			add("http://schema.org/performer");

			add("http://schema.org/addres");

			add("http://schema.org/honorificPrefi");

			add("http://schema.org/versio");

			add("http://schema.org/headlin");

			add("http://schema.org/servingSiz");

			add("http://schema.org/browserRequirement");

			add("http://schema.org/endDat");

			add("http://schema.org/printColum");

			add("http://schema.org/ma");

			add("http://schema.org/even");

			add("http://schema.org/additionalNam");

			add("http://schema.org/directo");

			add("http://schema.org/unsaturatedFatConten");

			add("http://schema.org/uploadDat");

			add("http://schema.org/thumbnailUr");

			add("http://schema.org/screensho");

			add("http://schema.org/carbohydrateConten");

			add("http://schema.org/itemConditio");

			add("http://schema.org/bran");

			add("http://schema.org/containedI");

			add("http://schema.org/installUr");

			add("http://schema.org/vide");

			add("http://schema.org/priceRang");

			add("http://schema.org/deathDat");

			add("http://schema.org/performerI");

			add("http://schema.org/ge");

			add("http://schema.org/captio");

			add("http://schema.org/currenciesAccepte");

			add("http://schema.org/storageRequirement");

			add("http://schema.org/addressRegio");

			add("http://schema.org/manufacture");

			add("http://schema.org/educationRequirement");

			add("http://schema.org/productionCompan");

			add("http://schema.org/thumbnai");

			add("http://schema.org/datePublishe");

			add("http://schema.org/paren");

			add("http://schema.org/imag");

			add("http://schema.org/industr");

			add("http://schema.org/ingredient");

			add("http://schema.org/articleSectio");

			add("http://schema.org/specialCommitment");

			add("http://schema.org/wordCoun");

			add("http://schema.org/inPlaylis");

			add("http://schema.org/ur");

			add("http://schema.org/founde");

			add("http://schema.org/know");

			add("http://schema.org/autho");

			add("http://schema.org/datePoste");

			add("http://schema.org/blogPost");

			add("http://schema.org/track");

			add("http://schema.org/acto");

			add("http://schema.org/accountablePerso");

			add("http://schema.org/benefit");

			add("http://schema.org/blogPos");

			add("http://schema.org/subEven");

			add("http://schema.org/albu");

			add("http://schema.org/hiringOrganizatio");

			add("http://schema.org/spous");

			add("http://schema.org/foundingDat");

			add("http://schema.org/homeLocatio");

			add("http://schema.org/isPartO");

			add("http://schema.org/availabilit");

			add("http://schema.org/postOfficeBoxNumbe");

			add("http://schema.org/review");

			add("http://schema.org/follow");

			add("http://schema.org/calorie");

			add("http://schema.org/employmentTyp");

			add("http://schema.org/contactTyp");

			add("http://schema.org/videoQualit");

			add("http://schema.org/priceCurrenc");

			add("http://schema.org/produce");

			add("http://schema.org/openingHour");

			add("http://schema.org/applicationSuit");

			add("http://schema.org/selle");

			add("http://schema.org/itemReviewe");

			add("http://schema.org/traile");

			add("http://schema.org/awar");

			add("http://schema.org/interactionCoun");

			add("http://schema.org/reviewCoun");

			add("http://schema.org/numTrack");

			add("http://schema.org/requirement");

			add("http://schema.org/processorRequirement");

			add("http://schema.org/alumn");

			add("http://schema.org/colleague");

			add("http://schema.org/fatConten");

			add("http://schema.org/countriesSupporte");

			add("http://schema.org/pric");

			add("http://schema.org/saturatedFatConten");

			add("http://schema.org/men");

			add("http://schema.org/acceptsReservation");

			add("http://schema.org/contactPoin");

			add("http://schema.org/carrierRequirement");

			add("http://schema.org/numberOfEpisode");

			add("http://schema.org/nationalit");

			add("http://schema.org/servesCuisin");

			add("http://schema.org/jobLocatio");

			add("http://schema.org/actor");

			add("http://schema.org/isb");

			add("http://schema.org/contactPoint");

			add("http://schema.org/fileForma");

			add("http://schema.org/faxNumbe");

			add("http://schema.org/copyrightYea");

			add("http://schema.org/provide");

			add("http://schema.org/offer");

			add("http://schema.org/episod");

			add("http://schema.org/descriptio");

			add("http://schema.org/employe");

			add("http://schema.org/encodin");

			add("http://schema.org/nutritio");

			add("http://schema.org/countriesNotSupporte");

			add("http://schema.org/printSectio");

			add("http://schema.org/offerCoun");

			add("http://schema.org/associatedMedi");

			add("http://schema.org/gende");

			add("http://schema.org/heigh");

			add("http://schema.org/dateCreate");

			add("http://schema.org/siblin");

			add("http://schema.org/phot");

			add("http://schema.org/requiresSubscriptio");

			add("http://schema.org/circl");

			add("http://schema.org/representativeOfPag");

			add("http://schema.org/relatedT");

			add("http://schema.org/childre");

			add("http://schema.org/lin");

			add("http://schema.org/musicB");

			add("http://schema.org/trac");

			add("http://schema.org/aggregateRatin");

			add("http://schema.org/telephon");

			add("http://schema.org/tickerSymbo");

			add("http://schema.org/occupationalCategor");

			add("http://schema.org/itemOffere");

			add("http://schema.org/recipeCategor");

			add("http://schema.org/primaryImageOfPag");

			add("http://schema.org/discusse");

			add("http://schema.org/publishe");

			add("http://schema.org/highPric");

			add("http://schema.org/lowPric");

			add("http://schema.org/bo");

			add("http://schema.org/permission");

			add("http://schema.org/seaso");

			add("http://schema.org/worstRatin");

			add("http://schema.org/emai");

			add("http://schema.org/exifDat");

			add("http://schema.org/cookTim");

			add("http://schema.org/cholesterolConten");

			add("http://schema.org/colleagu");

			add("http://schema.org/significantLink");

			add("http://schema.org/abou");

			add("http://schema.org/dateModifie");

			add("http://schema.org/itemListOrde");

			add("http://schema.org/mention");

			add("http://schema.org/publishingPrinciple");

			add("http://schema.org/productI");

			add("http://schema.org/illustrato");

			add("http://schema.org/operatingSyste");

			add("http://schema.org/polygo");

			add("http://schema.org/sourceOrganizatio");

			add("http://schema.org/itemListElemen");

			add("http://schema.org/addressLocalit");

			add("http://schema.org/contentLocatio");

			add("http://schema.org/ratingValu");

			add("http://schema.org/affiliatio");

			add("http://schema.org/attende");

			add("http://schema.org/honorificSuffi");

			add("http://schema.org/copyrightHolde");

			add("http://schema.org/workLocatio");

			add("http://schema.org/postalCod");

			add("http://schema.org/bookEditio");

			add("http://schema.org/qualification");

			add("http://schema.org/skill");

			add("http://schema.org/musicGroupMembe");

			add("http://schema.org/membe");

			add("http://schema.org/map");

			add("http://schema.org/superEven");

			add("http://schema.org/sugarConten");

			add("http://schema.org/embedUr");

			add("http://schema.org/replyToUr");

			add("http://schema.org/significantLin");

			add("http://schema.org/addressCountr");

			add("http://schema.org/titl");

			add("http://schema.org/bestRatin");

			add("http://schema.org/transcrip");

			add("http://schema.org/baseSalar");

			add("http://schema.org/alumniO");

			add("http://schema.org/paymentAccepte");

			add("http://schema.org/memoryRequirement");

			add("http://schema.org/expire");

			add("http://schema.org/partOfSeaso");

			add("http://schema.org/member");

			add("http://schema.org/commentTex");

			add("http://schema.org/bookForma");

			add("http://schema.org/contentSiz");

			add("http://schema.org/breadcrum");

			add("http://schema.org/encoding");

			add("http://schema.org/season");

			add("http://schema.org/award");

			add("http://schema.org/responsibilitie");

			add("http://schema.org/incentive");

			add("http://schema.org/contentUr");

			add("http://schema.org/applicationSubCategor");

			add("http://schema.org/givenNam");

			add("http://schema.org/bitrat");

			add("http://schema.org/recipeCuisin");

			add("http://schema.org/worksFo");

			add("http://schema.org/playerTyp");

			add("http://schema.org/duratio");

			add("http://schema.org/branchO");

			add("http://schema.org/articleBod");

			add("http://schema.org/printEditio");

			add("http://schema.org/mainContentOfPag");

			add("http://schema.org/longitud");

			add("http://schema.org/inAlbu");

			add("http://schema.org/encodesCreativeWor");

			add("http://schema.org/associatedArticl");

			add("http://schema.org/workHour");

			add("http://schema.org/employee");

			add("http://schema.org/commentTim");

			add("http://schema.org/isFamilyFriendl");

			add("http://schema.org/videoFrameSiz");

			add("http://schema.org/revie");

			add("http://schema.org/mode");

			add("http://schema.org/transFatConten");

			add("http://schema.org/startDat");

			add("http://schema.org/releaseNote");

			add("http://schema.org/byArtis");

			add("http://schema.org/contentRatin");

			add("http://schema.org/edito");

			add("http://schema.org/softwareVersio");

			add("http://schema.org/nam");

			add("http://schema.org/event");

			add("http://schema.org/partOfTVSerie");

			add("http://schema.org/founder");

			add("http://schema.org/seasonNumbe");

			add("http://schema.org/contributo");

			add("http://schema.org/priceValidUnti");

			add("http://schema.org/memberO");

			add("http://schema.org/discussionUr");

			add("http://schema.org/downloadUr");

			add("http://schema.org/sodiumConten");

			add("http://schema.org/album");

			add("http://schema.org/episode");

			add("http://schema.org/photo");

			add("http://schema.org/recipeInstruction");

			add("http://schema.org/featureLis");

			add("http://schema.org/keyword");

			add("http://schema.org/fiberConten");

			add("http://schema.org/tex");

			add("http://schema.org/recipeYiel");

			add("http://schema.org/devic");

			add("http://schema.org/audi");

			add("http://schema.org/birthDat");

			add("http://schema.org/episodeNumbe");

			add("http://schema.org/sibling");

			add("http://schema.org/salaryCurrenc");

			add("http://schema.org/jobTitl");

			add("http://schema.org/inLanguag");

			add("http://schema.org/commen");

			add("http://schema.org/attendee");

			add("http://schema.org/proteinConten");

			add("http://schema.org/elevatio");

			add("http://schema.org/creato");

			add("http://schema.org/datelin");

			add("http://schema.org/familyNam");

			add("http://schema.org/fileSiz");

			add("http://schema.org/widt");

			add("http://schema.org/streetAddres");

			add("http://schema.org/parent");

			add("http://schema.org/reviewBod");

			add("http://schema.org/regionsAllowe");

			add("http://schema.org/experienceRequirement");

			add("http://schema.org/prepTim");

			add("http://schema.org/numberOfPage");

			add("http://schema.org/genr");

			add("http://schema.org/encodingForma");

				
		}};

		Collection D2 = new ArrayList() {{
			add("http://schema.org/subEven");

			add("http://schema.org/availableTes");

			add("http://schema.org/causeO");

			add("http://schema.org/printColum");

			add("http://schema.org/nam");

			add("http://schema.org/infectiousAgen");

			add("http://schema.org/subtyp");

			add("http://schema.org/mechanismOfActio");

			add("http://schema.org/installUr");

			add("http://schema.org/endDat");

			add("http://schema.org/itemReviewe");

			add("http://schema.org/usesDevic");

			add("http://schema.org/membe");

			add("http://schema.org/recommendationStrengt");

			add("http://schema.org/availableI");

			add("http://schema.org/homeLocatio");

			add("http://schema.org/originatesFro");

			add("http://schema.org/sodiumConten");

			add("http://schema.org/subStageSuffi");

			add("http://schema.org/contactPoint");

			add("http://schema.org/seaso");

			add("http://schema.org/runsT");

			add("http://schema.org/genr");

			add("http://schema.org/costCurrenc");

			add("http://schema.org/memoryRequirement");

			add("http://schema.org/adverseOutcom");

			add("http://schema.org/phot");

			add("http://schema.org/sourceOrganizatio");

			add("http://schema.org/jobTitl");

			add("http://schema.org/bestRatin");

			add("http://schema.org/copyrightYea");

			add("http://schema.org/versio");

			add("http://schema.org/reviewBod");

			add("http://schema.org/publicationTyp");

			add("http://schema.org/preparatio");

			add("http://schema.org/recommendedIntak");

			add("http://schema.org/nationalit");

			add("http://schema.org/insertio");

			add("http://schema.org/secondaryPreventio");

			add("http://schema.org/duplicateTherap");

			add("http://schema.org/copyrightHolde");

			add("http://schema.org/provide");

			add("http://schema.org/wordCoun");

			add("http://schema.org/bookEditio");

			add("http://schema.org/isPartO");

			add("http://schema.org/alumniO");

			add("http://schema.org/siblin");

			add("http://schema.org/countriesNotSupporte");

			add("http://schema.org/addressRegio");

			add("http://schema.org/cod");

			add("http://schema.org/structuralClas");

			add("http://schema.org/honorificPrefi");

			add("http://schema.org/priceCurrenc");

			add("http://schema.org/prescriptionStatu");

			add("http://schema.org/medicineSyste");

			add("http://schema.org/manufacture");

			add("http://schema.org/labelDetail");

			add("http://schema.org/streetAddres");

			add("http://schema.org/acceptsReservation");

			add("http://schema.org/additionalNam");

			add("http://schema.org/expire");

			add("http://schema.org/commentTim");

			add("http://schema.org/industr");

			add("http://schema.org/workHour");

			add("http://schema.org/alternateNam");

			add("http://schema.org/even");

			add("http://schema.org/prepTim");

			add("http://schema.org/embedUr");

			add("http://schema.org/replyToUr");

			add("http://schema.org/relatedT");

			add("http://schema.org/thumbnai");

			add("http://schema.org/memberO");

			add("http://schema.org/contactTyp");

			add("http://schema.org/usedToDiagnos");

			add("http://schema.org/applicableLocatio");

			add("http://schema.org/partOfSyste");

			add("http://schema.org/reviewedB");

			add("http://schema.org/uploadDat");

			add("http://schema.org/track");

			add("http://schema.org/responsibilitie");

			add("http://schema.org/affectedB");

			add("http://schema.org/episode");

			add("http://schema.org/contributo");

			add("http://schema.org/captio");

			add("http://schema.org/contentSiz");

			add("http://schema.org/ratingCoun");

			add("http://schema.org/commentTex");

			add("http://schema.org/evidenceLeve");

			add("http://schema.org/howPerforme");

			add("http://schema.org/isb");

			add("http://schema.org/pathophysiolog");

			add("http://schema.org/strengthValu");

			add("http://schema.org/proprietaryNam");

			add("http://schema.org/reviewCoun");

			add("http://schema.org/audienc");

			add("http://schema.org/nonProprietaryNam");

			add("http://schema.org/photo");

			add("http://schema.org/tissueSampl");

			add("http://schema.org/doseUni");

			add("http://schema.org/postO");

			add("http://schema.org/cookTim");

			add("http://schema.org/ur");

			add("http://schema.org/itemListOrde");

			add("http://schema.org/exifDat");

			add("http://schema.org/contactPoin");

			add("http://schema.org/associatedAnatom");

			add("http://schema.org/caus");

			add("http://schema.org/datePublishe");

			add("http://schema.org/colleagu");

			add("http://schema.org/prescribingInf");

			add("http://schema.org/drugClas");

			add("http://schema.org/costOrigi");

			add("http://schema.org/phas");

			add("http://schema.org/inLanguag");

			add("http://schema.org/drugUni");

			add("http://schema.org/primaryPreventio");

			add("http://schema.org/bloodSuppl");

			add("http://schema.org/men");

			add("http://schema.org/isProprietar");

			add("http://schema.org/requiresSubscriptio");

			add("http://schema.org/regionsAllowe");

			add("http://schema.org/produce");

			add("http://schema.org/preO");

			add("http://schema.org/givenNam");

			add("http://schema.org/widt");

			add("http://schema.org/transFatConten");

			add("http://schema.org/familyNam");

			add("http://schema.org/aspec");

			add("http://schema.org/requirement");

			add("http://schema.org/recipeInstruction");

			add("http://schema.org/associatedArticl");

			add("http://schema.org/recipeCuisin");

			add("http://schema.org/tickerSymbo");

			add("http://schema.org/servingSiz");

			add("http://schema.org/latitud");

			add("http://schema.org/nerv");

			add("http://schema.org/processorRequirement");

			add("http://schema.org/titl");

			add("http://schema.org/additionalVariabl");

			add("http://schema.org/incentive");

			add("http://schema.org/qualification");

			add("http://schema.org/circl");

			add("http://schema.org/repetition");

			add("http://schema.org/studyLocatio");

			add("http://schema.org/parent");

			add("http://schema.org/creato");

			add("http://schema.org/workloa");

			add("http://schema.org/discusse");

			add("http://schema.org/endorser");

			add("http://schema.org/abou");

			add("http://schema.org/activeIngredien");

			add("http://schema.org/populatio");

			add("http://schema.org/member");

			add("http://schema.org/naturalProgressio");

			add("http://schema.org/contraindicatio");

			add("http://schema.org/numberOfEpisode");

			add("http://schema.org/primaryImageOfPag");

			add("http://schema.org/affiliatio");

			add("http://schema.org/antagonis");

			add("http://schema.org/intensit");

			add("http://schema.org/saturatedFatConten");

			add("http://schema.org/differentialDiagnosi");

			add("http://schema.org/directo");

			add("http://schema.org/hospitalAffiliatio");

			add("http://schema.org/musicB");

			add("http://schema.org/productI");

			add("http://schema.org/applicationCategor");

			add("http://schema.org/bitrat");

			add("http://schema.org/duratio");

			add("http://schema.org/unsaturatedFatConten");

			add("http://schema.org/selle");

			add("http://schema.org/illustrato");

			add("http://schema.org/branc");

			add("http://schema.org/dateCreate");

			add("http://schema.org/nerveMoto");

			add("http://schema.org/sensoryUni");

			add("http://schema.org/lin");

			add("http://schema.org/founde");

			add("http://schema.org/featureLis");

			add("http://schema.org/cos");

			add("http://schema.org/evidenceOrigi");

			add("http://schema.org/mainContentOfPag");

			add("http://schema.org/itemConditio");

			add("http://schema.org/currenciesAccepte");

			add("http://schema.org/startDat");

			add("http://schema.org/priceRang");

			add("http://schema.org/articleSectio");

			add("http://schema.org/review");

			add("http://schema.org/highPric");

			add("http://schema.org/studySubjec");

			add("http://schema.org/applicationSuit");

			add("http://schema.org/servesCuisin");

			add("http://schema.org/subEvent");

			add("http://schema.org/relatedLin");

			add("http://schema.org/encodingForma");

			add("http://schema.org/offerCoun");

			add("http://schema.org/ge");

			add("http://schema.org/browserRequirement");

			add("http://schema.org/postalCod");

			add("http://schema.org/restPeriod");

			add("http://schema.org/benefit");

			add("http://schema.org/estimatesRiskO");

			add("http://schema.org/origi");

			add("http://schema.org/clincalPharmacolog");

			add("http://schema.org/season");

			add("http://schema.org/priceValidUnti");

			add("http://schema.org/overdosag");

			add("http://schema.org/paren");

			add("http://schema.org/procedur");

			add("http://schema.org/procedureTyp");

			add("http://schema.org/signOrSympto");

			add("http://schema.org/worstRatin");

			add("http://schema.org/educationRequirement");

			add("http://schema.org/releaseNote");

			add("http://schema.org/comprisedO");

			add("http://schema.org/guidelineDat");

			add("http://schema.org/mention");

			add("http://schema.org/partOfTVSerie");

			add("http://schema.org/longitud");

			add("http://schema.org/increasesRiskO");

			add("http://schema.org/relatedTherap");

			add("http://schema.org/spous");

			add("http://schema.org/indicatio");

			add("http://schema.org/contentUr");

			add("http://schema.org/alternativeHeadlin");

			add("http://schema.org/childre");

			add("http://schema.org/carrierRequirement");

			add("http://schema.org/transcrip");

			add("http://schema.org/numberOfPage");

			add("http://schema.org/pregnancyCategor");

			add("http://schema.org/storageRequirement");

			add("http://schema.org/revie");

			add("http://schema.org/fileForma");

			add("http://schema.org/vide");

			add("http://schema.org/cookingMetho");

			add("http://schema.org/fiberConten");

			add("http://schema.org/event");

			add("http://schema.org/codingSyste");

			add("http://schema.org/polygo");

			add("http://schema.org/actio");

			add("http://schema.org/subStructur");

			add("http://schema.org/trialDesig");

			add("http://schema.org/proteinConten");

			add("http://schema.org/founder");

			add("http://schema.org/experienceRequirement");

			add("http://schema.org/edito");

			add("http://schema.org/bran");

			add("http://schema.org/totalTim");

			add("http://schema.org/specialCommitment");

			add("http://schema.org/commen");

			add("http://schema.org/exerciseTyp");

			add("http://schema.org/stageAsNumbe");

			add("http://schema.org/skill");

			add("http://schema.org/aggregateRatin");

			add("http://schema.org/superEven");

			add("http://schema.org/episodeNumbe");

			add("http://schema.org/itemOffere");

			add("http://schema.org/physiologicalBenefit");

			add("http://schema.org/imag");

			add("http://schema.org/codeValu");

			add("http://schema.org/lastReviewe");

			add("http://schema.org/imagingTechniqu");

			add("http://schema.org/offer");

			add("http://schema.org/attendee");

			add("http://schema.org/algorith");

			add("http://schema.org/alcoholWarnin");

			add("http://schema.org/foodWarnin");

			add("http://schema.org/addres");

			add("http://schema.org/normalRang");

			add("http://schema.org/ratingValu");

			add("http://schema.org/targetPopulatio");

			add("http://schema.org/signDetecte");

			add("http://schema.org/followu");

			add("http://schema.org/employe");

			add("http://schema.org/warnin");

			add("http://schema.org/legalStatu");

			add("http://schema.org/sibling");

			add("http://schema.org/reviewRatin");

			add("http://schema.org/workLocatio");

			add("http://schema.org/guidelineSubjec");

			add("http://schema.org/publishingPrinciple");

			add("http://schema.org/encoding");

			add("http://schema.org/costPerUni");

			add("http://schema.org/faxNumbe");

			add("http://schema.org/partOfSeaso");

			add("http://schema.org/ingredient");

			add("http://schema.org/contentLocatio");

			add("http://schema.org/functio");

			add("http://schema.org/carbohydrateConten");

			add("http://schema.org/addressLocalit");

			add("http://schema.org/associatedMedi");

			add("http://schema.org/fileSiz");

			add("http://schema.org/functionalClas");

			add("http://schema.org/know");

			add("http://schema.org/guidelin");

			add("http://schema.org/keyword");

			add("http://schema.org/gende");

			add("http://schema.org/album");

			add("http://schema.org/colleague");

			add("http://schema.org/inPlaylis");

			add("http://schema.org/citatio");

			add("http://schema.org/outcom");

			add("http://schema.org/subTes");

			add("http://schema.org/activityFrequenc");

			add("http://schema.org/fatConten");

			add("http://schema.org/biomechnicalClas");

			add("http://schema.org/openingHour");

			add("http://schema.org/identifyingExa");

			add("http://schema.org/studyDesig");

			add("http://schema.org/identifyingTes");

			add("http://schema.org/jobLocatio");

			add("http://schema.org/performer");

			add("http://schema.org/arterialBranc");

			add("http://schema.org/transmissionMetho");

			add("http://schema.org/downloadUr");

			add("http://schema.org/ma");

			add("http://schema.org/purpos");

			add("http://schema.org/breastfeedingWarnin");

			add("http://schema.org/overvie");

			add("http://schema.org/actor");

			add("http://schema.org/typicalTes");

			add("http://schema.org/diagra");

			add("http://schema.org/medicalSpecialt");

			add("http://schema.org/heigh");

			add("http://schema.org/honorificSuffi");

			add("http://schema.org/performerI");

			add("http://schema.org/mode");

			add("http://schema.org/awar");

			add("http://schema.org/operatingSyste");

			add("http://schema.org/recipeYiel");

			add("http://schema.org/isFamilyFriendl");

			add("http://schema.org/branchO");

			add("http://schema.org/softwareVersio");

			add("http://schema.org/devic");

			add("http://schema.org/representativeOfPag");

			add("http://schema.org/relatedAnatom");

			add("http://schema.org/musicGroupMembe");

			add("http://schema.org/acto");

			add("http://schema.org/interactingDru");

			add("http://schema.org/elevatio");

			add("http://schema.org/expertConsideration");

			add("http://schema.org/relatedConditio");

			add("http://schema.org/paymentAccepte");

			add("http://schema.org/significantLin");

			add("http://schema.org/containedI");

			add("http://schema.org/alumn");

			add("http://schema.org/relatedDru");

			add("http://schema.org/recipeCategor");

			add("http://schema.org/stud");

			add("http://schema.org/map");

			add("http://schema.org/activityDuratio");

			add("http://schema.org/videoFrameSiz");

			add("http://schema.org/frequenc");

			add("http://schema.org/award");

			add("http://schema.org/playerTyp");

			add("http://schema.org/birthDat");

			add("http://schema.org/accountablePerso");

			add("http://schema.org/bo");

			add("http://schema.org/blogPos");

			add("http://schema.org/seriousAdverseOutcom");

			add("http://schema.org/baseSalar");

			add("http://schema.org/publishe");

			add("http://schema.org/postOfficeBoxNumbe");

			add("http://schema.org/blogPost");

			add("http://schema.org/maximumIntak");

			add("http://schema.org/occupationalCategor");

			add("http://schema.org/calorie");

			add("http://schema.org/printEditio");

			add("http://schema.org/traile");

			add("http://schema.org/strengthUni");

			add("http://schema.org/datelin");

			add("http://schema.org/risk");

			add("http://schema.org/hiringOrganizatio");

			add("http://schema.org/relatedStructur");

			add("http://schema.org/drainsT");

			add("http://schema.org/doseSchedul");

			add("http://schema.org/infectiousAgentClas");

			add("http://schema.org/epidemiolog");

			add("http://schema.org/includedRiskFacto");

			add("http://schema.org/availableStrengt");

			add("http://schema.org/tributar");

			add("http://schema.org/pregnancyWarnin");

			add("http://schema.org/thumbnailUr");

			add("http://schema.org/isAvailableGenericall");

			add("http://schema.org/numTrack");

			add("http://schema.org/riskFacto");

			add("http://schema.org/countriesSupporte");

			add("http://schema.org/dosageFor");

			add("http://schema.org/employee");

			add("http://schema.org/availableServic");

			add("http://schema.org/tex");

			add("http://schema.org/sponso");

			add("http://schema.org/dietFeature");

			add("http://schema.org/significantLink");

			add("http://schema.org/relevantSpecialt");

			add("http://schema.org/possibleComplicatio");

			add("http://schema.org/backgroun");

			add("http://schema.org/printPag");

			add("http://schema.org/printSectio");

			add("http://schema.org/pric");

			add("http://schema.org/administrationRout");

			add("http://schema.org/safetyConsideratio");

			add("http://schema.org/follow");

			add("http://schema.org/encodesCreativeWor");

			add("http://schema.org/interactionCoun");

			add("http://schema.org/salaryCurrenc");

			add("http://schema.org/employmentTyp");

			add("http://schema.org/audi");

			add("http://schema.org/permission");

			add("http://schema.org/applicationSubCategor");

			add("http://schema.org/sugarConten");

			add("http://schema.org/seasonNumbe");

			add("http://schema.org/videoQualit");

			add("http://schema.org/supplyT");

			add("http://schema.org/contentRatin");

			add("http://schema.org/bodyLocatio");

			add("http://schema.org/costCategor");

			add("http://schema.org/headlin");

			add("http://schema.org/lowPric");

			add("http://schema.org/discussionUr");

			add("http://schema.org/categor");

			add("http://schema.org/stag");

			add("http://schema.org/bookForma");

			add("http://schema.org/addressCountr");

			add("http://schema.org/expectedPrognosi");

			add("http://schema.org/doseValu");

			add("http://schema.org/significanc");

			add("http://schema.org/descriptio");

			add("http://schema.org/regionDraine");

			add("http://schema.org/breadcrum");

			add("http://schema.org/inAlbu");

			add("http://schema.org/distinguishingSig");

			add("http://schema.org/foundingDat");

			add("http://schema.org/diagnosi");

			add("http://schema.org/nutritio");

			add("http://schema.org/deathDat");

			add("http://schema.org/emai");

			add("http://schema.org/cholesterolConten");

			add("http://schema.org/sourcedFro");

			add("http://schema.org/locatio");

			add("http://schema.org/albu");

			add("http://schema.org/productionCompan");

			add("http://schema.org/itemListElemen");

			add("http://schema.org/dateModifie");

			add("http://schema.org/autho");

			add("http://schema.org/recognizingAuthorit");

			add("http://schema.org/episod");

			add("http://schema.org/dru");

			add("http://schema.org/worksFo");

			add("http://schema.org/possibleTreatmen");

			add("http://schema.org/screensho");

			add("http://schema.org/articleBod");

			add("http://schema.org/attende");

			add("http://schema.org/sourc");

			add("http://schema.org/trac");

			add("http://schema.org/specialt");

			add("http://schema.org/availabilit");

			add("http://schema.org/connectedT");

			add("http://schema.org/telephon");

			add("http://schema.org/datePoste");

			add("http://schema.org/statu");

			add("http://schema.org/byArtis");

			add("http://schema.org/associatedPathophysiolog");

			add("http://schema.org/performe");

			add("http://schema.org/encodin");

		}};

		// Show the "before" lists
		System.out.println("First List: " + D1);
		System.out.println("Second List: " + D2);

		// Remove all elements in firstList from secondList
		D2.removeAll(D1);

		// Show the "after" list
		System.out.println("Result: " + D2.size());

		
	}
	public static void main(String[] args) throws IOException {
 //		"osspr_2013-09-04.n3",
//		"osspr_2010-04-01.n3",
//		"osspr_2013-09-04.n3",

		
	countClasses("/home/omar/Desktop/3Sep/4SEP/bio_2009-05-19.n3.txt"
			, "/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/Ontology/bio_2009-05-19.n3");

	countClasses("/home/omar/Desktop/3Sep/4SEP/bio_2010-04-20.n3.txt"

			, "/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/Ontology/bio_2010-04-20.n3");
		
		

//		countProp("/home/omar/Desktop/3Sep/5SEP_Prop/frbrer_2012-02-29.n3_prop.txt",
//				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/Ontology/frbrer_2012-02-29.n3");
//
//		countProp("/home/omar/Desktop/3Sep/5SEP_Prop/frbrer_2015-07-14.n3_prop.txt",
//				"/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/Ontology/frbrer_2015-07-14.n3");

		
//		getOutgoingLinks("/home/omar/Desktop/3Sep/foaf_2007-10-02_prop.txt",
//				"/home/omar/Desktop/3Sep/foaf_2007-10-02.n3");
		
		//compareLists();

	}

}


/*String arr[]={"dcam_2008-01-14.n3",
				"dcam_2010-10-11.n3",
				"dcam_2010-10-11.n3",
				"dcam_2012-06-14.n3",
				"dce_2008-01-14.n3",
				"dce_2012-06-14.n3",
				"dcam_2008-01-14.n3",
				"dcam_2010-10-11.n3",
				"dcterms_2008-01-14.n3",
				"dcterms_2010-10-11.n3",
				"dcterms_2010-10-11.n3",
				"dcterms_2012-06-14.n3",
				"dcam_2010-10-11.n3",
				"dcam_2012-06-14.n3",
				"dcterms_2010-10-11.n3",
				"dcterms_2012-06-14.n3",
				"foaf_2010-08-09.n3",
				"foaf_2014-01-14.n3",
				"dcterms_2008-01-14.n3",
				"dcterms_2012-06-14.n3",
				"dce_2008-01-14.n3",
				"dce_2012-06-14.n3",
				"dcterms_2010-10-11.n3",
				"dcterms_2012-06-14.n3",
				"dce_2010-10-11.n3",
				"dce_2012-06-14.n3",
				"foaf_2007-10-02.n3",
				"foaf_2010-01-01.n3",
				"foaf_2010-01-01.n3",
				"foaf_2010-08-09.n3",
				"dcterms_2008-01-14.n3",
				"dcterms_2010-10-11.n3",
				"dcterms_2008-01-14.n3",
				"dcterms_2010-10-11.n3",
				"dcterms_2010-10-11.n3",
				"dcterms_2012-06-14.n3",
				"dcterms_2008-01-14.n3",
				"dcterms_2010-10-11.n3",
				"dcterms_2010-10-11.n3",
				"dcterms_2012-06-14.n3",
				"dcam_2008-01-14.n3",
				"dcam_2010-10-11.n3",
				"dcam_2010-10-11.n3",
				"dcam_2012-06-14.n3",
				"dce_2008-01-14.n3",
				"dce_2012-06-14.n3",
				"dcterms_2010-10-11.n3",
				"dcterms_2012-06-14.n3",
				"dctype_2008-01-14.n3",
				"dctype_2010-10-11.n3",
				"dcterms_2008-01-14.n3",
				"dcterms_2010-10-11.n3",
				"foaf_2010-01-01.n3",
				"foaf_2010-08-09.n3",
				"dce_2008-01-14.n3",
				"dce_2010-10-11.n3",
				"dctype_2010-10-11.n3",
				"dctype_2012-06-14.n3",
				"dcterms_2010-10-11.n3",
				"dcterms_2012-06-14.n3",
				"dce_2010-10-11.n3",
				"dce_2012-06-14.n3",
				"bio_2010-04-20.n3",
				"bio_2011-06-14.n3",
				"dcterms_2010-10-11.n3",
				"dcterms_2012-06-14.n3",
				"dce_2010-10-11.n3",
				"dce_2012-06-14.n3",
				"foaf_2010-01-01.n3",
				"foaf_2010-08-09.n3",
				"dcterms_2008-01-14.n3",
				"dcterms_2012-06-14.n3",
				"prov_2012-07-24.n3",
				"prov_2013-04-30.n3",
				"foaf_2010-08-09.n3",
				"foaf_2014-01-14.n3",
				"foaf_2007-10-02.n3",
				"foaf_2010-01-01.n3",
				"dcterms_2008-01-14.n3",
				"dcterms_2010-10-11.n3",
				"foaf_2010-01-01.n3",
				"foaf_2010-08-09.n3",
				"dcterms_2008-01-14.n3",
				"dcterms_2010-10-11.n3",
				"dcterms_2010-10-11.n3",
				"dcterms_2012-06-14.n3",
				"dcterms_2010-10-11.n3",
				"dcterms_2012-06-14.n3",
				"dce_2010-10-11.n3",
				"dce_2012-06-14.n3",
				"schema_2012-04-27.n3",
				"schema_2013-04-05.n3",
				"schema_2013-04-05.n3",
				"schema_2013-08-07.n3",
				"schema_2013-08-07.n3",
				"schema_2013-12-04.n3",
				"schema_2013-12-04.n3",
				"schema_2015-05-12.n3",
				"foaf_2010-08-09.n3",
				"foaf_2014-01-14.n3",
				"foaf_2010-08-09.n3",
				"foaf_2014-01-14.n3",
				"dce_2008-01-14.n3",
				"dce_2010-10-11.n3",
				"dce_2010-10-11.n3",
				"dce_2012-06-14.n3",
				"dcterms_2010-10-11.n3",
				"dcterms_2012-06-14.n3",
				"dce_2010-10-11.n3",
				"dce_2012-06-14.n3",
				"dcterms_2010-10-11.n3",
				"dcterms_2012-06-14.n3",
				"dctype_2008-01-14.n3",
				"dctype_2012-06-14.n3",
				"dcterms_2008-01-14.n3",
				"dcterms_2012-06-14.n3",
				"foaf_2010-01-01.n3",
				"foaf_2010-08-09.n3",
				"schema_2012-11-08.n3",
				"schema_2013-12-04.n3",
				"org_2012-10-06.n3",
				"org_2013-12-16.n3",
				"schema_2012-11-08.n3",
				"schema_2013-04-05.n3",
				"schema_2013-04-05.n3",
				"schema_2013-12-04.n3",
				"foaf_2010-08-09.n3",
				"foaf_2014-01-14.n3",
				"schema_2013-12-04.n3",
				"schema_2014-02-05.n3",
				"schema_2014-02-05.n3",
				"schema_2014-07-28.n3",
				"schema_2013-11-19.n3",
				"schema_2013-12-04.n3",
				"schema_2013-12-04.n3",
				"schema_2015-02-04.n3",
				"foaf_2010-08-09.n3",
				"foaf_2014-01-14.n3",
				"foaf_2010-08-09.n3",
				"foaf_2014-01-14.n3",
				"dce_2010-10-11.n3",
				"dce_2012-06-14.n3",
				"osspr_2010-04-01.n3",
				"osspr_2013-09-04.n3",
				"dcterms_2008-01-14.n3",
				"dcterms_2012-06-14.n3",
				"dce_2008-01-14.n3",
				"dce_2012-06-14.n3",};
		
		for(int i=0;i<arr.length;i++){
			countProp("/home/omar/Desktop/3Sep/countAllPropPrefixes.txt", "/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/PREFIXES/"+arr[i]);

			countClasses("/home/omar/Desktop/3Sep/countAllclassesPrefixes.txt", "/media/omar/SanDisk_MyData/Lov_dataset/JulyExperiments/PREFIXES/"+arr[i]);
		}*/
