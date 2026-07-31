package net.wolren.land.entity;

import java.util.ArrayList;
import java.util.List;

public final class EntityTypeQueue {
    public static final List<Runnable> PENDING = new ArrayList<>();
    private EntityTypeQueue() {}
}
