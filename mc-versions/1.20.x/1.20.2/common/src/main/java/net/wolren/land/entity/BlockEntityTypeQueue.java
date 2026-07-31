package net.wolren.land.entity;

import java.util.ArrayList;
import java.util.List;

public final class BlockEntityTypeQueue {
    public static final List<Runnable> PENDING = new ArrayList<>();
    private BlockEntityTypeQueue() {}
}
