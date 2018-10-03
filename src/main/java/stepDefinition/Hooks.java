package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	@Before
    public void beforeScenario(){
        System.out.println("This will run before the Scenario");
        //start driver
    }	
	
	@After
    public void afterScenario(){
        System.out.println("This will run after the Scenario");
        //close driver
    }
}
