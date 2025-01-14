/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.peakemu.game.in.fight;

import org.peakemu.game.GameClient;
import org.peakemu.network.InputPacket;
import org.peakemu.world.fight.team.ChallengeTeam;
import org.peakemu.world.fight.fighter.Fighter;

/**
 *
 * @author Vincent Quatrevieux <quatrevieux.vincent@gmail.com>
 */
public class ToggleFightLock implements InputPacket<GameClient>{

    @Override
    public void parse(String args, GameClient client) {
        if(client.getPlayer() == null || client.getPlayer().getFighter() == null)
            return;
        
        Fighter fighter = client.getPlayer().getFighter();
        ChallengeTeam team = (ChallengeTeam) fighter.getTeam();
        
        if(team.getInit() == fighter)
            team.toggleLock();
    }

    @Override
    public String header() {
        return "fN";
    }
    
}
