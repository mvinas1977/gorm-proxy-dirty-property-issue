package gorm.proxy.dirty.property.issue

import app.test.Club
import app.test.Player

class BootStrap {

    def init = { servletContext ->
        Club club = new Club(id: 1, name: 'Boca Juniors')
        club.save()
        Player player = new Player(id: 2, name: 'Juan Roman Riquelme')
        player.club = club
        player.save()
    }

    def destroy = {
    }
}
