/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ujm.omar.extractor;

import java.util.Set;

public class InterestingCase {
    
    private PotentialInterestingCase interestingCase;
    private Set<String> terms;

    public InterestingCase(PotentialInterestingCase interestingCase, Set<String> terms) {
        this.interestingCase = interestingCase;
        this.terms = terms;
    }

    public PotentialInterestingCase getInterestingCase() {
        return interestingCase;
    }

    public Set<String> getTerms() {
        return terms;
    }

    public void setInterestingCase(PotentialInterestingCase interestingCase) {
        this.interestingCase = interestingCase;
    }

    public void setTerms(Set<String> terms) {
        this.terms = terms;
    }

    @Override
    public String toString() {
        return "intersting case : \n"
                + interestingCase + " for terms " + terms; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
