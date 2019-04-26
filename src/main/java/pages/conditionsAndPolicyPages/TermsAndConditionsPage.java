package pages.conditionsAndPolicyPages;

import base.Page;

public class TermsAndConditionsPage extends Page {

    public void verifyLegalNoticeTitle() {
        isElementDisplayed("legalNotice_CSS");
    }
}
