/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.peakemu.game.out.account;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public class NewLevel {
    final private int newLevel;

    public NewLevel(int newLevel) {
        this.newLevel = newLevel;
    }

    @Override
    public String toString() {
        return "AN" + newLevel;
    }
    
    
}
