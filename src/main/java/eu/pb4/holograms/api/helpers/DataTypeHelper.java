package eu.pb4.holograms.api.helpers;

import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandler;

import java.util.ArrayList;
import java.util.List;

public class DataTypeHelper {
    public static <T> List<DataTracker.Entry<?>> getEntries(List<DataTracker.SerializedEntry<?>> list) {
        List<DataTracker.Entry<?>> entries = new ArrayList<>();
        for (DataTracker.SerializedEntry<?> entry : list) {
            TrackedDataHandler<T> handler = (TrackedDataHandler<T>) entry.handler();
            TrackedData<T> d = handler.create(entry.id());
            entries.add(new DataTracker.Entry<>(d, (T) entry.value()));
        }
        return entries;
    }
}
