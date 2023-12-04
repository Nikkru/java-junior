package stream_API.reflection_API.lection.seminar.task3.models;

import stream_API.reflection_API.lection.seminar.task3.Column;

import java.util.UUID;

@stream_API.reflection_API.lection.seminar.task3.Entity
public class Entity {
    @Column(name = "id", primaryKey = true)
    private UUID id;
}
