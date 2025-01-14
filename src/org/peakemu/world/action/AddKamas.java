/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.peakemu.world.action;

import org.peakemu.Peak;
import org.peakemu.common.SocketManager;
import org.peakemu.objects.item.Item;
import org.peakemu.objects.player.Player;
import org.peakemu.world.MapCell;

/**
 *
 * @author Ludovic Sanctorum <ludovic.sanctorum@gmail.com>
 */
public class AddKamas implements ActionPerformer {

    @Override
    public int actionId() {
        return 4;
    }

    @Override
    public boolean apply(Action action, Player caster, Player target, MapCell cell, Item item) {
        try {
            int count = Integer.parseInt(action.getArgs());
            long curKamas = caster.getKamas();
            long newKamas = curKamas + count;
            if (newKamas < 0) {
                newKamas = 0;
            }
            caster.setKamas(newKamas);

            //Si en ligne (normalement oui)
            if (caster.isOnline()) {
                SocketManager.GAME_SEND_STATS_PACKET(caster);
            }
            return true;
        } catch (Exception e) {
            Peak.errorLog.addToLog(e);
            return false;
        }
    }

}
