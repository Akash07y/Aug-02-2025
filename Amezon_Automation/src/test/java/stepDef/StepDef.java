package stepDef;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {

	@Given("User logged in to allpication")
	public void loginCode()
	{
		System.out.println("Login code executed");
	}
	
	@Given("User click on edit profile button")
	public void editProfile() {
		System.out.println("Edit profile code executed");
	}
	
	@Given("User enter the name as {string} and email as {string}")
	public void enterNameAndEmail(String name, String email) {
		System.out.println("Name entered: " + name);
		System.out.println("Email entered: " + email);
	}
	
	
	@Given("User enter the {string} as {string} and email as {string}")
	public void enterNameAndEmail(String editValueOf, String name, String email) {
		
		if(editValueOf.equals("First Name")) {
			System.out.println("First Name entered: " + name);
			// POM Class
			// FistName.sendKeys(name);
		}
		else if(editValueOf.equals("Last Name")) {
			System.out.println("Last Name entered: " + name);
			// POM Class
			// LastName.sendKeys(name);
		}
		System.out.println("Name entered: " + name);
		System.out.println("Email entered: " + email);
	}
	
	@When("User click on save button")
	public void clickSave() {
		System.out.println("Save button clicked");
	}
	
	@When("User click on view profile button")
	public void viewProfile() {
		System.out.println("View profile button clicked");
	}
	
	@Then("Verify all the details in the profile")
	public void verifyProfileDetails(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		Map<String, String> firstData = data.get(1);
		String fName = firstData.get("First Name");
		// OR
		String fName1 =   data.get(1).get("First Name");
		String LName =   data.get(1).get("Last Name");
		String mobile =   data.get(1).get("Mobile No");
		String email =   data.get(1).get("Email Id");
		String addr =   data.get(1).get("Address");
		System.out.println(fName);
		System.out.println("Profile details verified");
	}
}
