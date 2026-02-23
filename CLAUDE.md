# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Selenium WebDriver automation framework for [wowutils.com](https://wowutils.com/viserio-cooldowns) using the Page Object Model (POM) and Component Object patterns. Built with Java 23, Maven, TestNG, and Selenium 4.39.

## Build & Test Commands

```bash
mvn clean test                              # Clean build and run all tests
mvn test                                    # Run all tests
mvn test -Dtest=OverviewTests               # Run a specific test class
mvn test -Dtest=OverviewTests#addNotes      # Run a single test method
mvn compile                                 # Compile without running tests
```

Tests require environment variables for Battle.net OAuth2 authentication:
- `BATTLENET_EMAIL_TEST`
- `BATTLENET_PASSWORD_TEST`

## Architecture

**Page Object Model with Component Objects:**
- `BasePage` — Abstract base providing explicit wait strategies (10s timeout) and common actions (click, type, acceptCookies). All page objects extend this.
- `BaseTest` — Abstract test base handling WebDriver lifecycle, site navigation, Battle.net login, and cookie acceptance via TestNG `@BeforeClass`/`@AfterClass`.
- **Pages** (`src/main/java/com/ryanh/pages/`) — Encapsulate page-level locators and interactions (HomePage, LoginPage, OverviewPage).
- **Components** (`src/main/java/com/ryanh/components/`) — Reusable UI components scoped to a root WebElement. `BossCard` represents a raid encounter card with note CRUD operations.
- `DriverFactory` — Static factory for WebDriver creation (Chrome, Firefox, Edge).

**Test structure:**
- Tests use TestNG `@DataProvider` for parameterized, data-driven execution (one run per boss).
- Each test is independent — creates its own test data in `@BeforeMethod` and cleans up in `@AfterMethod`. No inter-test dependencies.
- `RunWithoutTests` (`src/main/java/com/ryanh/helper/`) is a manual debug utility with a main method, not a test.

## Conventions

- Locators: private `By` fields at top of class, camelCase naming
- Page methods: action-based names (`addNote()`, `editNote()`, `navigateToOverview()`)
- No `Thread.sleep()` — use BasePage wait methods (`waitUntilVisible`, `waitUntilClickable`, `waitUntilExists`, `waitForPageURL`, `waitForStaleElement`)
- Toast notifications verify action completion in BossCard methods
- TestNG suite config: `src/test/java/testng.xml`
