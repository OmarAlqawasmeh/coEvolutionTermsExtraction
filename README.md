# Ontology Co-Evolution

**Ontology co-evolution**  is a situation where: `O` is an ontology
which has at least two versions `v1` and `v2`. `O'` is a different
ontology which has at least two versions `v1'` and `v2'`. `O` uses
terms that are defined by `O'`. `t(v)` is the creation time for a
version.
In order to have a co-evolution case between `O` and `O'`
with the ontologies `<v1,v1',v2,v2'>`, the following condition
must be satisfied:

`t(v1) < t(v2) ∧ t(v1') < t(v2') ∧ t(v1') < t(v1) ∧ t(v2') < t(v2)`


## The list of the targetted ontologies

The set of the targetted ontologies are included in `resources/Ontologies`


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
