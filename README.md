# Ontology Co-Evolution

**Ontology co-evolution** is a situation where: O is an ontology which has at
least two versions v1 and v2. 

<<<<<<< HEAD
O' is a different ontology which has at least two versions v1' and v2'.
=======
O' is an ontology which has at least two versions v1' and v2'.
>>>>>>> 64ea2b8bf178ac6ea86e0da4a3020e5b75220acf

t(v) is the creation time for a version. O uses terms that exist in O'.

O != O'.

Ontology co-evolution could happen if the following conditions are satisfied:

1. t(v_1) < t(v_2)
2. t(v_1') < t(v_2') 
3. t(v_1') < t(v_1)
4. t(v_2') < t(v_2)


## The list of the targetted ontologies
<<<<<<< HEAD

The set of the targetted ontologies are included in `resources/main`


## The different cases

Inside `src/resources`, there are two csv files with the different cases:

1. `LOV_cases.csv` <d1,d1,d1',d2',ns(O')>
2. `BioPortal_cases.csv`  <d1,d1,d1',d2',ns(O')>

## To run

1. run main method of class `extractor/termExtractionCoEvol`
=======

The set of the targetted ontologies are included in `resources/main`


## The different cases

Inside `src/resources`, there are two csv files with the different cases:

1. `LOV_cases.csv` <d1,d1,d1',d2',ns(O')>
2. `BioPortal_cases.csv`  <d1,d1,d1',d2',ns(O')>

## To run
>>>>>>> 64ea2b8bf178ac6ea86e0da4a3020e5b75220acf

1. run main method of class `extractor/termExtractionCoEvol`
