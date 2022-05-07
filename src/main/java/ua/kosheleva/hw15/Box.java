package ua.kosheleva.hw15;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;

@AllArgsConstructor
@Getter
public class Box {
    private double volume;
}

class BoxComparator implements Comparator<Box> {
    @Override
    public int compare(Box o1, Box o2) {
        if (o1.getVolume() == 0 && o2.getVolume() == 0) {
            return 0;
        } else if (o1.getVolume() == 0) {
            return -1;
        } else if (o2.getVolume() == 0) {
            return 1;
        }
        return (int) (o2.getVolume() - o1.getVolume());
    }
}
