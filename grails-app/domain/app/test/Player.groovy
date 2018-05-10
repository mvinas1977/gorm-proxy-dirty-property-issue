package app.test

import grails.databinding.BindUsing
import grails.databinding.SimpleMapDataBindingSource

class Player {

    String name

    @BindUsing({ Player player, SimpleMapDataBindingSource source ->

        if (source['club']?.id) {
            return Club.get(source['club']?.id as Long)
        }
    })
    Club club

    static constraints = {
        name nullable: false
        club nullable: false
    }
}
