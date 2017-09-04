/**
 * 
 */
package com.drools.practice.main;

import java.io.IOException;

import org.drools.compiler.compiler.DroolsParserException;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.drools.practice.model.Product;

/**
 * @author anilc
 *
 */
public class DroolsTest {
	public static void main(String[] args) throws DroolsParserException, IOException {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			// Get the session named kseesion-rule that we defined in kmodule.xml above.
			// Also by default the session returned is always stateful.
			KieSession kSession = kContainer.newKieSession("ksession-rule");

			Product product = new Product();
			product.setType("gold");

			kSession.insert(product);
			kSession.fireAllRules();
			System.out.println(
					"The discount for the jewellery product " + product.getType() + " is " + product.getDiscount());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
