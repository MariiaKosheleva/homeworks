package ua.kosheleva.hw25.service;

import ua.kosheleva.hw25.dao.UniversityGroupDao;
import ua.kosheleva.hw25.model.University;
import ua.kosheleva.hw25.model.UniversityGroup;
import ua.kosheleva.hw25.model.UniversityGroupInfo;

public class UniversityGroupService {
    private final UniversityGroupDao universityGroupDao = new UniversityGroupDao();
    private final UniversityGroupInfo universityGroupInfo = new UniversityGroupInfo();

    public UniversityGroup createUniversityGroup(String name, University university) {
        return new UniversityGroup(name, university);
    }

    public void printAmountOfStudentsInEachGroup() {
        universityGroupInfo.printUniversityGroupInfo(universityGroupDao.getAmountOfStudentsInEachGroup());
    }
}
