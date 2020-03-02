package com.thoughtworks.parkinglot.application

import com.thoughtworks.parkinglot.Application
import com.thoughtworks.parkinglot.domain.exception.IllegalTicketException
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLot
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotRepository
import com.thoughtworks.parkinglot.domain.model.parkinglot.TicketId
import com.thoughtworks.parkinglot.domain.service.ParkingService
import spock.lang.Specification

class ParkingApplicationServiceTest extends Specification {

    def parkingLotRepository = Mock(ParkingLotRepository)
    def parkingLot = Mock(ParkingLot)
    def parkingService = Mock(ParkingService)

    def "should return ticket"() {
        when:
        def result = app.greeting
        def ticket = parkingApplicationService.park();

        then:
        true
    }

    def "should return car"() {
        when:
        def result = app.greeting

        then:
        result != null
    }

    def "should throw exception when ticket id invalid"() {
        given:
        def parkingApplicationService = new ParkingApplicationService(parkingLotRepository, parkingService)
        ticketId = new TicketId("invalid-id")
        parkingLotId = new ParkingLotId("LOT001")

        when:
        parkingApplicationService.pick(ticketId, parkingLotId)

        then:
        thrown(IllegalTicketException)
    }
}
