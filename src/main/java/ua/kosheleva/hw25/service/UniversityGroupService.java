package ua.kosheleva.hw25.service;


import ua.kosheleva.hw25.dao.UniversityGroupDao;
import ua.kosheleva.hw25.model.University;
import ua.kosheleva.hw25.model.UniversityGroup;

public class UniversityGroupService {
    private final UniversityGroupDao universityGroupDao = new UniversityGroupDao();
    public UniversityGroup createUniversityGroup(String name, University university) {
        return new UniversityGroup(name, university);
    }

    /*public void getAmountOfStudentsInEachGroup(Integer index){
        universityGroupDao.getAmountOfStudentsInEachGroup(universityGroupDao.getAll().get(index).getId());
    }*/
}
