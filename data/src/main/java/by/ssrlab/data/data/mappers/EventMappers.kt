package by.ssrlab.data.data.mappers

import by.ssrlab.data.data.local.EventEntity
import by.ssrlab.data.data.remote.Event

fun EventEntity.toEvent(): Event{
    return Event(
        pk = pk,
        startDate = startDate,
        endDate = endDate,
        keyName = keyName
    )
}

fun Event.toEventEntity(): EventEntity{
    return EventEntity(
        pk = pk,
        startDate = startDate,
        endDate = endDate,
        keyName = keyName
    )
}