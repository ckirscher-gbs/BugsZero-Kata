/**
 * 
 */
package com.adaptionsoft.games.model;

import lombok.Getter;

/**
 * @author Céline Souchet
 */
public enum Category {
                      POP("Pop"),
                      SCIENCE("Science"),
                      SPORTS("Sports"),
                      ROCK("Rock");

    @Getter
    private String name;

    /**
     * Default constructor
     * 
     * @param name The name of the category
     */
    private Category(final String name) {
        this.name = name;
    }
}
