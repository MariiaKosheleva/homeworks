package service;

import dao.PartDao;

import java.util.List;

public class PartService {
    private final PartDao partDao = new PartDao();

    public void printStatisticsData() {
        prepareStatisticsForPrinting(partDao.getStatistics());
    }

    public void printInfoAboutCertainPart(Integer index) {
        prepareCertainPartInfoForPrinting(partDao.getInfoAboutCertainPart(partDao.getAll().get(index).getId()));
    }

    private void prepareStatisticsForPrinting(List<Object> statistics) {
        for (Object o : statistics) {
            Object[] row = (Object[]) o;
            System.out.println("\nAmount of parts: " + row[0] + "\nAmount of broken chips: " + row[1] +
                    "\nAmount of produced fuel: " + row[2]);
        }
    }

    private void prepareCertainPartInfoForPrinting(List<Object> infoAboutCertainDetail) {
        for (Object o : infoAboutCertainDetail) {
            Object[] row = (Object[]) o;
            System.out.println("\nPart id: " + row[0] + "\nCurrent date: " + row[1] + "\nUsed time: " + row[2] +
                    " milliseconds\nProduced fuel: " + row[3] + "\nAmount of broken chips: " + row[4]);
        }
    }
}
