package pages;

import base.Page;

public class SideMenuPage extends Page {

    public void getEurosportLogo () {
        isElementDisplayed("eurosportLogo_CN");
    }

    public void verifySideMenuCategories() {
        verifyEquals("sideMenuCatNumber", "sideMenuCategories_XPATH");
    }

    public void verifyAboutUsCat() {
        verifyEquals("aboutUsCatNumber", "aboutUsCat_XPATH");
    }
}
