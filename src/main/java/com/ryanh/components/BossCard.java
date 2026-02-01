package com.ryanh.components;

import com.ryanh.base.BaseComponent;
import org.openqa.selenium.By;

public class BossCard extends BaseComponent {
    /**
     * Selectors for elements on a boss card that are always available regardless on if there are any notes created.
     */
    //The add button that is always shown in the top right corner of a boss card
    private final By addNoteButton = By.cssSelector("div.grid div.flex button:not([title]):not(.border)");
    //Expand view button in top right corner next to the add button
    private final By expandViewButton = By.cssSelector("div.grid div.flex button[title=\"Open full view\"]");
    //The guide link for a boss in the top left corner of a boss card
    private final By bossGuideLink = By.cssSelector("div.grid div.flex a[href*=\"/viserio-cooldowns/guides\"]");

    /**
     * Selectors for elements on a boss card that are only available when no notes are created.
     */
    //The add button that only appears when a boss has no notes created
    private final By createANoteButton = By.xpath("//button[contains(text(), 'Create a note')]");

    /**
     * Selectors for elements on a boss card that are only available when at least one note is created.
     */
    //Edit note name button for created notes
    private final By editNoteNameButton = By.cssSelector("div.grid div.flex button[title=\"Edit note name\"]");
    //Copy note button for created notes
    private final By copyNoteButton = By.cssSelector("div.grid div.flex button[title*=\"Copy this note\"]");
    //Delete note button for created notes
    private final By deleteNoteButton = By.cssSelector("div.grid div.flex button[title*=\"Delete your note\"]");
    //Link for a note in the note table on a boss card
    private final By noteLink = By.cssSelector("div.grid div.flex a[href*=\"/viserio-cooldowns/raid/\"]");



}
