package stepdefinition;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepdefinition {

	    @Given("^I work in Latenights$")
	    public void i_work_in_latenights() throws Throwable {
	     
	        System.out.println("hello");
	    }

	    @When("^I meet watchmen$")
	    public void i_meet_watchmen() throws Throwable {
	        throw new PendingException();
	    }

	    @Then("^I Greeted him$")
	    public void i_greeted_him() throws Throwable {
	        throw new PendingException();
	    }

	}

