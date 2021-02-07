package stepDefs;

import desktop.fragments.SearchBlockFragment;
import desktop.fragments.SearchFiltersFragment;
import desktop.fragments.SearchResultsFragment;
import desktop.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static driver.SingletonDriver.getDriver;

public class SearchAndFilterAndCheckSearchResultsSteps {

    HomePage homePage = new HomePage();
    SearchBlockFragment searchBlockFragment = new SearchBlockFragment();
    SearchResultsFragment searchResultsFragment = new SearchResultsFragment();
    SearchFiltersFragment searchFiltersFragment = new SearchFiltersFragment();


    @Given("I am an anonymous customer with clear cookies")

    public void cookiesClearning() {
        getDriver().manage().deleteAllCookies();
    }

    @And("I open the \"Initial home page\"")
    public void openHomePage() {
        homePage.openHomePage();
    }


    @And("I search for \"Thinking in Java\"")
    public void searchForABook() {
        searchBlockFragment.bookNameInput("Thinking in Java");
    }

    @And("I am redirected to a \"Search page\"")
    public void searchResultsShow() {
        searchBlockFragment.searchForABook();
    }

    @And("Search results contain the following products")

    public void checkIfBooksArePresentOnSearchResult(List<String> listOfBooks) {
        List<String> namesOfBooksFromSearchResult = searchResultsFragment.returnNamesOfBooksFromSearchResult();

        for (int i = 0; i < namesOfBooksFromSearchResult.size(); i++) {
            Assert.assertTrue(namesOfBooksFromSearchResult.containsAll(listOfBooks));
        }
    }

    @And("I apply the following search filters")
    public void filtersSet(Map<String, String> filters) {

        String userPriceRangeFilter = filters.get("Price range");
        String userAvailabilityFilter = filters.get("Availability");
        String userLanguageFilter = filters.get("Language");
        String userFormatFilter = filters.get("Format");

        searchFiltersFragment.setFilters(userPriceRangeFilter, userAvailabilityFilter,
                userLanguageFilter, userFormatFilter);
    }

    @And("Search results contain only the following products")
    public void checkIfBooksArePresentOnSearchResultAfterFiltering(List<String> listOfBooksAfterFiltering) {

        List<String> namesOfBooksFromSearchResult = searchResultsFragment.returnNamesOfBooksFromSearchResult();

        for (int i = 0; i < namesOfBooksFromSearchResult.size(); i++) {
            Assert.assertTrue(namesOfBooksFromSearchResult.containsAll(listOfBooksAfterFiltering));
        }
    }


}



