package com.excuses.betterbuilding.registry.Properties;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import net.minecraft.state.property.Property;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public class ColorProperty extends Property<Integer> {
    private final ImmutableSet<Integer> values;

    protected ColorProperty(String name, int value) {
        super(name, Integer.class);
        if (value < 0) {
            throw new IllegalArgumentException("Value of " + name + " must be 0 or greater");
        } else if (value > 15) {
            throw new IllegalArgumentException("Value of " + name + " must be 15 or Less");
        } else {
            Set<Integer> set = Sets.newHashSet();

            for(int i = 0; i <= 15; ++i) {
                set.add(i);
            }

            this.values = ImmutableSet.copyOf(set);
        }
    }

    public Collection<Integer> getValues() {
        return this.values;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object instanceof ColorProperty && super.equals(object)) {
            ColorProperty colorProperty = (ColorProperty)object;
            return this.values.equals(colorProperty.values);
        } else {
            return false;
        }
    }

    public int computeHashCode() {
        return 31 * super.computeHashCode() + this.values.hashCode();
    }

    public static ColorProperty of(String name, int value) {
        return new ColorProperty(name, value);
    }

    public Optional<Integer> parse(String name) {
        try {
            Integer integer = Integer.valueOf(name);
            return this.values.contains(integer) ? Optional.of(integer) : Optional.empty();
        } catch (NumberFormatException var3) {
            return Optional.empty();
        }
    }

    public String name(Integer integer) {
        return integer.toString();
    }
}

