# Ontology Co-Evolution

Ontology co-evolution is a situation where: O is an ontology which has at
least two versions v1 and v2. O' is an ontology which has at least two versions v1' and v2'.
t(v) is the creation time for a version. O uses terms that exist in O'
O!=O'

Ontology co-evolution could happen if the following conditions are satisfied:

\begin{enumerate}
    \item $t(v_1) < t(v_2)$ 
    \item $t(v_1') < t(v_2')$ 
    \item $ t(v_1') < t(v_1) $
    \item $t(v_2') < t(v_2)$
\end{enumerate}



# Src/resources
Inside `src/resources`, there are two csv files with the different cases:

1. `LOV_cases.csv` <d1,d1,d1',d2',ns(O')>
2. `BioPortal_cases.csv`  <d1,d1,d1',d2',ns(O')>



## The list of the targetted ontologies
The set of the targetted ontologies are included in `resources/main`

## To run

1. run main method of class `extractor/termExtractionCoEvol`





