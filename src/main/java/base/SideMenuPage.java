package base;

import pages.conditionsAndPolicyPages.CookiePolicyPage;
import pages.conditionsAndPolicyPages.PrivacyPolicyPage;
import pages.conditionsAndPolicyPages.PrivacySettingsPage;
import pages.conditionsAndPolicyPages.TermsAndConditionsPage;
import pages.mainSideMenuPages.HelpPage;

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

    public TermsAndConditionsPage getTermsAndConditionsPage() {
        click("termsAndConditions_XPATH");
        return new TermsAndConditionsPage();
    }

    public PrivacyPolicyPage getPrivacyPolicyPage() {
        click("privacyPolicySM_XPATH");
        return new PrivacyPolicyPage();
    }

    public PrivacySettingsPage getPrivacySettingsPage() {
        click("privacySettingsSM_XPATH");
        return new PrivacySettingsPage();
    }

    public CookiePolicyPage getCookiePolicyPage() {
        click("cookiePolicyPage_XPATH");
        return new CookiePolicyPage();
    }

    public HelpPage getHelpPage() {
        click("helpPage_XPATH");
        return new HelpPage();
    }
}
