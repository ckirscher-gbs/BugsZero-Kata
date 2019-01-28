/**
 * 
 */
package com.adaptionsoft.games.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Céline Souchet
 */
@Data
@AllArgsConstructor
@Builder
public class Question {

    private int id;

    private Category category;

    @Override
    public String toString() {
        return category.getName() + " question " + id;
    }
}
