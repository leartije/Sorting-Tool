package sorting.services;

import sorting.util.Msg;
import sorting.util.UtilStuff;

import java.util.*;

public class LineSort implements SortingTool {

    @Override
    public void executeNatural(boolean isFromConsole, String fileName) {
        List<String> strings = readInput(isFromConsole, fileName);
        sortNatural(strings);
    }

    @Override
    public void executeByCount(boolean isFromConsole, String fileName) {
        List<String> strings = readInput(isFromConsole, fileName);
        sortByCount(strings);
    }

    private List<String> readInput(boolean isFromConsole, String file) {
        List<String> list = new ArrayList<>();
        Scanner scanner;

        if (isFromConsole){
            scanner = new Scanner(System.in);
        } else {
            scanner = new Scanner(file);
        }

        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        return list;
    }

    private void sortNatural(List<String> list) {
        Collections.sort(list);
        System.out.printf(Msg.TOTAL_NUMBERS, list.size());
        System.out.print(Msg.SORTED_DATA);
        list.forEach(aLong -> System.out.print(aLong + " "));
        System.out.println();
    }

    private void sortByCount(List<String> list) {
        Map<String, Integer> statistic = getStatistic(list);
        Map<String, Integer> sorted = new LinkedHashMap<>();

        statistic.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEach(x -> sorted.put(x.getKey(), x.getValue()));

        System.out.printf(Msg.TOTAL_LINES, list.size());
        sorted.forEach((string, integer) -> System.out.printf(Msg.BY_COUNT_DATA, string, integer,
                UtilStuff.getPercentage(list.size(), integer)));
    }

    private Map<String, Integer> getStatistic(List<String> list) {
        Map<String, Integer> mapa = new TreeMap<>();
        for (String string : list) {
            mapa.put(string, mapa.getOrDefault(string, 0) + 1);
        }
        return mapa;
    }

}


