import app.test.Club
import app.test.Player
import spock.lang.Specification

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback

@Rollback
@Integration
class DirtyCheckSpec extends Specification {

    void "test dirty hibernate"() {
        given:
        Club club = Club.findByName('Boca Juniors')
        assert club
        Player player = Player.findByName('Juan Roman Riquelme')
        assert player

        when:
        player.properties = [club: [id: club.id]]

        then:
        !player.hasChanged('club')
    }
}
