package ua.kosheleva.hw25.service;


import ua.kosheleva.hw25.dao.CourseDao;
import ua.kosheleva.hw25.dao.CuratorDao;
import ua.kosheleva.hw25.model.Curator;
import ua.kosheleva.hw25.model.UniversityGroup;

import java.time.LocalDate;
import java.util.Random;

public class CuratorService {
    private final static Random RANDOM = new Random();
    private final CuratorDao curatorDao = new CuratorDao();

    public void showAllTeachersBornBeforeXDateAndWithMoreThanYWorkExperience(){
        curatorDao.getAllTeachersBornBeforeXDateAndWithMoreThanYWorkExperience(1965, 11, 4, 3)
                .forEach(curator -> { System.out.println("\nName: " + curator.getCuratorName()
                        + "\nDate of birth: " + curator.getDateOfBirth()
                        + "\nWork experience: " + curator.getWorkExperience());
        });
    }

    public void addCurator(UniversityGroup universityGroup) {
        final Curator curator = new Curator("Curator - " + RANDOM.nextInt(10, 1000), setDate(), RANDOM.nextInt(0, 10));
        universityGroup.setCurator(curator);
        curator.setUniversityGroup(universityGroup);
    }

    private LocalDate setDate() {
        int year = RANDOM.nextInt(1936, 1998);
        int month = RANDOM.nextInt(1, 12);
        int day;
        if (month == 2) {
            day = RANDOM.nextInt(1, 28);
        } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            day = RANDOM.nextInt(1, 31);
        } else {
            day = RANDOM.nextInt(1, 30);
        }
        return LocalDate.of(year, month, day);
    }
}
