package tests;

import models.components.ComponentExploring;
import models.components.ExternalLoginPage;
import models.components.InternalLoginPage;

public class GenericTypeTest {
    public static void main(String[] args) {
        ComponentExploring componentExploring = new ComponentExploring();

        // Tu quyet dinh thoi diem tao instance
        componentExploring.login(InternalLoginPage.class, "Internal user");
        componentExploring.login(ExternalLoginPage.class, "External user");
    }
}
