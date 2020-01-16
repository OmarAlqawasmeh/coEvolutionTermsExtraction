install.packages("foreign")
install.packages("agrmt")

library(foreign)
library (agrmt)


agreementClassification <- c(0, 9, 30, 93, 56)
print ("Level of agreement for the classification")
consensus(agreementClassification)

confidenceValue <- c(0, 26, 84, 52, 26)
print ("Confidence value")
consensus(confidenceValue)


#----------------Pitfalls occurences-------------------

P1occurences <- c(2,0,14,11,0)
print ("Confidence value")
consensus(P1occurences)

P2occurences <- c(7,11,7,2,0)
print ("Confidence value")
consensus(P2occurences)

P3occurences <- c(5,5,8,7,2)
print ("Confidence value")
consensus(P3occurences)

P4occurences <- c(7,6,7,3,4)
print ("Confidence value")
consensus(P4occurences)

P5occurences <- c(6,9,8,3,1)
print ("Confidence value")
consensus(P5occurences)

P6occurences <- c(8,11,6,2,0)
print ("Confidence value")
consensus(P6occurences)

P7occurences <- c(9,10,5,2,1)
print ("Confidence value")
consensus(P7occurences)

P8occurences <- c(10,10,4,2,1)
print ("Confidence value")
consensus(P8occurences)

P9occurences <- c(4,5,11,7,0)
print ("Confidence value")
consensus(P9occurences)


# For each question we have 9 frequency vectors. 
# Each vector represent the answers for the different participants.

# Q1. How problematic is this pitfall?

# Pitfall 1.
P1 <- c(0, 5, 53, 55, 75)
print ("Q1. Consensus value for P1")
consensus(P1)



P2 <- c(13, 7, 70, 76, 22)
print ("Q1. Consensus value for P2")
consensus(P2)



P3 <- c(5, 2, 67, 42, 72)
print ("Q1. Consensus value for P3")
consensus(P3)




P4 <- c(5, 21, 44, 81, 37)
print ("Q1. Consensus value for P4")
consensus(P4)



P5 <- c(5, 24, 30, 104, 25)
print ("Q1. Consensus value for P5")
consensus(P5)



P6 <- c(38, 39, 79, 25, 7)
print ("Q1. Consensus value for P6")
consensus(P6)




P7 <- c(5,    37,   42,   65,  39)
print ("Q1. Consensus value for P7")
consensus(P7)




P8 <- c(13, 21, 60, 40, 54)
print ("Q1. Consensus value for P8")
consensus(P8)




P9 <- c(12, 43, 77, 40, 16)
print ("Q1. Consensus value for P9")
consensus(P9)





# Q2. How would you rate the impact on subsequent versions of the ontology?

# Pitfall 1.
P1 <- c(0,0,20,74,56)
print ("Q2. Consensus value for P1")
consensus(P1)



P2 <- c(4,19,57,31,39)
print ("Q2. Consensus value for P2")
consensus(P2)



P3 <- c(9,15,40,43,43)
print ("Q2. Consensus value for P3")
consensus(P3)




P4 <- c(4,18,19,56,53)
print ("Consensus value for P4")
consensus(P4)



P5 <- c(9,33,14,68,26)
print ("Consensus value for P5")
consensus(P5)



P6 <- c(16,35,79,13,7)
print ("Consensus value for P6")
consensus(P6)




P7 <- c(4,26,41,54,25)
print ("Consensus value for P7")
consensus(P7)




P8 <- c(4,24,62,34,26)
print ("Consensus value for P8")
consensus(P8)




P9 <- c(4,58,41,30,17)
print ("Consensus value for P9")
consensus(P9)





# Q3. How problematic is it to import ontologies that have this pitfall?

P1 <- c(0,0,49,46,64)
print ("Q3. Consensus value for P1")
consensus(P1)



P2 <- c(7,19,60,40,33)
print ("Consensus value for P2")
consensus(P2)



P3 <- c(7,0,47,39,66)
print ("Consensus value for P3")
consensus(P3)




P4 <- c(12,23,16,74,34)
print ("Consensus value for P4")
consensus(P4)



P5 <- c(7,28,40,63,21)
print ("Consensus value for P5")
consensus(P5)



P6 <- c(30,32,62,35,0)
print ("Consensus value for P6")
consensus(P6)




P7 <- c(7,26,49,43,34)
print ("Consensus value for P7")
consensus(P7)




P8 <- c(17,16,56,51,19)
print ("Consensus value for P8")
consensus(P8)




P9 <- c(26,72,43,15,3)
print ("Consensus value for P9")
consensus(P9)

