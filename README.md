# Ontology Co-Evolution

**Ontology co-evolution** is a situation where: O is an ontology which has at
least two versions v1 and v2. 
O' is a different ontology which has at least two versions v1' and v2'.

t(v) is the creation time for a version. O uses terms that exist in O'.

Ontology co-evolution could happen if the following conditions are satisfied:

1. t(v_1) < t(v_2)
2. t(v_1') < t(v_2') 
3. t(v_1') < t(v_1)
4. t(v_2') < t(v_2)


## The list of the targetted ontologies

The set of the targetted ontologies are included in `resources/main`


## The different cases

Inside `src/resources`, there are two csv files with the different cases:

1. `LOV_cases.csv` `<v1,v1,v1',v2',ns(O')>`
2. `BioPortal_cases.csv` `<v1,v1,v1',v2',ns(O')>`


## The overall results

Inside `src/resources`, there are two csv files with the result for all the co-evolution cases:

1. `All results for LOV.csv` 
2. `All results for BioPortal.csv`



## To run

1. run main method of class `extractor/termExtractionCoEvol`
